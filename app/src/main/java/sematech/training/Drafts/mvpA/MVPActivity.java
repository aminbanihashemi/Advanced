package sematech.training.Drafts.mvpA;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import sematech.training.R;
import sematech.training.custom_views.MyEditText;
import sematech.training.custom_views.MyTextView;

public class MVPActivity extends AppCompatActivity implements MVPContract.View {
    MyEditText name;
    MyTextView results;
    MVPContract.Presenter presenter = new MVPPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter.attachView(this);
        bind();
        (findViewById(R.id.getAge)).setOnClickListener(V->{
            presenter.onGetAge(name.text());
        });
    }

    private void bind() {
        name = findViewById(R.id.name);
        results = findViewById(R.id.results);
    }

    @Override
    public void onAgeRecevied(int age) {
        results.setText("Age is "+age);
    }
}
