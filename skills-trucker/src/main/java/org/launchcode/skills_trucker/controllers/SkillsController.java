package org.launchcode.skills_trucker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@ResponseBody
public class SkillsController {

@GetMapping
    public String heading(){
    String html = "<h1>Skills trucker</h1>"+
            "<h2>We have a few skills we would like to learn. Here is the list!</h2>"+
            "<ol>"+
            "<li>Java</li>"+
            "<li>JavaScript</li>" +
            "<li>Python</li>"+
            "</ol>";
    return html;
}

@GetMapping(value="form")
    public String formRequest(){
    String html = "<form method='post'>" +
            "Name:<br>" +
            "<input type = 'text' name = 'name' />" +
            "<br>My favorite language:<br>" +
            "<select name = 'firstChoice'>" +
            "<option value = 'Java'>Java</option>" +
            "<option value = 'Javascript'>JavaScript</option>" +
            "<option value = 'Python'>Python</option>" +
            "</select>" +
            "<br>My second favorite language:<br>" +
            "<select name = 'secondChoice'>" +
            "<option value = 'Java'>Java</option>" +
            "<option value = 'Javascript'>JavaScript</option>" +
            "<option value = 'Python'>Python</option>" +
            "</select>" +
            "<br>My third favorite language:<br>" +
            "<select name = 'thirdChoice'>" +
            "<option value = 'Java'>Java</option>" +
            "<option value = 'Javascript'>JavaScript</option>" +
            "<option value = 'Python'>Python</option>" +
            "</select><br>" +
            "<input type = 'submit' value = 'Submit' />" +
            "</form>";

    return html;
}

    @PostMapping(value="form")
    public String namePage(@RequestParam String name, @RequestParam String firstChoice, @RequestParam String secondChoice, @RequestParam String thirdChoice) {
        String html = "<h1>" + name + "</h1>" +
                "<ol>" +
                "<li>" + firstChoice + "</li>" +
                "<li>" + secondChoice + "</li>" +
                "<li>" + thirdChoice + "</li>" +
                "</ol>";
        return html;
    }

}
