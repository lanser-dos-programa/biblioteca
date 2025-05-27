package com.bibliotecaluca.demo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuario", nullable = false)
    private Usuario nome;

    @ManyToOne(optional = false)
    @JoinColumn(name = "livro", nullable = false)
    private Livro titulo;

    @Column(nullable = false)
    private LocalDate dataEmprestimo;

    @Column(nullable = false)
    private LocalDate dataDevolucao;

    @OneToMany(mappedBy = "Emprestimo")
    private List<Multa> multa;
}