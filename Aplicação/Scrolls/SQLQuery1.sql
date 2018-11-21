use master
go
drop database dbScrolls

use dbScrolls

select * from Imagem

select * from Produto
exec sp_help Produto
select * from Funcionario

select * from Categoria

select * from Genero where CategoriaId = 2

select * from Endereco


insert into Endereco(CEP, Pais, Estado, Cidade, Bairro, Logradouro, Complemento, Numero)
values ('1', '1', '1', '1', '1', '1', '1', 1)
go
insert into Funcionario
values ('Administrador', 'do Site', '000.000.000-00', 'as@as.as', 'c:/', '123', 1, 1)

go


insert into Categoria values('Livro'), ('Jogos')
go
insert into Genero values('Fantasia', 1), ('Horror', 1), ('Jogos', 1), ('Romance', 1), ('Xbox', 2), ('PS3', 2), ('Wii', 2)
