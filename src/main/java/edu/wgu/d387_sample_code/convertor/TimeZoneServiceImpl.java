package edu.wgu.d387_sample_code.convertor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Setter
@Getter
public class TimeZoneServiceImpl implements TimeZoneService {

    private List<ZonedDateTime> times;

    @Override
    public void addTimeZones() {

        this.times = new ArrayList<>();

        ZoneId eastern = ZoneId.of("America/New_York");
        ZoneId mountain = ZoneId.of("US/Arizona");
        ZoneId utc = ZoneId.of("UTC");


        LocalDateTime localDateTime = LocalDateTime.now();


        ZonedDateTime zonedDateTime = (localDateTime.atZone(eastern));
        this.times.add(zonedDateTime);
        zonedDateTime = (localDateTime.atZone(mountain));
        this.times.add(zonedDateTime);
        zonedDateTime = (localDateTime.atZone(utc));
        this.times.add(zonedDateTime);
    }

    @Override
    public String timesToJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(this.times);
    }
}
