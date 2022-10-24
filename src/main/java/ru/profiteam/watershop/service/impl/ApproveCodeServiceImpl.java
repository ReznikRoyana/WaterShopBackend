package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.ApproveCodeBuilder;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.dto.response.CountryDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.service.ApproveCodeService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ApproveCodeServiceImpl implements ApproveCodeService {

    ApproveCodeRepository approveCodeRepository;
    ApproveCodeBuilder approveCodeBuilder;

    @Override
    public void create(CreateApproveCodeDto request) {
        ApproveCode approveCode = approveCodeBuilder.build(request);
        approveCodeRepository.save(approveCode);

    }

    @Override
    public List<ApproveCodeDto> getAll() {
        List<ApproveCode> approveCodeList = approveCodeRepository.findAll();
        List<ApproveCodeDto> approveCodeDtoList = new ArrayList<>();
        for (ApproveCode item : approveCodeList) {
            approveCodeDtoList.add(approveCodeBuilder.build(item));
        }
        return approveCodeDtoList;
    }

    @Override
    public void update(Long id, CreateApproveCodeDto request) {

    }

    @Override
    public void approve(ApproveCodeDto request) {
//        var approveCode = approveCodeRepository
//                .findAll()
//                .stream()
//                .filter(x -> x.getNumber().equals(request.getNumber()) && x.getCode().equals(request.getCode()))
//                .collect(Collectors.toList());
//        if (!approveCode.isEmpty());
//
        Optional<ApproveCode> approveCodeOpt = approveCodeRepository
                .findByNumberAndCode(request.getNumber(), request.getCode());

        if (approveCodeOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        ApproveCode approveCode = approveCodeOpt.get();
        approveCode.setIsActivated(true);
        approveCodeRepository.save(approveCode);
    }
}
