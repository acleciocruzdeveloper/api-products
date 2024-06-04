package br.com.api.product.model;

import br.com.api.product.dto.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "category")
public class Category {
    @Id
    private Long id;
    private String nome;

    public Category() {
    }

    public Category(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public static Category coverter(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setNome(categoryDTO.getNome());
        category.setId(categoryDTO.getId());
        return category;
    }

}
