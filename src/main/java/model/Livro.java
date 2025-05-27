package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    private Integer classificacao;

    private Integer genero;

    @OneToMany(mappedBy = "Livro")
    private List <Emprestimo> emprestimos;

}

