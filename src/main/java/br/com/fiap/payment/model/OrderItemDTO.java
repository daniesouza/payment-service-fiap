package br.com.fiap.payment.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO {

    private Long id;
    private String name;
    private BigDecimal price;

}
