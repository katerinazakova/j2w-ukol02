package cz.czechitas.java2webapps.ukol2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class QuoteController {
    private final Random random = new Random();

    @GetMapping("/")
    public ModelAndView settingChangingQuoteAndPhoto() throws IOException {
        int randomNumber = random.nextInt(7);
        ModelAndView result = new ModelAndView("index");

        result.addObject("fotografie", String.format("/images/fotografie-%d.jpg", randomNumber));

        List<String> allQuotes = readAllLines("R. Fulghum citaty.txt");
        result.addObject("quote",allQuotes.get(randomNumber));

        return result;
    }

    private static List<String> readAllLines(String resources) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream inputStream = classLoader.getResourceAsStream(resources);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            return reader
                    .lines()
                    .collect(Collectors.toList());
        }
    }
}
