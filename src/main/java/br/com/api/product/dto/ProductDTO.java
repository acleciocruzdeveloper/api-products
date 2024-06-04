package br.com.api.product.dto;

import br.com.api.product.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public static ProductDTO converter(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setDescricao(product.getDescricao());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(product.getProductIdentifier());

        return productDTO;
    }

}
