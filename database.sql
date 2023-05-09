
CREATE TABLE borrower(
	bid int,
    name VARCHAR(50),
    pass VARCHAR(50),
	email VARCHAR(50),
	phone int,
    libcard boolean,
	PRIMARY KEY (bid) 
);
create table librarian(
	lid int,
    name VARCHAR(50),
    pass VARCHAR(50),
	PRIMARY KEY (lid) 
);


create table book(
	bookid int,
    title VARCHAR(50),
    author VARCHAR(50),
	borrowed boolean,
	PRIMARY KEY (bookid) 
);
create table borrowed(
	bookid int,
    userid int
);
INSERT INTO borrower VALUES (101, 'John Smith', 'pas123', 'jsmith@gmail.com', 0331555123, true);
INSERT INTO borrower VALUES (102, 'Jane Doe', 'abc123', 'jdoe@gmail.com', 0301555567, true);
INSERT INTO borrower VALUES (103, 'Bob Johnson', 'passw0rd', 'bjohnson@gmail.com', 0300555987, false);
INSERT INTO borrower VALUES (104, 'Sara', 'ilovecake', 'slee@gmail.com', 0302555432, true);
INSERT INTO borrower VALUES (105, 'Jack Brown', 'brownie', 'jbrown@gmail.com', 0300555876, true);
INSERT INTO borrower VALUES (106, 'Emily Davis', 'password456', 'edavis@gmail.com', 0333555345, false);
INSERT INTO borrower VALUES (107, 'David Lee', 'dlee123', 'dlee@gmail.com', 0333555789, true);

INSERT INTO librarian VALUES (110, 'John ', 'John101');
INSERT INTO librarian VALUES (122, 'Jones', 'sm134');
INSERT INTO librarian VALUES (133, 'Lara', 'La678');

INSERT INTO book VALUES (1, 'The Great Gatsby', 'F. Scott Fitzgerald', false);
INSERT INTO book VALUES (2, 'To Kill a Mockingbird', 'Harper Lee', true);
INSERT INTO book VALUES (3, '1984', 'George Orwell', false);
INSERT INTO book VALUES (4, 'Pride and Prejudice', 'Jane Austen', false);
INSERT INTO book VALUES (5, 'The Catcher in the Rye', 'J.D. Salinger', false);
INSERT INTO book VALUES (6, 'The Lord of the Rings', 'J.R.R. Tolkien', true);
INSERT INTO book VALUES (7, 'The Hitchhiker''s Guide to the Galaxy', 'Douglas Adams', true);
INSERT INTO book VALUES (8, 'Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', false);
INSERT INTO book VALUES (9, 'The Hobbit', 'J.R.R. Tolkien', false);

INSERT INTO borrowed VALUES (6, 102);
INSERT INTO borrowed VALUES (4, 101);
INSERT INTO borrowed VALUES (7, 104);


