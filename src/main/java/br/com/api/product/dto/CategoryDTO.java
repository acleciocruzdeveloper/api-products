package br.com.api.product.dto;

import br.com.api.product.model.Category;

public class CategoryDTO {
    private Long id;
    private String nome;

    public CategoryDTO() {
    }

    public CategoryDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static CategoryDTO coverter(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setNome(category.getNome());
        categoryDTO.setId(category.getId());
        return categoryDTO;
    }
}
