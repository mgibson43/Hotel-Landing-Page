package edu.wgu.d387_sample_code;

import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
@Setter
public class LanguageThread implements Runnable {

    private String language;
    private String resourcePath;

    public LanguageThread(String language) {
        this.language = language;

        if (this.language.equals("en")) {
            this.resourcePath = "welcome_en_US.properties";
        }
        else {
            this.resourcePath = "welcome_fr_CA.properties";
        }
    }

    @Override
    public void run() {

        Properties properties = new Properties();
        try {
            InputStream stream = new ClassPathResource(this.resourcePath).getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
