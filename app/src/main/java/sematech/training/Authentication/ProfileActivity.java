package sematech.training.Authentication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sematech.training.R;
import sematech.training.custom_views.MyTextView;

public class ProfileActivity extends AppCompatActivity {
    private MyTextView tvEmailProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        bind();

    }

    private void bind() {
        tvEmailProfile = findViewById(R.id.tvEmailProfile);
    }
}
