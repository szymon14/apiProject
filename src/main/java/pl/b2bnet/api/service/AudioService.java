package pl.b2bnet.api.service;

import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.b2bnet.api.Model.AudioTag;
import pl.b2bnet.api.enumerate.TagNames;
import pl.b2bnet.api.exception.NoSuchTagException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AudioService {
    @Autowired
    private ApiService apiService;

    public AudioTag metals() {
        int count = 0;
        int reach = 0;
        for (AudioTag audioTag : apiService.fromApi()) {
            if (audioTag.getName().contains("metal")) {
                count += audioTag.getCount();
                reach += audioTag.getReach();
            }
        }
        AudioTag audioTag = new AudioTag("metal", count, reach);
        return audioTag;
    }

    public List<AudioTag> showTagsWithCountAbove(int aboveValue) {
        List<AudioTag> result = new ArrayList<>();
        for (AudioTag audioTag : apiService.fromApi()) {
            if (audioTag.getCount() > aboveValue) {
                result.add(audioTag);
            }
        }
        return result;
    }

    public String compareTwoTags(String name1, String name2) throws NoSuchTagException {
        if (!EnumUtils.isValidEnum(TagNames.class,
                name1.toUpperCase().replace(" ","").replace("-",""))
                || !EnumUtils.isValidEnum(TagNames.class,
                name2.toUpperCase().replace(" ","").replace("-",""))) {
            throw new NoSuchTagException("TAGI SĄ NIE POPRAWNE");
        }
        AudioTag val1 = null;
        AudioTag val2 = null;
        String message = "";
        for (AudioTag audioTag : apiService.fromApi()) {
            if (audioTag.getName().equals(name1)) {
                val1 = audioTag;
            }
            if (audioTag.getName().equals(name2)) {
                val2 = audioTag;
            }
        }
        if (val1.getCount() > val2.getCount()) {
            message += val1.getName() + " " + val1.getCount() + " > "
                    + val2.getName() + " " +  val2.getCount();
        } else {
            message += val2.getName() + " " + val2.getCount() + " > "
                    + val1.getName() + " " + val1.getCount();
        }
        return message;
    }

    public List<String> names() {
        List<String> names = new ArrayList<>();
        for (AudioTag audioTag : apiService.fromApi()) {
            names.add(audioTag.getName());
        }
        return names;
    }
    public List<AudioTag> sortByReach(){
        List<AudioTag> list = apiService.fromApi().stream()
                .sorted((o1, o2) -> o1.getReach()-o2.getReach()).
                        collect(Collectors.toList());
        return list;
    }

}
