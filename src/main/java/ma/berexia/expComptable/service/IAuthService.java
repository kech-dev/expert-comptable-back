package ma.berexia.expComptable.service;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.entity.dto.UserAuth;

public interface IAuthService {
    UserAuth signIn(String email, String password);
    void signUp(User user);
}
