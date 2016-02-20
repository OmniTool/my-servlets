package mywebapp.ejb.lesson;

import javax.ejb.Local;

@Local
public interface HelloWorldLocal {
    public String getMessage(String name);
}
