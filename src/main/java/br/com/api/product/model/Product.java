package br.com.api.product.model;

import br.com.api.product.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "product")
public class Product {
    @Id
    private Long id;
    private String nome;
    private String descricao;
    private Float preco;
    private String productIdentifier;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product() {
    }

    public Product(Long id, String nome, String descricao, Float preco, String productIdentifier, Category category) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.productIdentifier = productIdentifier;
        this.category = category;
    }

    public static Product converter(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(product.getNome());
        product.setDescricao(productDTO.getDescricao());
        product.setPreco(productDTO.getPreco());
        product.setProductIdentifier(productDTO.getProductIdentifier());
        if (productDTO.getCategoryDTO() != null) {
            product.setCategory(
                    Category.coverter(productDTO.getCategoryDTO())
            );
        }
        return product;
    }

}
