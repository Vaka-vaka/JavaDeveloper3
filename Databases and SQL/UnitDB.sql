create table Users(
	id serial primary key,
	name varchar(50) not null,
	description varchar(50) not null
);

create table Items(
	users_id serial primary key,
	name varchar(50) not null,
	count integer not null
); 