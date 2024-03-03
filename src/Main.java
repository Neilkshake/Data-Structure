import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Parte 1: Insira os nomes das pessoas separados por vírgula:");
        String input = scanner.nextLine();

        List<String> nomes = Arrays.asList(input.split(","));
        Collections.sort(nomes);

        System.out.println("Nomes em ordem alfabética:");
        for (String nome : nomes) {
            System.out.println(nome);
        }

        System.out.println("\nParte 2: Insira o nome e o gênero das pessoas (no formato nome-gênero), separados por vírgula:");
        input = scanner.nextLine();

        Map<String, List<String>> pessoasPorGenero = new HashMap<>();
        String[] pessoas = input.split(",");
        for (String pessoa : pessoas) {
            String[] partes = pessoa.split("-");
            String nome = partes[0];
            String genero = partes[1];

            if (!pessoasPorGenero.containsKey(genero)) {
                pessoasPorGenero.put(genero, new ArrayList<>());
            }
            pessoasPorGenero.get(genero).add(nome);
        }

        System.out.println("\nPessoas agrupadas por gênero:");
        for (Map.Entry<String, List<String>> entry : pessoasPorGenero.entrySet()) {
            System.out.println("Gênero: " + entry.getKey());
            for (String nome : entry.getValue()) {
                System.out.println("- " + nome);
            }
        }
    }
}