package model;
import jakarta.persistence.*;
import java.util.List;
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "usuario")
    private List <Emprestimo> emprestimos;


}
