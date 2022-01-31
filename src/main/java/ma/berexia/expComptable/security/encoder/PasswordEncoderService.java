package ma.berexia.expComptable.security.encoder;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderService {
    private final BCryptPasswordEncoder encoder;
    public PasswordEncoderService(){
        this.encoder = new BCryptPasswordEncoder(4);
    }
    public String encode(String password){
        return this.encoder.encode(password);
    }
}
