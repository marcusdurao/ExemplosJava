package br.com.exemplos.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NodeFlat {
    private Long id;
    private String description;
    private Long parentId;
    private Long order;
}
