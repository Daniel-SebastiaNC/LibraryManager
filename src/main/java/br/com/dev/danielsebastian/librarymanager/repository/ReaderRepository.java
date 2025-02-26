package br.com.dev.danielsebastian.librarymanager.repository;

import br.com.dev.danielsebastian.librarymanager.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
