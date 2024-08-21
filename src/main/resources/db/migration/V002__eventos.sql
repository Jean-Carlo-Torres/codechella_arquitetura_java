CREATE TABLE eventos (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL UNIQUE,
    descricao VARCHAR(255) NOT NULL,
    categoria VARCHAR(50) NOT NULL,
    data TIMESTAMP NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf CHAR(2) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(9) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(100)
);

CREATE TABLE compras (
    id BIGSERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    usuario_id BIGINT NOT NULL,
    forma_de_pagamento VARCHAR(50) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE ingressos (
    id BIGSERIAL PRIMARY KEY,
    evento_id BIGINT NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    preco DECIMAL(7,2) NOT NULL,
    codigo VARCHAR(255) NOT NULL UNIQUE,
    compra_id BIGINT,
    tipo VARCHAR(100),
    versao INT NOT NULL,
    FOREIGN KEY (evento_id) REFERENCES eventos(id),
    FOREIGN KEY (compra_id) REFERENCES compras(id)
);
