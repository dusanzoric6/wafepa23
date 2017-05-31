package jwd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Dusan on 5/23/2017.
 */

@SpringBootApplication
public class App extends SpringBootServletInitializer {

  @Autowired
  private TestData data;

  public static void main (String[] args) throws Exception {
    SpringApplication.run(App.class, args);
  }
}
