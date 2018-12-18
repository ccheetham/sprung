package io.spring.stream.sample.transformer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransformerApplicationTests {

    @Autowired
    private Transformer transformer;

    @Test
    public void simpleTest() {
        Map<String, Object> resultMap = transformer.transform(createInputData());
        assertThat(resultMap).hasSize(2)
                .contains(entry("sensor_id", "1"))
                .contains(entry("temp_val", "100"));
    }

    private Map<String, Object> createInputData() {
        HashMap<String, Object> inputData = new HashMap<>();
        inputData.put("id", "1");
        inputData.put("temperature", "100");
        return inputData;
    }
}

