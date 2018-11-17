package sematech.training.Authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import sematech.training.R;
import sematech.training.custom_views.MyButton;

public class AuthActivity extends AppCompatActivity implements View.OnClickListener{
    MyButton btnRegisterAuth,btnLoginAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        bind();
        btnRegisterAuth.setOnClickListener(this);
        btnLoginAuth.setOnClickListener(this);

    }

    private void bind() {
        btnRegisterAuth = findViewById(R.id.btnRegisterAuth);
        btnLoginAuth = findViewById(R.id.btnLoginAuth);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnRegisterAuth)
            startActivity(new Intent(this,RegstrationActivity.class));
        else if (v.getId()==R.id.btnLoginAuth)
            startActivity(new Intent(this,LoginActivity.class));
    }
}
