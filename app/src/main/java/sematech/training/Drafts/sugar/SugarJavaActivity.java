package sematech.training.Drafts.sugar;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import sematech.training.R;
import sematech.training.custom_views.MyEditText;
import sematech.training.custom_views.MyTextView;
import sematech.training.Drafts.kotlin.PublicMethod;
import sematech.training.utils.BaseActivity;

public class SugarJavaActivity extends BaseActivity implements View.OnClickListener {

    MyEditText name,family,age;
    MyTextView results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_java);

        bind();
        loadData();
        findViewById(R.id.register).setOnClickListener(this);

    }

    private void bind() {
        name=findViewById(R.id.name);
        family=findViewById(R.id.family);
        age=findViewById(R.id.age);
        results=findViewById(R.id.results);
    }

    @Override
    public void onClick(View v) {
        register();
    }

    private void register() {
        StudentModel std = new StudentModel();
        std.setName(name.text());
        std.setFamily(family.text());
        try{
            //momken ast user bejaie number, word vared konad, be hamind dalil,
            //dakhele try catch migozarim ke be error nakhorim.
            std.setAge(Integer.parseInt(age.text()));
        }catch (Exception e){
            std.setAge(0);
        }
        std.save();
        loadData();
        cleanForm();
        PublicMethod.Companion.toast(mContext,getString(R.string.form_saved));

    }

    void loadData(){
        List<StudentModel> students = new ArrayList<>();
        students = StudentModel.listAll(StudentModel.class);
        for (StudentModel std:students) {
            results.append(std.getName()+" "+std.getFamily()+" "+std.getAge());
        }
    }

    void cleanForm(){
        name.setText("");
        family.setText("");
        age.setText("");
    }
}
