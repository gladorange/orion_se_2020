package shilkin.mishop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrderDTO {
    private Long id;
    @NotNull
    private Long productId;
    @NotNull
    private int productCount;
    @NotNull
    private int finalPrice;
}
