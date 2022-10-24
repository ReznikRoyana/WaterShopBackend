package ru.profiteam.watershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.profiteam.watershop.domain.enums.MessageContextType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryServiceMessageDto {
    Long id;
    UserDto recipient;
    UserDto sender;
    String context;
    MessageContextType messageContextType;
    String date;

}
