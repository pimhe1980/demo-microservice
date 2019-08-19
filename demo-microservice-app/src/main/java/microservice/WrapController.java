package microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author pimhe
 */
@RestController
@RequestMapping("wrap")
public class WrapController {

    private static String GET_URL = "http://localhost:8090/";

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String wrap(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "text/plain");
        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);
        Class<String> responseType = String.class;
        ResponseEntity<String> responseEntity = restTemplate.exchange(GET_URL, HttpMethod.GET, httpEntity, responseType);
        return "wrap ( " + responseEntity.getBody() + " )";
    }
}
