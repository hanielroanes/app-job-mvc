create table client(
 id integer not null,
 name varchar(50) not null,
 phone varchar(16) not null,
 cpf varchar(20) not null,

 constraint pk_cliente primary key (id)
);

create table worker(
 id integer not null unique,
 name varchar(50) not null,
 phone varchar(16) not null,
 cpf varchar(20) not null,

 constraint pk_worker primary key (id)
);

create table service(
 id integer not null unique,
 description varchar(50) not null,
 id_worker integer not null,

 constraint pk_service primary key (id),
 constraint fk_worker foreign key (id_worker) references worker(id)
);

create table keyword(
 id integer not null unique,
 description varchar(50) not null,

 constraint pk_id primary key (id)
);

create table service_keyword(
 id_service integer not null,
 id_keyword integer not null,

 constraint fk_service foreign key (id_service) references service(id),
 constraint fk_keyword foreign key (id_keyword) references keyword(id)
);

create table user_phone(
 id_user integer not null,
 id_phone varchar(16) not null,

 constraint fk_user foreign key (id_user) references client(id)
);