set foreign_key_checks = 0;

delete from gasto;
delete from usuario;

set foreign_key_checks = 1;

alter table gasto auto_increment = 1;
alter table usuario auto_increment = 1;

insert into gasto (id, data_gasto, descricao, valor) values
( 1, '2020-12-09', 'Mercado',                      28.20),
( 2, '2020-12-10', 'Condominio',                  260.00),
( 3, '2020-11-11', 'Abastecer',                    50.00),
( 4, '2020-11-16', 'Aluguel',                      46.49),
( 5, '2020-10-16', 'Conta de Agua',               107.50),
( 6, '2020-10-18', 'Conta de luz',                 48.24);

insert into usuario (id, nome) values
( 1, 'Victor'),
( 2, 'Milena');