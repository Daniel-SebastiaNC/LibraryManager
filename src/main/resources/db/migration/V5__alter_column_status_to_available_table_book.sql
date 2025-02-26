ALTER TABLE tb_book RENAME COLUMN status TO available;
ALTER TABLE tb_book ALTER COLUMN available SET DEFAULT true;
