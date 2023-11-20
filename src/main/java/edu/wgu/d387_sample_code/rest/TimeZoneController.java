package edu.wgu.d387_sample_code.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import edu.wgu.d387_sample_code.convertor.TimeZoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeZoneController {

    private TimeZoneServiceImpl timeZoneService;

    @Autowired
    public TimeZoneController(TimeZoneServiceImpl timeZoneService) {

        this.timeZoneService = timeZoneService;
    }

    @GetMapping("/timezone")
    public String timeZone() throws JsonProcessingException {

        this.timeZoneService.addTimeZones();
        return this.timeZoneService.timesToJson();
    }
}
