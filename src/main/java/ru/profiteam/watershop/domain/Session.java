package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "session")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Session extends PersistentObject {

    @Column(name = "login_date")
    String loginDate;

    @Column(name = "logout_date")
    String logoutDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "token")
    String token;

}
