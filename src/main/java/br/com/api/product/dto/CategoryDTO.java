package br.com.api.product.dto;

import br.com.api.product.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {
    private Long id;
    private String nome;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static CategoryDTO coverter(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }
}
