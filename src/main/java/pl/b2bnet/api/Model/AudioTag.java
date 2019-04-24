package pl.b2bnet.api.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AudioTag {
    private String name;
    private int count;
    private int reach;

    public AudioTag() {

    }

    public AudioTag(String name, int count, int reach) {
        this.name = name;
        this.count = count;
        this.reach = reach;
    }

}
