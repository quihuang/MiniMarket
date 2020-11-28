create database if not exists bd_mini_proyecto;
use bd_mini_proyecto;

create table TblTipoIdentificacion(

	TipId int not null auto_increment primary key,
	TipNombre varchar(50) not null
);

create table TblTipoProducto(
	TipProId int not null auto_increment primary key,
	TipProNombre varchar(50) not null,
	TipProIva decimal not null
);

create table TblEstado(

	EstId int not null auto_increment primary key,
	EstEstado varchar(50) not null
);

create table TblMetodoPago(
	MetId int not null auto_increment primary key,
	MetDescripcion varchar(50) not null
);

create table TblProducto(

	ProRef int not null auto_increment primary key,
	ProNombre varchar(50) not null,
	ProPrecio decimal not null,
	ProStock int not null,
	ProFechaVencimiento date not null,
	TblTipoProducto_TipId int not null,
	TblEstado_EstId int not null

);

alter table TblProducto add foreign key(TblEstado_EstId) references TblEstado(EstId);
alter table TblProducto add foreign key(TblTipoProducto_TipId) references TblTipoProducto(TipProId);

create table TblCliente(

	CliIdentificacion int not null auto_increment primary key,
	CliContrasenia varchar(200) not null,
	CliNombre1 varchar(50) not null,
	CliNombre2 varchar(50),
	CliApellido1 varchar(50) not null,
	CliApellido2 varchar(50),
	CliCelular varchar(50),
	CliCorreo varchar(50),
	TblTipoIdenticacion_TipId int not null,
	TblEstado_EstId int not null
);


create table TblAdministrador(

	AdmIdentificacion int not null auto_increment primary key,
	AdmContrasenia varchar(200) not null,
	AdmNombre1 varchar(50) not null,
	AdmNombre2 varchar(50),
	AdmApellido1 varchar(50) not null,
	AdmApellido2 varchar(50),
	AdmCelular varchar(50),
	AdmCorreo varchar(50),
	TblTipoIdenticacion_TipId int not null,
	TblEstado_EstId int not null


);


create table TblVendedor(

	VenIdentificacion int not null auto_increment primary key,
	VenContrasenia varchar(200) not null,
	VenNombre1 varchar(50) not null,
	VenNombre2 varchar(50),
	VenApellido1 varchar(50) not null,
	VenApellido2 varchar(50),
	VenCelular varchar(50),
	VenCorreo varchar(50),
	TblTipoIdenticacion_TIpId int not null,
	TblEstado_EstId int not null
);

alter table TblCliente add foreign key(TblEstado_EstId) references TblEstado(EstId);
alter table TblAdministrador add foreign key(TblEstado_EstId) references TblEstado(EstId);
alter table TblVendedor add foreign key(TblEstado_EstId) references TblEstado(EstId);



alter table TblCliente add foreign key(TblTipoIdenticacion_TipId) references TblTipoIdentificacion(TipId);
alter table TblAdministrador add foreign key(TblTipoIdenticacion_TipId) references TblTipoIdentificacion(TipId);
alter table TblVendedor add foreign key(TblTipoIdenticacion_TipId) references TblTipoIdentificacion(TipId);

create table TblPedido(

	PedId int not null auto_increment primary key,
	PedFecha date not null,
	TblCliente_CliIdenficacion int not null,
	TblMetodoPago_MetId int not null
);

alter table TblPedido add foreign key(TblMetodoPago_MetId) references TblMetodoPago(MetId);


create table TblProductoPedido(
	ProPed_Id int not null auto_increment primary key,
	TblProducto_ProRef int not null,
	TblPedido_PedId int not null 
);


alter table TblProductoPedido add foreign key(TblPedido_PedId) references TblPedido(PedId);
alter table TblProductoPedido add foreign key(TblProducto_ProRef) references TblProducto(ProRef);



insert into TblEstado values(null,"activo");
insert into TblEstado values(null,"inactivo");

insert into TblTipoIdentificacion values(null,"cedula");
insert into TblTipoIdentificacion values(null,"cedula extrangeria");
insert into TblTipoIdentificacion values(null,"NIT");


insert into TblMetodoPago values(null,"efectivo");
insert into TblMetodoPago values(null,"tarjeta debito");
insert into TblMetodoPago values(null,"tarjeta credito");


ALTER TABLE TblTipoProducto ADD UNIQUE (TipProNombre);
ALTER TABLE TblProducto ADD UNIQUE (ProNombre);