package br.com.exemplos.Stream;

import br.com.exemplos.dto.Venda;
import br.com.exemplos.utils.ExemploUtil;
import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.List;

public class VendaStream {

    @SneakyThrows
    public static void main(String[] args) {
        var vendas = Venda.jsonToDto(ExemploUtil.getNodesFromJsonFile("Venda.json"));

        sortComparatorMethodReference(vendas);
        sortComparatorMethodLambda(vendas);

    }

    private static void sortComparatorMethodReference(List<Venda> vendas) {
        vendas.sort(Comparator.comparing(Venda::getVlTotal));
        vendas.forEach(System.out::println);
    }

    private static void sortComparatorMethodLambda(List<Venda> vendas) {
        vendas.sort(Comparator.comparing(Venda::getVlTotal).reversed());
        vendas.forEach(v -> System.out.println(v));
    }

}
