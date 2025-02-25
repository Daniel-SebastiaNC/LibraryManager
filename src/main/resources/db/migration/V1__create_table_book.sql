CREATE TABLE tb_book (
    id serial PRIMARY KEY,
    title varchar(100) NOT NULL,
    author varchar(70) NOT NULL,
    description text,
    status BIT NOT NULL
);