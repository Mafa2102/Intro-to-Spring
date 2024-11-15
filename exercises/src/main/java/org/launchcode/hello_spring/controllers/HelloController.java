package org.launchcode.hello_spring.controllers;

import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {


    @RequestMapping(value="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>" +
                "<input type = 'text' name = 'name' />" +
                "<select name = 'language'>" +
                "<option value = 'english'>English</option>" +
                "<option value = 'french'>French</option>" +
                "<option value = 'italian'>Italian</option>" +
                "<option value = 'spanish'>Spanish</option>" +
                "<option value = 'russian'>Russian</option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet Me!' />" +
                "</form>";
        return html;
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello, ";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour, ";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno, ";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola, ";
        }
        else if (l.equals("russian")) {
            greeting = "Привет, ";
        }

        return greeting + " " + n;
    }

    @RequestMapping(value="hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye!";
    }

    //@GetMapping

}
