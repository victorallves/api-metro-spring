![api_metro_modelagem](https://github.com/victorallves/api-metro-spring/assets/113953361/2b3ecc44-95fc-471c-a47e-3ddc85700e32)

------------------------------------------------------------------------------
 Script de Criação das Tabelas 

------------------------------------------------------------------------------

CREATE TABLE Funcionario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    cargo VARCHAR(100) NOT NULL,
    salario NUMERIC(10, 2) NOT NULL
);


CREATE TABLE Linha (
    id_linha SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo_transporte VARCHAR(100) NOT NULL,
    estacao_inicio VARCHAR(100) NOT NULL,
    estacao_fim VARCHAR(100) NOT NULL
);


CREATE TABLE Veiculo (
    id_veiculo SERIAL PRIMARY KEY,
    tipo VARCHAR(100) NOT NULL,
    modelo VARCHAR(100) NOT NULL,
    numero_identificacao VARCHAR(100) NOT NULL
);


ALTER TABLE Funcionario
ADD COLUMN linha_id INTEGER,
ADD CONSTRAINT fk_funcionario_linha
FOREIGN KEY (linha_id)
REFERENCES Linha(id_linha);


ALTER TABLE Funcionario
ADD COLUMN veiculo_id INTEGER,
ADD CONSTRAINT fk_funcionario_veiculo
FOREIGN KEY (veiculo_id)
REFERENCES Veiculo(id_veiculo);

