
-- MySQL DROP
DROP DATABASE IF EXISTS db_rex;
DROP SCHEMA IF EXISTS db_rex;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_rex
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_rex` DEFAULT CHARACTER SET utf8 ;
USE `db_rex` ;


-- -----------------------------------------------------
-- Table `db_rex`.`tb_tipo_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_tipo_pessoa` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `mascara` VARCHAR(18) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_rex`.`tb_pessoa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_pessoa` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `tipo_pessoa` BIGINT(20) NOT NULL,
  `doc` VARCHAR(50) NOT NULL,
  `nome` VARCHAR(50) NOT NULL,
  `nome_auxiliar` VARCHAR(50) DEFAULT NULL,
  `email` VARCHAR(50) DEFAULT NULL,
  `endereco` BIGINT(20) DEFAULT NULL,
  `telefone` VARCHAR(50) DEFAULT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `doc` (`doc` ASC),
  INDEX `tipo_pessoa` (`tipo_pessoa` ASC),
  INDEX `endereco` (`endereco` ASC),
  CONSTRAINT `tb_pessoa_ibfk_1`
    FOREIGN KEY (`tipo_pessoa`)
    REFERENCES `db_rex`.`tb_tipo_pessoa` (`id`),
  CONSTRAINT `tb_pessoa_ibfk_2`
    FOREIGN KEY (`endereco`)
    REFERENCES `db_localidade`.`tb_endereco` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_nivel_acesso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_nivel_acesso` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `nivel` INT(2) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC),
  UNIQUE INDEX `nivel` (`nivel` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_rex`.`tb_usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_usuario` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `usuario` VARCHAR(20) NOT NULL,
  `senha` VARCHAR(20) NOT NULL,
  `pessoa` BIGINT(20) NOT NULL,
  `nivel_acesso` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `usuario` (`usuario` ASC),
  UNIQUE INDEX `pessoa` (`pessoa` ASC),
  INDEX `nivel_acesso` (`nivel_acesso` ASC),
  CONSTRAINT `tb_usuario_ibfk_1`
    FOREIGN KEY (`pessoa`)
    REFERENCES `db_rex`.`tb_pessoa` (`id`),
  CONSTRAINT `tb_usuario_ibfk_2`
    FOREIGN KEY (`nivel_acesso`)
    REFERENCES `db_rex`.`tb_nivel_acesso` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_unidade_medida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_unidade_medida` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_material`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_material` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `unidade_medida` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC),
  INDEX `unidade_medida` (`unidade_medida` ASC),
  CONSTRAINT `tb_material_ibfk_1`
    FOREIGN KEY (`unidade_medida`)
    REFERENCES `db_rex`.`tb_unidade_medida` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_competencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_competencia` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `usuario` BIGINT(20) NOT NULL,
  `material` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `usuario` (`usuario` ASC),
  INDEX `material` (`material` ASC),
  CONSTRAINT `tb_competencia_ibfk_1`
    FOREIGN KEY (`usuario`)
    REFERENCES `db_rex`.`tb_usuario` (`id`),
  CONSTRAINT `tb_competencia_ibfk_2`
    FOREIGN KEY (`material`)
    REFERENCES `db_rex`.`tb_material` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_status_doacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_status_doacao` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_doacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_rex`.`tb_doacao` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(50) NOT NULL,
  `descricao` VARCHAR(300) NOT NULL,
  `doador` BIGINT(20) DEFAULT NULL,
  `coletor` BIGINT(20) DEFAULT NULL,
  `endereco` BIGINT(20) NOT NULL,
  `status` BIGINT(20) DEFAULT NULL,
  
  `material` BIGINT(20) NOT NULL,
  `quantia` INT NOT NULL,
  
  `data_abertura` DATETIME NOT NULL,
  `data_coleta` DATETIME DEFAULT NULL,
  
  PRIMARY KEY (`id`),
  INDEX `doador` (`doador` ASC),
  INDEX `coletor` (`coletor` ASC),
  INDEX `endereco` (`endereco` ASC),
  INDEX `status` (`status` ASC),  
  INDEX `material` (`material` ASC),

  CONSTRAINT `tb_doacao_ibfk_1`
    FOREIGN KEY (`doador`)
    REFERENCES `db_rex`.`tb_usuario` (`id`),
  CONSTRAINT `tb_doacao_ibfk_2`
    FOREIGN KEY (`coletor`)
    REFERENCES `db_rex`.`tb_usuario` (`id`),
  CONSTRAINT `tb_doacao_ibfk_3`
    FOREIGN KEY (`endereco`)
    REFERENCES `db_localidade`.`tb_endereco` (`id`),
  CONSTRAINT `tb_doacao_ibfk_4`
    FOREIGN KEY (`status`)
    REFERENCES `db_rex`.`tb_status_doacao` (`id`),

  CONSTRAINT `tb_doacao_ibfk_5`
    FOREIGN KEY (`material`)
    REFERENCES `db_rex`.`tb_material` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
