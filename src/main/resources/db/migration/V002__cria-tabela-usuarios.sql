create table usuario (
	id bigint not null auto_increment,
	nome varchar(60) not null,
	
	primary key (id)
);

create table gastos_usuarios (
	gasto_id bigint not null,
	usuario_id bigint not null,
	
	constraint pk_ghasto_usuario primary key (gasto_id, usuario_id),
	
	constraint fk_gasto foreign key (gasto_id) references gasto (id),
	constraint fk_usuario foreign key (usuario_id) references usuario (id)
);