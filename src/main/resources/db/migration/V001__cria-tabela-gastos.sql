create table gasto (
  id bigint not null auto_increment,
  descricao varchar(60) not null,
  valor decimal(10,2) not null,
  data_gasto date not null,
  primary key (id)
);