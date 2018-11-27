package sematech.training.Drafts.RealmMVP;

import io.realm.RealmObject;

public class StudentEntity extends RealmObject {

    public String name,family,mobile;
    public int age;

    public StudentEntity() {
    }

    public StudentEntity(String name, String family, String mobile, int age) {
        this.name = name;
        this.family = family;
        this.mobile = mobile;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getMovile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
