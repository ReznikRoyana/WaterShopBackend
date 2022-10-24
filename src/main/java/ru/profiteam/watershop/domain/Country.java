package ru.profiteam.watershop.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import ru.profiteam.watershop.domain.base.PersistentObject;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

// страны
@Getter
@Setter
@Entity
@Table(name = "country")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Country extends PersistentObject {

    @Column(name = "name")
    String name;
}
