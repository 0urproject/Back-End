create database db_aMEI;
use db_aMEI;
CREATE TABLE temas (
	id bigint PRIMARY KEY  AUTO_INCREMENT,
	categoria varchar(255) NOT NULL,
	hashtag varchar(255) NOT NULL,
	descricao varchar(255) NOT NULL	
);

CREATE TABLE usuarios (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	nome varchar(255) NOT NULL,
	email varchar(255) NOT NULL,
	descricaoperfil varchar(500) NOT NULL,
	imgusuario varchar(255) NOT NULL,
	senha varchar(80) NOT NULL	
);

CREATE TABLE posts (
	id bigint PRIMARY KEY AUTO_INCREMENT,
	usuarios_id bigint NOT NULL,
	descricao varchar(500) NOT NULL,
	imgpost varchar(500) NOT NULL,
	temas_id bigint NOT NULL	
);

ALTER TABLE posts ADD CONSTRAINT posts_fk0 FOREIGN KEY (usuarios_id) REFERENCES usuarios(id);

ALTER TABLE posts ADD CONSTRAINT posts_fk3 FOREIGN KEY (temas_id) REFERENCES temas(id);

