package ma.berexia.expComptable.service;

import ma.berexia.expComptable.entity.dto.UserAuth;

public interface IAuthService {
    public UserAuth signIn(String email, String password);

}
