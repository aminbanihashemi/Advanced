package sematech.training.Models;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class User {
    private String fullname;
    private String email;
    private String number;
    private int age;
    private boolean gender;
    private Drawable img;

    public User(String fullname, String email, String number, int age, boolean gender, Drawable img) {
        this.fullname = fullname;
        this.email = email;
        this.number = number;
        this.age = age;
        this.gender = gender;
        this.img = img;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
