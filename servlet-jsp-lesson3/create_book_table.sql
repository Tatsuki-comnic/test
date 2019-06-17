CREATE TABLE author(
	id   int primary key auto_increment,
	name varchar(20)
);

CREATE TABLE publisher(
	id   int primary key auto_increment,
	name varchar(20)
);

CREATE TABLE book(
	isbn         char(14) primary key,
	title        varchar(30) not null,
	author_id    int not null,
	publisher_id int not null,
	price        double not null,
	foreign key(author_id) references author(id),
	foreign key(publisher_id) references publisher(id)
);

INSERT INTO author(name) VALUES('Paul Auster');
INSERT INTO author(name) VALUES('Steven Millhauser');
INSERT INTO author(name) VALUES('Raymond Carver');
INSERT INTO author(name) VALUES('Kurt Vonnegut');
INSERT INTO author(name) VALUES('Truman Capote');

INSERT INTO publisher(name) VALUES('Picador');
INSERT INTO publisher(name) VALUES('Vintage');
INSERT INTO publisher(name) VALUES('Penguin Books');
INSERT INTO publisher(name) VALUES('Dial Press');

INSERT INTO book VALUES('978-1250160010', '4 3 2 1', 1, 1, 10.48);
INSERT INTO book VALUES('978-0804169080', 'Voices in the Night',2, 2, 10.87);
INSERT INTO book VALUES('978-0375726286', 'Call If You Need Me',3, 2, 15.10);
INSERT INTO book VALUES('978-0679745648', 'Other Voices, Other Rooms',5, 2, 12.07);
INSERT INTO book VALUES('978-0385333498', 'The Sirens of Titan',4 , 4, 13.60);
INSERT INTO book VALUES('978-0375726222', 'The Music of Chance', 1, 3, 12.99);
INSERT INTO book VALUES('978-0375701436', 'Little Kingdoms',2 ,2, 15.95);
INSERT INTO book VALUES('978-0143039839', 'The New York Trilogy',1, 3, 12.30);
INSERT INTO book VALUES('978-0679745570', 'The Grass Harp', 5, 2, 11.64);
INSERT INTO book VALUES('978-0385334143', 'Mother Night',4, 4, 9.78);
INSERT INTO book VALUES('978-0140115857', 'Moon Palace',1, 3, 13.60);
INSERT INTO book VALUES('978-0375703805', 'All of Us',3, 2, 13.56);



