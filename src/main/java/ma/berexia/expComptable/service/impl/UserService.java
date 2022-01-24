package ma.berexia.expComptable.service.impl;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.repo.UserRepo;

import ma.berexia.expComptable.service.IUserService;
import ma.berexia.expComptable.service.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserService implements IUserService {
    private final Map<String, User> users=new ConcurrentHashMap<String,User>();

    @Autowired
    private UserRepo userRepo;

    public UserService(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        this.users.put("test@test.fr",new User(1,"test@test.fr",encoder.encode("test"),"admin",true));
    }

    @Override
    public User save(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepo.findById(id).orElseThrow(()->new UserNotFoundException());
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByEmail(String email) {
        return Optional.ofNullable(this.users.get(email)).orElseThrow(()->new UserNotFoundException());
       // return this.userRepo.findByEmail(email).orElseThrow(()->new UserNotFoundException());
    }


}
