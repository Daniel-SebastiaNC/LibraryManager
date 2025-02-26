CREATE TABLE tb_reader (
    id serial PRIMARY KEY,
    name varchar(100) NOT NULL,
    book_id INTEGER,
    CONSTRAINT fk_reader_book FOREIGN KEY(book_id) REFERENCES tb_book(id)
);