CREATE SCHEMA IF NOT EXISTS products;

CREATE TABLE IF NOT EXISTS products.category
(
    id   bigserial primary key,
    nome varchar(150) not null
);

CREATE TABLE IF NOT EXISTS products.product
(
    id                 bigserial primary key,
    product_identifier varchar      not null,
    nome               varchar(100) not null,
    descricao          varchar(250) not null,
    preco              float        not null,

    category_id        bigint REFERENCES products.category (id)
);

INSERT INTO products.category(id, nome)
values (1, 'Eletrônico');
INSERT INTO products.category(id, nome)
values (2, 'Móveis');
INSERT INTO products.category(id, nome)
values (3, 'Brinquedos');
