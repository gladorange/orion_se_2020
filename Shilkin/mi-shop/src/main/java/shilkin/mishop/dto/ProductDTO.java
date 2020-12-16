package shilkin.mishop.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long categoryId;
    @NotNull
    private int price;
    @NotNull
    @Range
    private int productCount;
}
