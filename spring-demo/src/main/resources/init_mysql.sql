create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 4 );
create table person (id bigint not null, first_name varchar(255), last_name varchar(255), primary key (id));
insert into person values (1, 'Sandro', 'Giacomozzi');
insert into person values (2, 'Adriana', 'Giacomozzi');
insert into person values (3, 'Isabela', 'Giacomozzi');