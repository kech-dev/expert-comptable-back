package ma.berexia.expComptable.service.impl;

import ma.berexia.expComptable.entity.dto.UserAuth;
import ma.berexia.expComptable.security.JwtUtil;
import ma.berexia.expComptable.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Override
    public UserAuth signIn(String email, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
        UserDetails userDetails=myUserDetailsService.loadUserByUsername(email);
        String token=jwtTokenUtil.generateToken(userDetails);
        return new UserAuth(token, this.jwtTokenUtil.extractExpiration(token));
    }
}
