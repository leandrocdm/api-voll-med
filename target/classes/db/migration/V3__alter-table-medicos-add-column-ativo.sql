alter table medicos add ativo TINYINT(1) not null;
update medicos set ativo = true;