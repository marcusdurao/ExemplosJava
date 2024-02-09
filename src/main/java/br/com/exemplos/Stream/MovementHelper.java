package br.com.exemplos.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

public class MovementHelper {

    public static int compareto(MovementRequest request, MovementRequest entity) {

        var isChangeStatus = isEqualStatus(request, entity);
        var isChangeInfo = isEqualAtributte(request, entity);

        if (isChangeStatus && isChangeInfo) {
            return 0;
        }

        if (!isChangeStatus && isChangeInfo) {
            return 1;
        }

        return -1;

    }

    private static boolean isEqualStatus(MovementRequest request, MovementRequest entity) {
        var obj1 = (MovementStatus) from(request);
        var obj2 = (MovementStatus) from(entity);
        return obj1.equals(obj2);
    }

    private static boolean isEqualAtributte(MovementRequest request, MovementRequest entity) {
        var obj1 = (MovementInfo) from(request);
        var obj2 = (MovementInfo) from(entity);
        return obj1.equals(obj2);
    }

    private static Movement from(MovementRequest movementRequest) {
        return Movement.builder()
                .id(movementRequest.getId())
                .status(movementRequest.getStatus())
                .amount(movementRequest.getAmount())
                .cost(movementRequest.getCost())
                .build();
    }


    @Data
    @SuperBuilder
    @AllArgsConstructor
    private static class Movement implements MovementStatus, MovementInfo {
        private Long id;
        private String status;
        private Long amount;
        private Long cost;
    }

    public interface MovementStatus {
        Long getId();

        String getStatus();
    }

    public interface MovementInfo {
        Long getAmount();

        Long getCost();
    }

}

