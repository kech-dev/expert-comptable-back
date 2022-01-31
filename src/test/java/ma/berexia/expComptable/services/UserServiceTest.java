package ma.berexia.expComptable.services;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.entity.UserRole;
import ma.berexia.expComptable.repo.UserRepo;
import ma.berexia.expComptable.service.exception.UserAlreadyExistException;
import ma.berexia.expComptable.service.exception.UserNotFoundException;
import ma.berexia.expComptable.service.impl.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepo userRepo;
    @InjectMocks
    UserService userService;

    @Test
    void save_user_and_return_user_with_generated_id(){
        var user=new User("test@test.com","test", UserRole.ADMIN,true);
        var savedUser=new User(1,"test@test.com","test",UserRole.ADMIN,true);

        given(userRepo.save(user)).willReturn(savedUser);

        Assertions.assertThat(userService.save(user)).isEqualTo(savedUser);

    }
    @Test
    void get_all_users(){
        var users= new ArrayList<User>();
        users.add(new User(1,"test@test.com","test",UserRole.ADMIN,true));
        users.add(new User(2,"test2@test.com","test",UserRole.ADMIN,true));
        users.add(new User(3,"test3@test.com","test",UserRole.ADMIN,true));

        given(userRepo.findAll()).willReturn(users);

        Assertions.assertThat(userService.getAll()).isEqualTo(users);

    }
    @Test
    void user_found_by_id(){
        var userId=1;
        var user=new User(1,"test@test.com","test",UserRole.ADMIN,true);

        given(userRepo.findById(userId)).willReturn(Optional.of(user));

        Assertions.assertThat(userService.getById(userId)).isEqualTo(user);
    }
    @Test
    void user_not_found_by_id(){
        var userId=1;

        given(userRepo.findById(userId)).willThrow(new UserNotFoundException("any"));

        Assertions.assertThatExceptionOfType(UserNotFoundException.class)
                .isThrownBy(()->userService.getById(userId));
    }

    @Test
    void user_already_exist(){
        var user=new User("test@test.com","test",UserRole.ADMIN,true);

        given(userRepo.findByEmail(user.getEmail())).willReturn(Optional.of(user));

        Assertions.assertThatExceptionOfType(UserAlreadyExistException.class)
                .isThrownBy(()->userService.save(user));
    }
}
