import java.time.LocalDate;

public class Pessoa {
    //ATRIBUTOS
    private String Nome;
    private LocalDate dataNascimento;

    //CONSTRUTOR
    public Pessoa(String nome, LocalDate dataNascimento) {
        Nome = nome;
        this.dataNascimento = dataNascimento;
    }

    //GETTERS
    public String getNome() {
        return Nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
