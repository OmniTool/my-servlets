package mywebapp.ejb.lesson;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldBean implements HelloWorldLocal {
    public String getMessage(String name) {
        return "Hello, " + name + "!";
    }
}
