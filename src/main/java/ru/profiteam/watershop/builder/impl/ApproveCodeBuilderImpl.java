package ru.profiteam.watershop.builder.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.profiteam.watershop.builder.ApproveCodeBuilder;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.utils.GeneratorHelper;
import java.util.Date;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ApproveCodeBuilderImpl implements ApproveCodeBuilder {

    @Override
    public ApproveCode build(CreateApproveCodeDto request ) {
        ApproveCode approveCode = new ApproveCode();
        approveCode.setCode(GeneratorHelper.code());
        approveCode.setNumber(request.getPhoneNumber());
        approveCode.setCreatedAt(new Date());
        approveCode.setIsActivated(false);
        return approveCode;
    }


    @Override
    public ApproveCode build(ApproveCodeDto request) {
        return null;
    }

    @Override
    public ApproveCodeDto build(ApproveCode approveCode) {
        return null;
    }

    @Override
    public void update(ApproveCode approveCode, ApproveCodeDto request) {

    }
}
