package br.com.exemplos.Stream;

import java.util.Optional;
import java.util.function.Supplier;

public class ValidacaoEncadeada {
    public static void main(String[] args) {
        runTests(
                () -> test1(),
                () -> test2(),
                () -> test3()
        );
    }

    public static void runTests(Supplier<Optional<String>>... tests) {
        for (Supplier<Optional<String>> test : tests) {
            Optional<String> result = test.get();
            if (result.isEmpty()) {
                System.out.println("Teste falhou, parando a execução...");
                return;
            }
        }
        System.out.println("Todos os testes foram bem-sucedidos!");
    }

        public static Optional<String> test1() {
        System.out.println("Executando teste 1...");
        return Optional.of("Teste 1 passou!");
    }

    public static Optional<String> test2() {
        System.out.println("Executando teste 2...");
        return Optional.of("Teste 2 passou!");
    }

    public static Optional<String> test3() {
        System.out.println("Executando teste 3...");
        return Optional.empty();
    }
}
