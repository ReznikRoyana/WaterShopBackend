package ru.profiteam.watershop.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.profiteam.watershop.annotation.BaseApiResponseEmpty;
import ru.profiteam.watershop.controllers.base.AuthorizationController;
import ru.profiteam.watershop.dto.request.CreateApproveCodeDto;
import ru.profiteam.watershop.dto.response.ApproveCodeDto;
import ru.profiteam.watershop.service.ApproveCodeService;

import javax.servlet.http.HttpServletRequest;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RestController
@RequestMapping("approve_code")
@Tag(name = "Approve_code")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ApproveCodeController extends AuthorizationController {
    ApproveCodeService approveCodeService;

    @Autowired
    public ApproveCodeController(ApproveCodeService approveCodeService, HttpServletRequest request) {
        super(request);
        this.approveCodeService = approveCodeService;
    }

    @BaseApiResponseEmpty
    @PostMapping("send-code")
    public void sendCode(@RequestBody CreateApproveCodeDto request) {
        approveCodeService.create(request);
    }

    @BaseApiResponseEmpty
    @PostMapping("approve-code")
    public void approveCode(@RequestBody ApproveCodeDto request) {
        approveCodeService.approve(request);
    }

}
