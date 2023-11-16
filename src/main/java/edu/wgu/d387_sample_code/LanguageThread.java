package edu.wgu.d387_sample_code;

import edu.wgu.d387_sample_code.entity.LanguageType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Getter
@Setter
public class LanguageThread extends Thread {

    private LanguageType language;
    private String resourcePath;
    private InputStream stream;

    public LanguageThread(LanguageType language) {
        this.language = language;

        if (this.language == LanguageType.EN) {
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
            this.stream = new ClassPathResource(this.resourcePath).getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
