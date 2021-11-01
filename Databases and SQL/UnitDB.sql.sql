create table Users(
	id serial primary key,
	name varchar(50) not null,
	description varchar(250) not null
);

create table Items(
	id serial primary key,
	name varchar(50) not null,
	count integer not null,
	user_id integer not null,
	constraint items_fk foreign key (user_id) references users(id)
); 

create table groups (
	id serial primary key,
	name varchar(50) not null
);
