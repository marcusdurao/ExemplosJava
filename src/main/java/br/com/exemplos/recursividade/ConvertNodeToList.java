package br.com.exemplos.recursividade;

import br.com.exemplos.dto.Node;
import br.com.exemplos.dto.NodeFlat;
import br.com.exemplos.utils.ExemploUtil;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ConvertNodeToList {
    private static void builderNodeFlat(Iterator<Node> iterator, List<NodeFlat> nodeFlatList, Long idParent) {
        Node node;
        while (iterator.hasNext()) {
            node = iterator.next();

            nodeFlatList.add(NodeFlat.builder()
                    .id(node.getId())
                    .description(node.getDescription())
                    .parentId(idParent)
                    .build());

            var children = node.getChildren();
            if (isEmpty(node.getChildren())) {
                children = new ArrayList<>();
            }

            builderNodeFlat(children.iterator(), nodeFlatList, node.getId());
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        var content = ExemploUtil.getNodesFromJsonFile("listaNode.json");
        var nodes = Node.jsonToObject(content);

        List<NodeFlat> nodeFlatList = new ArrayList<>();

        builderNodeFlat(nodes.iterator(), nodeFlatList, null);

        System.out.println(nodeFlatList);

    }
}
