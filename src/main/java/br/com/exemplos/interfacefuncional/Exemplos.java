package br.com.exemplos.interfacefuncional;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Exemplos {
    public static void main(String[] args) {
        fornecedor();
        consumidor();
    }

    private static void fornecedor() {
        Stream.generate(()-> new Random().nextInt())
                .limit(5)
                .forEach(System.out::println);
    }

    private static void consumidor() {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        numbers.forEach(number -> System.out.println(number));

        BiConsumer<Integer, Integer> printSum  = (number1,number2) -> System.out.println(number1+number2);
        printSum.accept(1,2);

    }

}
