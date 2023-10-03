package tests_for_files;

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
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class CsvTest {

    private static final ClassLoader cl = CsvTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .csv")
    void csvTest() throws IOException, CsvException {

        boolean filePresentInZip = false;

        try (InputStream zipStream = cl.getResourceAsStream("zip/zip.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("csv.csv")) {

                    filePresentInZip = true;

                    Reader reader = new InputStreamReader(zipInputStream);
                    CSVReader csvReader = new CSVReader(reader);
                    List<String[]> content = csvReader.readAll();
                    System.out.println("");

                        Assertions.assertEquals(content).hasSize(10);

                        Assertions.assertEquals(content.get(0)).containsExactly("русский язык", "2");
                        Assertions.assertEquals(content.get(1)).containsExactly("литература", "4");
                        Assertions.assertEquals(content.get(2)).containsExactly("английский", "2");
                        Assertions.assertEquals(content.get(3)).containsExactly("математика", "3");
                    }
                }
            }

            Assertions.assertEquals(filePresentInZip).as("Ожидаемый файл отсутствует в архиве zip.zip").isTrue();

                }
            }
