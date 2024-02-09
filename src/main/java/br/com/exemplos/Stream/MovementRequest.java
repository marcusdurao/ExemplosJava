package br.com.exemplos.Stream;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovementRequest {
    private Long id;
    private String status;
    private Long amount;
    private Long cost;
    private Date movementDate;
}
