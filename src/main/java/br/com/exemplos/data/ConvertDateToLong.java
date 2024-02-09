package br.com.exemplos.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDateToLong {
        public static void main(String[] args) {
            // Data no formato "22/12/2023"
            String dataString = "16/12/2023 00:00:00";

            // Padrão para o formato da data
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            try {
                // Convertendo a string para um objeto Date
                Date data = sdf.parse(dataString);

                // Obtendo o valor em milissegundos
                long valorEmMilissegundos = data.getTime();

                // Imprimindo o valor em milissegundos
                System.out.println("Valor em milissegundos: " + valorEmMilissegundos);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
