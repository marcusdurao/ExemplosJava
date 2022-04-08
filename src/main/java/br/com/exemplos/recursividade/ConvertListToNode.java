package br.com.exemplos.recursividade;

import br.com.exemplos.dto.Node;
import br.com.exemplos.dto.NodeFlat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

public class ConvertListToNode {

    private static List<NodeFlat> nodeFlats = Arrays.asList(
            new NodeFlat(1L, "Masculino", null, 0L),
            new NodeFlat(2L, "Calçados", 1L, 1L),
            new NodeFlat(3L, "Botas", 2L, 2L),
            new NodeFlat(8L, "Feminino", null, 4L),
            new NodeFlat(4L, "Chuteiras", 2L, 3L),
            new NodeFlat(9L, "Moda Íntima", 8L, 5L),
            new NodeFlat(10L, "Calcinhas", 9L, 6L),
            new NodeFlat(9L, "Moda Íntima", 8L, 5L)
    );

    private static Long nullToZero(Long value) {
        return !Objects.isNull(value) ? value : 0;
    }

    private static void filterNode(Iterator<Node> iterator, NodeFlat nodeFlat) {
        Node node = null;
        while (iterator.hasNext()) {
            node = iterator.next();
            if (node.getId().equals(nodeFlat.getParentId())) {
                if (nonNull(node.getChildren())) {
                    node.getChildren()
                            .add(
                                    Node.builder()
                                            .id(nodeFlat.getId())
                                            .description(nodeFlat.getDescription())
                                            .children(null)
                                            .build());
                } else {
                    List<Node> nodes = new ArrayList<>();
                    nodes.add(Node.builder()
                            .id(nodeFlat.getId())
                            .description(nodeFlat.getDescription())
                            .build());
                    node.setChildren(nodes);
                }
            } else {
                var children = node.getChildren();
                if (isEmpty(node.getChildren())) {
                    children = new ArrayList<>();
                }
                filterNode(children.iterator(), nodeFlat);
            }
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodeFlats.sort((n1, n2) -> nullToZero(n1.getOrder()).compareTo(nullToZero(n2.getOrder())));
        nodeFlats.forEach(
                n -> {
                    if (n.getParentId() == null) {
                        nodes.add(Node.builder()
                                .id(n.getId())
                                .description(n.getDescription())
                                .build());
                        System.out.println(n.getDescription());
                    } else {
                        System.out.println(n.getDescription());
                        filterNode(nodes.iterator(), n);
                    }
                }
        );

        System.out.println(nodes);
    }
}
