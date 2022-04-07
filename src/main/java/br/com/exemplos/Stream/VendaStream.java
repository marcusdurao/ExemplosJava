package br.com.exemplos.Stream;

import br.com.exemplos.dto.Cliente;
import br.com.exemplos.dto.Venda;
import br.com.exemplos.utils.ExemploUtil;
import lombok.SneakyThrows;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

public class VendaStream {


    @SneakyThrows
    public static void main(String[] args) {
        var vendas = Venda.jsonToDto(ExemploUtil.getNodesFromJsonFile("Venda.json"));

//        sortComparatorMethodReference(vendas);
//        sortComparatorMethodLambda(vendas);

        Venda ve = new Venda();
        Cliente cl = new Cliente();
        cl.setIdade(1);
        ve.setCliente(cl);

        var object = Optional.ofNullable(ve.getCliente())
                                    .map(v -> v.getId())
                .orElse(null);

        System.out.println(object);
    }

    private static void sortComparatorMethodReference(List<Venda> vendas) {
        vendas.sort(Comparator.comparing(Venda::getVlTotal));
        vendas.forEach(System.out::println);
    }

    private static void sortComparatorMethodLambda(List<Venda> vendas) {
        vendas.sort(Comparator.comparing(Venda::getVlTotal).reversed());
        vendas.forEach(v -> System.out.println(v));
    }


    private static Object isNullObject(Object o) {

        if (nonNull(o)) {
            return o;
        }
        else
            return null;
    }
}
