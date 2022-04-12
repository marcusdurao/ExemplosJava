package br.com.exemplos.recursividade;

import br.com.exemplos.dto.Node;
import br.com.exemplos.dto.NodeBaseDTO;
import br.com.exemplos.utils.ExemploUtil;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class ReturnNodeById {

    private static boolean isEmpty(List<Node> nodes) {
        return isNull(nodes) || nodes.isEmpty();
    }

    private static NodeBaseDTO getNodeById(Iterator<Node> iterator, Long id) {
        Node node;
        NodeBaseDTO baseDTO = null;
        while (iterator.hasNext()) {
            node = iterator.next();

            if (node.getId().equals(id)) {
                baseDTO = NodeBaseDTO.builder()
                        .id(node.getId())
                        .description(node.getDescription())
                        .build();
            }

            if (!nonNull(baseDTO)) {
                var children = node.getChildren();
                if (isEmpty(node.getChildren())) {
                    children = new ArrayList<>();
                }

                getNodeById(children.iterator(), id);
            }
            break;
        }

        return baseDTO;
    }

    @SneakyThrows
    public static void main(String[] args) {
        var content = ExemploUtil.getNodesFromJsonFile("listaNode.json");
        var nodes = Node.jsonToObject(content);

        List<NodeBaseDTO> nodeFlatList = new ArrayList<>();
        var node = getNodeById(nodes.iterator(), 3L);

        System.out.println(node);

    }
}
