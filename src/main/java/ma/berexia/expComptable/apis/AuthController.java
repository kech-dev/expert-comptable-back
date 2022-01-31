package ma.berexia.expComptable.apis;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private IAuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestParam String email, @RequestParam String password){
        return ResponseEntity.ok(this.authService.signIn(email, password));
    }

    @PostMapping("/signup")
    public void signUp(@RequestBody User user){
        this.authService.signUp(user);
    }
}
