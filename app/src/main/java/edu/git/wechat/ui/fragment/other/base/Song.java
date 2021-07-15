package edu.git.wechat.ui.fragment.other.base;

import java.util.List;

public class Song {
    private String name ;
    private String id ;
    private List<Artist> ar;

    public Song() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Artist> getAr() {
        return ar;
    }

    public void setAr(List<Artist> ar) {
        this.ar = ar;
    }
}
