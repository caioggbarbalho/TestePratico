import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //3.1 Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
        List<Funcionario> funcionarios = new ArrayList<>();

        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloísa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        //3.2 Remover o funcionário “João” da lista.
        funcionarios.removeIf(funcionario -> funcionario.getNome().equalsIgnoreCase("João"));

        //3.3 Imprimir todos os funcionários com todas suas informações
        System.out.println("Tabela de Funcionários");
        for (Funcionario f : funcionarios) {
            System.out.println(f);
        }

        //3.4 Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
        System.out.println();
        System.out.println("Os funcionários receberam aumento de 10%. ATUALIZANDO TABELA...");
        for (Funcionario f: funcionarios) {
            f.receberAumento(10);
            System.out.println(f);
        }

        //3.5  Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
        Map<String, List<Funcionario>> funcionariosFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        //3.6 Imprimir os funcionários, agrupados por função.
        System.out.println();
        funcionariosFuncao.forEach((funcao, listaFuncionarios) -> {
            System.out.println("Função: " + funcao);
            listaFuncionarios.forEach(funcionario -> System.out.println("  Nome: " + funcionario.getNome()));
        });

        //3.7 Não estava listado na explicação do teste

        //3.8 Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println();
        System.out.println("Funcionários com aniversário nos meses 10 e 12");
        for (Funcionario f : funcionarios) {
            int mesNascimento = f.getDataNascimento().getMonthValue();
            if (mesNascimento == 10 || mesNascimento == 12) {
                System.out.println("Nome: " + f.getNome() + ", Data de Nascimento: " + f.getDataNascimento().format(formatter));
            }
        }

        //3.9 Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        System.out.println();
        Funcionario funcionarioMaisVelho = Collections.min(funcionarios, Comparator.comparing(Funcionario::getDataNascimento));
        System.out.println("Funcionário mais velho");
        System.out.println(funcionarioMaisVelho.getNome() + ", " + (LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear()) + " anos");

        //3.10 Imprimir a lista de funcionários por ordem alfabética.
        System.out.println();
        System.out.println("Funcionários em ordem alfabética:");
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(funcionario -> System.out.println(funcionario.getNome()));

        //3.11 Imprimir o total dos salários dos funcionários.
        System.out.println();
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Total dos salários dos funcionários: R$" + String.format("%,.2f", totalSalarios));

        //3.12 Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        System.out.println();
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salariosMinimos = funcionario.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
            System.out.println("Nome: " + funcionario.getNome() + ", Salários Mínimos: " + salariosMinimos);
        }
    }
}
