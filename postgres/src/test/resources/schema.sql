create database postgres;

comment on database postgres
is 'default administrative connection database';

create sequence nothing_id_seq
  as integer
  maxvalue 2147483647;

create table nothing
(
	id int not null
		constraint coffee_pkey
			primary key,
	name varchar(255) not null
);

