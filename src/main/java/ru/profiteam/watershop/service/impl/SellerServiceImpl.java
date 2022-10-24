package ru.profiteam.watershop.service.impl;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.profiteam.watershop.builder.SellerBuilder;
import ru.profiteam.watershop.domain.Seller;
import ru.profiteam.watershop.dto.request.CreateSellerDto;
import ru.profiteam.watershop.dto.response.SellerDto;
import ru.profiteam.watershop.repository.SellerRepository;
import ru.profiteam.watershop.service.SellerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SellerServiceImpl implements SellerService {

    SellerRepository sellerRepository;
    SellerBuilder sellerBuilder;

    @Autowired
    public SellerServiceImpl(SellerRepository sellerRepository, SellerBuilder sellerBuilder) {
        this.sellerRepository = sellerRepository;
        this.sellerBuilder = sellerBuilder;
    }

    @Override
    public void create(CreateSellerDto request) {
        Seller seller = sellerBuilder.build(request);
        sellerRepository.save(seller);
    }

    @Override
    public List<SellerDto> getAll() {
        List<Seller> sellerList = sellerRepository.findAll();
        List<SellerDto> sellerDtoList = new ArrayList<>();
        for (Seller item : sellerList) {
            sellerDtoList.add(sellerBuilder.build(item));
        }
        return sellerDtoList;
    }

    @Override
    public void deleteById(Long id) {
        Optional<Seller> sellerOpt = sellerRepository.findById(id);
        if (sellerOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        sellerRepository.deleteById(id);
    }

    @Override
    public SellerDto getById(Long id) {
        Optional<Seller> sellerOpt = sellerRepository.findById(id);
        if (sellerOpt.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return sellerBuilder.build(sellerOpt.get());
    }
}
