/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     01/06/2020 22:27:46                          */
/*==============================================================*/


drop table if exists CLIENTE;

drop table if exists COMPRA;

drop table if exists COMPRAMEDICAMENTO;

drop table if exists DOMICILIO;

drop table if exists DROGUERIA;

drop table if exists EMPLEADO;

drop table if exists FACTURA;

drop table if exists FACTURAMEDICAMENTOS;

drop table if exists MEDICAMENTO;

drop table if exists MEDICAMENTOINVIMA;

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CEDULACLIENTE        varchar(11) not null,
   NOMBRE               varchar(20) not null,
   APELLIDO             varchar(20) not null,
   TELEFONO             varchar(15) not null,
   DIRECCIONCLIENTE     varchar(32) not null,
   DESCRIPCIONDIRECCION varchar(32),
   primary key (CEDULACLIENTE)
);

/*==============================================================*/
/* Table: COMPRA                                                */
/*==============================================================*/
create table COMPRA
(
   IDCOMPRA             int not null auto_increment,
   NOMBREPROVEEDOR      varchar(32) not null,
   PRECIOTOTAL          bigint not null,
   primary key (IDCOMPRA)
);

/*==============================================================*/
/* Table: COMPRAMEDICAMENTO                                     */
/*==============================================================*/
create table COMPRAMEDICAMENTO
(
   IDMEDICAMENTO        int not null,
   IDCOMPRA             int not null,
   PRECIOUNITARIO       int not null,
   CANTIDAD             int not null,
   primary key (IDMEDICAMENTO, IDCOMPRA)
);

/*==============================================================*/
/* Table: DOMICILIO                                             */
/*==============================================================*/
create table DOMICILIO
(
   IDDOMICILIO          int not null auto_increment,
   IDFACTURA            int,
   ESTADO               tinyint not null,
   primary key (IDDOMICILIO)
);

/*==============================================================*/
/* Table: DROGUERIA                                             */
/*==============================================================*/
create table DROGUERIA
(
   NITDROGUERIA         varchar(20) not null,
   NOMBREDROGUERIA      varchar(32) not null,
   DIRECCIONDROGUERIA   varchar(32) not null,
   TELEFONO             varchar(15) not null,
   EMAIL                varchar(50) not null,
   REPRESENTANTELEGAL   varchar(32) not null,
   primary key (NITDROGUERIA)
);

/*==============================================================*/
/* Table: EMPLEADO                                              */
/*==============================================================*/
create table EMPLEADO
(
   CEDULAEMPLEADO       varchar(11) not null,
   NOMBREEMPLEADO       varchar(20) not null,
   TELEFONO             varchar(15) not null,
   DIRECCIONEMPLEADO    varchar(32) not null,
   APELLIDOEMPLEADO     varchar(20) not null,
   CONTRASENIA          varchar(20) not null,
   CORREO               varchar(50) not null,
   primary key (CEDULAEMPLEADO)
);

/*==============================================================*/
/* Table: FACTURA                                               */
/*==============================================================*/
create table FACTURA
(
   IDFACTURA            int not null auto_increment,
   NITDROGUERIA         varchar(20),
   CEDULACLIENTE        varchar(11),
   CEDULAEMPLEADO       varchar(11),
   PRECIOTOTAL          bigint not null,
   primary key (IDFACTURA)
);

/*==============================================================*/
/* Table: FACTURAMEDICAMENTOS                                   */
/*==============================================================*/
create table FACTURAMEDICAMENTOS
(
   IDMEDICAMENTO        int not null,
   IDFACTURA            int not null,
   CANTIDADVENDIDA      int not null,
   primary key (IDMEDICAMENTO, IDFACTURA)
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
   IDMEDICAMENTO        int not null auto_increment,
   IDMEDICAMENTOINVIMA  int,
   PRECIOVENTA          int not null,
   STOCK                int not null,
   primary key (IDMEDICAMENTO)
);

/*==============================================================*/
/* Table: MEDICAMENTOINVIMA                                     */
/*==============================================================*/
create table MEDICAMENTOINVIMA
(
   IDMEDICAMENTOINVIMA  int not null auto_increment,
   NOMBREMEDICAMENTO    varchar(300) not null,
   TITULAR              varchar(300) not null,
   DESCRIPCION          varchar(300) not null,
   PRESENTACION         varchar(300) not null,
   PRINCIPIOACTIVO      varchar(300) not null,
   primary key (IDMEDICAMENTOINVIMA)
);

alter table COMPRAMEDICAMENTO add constraint FK_REFERENCE_6 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table COMPRAMEDICAMENTO add constraint FK_REFERENCE_7 foreign key (IDCOMPRA)
      references COMPRA (IDCOMPRA) on delete restrict on update restrict;

alter table DOMICILIO add constraint FK_REFERENCE_12 foreign key (IDFACTURA)
      references FACTURA (IDFACTURA) on delete restrict on update restrict;

alter table FACTURA add constraint FK_REFERENCE_10 foreign key (CEDULACLIENTE)
      references CLIENTE (CEDULACLIENTE) on delete restrict on update restrict;

alter table FACTURA add constraint FK_REFERENCE_11 foreign key (CEDULAEMPLEADO)
      references EMPLEADO (CEDULAEMPLEADO) on delete restrict on update restrict;

alter table FACTURA add constraint FK_REFERENCE_8 foreign key (NITDROGUERIA)
      references DROGUERIA (NITDROGUERIA) on delete restrict on update restrict;

alter table FACTURAMEDICAMENTOS add constraint FK_REFERENCE_5 foreign key (IDMEDICAMENTO)
      references MEDICAMENTO (IDMEDICAMENTO) on delete restrict on update restrict;

alter table FACTURAMEDICAMENTOS add constraint FK_REFERENCE_9 foreign key (IDFACTURA)
      references FACTURA (IDFACTURA) on delete restrict on update restrict;

alter table MEDICAMENTO add constraint FK_REFERENCE_13 foreign key (IDMEDICAMENTOINVIMA)
      references MEDICAMENTOINVIMA (IDMEDICAMENTOINVIMA) on delete restrict on update restrict;

