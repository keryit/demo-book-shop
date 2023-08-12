package spring.boot.demobooksshop.dto.user;

import lombok.Data;

@Data
public class UserRegisteredResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String shippingAddress;
}
