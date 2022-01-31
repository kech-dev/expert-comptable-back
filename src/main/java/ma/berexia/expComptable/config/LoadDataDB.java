package ma.berexia.expComptable.config;

import ma.berexia.expComptable.entity.User;
import ma.berexia.expComptable.entity.UserRole;
import ma.berexia.expComptable.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoadDataDB implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private UserRepo userRepo;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);
        this.userRepo.save(new User(0,"test@test.fr",encoder.encode("test"), UserRole.ADMIN,false));
    }
}
