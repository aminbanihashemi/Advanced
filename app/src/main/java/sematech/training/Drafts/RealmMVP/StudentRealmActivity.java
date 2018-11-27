package sematech.training.Drafts.RealmMVP;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import es.dmoral.toasty.Toasty;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyEditText;
import sematech.training.utils.BaseActivity;

public class StudentRealmActivity extends BaseActivity implements Contract.View {
    MyEditText name,family,age,mobile;
    Contract.Presenter presenter = new Presenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_realm);
        presenter.attachView(this);
        bind();
        findViewById(R.id.registerstd).setOnClickListener(V->{
            presenter.register(name.text(),family.text(),mobile.text(),age.text());
        });
    }

    private void bind() {
        name = findViewById(R.id.namestd);
        family = findViewById(R.id.familystd);
        age = findViewById(R.id.agestd);
        mobile = findViewById(R.id.mobilestd);
    }

    @Override
    public void onUserLoaded(List<StudentEntity> students) {

    }

    @Override
    public void userRegister() {
        name.setText("");
        family.setText("");
        age.setText("");
        mobile.setText("");
        Toasty.success(this,"Success");
    }
}
