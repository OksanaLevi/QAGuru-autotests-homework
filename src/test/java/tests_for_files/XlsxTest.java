package tests_for_files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.codeborne.xlstest.XLS;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class XlsxTest {
    private static final ClassLoader cl = PdfTest.class.getClassLoader();

    @Test
    @DisplayName("Проверка содержимого файла .xls")
    void xlsTest() throws IOException {

        boolean filePresentInZip = false;

        try (InputStream zipStream = cl.getResourceAsStream("zip.zip");
             ZipInputStream zipInputStream = new ZipInputStream(Objects.requireNonNull(zipStream))) {

            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null) {
                if (zipEntry.getName().equals("excel.xls")) {

                    filePresentInZip = true;

                    XLS xls = new XLS(zipInputStream);

                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Номер п/п");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Имя");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Рост");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Цвет глаз");

                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("1");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Оля");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("171");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("голубой");

                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("2");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("Саша");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("173");
                    Assertions.assertEquals(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("зеленый");
                }
            }
        }

        Assertions.assertEquals(filePresentInZip).as("Ожидаемый файл отсутствует в архиве zip.zip").isTrue();

    }
}
