package ru.profiteam.watershop.utils;

import lombok.Data;

import java.util.Date;

@Data
public class ErrorSwaggerModel {

    Date timestamp;
    Integer status;
    String error;
    String path;
}
