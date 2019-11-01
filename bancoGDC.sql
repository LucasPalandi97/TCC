
CREATE SCHEMA IF NOT EXISTS gdcti;
USE gdcti ;

-- -----------------------------------------------------
-- Table gdcti.incidente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS incidente (
  id INT(11) NOT NULL,
  tipo VARCHAR(45) NOT NULL,
  data VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NOT NULL,
  subcategoria VARCHAR(45) NOT NULL,
  prioridade INT(1) NOT NULL,
  titulo VARCHAR(80) NOT NULL,
  descricao VARCHAR(1000) NOT NULL,
  serie VARCHAR(45) NULL DEFAULT NULL,
  status INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table gdcti.requisicao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS requisicao (
  id INT(11) NOT NULL AUTO_INCREMENT,
  tipo VARCHAR(3) NOT NULL,
  data VARCHAR(45) NOT NULL,
  categoria VARCHAR(45) NOT NULL,
  subcategoria VARCHAR(45) NOT NULL,
  prioridade INT(1) NOT NULL,
  titulo VARCHAR(80) NOT NULL,
  descricao VARCHAR(1000) NOT NULL,
  status INT(1) NULL DEFAULT NULL,
  PRIMARY KEY (id));


-- -----------------------------------------------------
-- Table gdcti.user
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS user (
  username VARCHAR(20) NOT NULL,
  name VARCHAR(45) NOT NULL,
  password VARCHAR(30) NOT NULL,
  funcao VARCHAR(12) NOT NULL,
  email VARCHAR(30) NOT NULL,
  telefone VARCHAR(14) NOT NULL,
  PRIMARY KEY (username),
  UNIQUE INDEX username_UNIQUE (username ASC) VISIBLE);
show tables;
select * from requisicao;