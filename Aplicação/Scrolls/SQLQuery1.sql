use master
go
drop database dbScrolls

use dbScrolls

exec sp_help Produto

select * from Banner

select * from Produto

select * from Funcionario

select * from Cliente

select * from Categoria

select * from Genero

select * from Endereco

insert into Produto(Nome, Descricao, Preco, Quantidade, Complemento, GeneroId)
values('Livro', 'teste', 32.32, 32, '<table class="table table-bordered responsive" id="products-table"><tbody><tr><th>Titulo</th><th>Descrição</th><th>Ações</th></tr><tr><td contenteditable="true" style="vertical-align: middle; max-width: 295px;" width="295">&nbsp;Autor</td><td contenteditable="true" style="vertical-align: middle; max-width: 665px;" width="665">Duo bot do amor&nbsp;</td><td style="text-align: center; vertical-align: middle; max-width: 157px;" width="157"><button type="button" class="btn btn-white" onclick="RemoveTableRow(this)" style="border-radius: 50%;  height: 42px;"><i class="entypo-cancel"></i></button></td></tr></tbody><tfoot><tr><td colspan="5" style="text-align: left;"><button onclick="AddTableRow()" type="button" style="border-radius: 25%;"><i class="entypo-plus"></i></button></td></tr></tfoot></table>', 3)
go
insert into Produto(Nome, Descricao, Preco, Quantidade, Promocao, Complemento, GeneroId)
values('testerep', 'testerep', 34.32, 0, 59 ,'<table class="table table-bordered responsive" id="products-table"><tbody><tr><th>Titulo</th><th>Descrição</th><th>Ações</th></tr><tr><td contenteditable="true" style="vertical-align: middle; max-width: 295px;" width="295">&nbsp;Autor</td><td contenteditable="true" style="vertical-align: middle; max-width: 665px;" width="665">Duo bot do amor&nbsp;</td><td style="text-align: center; vertical-align: middle; max-width: 157px;" width="157"><button type="button" class="btn btn-white" onclick="RemoveTableRow(this)" style="border-radius: 50%;  height: 42px;"><i class="entypo-cancel"></i></button></td></tr></tbody><tfoot><tr><td colspan="5" style="text-align: left;"><button onclick="AddTableRow()" type="button" style="border-radius: 25%;"><i class="entypo-plus"></i></button></td></tr></tfoot></table>', 7)

insert into Funcionario
values ('Administrador', 'do Site', '000.000.000-00', '00.000.000-0', 'as@as.as', 'c:/', '10-10-2020', '00000-000', 'Uma rua', '12', '123', 1)

go


insert into Categoria values('Livro'), ('Jogos'), ('Vestuário')
go
insert into Genero values('Fantasia', 1), ('Horror', 1), ('Jogos', 1), ('Romance', 1), ('Xbox', 2), ('PS3', 2), ('Wii', 2), ('Camisetas', 3), ('Manga longa', 3), ('Moletom', 3)

