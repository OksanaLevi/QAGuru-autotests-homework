package tests_for_files.tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipContentTest {

    private static final ClassLoader cl = JsonParseTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла csv из zip")
    void csvTest() throws IOException, CsvException {


        try (ZipInputStream zis = openZipStream()) {
            verifyZipEntryContent(zis, "csv.csv", inputStream -> {
                Reader reader = new InputStreamReader(inputStream);
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> content = csvReader.readAll();
                Assertions.assertEquals(3, content.size());
                final String[] firstRow = content.get(0);
                final String[] secondRow = content.get(1);
                final String[] thirdRow = content.get(2);

                Assertions.assertArrayEquals(new String[]{"russian", "1"}, firstRow);
                Assertions.assertArrayEquals(new String[]{"english", "2"}, secondRow);
                Assertions.assertArrayEquals(new String[]{"match", "3"}, thirdRow);
            });
        }
    }

    @Test
    @DisplayName("Проверка содержимого файла pdf из zip")
    void testPdfTest() throws IOException, CsvException {
        try (ZipInputStream zis = openZipStream()) {
            verifyZipEntryContent(zis, "pdg.pdf", inputStream -> {
                PDF pdf = new PDF(inputStream);
                Assertions.assertTrue(pdf.text.contains("Пример pdf"));
            });
        }
    }

    @Test
    @DisplayName("Проверка содержимого файла excel из zip")
    void testXlsxTest() throws Exception {
        try (ZipInputStream zis = openZipStream()) {
            verifyZipEntryContent(zis, "excel.xlsx", inputStream -> {
                XLS xls = new XLS(inputStream);
                String cellValue = xls.excel.getSheetAt(0)
                        .getRow(2)
                        .getCell(3)
                        .getStringCellValue();
                Assertions.assertTrue(cellValue.contains("green"));

            });
        }
    }


    private ZipInputStream openZipStream() {
        InputStream stream = cl.getResourceAsStream("zip/zip.zip");
        return new ZipInputStream(stream);
    }

    private void verifyZipEntryContent(ZipInputStream zis, String entryName, ZipEntryVerifier verifier) throws IOException, CsvException {
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            final String name = entry.getName();
            if (name.contains(entryName)) {
                verifier.verifyEntry(zis);
            }
        }
    }

    interface ZipEntryVerifier {
        void verifyEntry(InputStream inputStream) throws IOException, CsvException;
    }

}
