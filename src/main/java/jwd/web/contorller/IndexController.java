package jwd.web.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dusan on 5/26/2017.
 */

@Controller
public class IndexController {

  @RequestMapping("/")
  public String index() {
    return "/static/app/html/index.html";
  }
}

