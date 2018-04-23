
SELECT IF((SELECT MIN(db_localidade.tb_estado.id) FROM db_localidade.tb_estado WHERE LOWER(db_localidade.tb_estado.nome) = Chile) IS NOT NULL , TRUE , FALSE)


SELECT EXISTS(SELECT 1 FROM db_localidade.tb_estado WHERE db_localidade.tb_estado.nome LIKE '%Estado%') as count
SELECT EXISTS( SELECT 1 FROM db_localidade.tb_estado WHERE db_localidade.tb_estado.nome LIKE '%Estado%' ) as count


SELECT u.usuario as NomeUsuario ,p.email as Email, n.nome as NivelAcesso, p.nome as NomePessoa, p.nome_auxiliar as Apelido, tf.numero as Telefone, tp.nome as TipoPessoa,
b.nome as Bairro, e.cep as CEP,l.nome as Logradouro, e.numero as Numero, tl.nome as TipoLogradouro, e.complemento as Complemento FROM db_rex.tb_usuario u 
	INNER JOIN db_rex.tb_nivel_acesso n ON u.nivel_acesso = n.id 
	INNER JOIN db_rex.tb_pessoa p ON u.pessoa = p.id
	INNER JOIN db_rex.tb_telefone tf ON p.id = tf.pessoa
	INNER JOIN db_rex.tb_tipo_pessoa tp ON p.tipo_pessoa = tp.id
	INNER JOIN db_localidade.tb_endereco e ON e.id = p.endereco
	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id
	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id
	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id
	
	SELECT u.usuario as NomeUsuario ,p.email as Email, n.nome as NivelAcesso, p.nome as NomePessoa, p.nome_auxiliar as Apelido, tp.nome as TipoPessoa,
b.nome as Bairro, e.cep as CEP,l.nome as Logradouro, e.numero as Numero, tl.nome as TipoLogradouro, e.complemento as Complemento FROM db_rex.tb_usuario u 
	INNER JOIN db_rex.tb_nivel_acesso n ON u.nivel_acesso = n.id 
	INNER JOIN db_rex.tb_pessoa p ON u.pessoa = p.id
	INNER JOIN db_rex.tb_tipo_pessoa tp ON p.tipo_pessoa = tp.id
	INNER JOIN db_localidade.tb_endereco e ON e.id = p.endereco
	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id
	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id
	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id
	
	
	SELECT d.titulo as Titulo, d.descricao as Descricao, d.doador as Doador, d.coletor as Coletor, sd.nome as Status,
b.nome as Bairro, e.cep as CEP, e.numero as Numero, e.complemento as Complemento, l.nome as Logradouro, tl.nome as TipoLogradouro,  
	FROM db_rex.tb_doacao d
	INNER JOIN db_rex.tb_status_doacao sd ON d.status = sd.id
	INNER JOIN db_localidade.tb_endereco e ON e.id = d.endereco
	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id
	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id
	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id

	SELECT d.id as idDoacao, d.titulo as Titulo, d.descricao as Descricao, d.doador as Doador, d.coletor as Coletor, sd.nome as Status, m.id as idMaterial, m.nome as Material, d.quantia as Quantia, um.nome as UnidadeMedida, b.nome as Bairro, e.cep as CEP, e.numero as Numero, e.complemento as Complemento, l.nome as Logradouro, tl.nome as TipoLogradouro FROM db_rex.tb_doacao d
	INNER JOIN db_rex.tb_status_doacao sd ON d.status = sd.id
	INNER JOIN db_rex.tb_material m ON m.id = d.material
	INNER JOIN db_rex.tb_unidade_medida um ON m.unidade_medida = um.id
	INNER JOIN db_localidade.tb_endereco e ON e.id = d.endereco
	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id
	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id
	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id

SELECT d.id as idDoacao, d.titulo as Titulo, d.descricao as Descricao, d.doador as Doador, d.coletor as Coletor, sd.nome as Status, b.nome as Bairro, e.cep as CEP, e.numero as Numero, e.complemento as Complemento, l.nome as Logradouro, tl.nome as TipoLogradouro, d.data_coleta as DataRemocao FROM db_rex.tb_doacao d
	INNER JOIN db_rex.tb_status_doacao sd ON d.status = sd.id
	INNER JOIN db_localidade.tb_endereco e ON e.id = d.endereco
	INNER JOIN db_localidade.tb_logradouro l ON e.logradouro = l.id
	INNER JOIN db_localidade.tb_tipo_logradouro tl ON l.tipo_logradouro = tl.id
	INNER JOIN db_localidade.tb_bairro b ON e.bairro = b.id WHERE  b.nome LIKE '%Ce%'



-- SELECT * FROM db_localidade.;
-- SELECT * FROM db_localidade.tb_pais;
-- SELECT * FROM db_localidade.tb_estado;
-- SELECT * FROM db_localidade.tb_municipio;
-- SELECT * FROM db_localidade.tb_bairro;
-- SELECT * FROM db_localidade.tb_tipo_logradouro;
-- SELECT * FROM db_localidade.tb_endereco;

	

-- SELECT * FROM db_rex.tb_tipo_logradouro;
-- SELECT * FROM db_rex.tb_endereco;
-- SELECT * FROM db_rex.tb_tipo_pessoa;
-- SELECT * FROM db_rex.tb_pessoa;
-- SELECT * FROM db_rex.tb_telefone;
-- SELECT * FROM db_rex.tb_nivel_acesso;
-- SELECT * FROM db_rex.tb_usuario;

-- SELECT * FROM db_rex.tb_usuario;

-- SELECT * FROM db_rex.tb_doacao;
-- SELECT * FROM db_rex.tb_material;

-- -----------------------------------------------------
-- Table `db_rex`.`tb_material_doacao`
-- -----------------------------------------------------
--CREATE TABLE IF NOT EXISTS `db_rex`.`tb_material_doacao` (
--  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
--  `doacao` BIGINT(20) NOT NULL,
--  `material` BIGINT(20) NOT NULL,
--  `quantia` INT NOT NULL,
--  `data_inclusao` DATETIME NOT NULL,
--  `data_remocao` DATETIME DEFAULT NULL,
--  PRIMARY KEY (`id`),
--  INDEX `doacao` (`doacao` ASC),
--  INDEX `material` (`material` ASC),
--  CONSTRAINT `tb_material_doacao_ibfk_1`
--    FOREIGN KEY (`doacao`)
--    REFERENCES `db_rex`.`tb_doacao` (`id`),
--  CONSTRAINT `tb_material_doacao_ibfk_2`
--    FOREIGN KEY (`material`)
--    REFERENCES `db_rex`.`tb_material` (`id`))
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `db_rex`.`tb_telefone`
-- -----------------------------------------------------
--CREATE TABLE IF NOT EXISTS `db_rex`.`tb_telefone` (
--  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
--  `pessoa` BIGINT(20) NOT NULL,
--  `numero` VARCHAR(50) NOT NULL,
--  `data_inclusao` DATETIME NOT NULL,
--  `data_remocao` DATETIME DEFAULT NULL,
--  PRIMARY KEY (`id`),
--  UNIQUE INDEX `numero` (`numero` ASC),
--  INDEX `pessoa` (`pessoa` ASC),
--  CONSTRAINT `tb_telefone_ibfk_1`
--    FOREIGN KEY (`pessoa`)
--    REFERENCES `db_rex`.`tb_pessoa` (`id`))
--ENGINE = InnoDB
--DEFAULT CHARACTER SET = utf8;