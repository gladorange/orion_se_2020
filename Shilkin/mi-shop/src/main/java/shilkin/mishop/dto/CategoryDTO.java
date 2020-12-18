package shilkin.mishop.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {
    private Long id;
    @NotNull
    private String name;
    private Long parentCategoryId;
}
