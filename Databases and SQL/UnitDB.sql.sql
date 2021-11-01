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

create table group_to_user(
	group_id integer not null, 
	user_id integer not null, 
	
	constraint user_id_fk foreign key (user_id) references users (id),
	constraint group_id_fk foreign key (group_id) references groups (id)
);
