package ru.profiteam.watershop.builder;

import ru.profiteam.watershop.domain.*;
import ru.profiteam.watershop.dto.request.CreateDeliveryServiceMassageDto;
import ru.profiteam.watershop.dto.response.DeliveryServiceMessageDto;

public interface DeliveryServiceMassageBuilder {

    DeliveryServiceMessageDto build(DeliveryServiceMassage deliveryServiceMassage);

    DeliveryServiceMassage build(CreateDeliveryServiceMassageDto request,
                                 User recipient, User sender);

    void update(DeliveryServiceMassage deliveryServiceMassage,
                CreateDeliveryServiceMassageDto request,
                User recipient, User sender);
}
