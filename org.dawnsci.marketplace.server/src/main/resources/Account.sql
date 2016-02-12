create table Account (id identity,
						username varchar(256) unique,
						password varchar(256) not null,
						firstName varchar(256) not null, 
						lastName varchar(256) not null,
						imageUrl varchar(256) null);