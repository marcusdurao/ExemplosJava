package br.com.exemplos.utils;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;

public class ExemploUtil {
    private static final String BASE_PATH = "src/main/resources/json/";

    @SneakyThrows
    public static String getNodesFromJsonFile(String file) {
        return new String(Files.readAllBytes(new File(BASE_PATH + file).toPath()));
    }

}
