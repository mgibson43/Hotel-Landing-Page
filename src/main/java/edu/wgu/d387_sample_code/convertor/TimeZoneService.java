package edu.wgu.d387_sample_code.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface TimeZoneService {

    public void addTimeZones();

    public String timesToJson() throws JsonProcessingException;
}
