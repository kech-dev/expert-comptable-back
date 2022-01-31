package ma.berexia.expComptable.service.impl;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.entity.UserRole;
import ma.berexia.expComptable.repo.UserRepo;

import ma.berexia.expComptable.service.IUserService;
import ma.berexia.expComptable.service.exception.UserAlreadyExistException;
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

    @Autowired
    private UserRepo userRepo;

    public UserService(){

    }

    @Override
    public User save(User user) {
        this.userRepo.findByEmail(user.getEmail()).ifPresent(u-> {throw new UserAlreadyExistException("the email: "+user.getEmail()+" already exist");});
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return this.userRepo.findAll();
    }

    @Override
    public User getById(int id) {
        return this.userRepo.findById(id).orElseThrow(()->new UserNotFoundException("user with id: "+id+" not found"));
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User findByEmail(String email) {
       return this.userRepo.findByEmail(email).orElseThrow(()->new UserNotFoundException("user with email: "+email+" not found"));
    }


}
