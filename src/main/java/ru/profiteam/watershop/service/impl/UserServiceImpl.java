package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.UserBuilder;
import ru.profiteam.watershop.domain.ApproveCode;
import ru.profiteam.watershop.domain.User;
import ru.profiteam.watershop.dto.response.UserDto;
import ru.profiteam.watershop.repository.ApproveCodeRepository;
import ru.profiteam.watershop.repository.UserRepository;
import ru.profiteam.watershop.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserBuilder userBuilder;
    ApproveCodeRepository approveCodeRepository;

//    @Override
//    public String auth(RegistrationDto request) {
//        Optional<User> userOpt = userRepository.findFirstByLogin(request.getLogin());
//        if (userOpt.isEmpty() || !DigestUtils.md5DigestAsHex(request.getPassword().getBytes()).equals(userOpt.get().getPassword())){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        return tokenService.buildToken(userOpt.get().getId());
//    }

//    @Override
//    public Long getIdByToken(String token) {
//        return tokenService.parseJwt(token);
//    }

//    @Override
//    public void registration(RegistrationDto request) {
//        if (request.getPassword().length() < 6) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//        var approveLoginOpt = approveCodeRepository
//                .findFirstByNumber(request.getLogin());
//        if (approveLoginOpt.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//
//        }
//        var userLoginOpt = userRepository.findFirstByLogin(request.getLogin());
//        if (userLoginOpt.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
//        }
//
//        var entityUser = userBuilder.regBuild(request);
//        userRepository.save(entityUser);
//    }

    @Override
    public List<UserDto> getAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User item: userList){
            userDtoList.add(userBuilder.build(item));
        }
        return userDtoList;
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Optional<ApproveCode> approveCodeOpt = approveCodeRepository.
                findFirstByNumber(userOpt.get().getPhoneNumber());
        if (approveCodeOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        approveCodeRepository.deleteById(approveCodeOpt.get().getId());
        userRepository.deleteById(id);
    }
}
