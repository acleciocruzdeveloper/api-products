package br.com.api.product.dto;

import br.com.api.product.model.Category;
import br.com.api.product.model.Product;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDTO {

    private String nome;
    private String descricao;
    private Float preco;
    private String productIdentifier;
    private CategoryDTO categoryDTO;

    public ProductDTO() {
    }

    public ProductDTO(String nome, String descricao, Float preco, String productIdentifier, CategoryDTO categoryDTO) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.productIdentifier = productIdentifier;
        this.categoryDTO = categoryDTO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getProductIdentifier() {
        return productIdentifier;
    }

    public void setProductIdentifier(String productIdentifier) {
        this.productIdentifier = productIdentifier;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public static ProductDTO converter(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());

        return productDTO;
    }

}
