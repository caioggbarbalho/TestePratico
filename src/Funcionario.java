import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario extends Pessoa{
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    //ATRIBUTOS
    private BigDecimal salario;
    private String funcao;

    //CONSTRUTOR
    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    //MÉTODOS
    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void receberAumento(int percento) {
        BigDecimal fator = BigDecimal.valueOf(1 + (percento / 100.0));
        this.salario = this.salario.multiply(fator);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "; Data de Nascimento: " + getDataNascimento().format(formatter) +
                "; Salário: R$" + String.format("%,.2f", getSalario()) +
                "; Função: " + getFuncao();
    }
}