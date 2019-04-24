package pl.b2bnet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnet.api.Model.AudioTag;
import pl.b2bnet.api.service.ApiService;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/tag")
    public List<AudioTag> allTags() {
        return apiService.fromApi();
    }

}
