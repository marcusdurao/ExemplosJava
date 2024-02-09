package br.com.exemplos.Stream;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TesteMovementHelper {
    public static void main(String[] args) {
        var movementDate = LocalDate.now();
        var date = new Date();

        var teste = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        MovementRequest.builder().id(1L).status("ABERTO").amount(10L).cost(10L).build();

        var request = List.of(
                MovementRequest.builder().id(1L).status("ABERTO").amount(10L).cost(10L).build(),
                MovementRequest.builder().id(2L).status("FATURADO").amount(10L).cost(10L).build());

        var entity = List.of(
                MovementRequest.builder().id(1L).status("ABERTO").amount(10L).cost(10L).build(),
                MovementRequest.builder().id(2L).status("ABERTO").amount(10L).cost(10L).build());

        entity.forEach(mov -> System.out.println(compareto(request, mov)));


    }

    private static List<Integer> compareto(List<MovementRequest> request, MovementRequest entity) {
        return request.stream().map(req -> MovementHelper.compareto(req, entity)).collect(Collectors.toList());
    }
}
