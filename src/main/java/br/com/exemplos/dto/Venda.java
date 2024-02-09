package br.com.exemplos.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Venda {
    private Long id;
    private Date dtEmissao;
    private Double vlTotal;
    private Cliente cliente;
    private List<VendaItem> itens;

    private static int count = 0;

    public int getCount(){
        return count++;
    }

    public static List<Venda> jsonToDto(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, new TypeReference<>() {
        });
    }
}
