ALTER TABLE tb_reader DROP COLUMN book_id;

ALTER TABLE tb_book
ADD COLUMN reader_id INTEGER;

ALTER TABLE tb_book ADD
CONSTRAINT fk_book_reader FOREIGN KEY(reader_id) REFERENCES tb_reader(id);