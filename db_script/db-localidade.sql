
-- MySQL DROP
DROP DATABASE IF EXISTS db_localidade;
DROP SCHEMA IF EXISTS db_localidade;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema db_localidade
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `db_localidade` DEFAULT CHARACTER SET utf8 ;
USE `db_localidade` ;


-- -----------------------------------------------------
-- Table `db_localidade`.`tb_pais`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_pais` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_localidade`.`tb_estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_estado` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `regiao` VARCHAR(50) NOT NULL,
  `pais` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC),
  UNIQUE INDEX `uf` (`uf` ASC),
  INDEX `pais` (`pais` ASC),
  CONSTRAINT `tb_estado_ibfk_1`
    FOREIGN KEY (`pais`)
    REFERENCES `db_localidade`.`tb_pais` (`id`))  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_localidade`.`tb_municipio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_municipio` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `estado` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC),
  INDEX `estado` (`estado` ASC),
  CONSTRAINT `tb_municipio_ibfk_1`
    FOREIGN KEY (`estado`)
    REFERENCES `db_localidade`.`tb_estado` (`id`))  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_localidade`.`tb_bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_bairro` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `municipio` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC),
  INDEX `municipio` (`municipio` ASC),
  CONSTRAINT `tb_bairro_ibfk_1`
    FOREIGN KEY (`municipio`)
    REFERENCES `db_localidade`.`tb_municipio` (`id`))  
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_localidade`.`tb_tipo_logradouro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_tipo_logradouro` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nome` (`nome` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;




-- -----------------------------------------------------
-- Table `db_localidade`.`tb_logradouro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_logradouro` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(50) NOT NULL,
  `tipo_logradouro` BIGINT(20) NOT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `nome` (`nome` ASC),
  INDEX `tipo_logradouro` (`tipo_logradouro` ASC),
    CONSTRAINT `tb_logradouro_ibfk_1`
    FOREIGN KEY (`tipo_logradouro`)
    REFERENCES `db_localidade`.`tb_tipo_logradouro` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



-- -----------------------------------------------------
-- Table `db_localidade`.`tb_endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_localidade`.`tb_endereco` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(50) DEFAULT NULL,
  `latitude` FLOAT DEFAULT NULL,
  `longitude` FLOAT DEFAULT NULL,
  `bairro` BIGINT(20) DEFAULT NULL,
  `logradouro` BIGINT(20) DEFAULT NULL,
  `numero` INT(8) DEFAULT NULL,
  `complemento` VARCHAR(50) DEFAULT NULL,
  `data_inclusao` DATETIME NOT NULL,
  `data_remocao` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `bairro` (`bairro` ASC),
  CONSTRAINT `tb_endereco_ibfk_1`
    FOREIGN KEY (`bairro`)
    REFERENCES `db_localidade`.`tb_bairro` (`id`),
  INDEX `logradouro` (`logradouro` ASC),
  CONSTRAINT `tb_endereco_ibfk_2`
    FOREIGN KEY (`logradouro`)
    REFERENCES `db_localidade`.`tb_logradouro` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
