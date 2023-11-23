package edu.wgu.d387_sample_code.convertor;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

    private List<LocalDateTime> times;

    @Override
    public void addTimeZones() {

        this.times = new ArrayList<>();

        ZoneId eastern = ZoneId.of("America/New_York");
        ZoneId mountain = ZoneId.of("America/Denver");
        ZoneId utc = ZoneId.of("UTC");
        ZoneId zoneId = ZoneId.systemDefault();

        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime = localDateTime.atZone(zoneId);

        ZonedDateTime easternZone = zonedDateTime.withZoneSameInstant(eastern);
        LocalDateTime easternLocal = easternZone.toLocalDateTime();
        this.times.add(easternLocal);

        ZonedDateTime mountainZone = zonedDateTime.withZoneSameInstant(mountain);
        LocalDateTime mountainLocal = mountainZone.toLocalDateTime();
        this.times.add(mountainLocal);

        ZonedDateTime utcZone = zonedDateTime.withZoneSameInstant(utc);
        LocalDateTime utcLocal = utcZone.toLocalDateTime();
        this.times.add(utcLocal);
    }

    @Override
    public String timesToJson() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper.writeValueAsString(this.times);
    }
}
