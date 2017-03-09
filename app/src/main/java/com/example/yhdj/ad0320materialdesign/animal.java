package com.example.yhdj.ad0320materialdesign;

/**
 * Created by yhdj on 2017/3/9.
 */

public class animal {

    private String name;
    private int image;

    public animal(String name, int image){
            this.name = name;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
