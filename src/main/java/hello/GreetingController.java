package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s, %s, %s, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World2") String name,
    		@RequestParam(value="name2", defaultValue="World2") String name2,
    		@RequestParam(value="name3", defaultValue="World3") String name3,
    		@RequestParam(value="name4", defaultValue="World4") String name4) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name, name2, name3, name4));
    }
}
