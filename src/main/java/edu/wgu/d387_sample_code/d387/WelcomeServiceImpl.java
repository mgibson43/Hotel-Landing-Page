package edu.wgu.d387_sample_code.d387;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Service
public class WelcomeServiceImpl extends Thread implements WelcomeService {

    private List<String> messages = new ArrayList<>();
    private final ExecutorService executer = newFixedThreadPool(2);

    @Override
    public String getJsonList() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.messages);
    }

    public void run() {

        Properties properties = new Properties();

        executer.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_US.properties").getInputStream();
                properties.load(stream);
                this.messages.add(properties.getProperty("welcome"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        executer.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);
                this.messages.add(properties.getProperty("welcome"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
