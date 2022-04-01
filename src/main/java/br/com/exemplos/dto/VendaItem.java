package br.com.exemplos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendaItem {
    private Long id;
    private Produto produto;
    private Integer qtd;
    private Double vlUnit;
    private Double vlTotal;
}
