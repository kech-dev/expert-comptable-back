package ma.berexia.expComptable.service;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.entity.dto.UserAuth;

import java.util.List;

public interface IUserService {
    public User save(User user);
    public List<User> getAll();
    public User getById(int id);
    public void delete(int id);
    public User findByEmail(String email);

}
