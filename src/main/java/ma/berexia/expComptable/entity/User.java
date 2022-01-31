package ma.berexia.expComptable.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;
    private String password;
    private UserRole role;
    private Boolean active;
    public User(){}
    public User(String email,String password,UserRole role,boolean active){
        this.email=email;
        this.password=password;
        this.role=role;
        this.active=active;
    }
}
