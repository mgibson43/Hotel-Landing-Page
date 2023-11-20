package edu.wgu.d387_sample_code.convertor;


import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface WelcomeService {

    public void startService();
    public String getJsonList() throws JsonProcessingException;
}
