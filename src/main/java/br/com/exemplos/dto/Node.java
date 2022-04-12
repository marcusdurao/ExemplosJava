package br.com.exemplos.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Node extends NodeBaseDTO{
    private List<Node> children;

    public Node(Node node) {
        super.setId(node.getId());
        super.setDescription(node.getDescription());
        if (nonNull(node.getChildren())) {
            children = new ArrayList<>();
            node.getChildren().forEach(c -> children.add(new Node(c)));
        }
    }

    public static List<Node> jsonToObject(String json) throws JsonProcessingException {
        return new ObjectMapper().readValue(json, new TypeReference<>() {
        });
    }

    public static String objectToJson(List<Node> children) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(children);
    }

}
