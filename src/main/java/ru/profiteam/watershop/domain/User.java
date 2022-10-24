package ru.profiteam.watershop.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import ru.profiteam.watershop.domain.enums.UserType;

import javax.persistence.*;
import java.util.List;
//слиент

@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class User extends PersistentObject {

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    UserType type;

    @Column(name = "full_name")
    String fullName;

    @Column(name = "login")
    String login;

    @Column(name = "password")
    String password;

    @Column(name = "email")
    String email;

    @Column(name = "phone_number")
    String phoneNumber;

}
