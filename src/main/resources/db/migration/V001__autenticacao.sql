CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE perfis_acesso (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE usuarios_perfis (
    id_usuario BIGINT NOT NULL,
    id_perfil BIGINT NOT NULL,
    PRIMARY KEY(id_usuario, id_perfil),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id),
    FOREIGN KEY (id_perfil) REFERENCES perfis_acesso(id)
);

INSERT INTO perfis_acesso (id, nome) VALUES (1, 'ROLE_ADMIN');
INSERT INTO perfis_acesso (id, nome) VALUES (2, 'ROLE_COMPRADOR');

INSERT INTO usuarios (id, nome, cpf, email, data_nascimento, senha) VALUES
(1, 'Administrador', '00000000000', 'admin@email.com.br', '1990-01-01', '$2a$10$NRPNQpth64z1VKCrOdtZ/Otpk5zHsbaVXdXYPJazgsaH/QBvE3WPy'),
(2, 'Comprador', '11111111111', 'comprador@email.com.br', '1980-10-10', '$2a$10$f.lj9PV2eC2H3LLZzsYciu.Gkg.zTu9mIa05DfCQMCvmzw47WolXu');

INSERT INTO usuarios_perfis (id_usuario, id_perfil) VALUES (1, 1);
INSERT INTO usuarios_perfis (id_usuario, id_perfil) VALUES (1, 2);
INSERT INTO usuarios_perfis (id_usuario, id_perfil) VALUES (2, 2);
