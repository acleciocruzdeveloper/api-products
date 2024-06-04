package br.com.api.product.model;

import br.com.api.product.dto.CategoryDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

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

    public Long getId() {
        return id;
    }

    private void seId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static Category coverter(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setNome(categoryDTO.getNome());
        category.seId(categoryDTO.getId());
        return category;
    }

}
