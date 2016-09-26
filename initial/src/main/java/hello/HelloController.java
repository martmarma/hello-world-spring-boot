package hello;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class HelloController {
    
    @RequestMapping("/")
    public String index() {
        return "Hello World";
    }

    private String form = "<form action=\"/incomingPOST\"><input name=\"username\" id=\"username\" type=\"text\"/><input type=\"submit\" value=\"press me\"/></form>";
    @RequestMapping("/greeting")
    public String greeting() {
        return form;
    }

    @RequestMapping(path = "/incomingPOST", method = RequestMethod.POST) //POST request
    public String incomingPOST(@RequestParam(value="username", required=false, defaultValue="User") String name, Model model) {
        return "Hello " + name + "!";
    }

    @RequestMapping(path = "/{incomingGET}", method = RequestMethod.GET) //GET request
    public String incomingGET(@RequestParam(value="username", required=false, defaultValue="User") String name, Model model) {
        return "Hello " + name + "!";
    }

}


/*
When we didn't have a specific GET request and POST request, we did this:
    private String form = "<form method=\"/POST\"> <action=\"/incoming\"><input name=\"username\" id=\"username\" type=\"text\"/><input type=\"submit\" value=\"press me\"/></form>";
    @RequestMapping("/greeting")
    public String greeting() {
        return form;
    }
 */