create database Tarea_ejercicio1;
go

use Tarea_ejercicio1;
go

create table Autor(
    idAutor varchar(5) not null,
    nombre varchar(45) not null,
    apellido varchar(45) not null,
    edad int,
    estado bit constraint DF_Autor_estado default 1,
    
    constraint PK_Autor primary key (idAutor),
    constraint CK_Autor_edad check (edad > 18)
);

create table Libro(
    idLibro int identity(1,1) not null constraint PK_Libro primary key,
    nombre varchar(45) not null,
    descripcion varchar(45) null,
    nro_paginas int constraint DF_Libro_nro_paginas default 10,
    Autor_idAutor varchar(5),
    isbn varchar(20),
    
    constraint CK_Libro_nro_paginas check (nro_paginas >= 10),
    constraint U_Libro_isbn unique nonclustered (isbn)
);

alter table Libro
    add constraint FK_Autor_Libro foreign key (Autor_idAutor) 
    references Autor(idAutor) on update cascade;

insert into Autor(idAutor, nombre, apellido, edad)
values('A0001', 'Gabriel', 'García Márquez', 87);

select * from Autor;

insert into Libro(nombre, descripcion, nro_paginas, Autor_idAutor, isbn)
values('Cien años de soledad', 'Novela de realismo mágico', 417, 'A0001', '978-0307474728');

select * from Libro;

update Autor set idAutor = 'A0002' where idAutor = 'A0001';

select * from Libro;