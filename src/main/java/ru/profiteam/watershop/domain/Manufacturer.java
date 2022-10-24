package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//производитель
@Getter
@Setter
@Entity
@Table(name = "manufacturer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Manufacturer extends PersistentObject {

    @Column(name = "name")
    String name;

    @Column(name = "logo")
    String logo;

    @Column(name ="sum")
    String sum;
}
