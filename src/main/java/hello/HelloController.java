package hello;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;

@RestController
public class HelloController {

    private URL base;
    private RestTemplate template;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/hello")
    public String getHello() throws Exception {
        ResponseEntity<JsonNode> response = template.getForEntity("http://services.shop.com:8085/ShoppingCart/GiftRegistry/Events?siteId=260", JsonNode.class);
        return response.toString();
    }
}