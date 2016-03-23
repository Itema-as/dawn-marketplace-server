create table if not exists UserConnection (userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(512) not null,
	secret varchar(512),
	refreshToken varchar(512),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));


drop index if exists UserConnectionRank
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

create table if not exists Account (id identity,
	username varchar(256) unique,
	password varchar(256) not null,
	firstName varchar(256) not null, 
	lastName varchar(256) not null);

create table if not exists SolutionConnection (
	username varchar(256) not null,
	solution varchar(256) not null,
	primary key (username, solution));
