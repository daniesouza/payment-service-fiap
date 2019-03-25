package br.com.fiap.payment.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private String name;
    private String email;
    private String shippingAddress;
    private List<OrderItemDTO> orderItemDTOS;
    private BigDecimal totalPrice;
    private PaymentDTO paymentDTO;
    private LocalDate orderDate;
    private String status;

}
