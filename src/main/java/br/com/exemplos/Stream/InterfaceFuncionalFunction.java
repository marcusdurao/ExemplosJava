package br.com.exemplos.Stream;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.function.Function;

import static java.util.Optional.ofNullable;

public class InterfaceFuncionalFunction {

    public static void main(String[] args) {
        var teste1 = Teste1.builder()
                .id(1)
                .nome("Marcus")
                .build();

        var teste = ofNullable(teste1).map(testeFuncao(10)).orElse(null);
        System.out.println(teste);
    }

    public static Function<Teste1, Teste2> testeFuncao(int age) {
        return teste1 -> getTeste2(teste1, age);
    }

    private static Teste2 getTeste2(Teste1 teste1, int age) {
        return Teste2.builder().id(teste1.id)
                .nome(teste1.nome)
                .age(age).build();

    }

    @Builder
    @Data
    private static class Teste1 implements Serializable {
        private int id;
        private String nome;

    }

    @Data
    @Builder
    private static class Teste2 implements Serializable {
        private int id;
        private String nome;
        private int age;
    }

}
