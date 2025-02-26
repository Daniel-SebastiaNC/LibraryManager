package br.com.dev.danielsebastian.librarymanager.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 70, nullable = false)
    private String author;

    private String description;

    @Column(columnDefinition="boolean default true", nullable = false)
    private boolean available;

}
