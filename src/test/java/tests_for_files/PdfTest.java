package tests_for_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.pdftest.PDF;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class PdfTest {
    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .pdf")
    void pdfTest() throws IOException {

        boolean filePresentInZip = false;

        try (InputStream zipStream = cl.getResourceAsStream("zip/zip.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("pdf.pdf")) {

                    filePresentInZip = true;

                    PDF pdf = new PDF(zipInputStream);

                    String expectedResult = "Portable Document Format — межплатформенный открытый формат электронных документов," +
                            "изначально разработанный фирмой Adobe Systems в 1992 году с использованием ряда" +
                            "возможностей языка PostScript.";

                    Assertions.assertEquals(pdf.text.replace("\r\n", ""))
                            .isEqualTo(expectedResult);
                }
            }
        }

        Assertions.assertThat(filePresentInZip).as("Ожидаемый файл отсутствует в архиве zip.zip").isTrue();

    }
}