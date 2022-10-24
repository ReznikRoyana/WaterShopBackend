package ru.profiteam.watershop.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSellerDto {
    String name;
    String inn;
    String bik;
    String description;
}
