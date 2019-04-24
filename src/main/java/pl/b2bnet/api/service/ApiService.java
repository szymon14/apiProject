package pl.b2bnet.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.b2bnet.api.Model.AudioResponse;
import pl.b2bnet.api.Model.AudioTag;

import java.util.List;

@Service
public class ApiService {
    public static final String
            uri = "http://ws.audioscrobbler.com//2.0/?method=tag.getTopTags&api_key=d89694613c7aa1e170d4276f49d46033&format=json";
    @Autowired
    private RestTemplate restTemplate;

    public List<AudioTag> fromApi() {
        ResponseEntity<AudioResponse> responseEntity = restTemplate.getForEntity(uri, AudioResponse.class);
        return responseEntity.getBody().getToptags().getTag();
    }
}
