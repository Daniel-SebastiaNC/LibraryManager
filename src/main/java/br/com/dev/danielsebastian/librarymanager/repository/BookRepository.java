package br.com.dev.danielsebastian.librarymanager.repository;

import br.com.dev.danielsebastian.librarymanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
