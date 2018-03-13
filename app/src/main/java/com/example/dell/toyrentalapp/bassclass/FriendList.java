package com.example.dell.toyrentalapp.bassclass;

/**
 * Created by dell on 2018/3/13.
 */

public class FriendList {
    private int image;
    private String tails;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTails() {
        return tails;
    }

    public void setTails(String tails) {
        this.tails = tails;
    }

    public FriendList(int image, String tails) {
        this.image = image;
        this.tails = tails;
    }
}
