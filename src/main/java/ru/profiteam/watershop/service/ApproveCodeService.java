package ru.profiteam.watershop.service;

import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import java.util.List;

public interface ApproveCodeService {
    void create(CreateApproveCodeDto request);
    List<ApproveCodeDto> getAll();
    void update(Long id, CreateApproveCodeDto request);
    void approve(ApproveCodeDto request);
}
