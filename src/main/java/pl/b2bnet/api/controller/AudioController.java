package pl.b2bnet.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.b2bnet.api.Model.AudioTag;
import pl.b2bnet.api.exception.NoSuchTagException;
import pl.b2bnet.api.service.AudioService;

import java.util.List;

@RestController
public class AudioController {
    @Autowired
    private AudioService audioService;

    @GetMapping("/metals")
    public AudioTag sumAllMetal() {
        return audioService.metals();
    }

    @GetMapping("/tagsAbove/{val}")
    public List<AudioTag> aboveValue(@PathVariable int val) {
        return audioService.showTagsWithCountAbove(val);
    }

    @GetMapping("/tagsCompare/{name1}/{name2}")
    public String compareTags(@PathVariable String name1, @PathVariable String name2) throws NoSuchTagException {
        return audioService.compareTwoTags(name1, name2);
    }

    @GetMapping("/names")
    public List<String> names() {
        return audioService.names();
    }

}
