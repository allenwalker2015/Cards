package com.allen.cards;

/**
 * Created by uca on 04-18-18.
 */

public class Serie {
  private String name,caps,desc;
  private int img;
  private boolean isFav= false;



    public Serie(String name, String caps, String desc, int img){
      this.name=name;
      this.caps=caps;
      this.desc=desc;
      this.img=img;

  }

    public String getCaps() {
        return caps;
    }

    public void setCaps(String caps) {
        this.caps = caps;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getisFav() {
        return isFav;
    }

    public void setFav(boolean fav) {
        isFav = fav;
    }
}
