package hello.controer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller("/api")
public class DefaultController
{

    @RequestMapping
    @ResponseBody
    public String home()
    {
        return "Hello World!";
    }
}
