package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.*;

//города
@Getter
@Setter
@Entity
@Table(name = "city")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City extends PersistentObject {

    @Column(name = "name")
    String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;
}
