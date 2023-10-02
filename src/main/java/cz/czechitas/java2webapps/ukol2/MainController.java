package cz.czechitas.java2webapps.ukol2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Random;

@Controller
public class MainController {
    private final Random random = new Random();

    @GetMapping("/")
    public ModelAndView changingQuoteAndPhoto() {
        ModelAndView result = new ModelAndView("index");

        int randomNumber = random.nextInt(7) + 1;
        result.addObject("fotografie", String.format("/images/fotografie-%d.jpg", randomNumber));
        return result;
    }
}
