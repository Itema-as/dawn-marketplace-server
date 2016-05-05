/* Create a normal user */
insert into Account 
	(username, password, firstName, lastName) values 
	('user', 'password', 'firstName', 'lastName');
	
insert into Authorities
	(username, authority) values 
	('user', 'ROLE_USER');			

/* Create a user that can do uploads */
insert into Account 
	(username, password, firstName, lastName) values 
	('upload', 'password', 'firstName', 'lastName');
	
insert into Authorities
	(username, authority) values 
	('upload', 'ROLE_USER');

insert into Authorities
	(username, authority) values 
	('upload', 'ROLE_UPLOAD');
