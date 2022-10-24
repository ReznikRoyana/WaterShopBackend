package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;

public interface ApproveCodeBuilder {
    ApproveCode build(CreateApproveCodeDto approveCode);

    ApproveCode build(ApproveCodeDto request);

    ApproveCodeDto build (ApproveCode approveCode);

    void update(ApproveCode approveCode, ApproveCodeDto request);



}
