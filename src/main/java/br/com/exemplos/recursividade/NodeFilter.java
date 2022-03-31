package br.com.exemplos.recursividade;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.stripAccents;


public class NodeFilter {

    @SneakyThrows
    private static String getNodesFromJsonFile() {
        return new String(Files.readAllBytes(new File("src/main/resources/json/lista.json").toPath()));
    }

    private static void filterNodes(List<Node> nodes, String description) {
        filterNode(nodes.iterator(), description);
    }

    private static boolean isEmpty(List<Node> nodes) {
        return isNull(nodes) || nodes.isEmpty();
    }

    private static boolean descriptionContains(String description, String filter) {
        if (isNull(description)) {
            return false;
        }
        var normalizedDescription = stripAccents(description).toLowerCase();
        return normalizedDescription.contains(stripAccents(filter).toLowerCase());
    }

    private static void filterNode(Iterator<Node> iterator, String filter) {
        while (iterator.hasNext()) {
            var node = iterator.next();
            var remove = true;

            if (descriptionContains(node.getDescription(), filter)) {
                remove = false;
            } else {
                var children = node.getChildren();
                if (isEmpty(node.getChildren())) {
                    children = new ArrayList<>();
                }
                filterNode(children.iterator(), filter);
                remove = children.isEmpty();
            }

            if (remove) {
                iterator.remove();
            }
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        var content = getNodesFromJsonFile();
        var nodes = Node.jsonToObject(content);

        var result = new ArrayList<Node>();
        nodes.forEach(c -> result.add(new Node(c)));

        filterNodes(result, "cami");

        var jsonFilter = Node.objectToJson(result);
        System.out.println(jsonFilter);

    }
}
