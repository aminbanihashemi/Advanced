package sematech.training.Drafts.sugar;

import com.orm.SugarRecord;

public class StudentModel extends SugarRecord<StudentModel> {
    public String name,family;
    public int age;

    public StudentModel() {
    super();
    }

    public StudentModel(String name, String family, int age) {
        super();
        this.name = name;
        this.family = family;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", age=" + age +
                '}';
    }
}
