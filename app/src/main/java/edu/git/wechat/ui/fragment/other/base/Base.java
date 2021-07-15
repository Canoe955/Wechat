package edu.git.wechat.ui.fragment.other.base;

import java.util.List;

public class Base {
    private int code;
    private boolean more;
    private List<Song> songs;

    public Base() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isMore() {
        return more;
    }

    public void setMore(boolean more) {
        this.more = more;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}
