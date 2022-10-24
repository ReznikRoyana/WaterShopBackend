package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateManufacturerDto;
import ru.profiteam.watershop.dto.request.CreateSessionDto;

public interface SessionService {
    void create(CreateSessionDto request);
}
