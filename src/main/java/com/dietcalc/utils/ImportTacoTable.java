package com.dietcalc.utils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class ImportTacoTable {

    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader("./src/taco.pdf");

        reader.selectPages("29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,66,67,68");
        PrintWriter writer = new PrintWriter("./src/taco.txt", "UTF-8");


        int pages = reader.getNumberOfPages();

        try {
            for (int i = 1; i <= pages; i++) {
                writer.println(PdfTextExtractor.getTextFromPage(reader, i));
            }
        } catch (Exception e) {
            log.error("Erro ao importar da tabela: " + e.getMessage());
        } finally {
            reader.close();
            writer.close();
        }


    }
}
