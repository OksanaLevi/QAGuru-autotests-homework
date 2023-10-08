package tests_for_files.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests_for_files.utils.Employee;
import tests_for_files.utils.Job;

import java.io.File;


public class JsonParseTest {

    @Test
    @DisplayName("Парсим Json")
    void jacksonTest() throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        File jsonFile = new File("json/employee.json");

        Employee jsonGetEmployee = objectMapper.readValue(jsonFile, new TypeReference<>() {
        });
        Assertions.assertEquals("Olya", jsonGetEmployee.getName());
        Assertions.assertTrue(jsonGetEmployee.getMarried());
        Assertions.assertEquals(32, jsonGetEmployee.getAge());

        Job jsonGetJob = objectMapper.readValue(jsonFile, new TypeReference<>() {
        });
        Assertions.assertEquals("Manager", jsonGetJob.getRole());
        Assertions.assertEquals("Moscow", jsonGetJob.getCity());
        Assertions.assertEquals(78990, jsonGetJob.getSalary());

    }
}
