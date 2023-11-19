package edu.wgu.d387_sample_code.d387;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class WelcomeController {

    private final WelcomeServiceImpl welcomeService;

    @Autowired
    public WelcomeController(WelcomeServiceImpl welcomeService) {
        this.welcomeService = welcomeService;
        this.welcomeService.start();
    }

    @GetMapping("/welcome")
    public String welcome() throws JsonProcessingException {

        return welcomeService.getJsonList();
    }
}
