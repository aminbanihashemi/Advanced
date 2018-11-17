package sematech.training;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import sematech.training.WorkoutOne.WorkoutOneActivity;
import sematech.training.WorkoutTwo.MapsActivity;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyImageView;
import sematech.training.custom_views.MyTextView;
import sematech.training.utils.BaseActivity;
import sematech.training.utils.BaseApplication;
import sematech.training.utils.Publics;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    MyButton workoutOne,workoutTwo,workoutThree,workoutFour,workoutFive,workoutSix,workoutSeven,workoutEight;
    MyTextView userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        String email = i.getStringExtra("Email");
        userName.setText(email);



//        ((MyImageView)findViewById(R.id.img)).load("http://live.irib.ir/assets/images/conductor-icon.png");
        bind();
        workoutOne.setOnClickListener(this);
        workoutTwo.setOnClickListener(this);
        workoutThree.setOnClickListener(this);
        workoutFour.setOnClickListener(this);
        workoutFive.setOnClickListener(this);
        workoutSix.setOnClickListener(this);
        workoutSeven.setOnClickListener(this);
        workoutEight.setOnClickListener(this);

    }

    private void bind() {
        userName = findViewById(R.id.userName);
        workoutOne=findViewById(R.id.workoutOne);
        workoutTwo=findViewById(R.id.workoutTwo);
        workoutThree=findViewById(R.id.workoutThree);
        workoutFour=findViewById(R.id.workoutFour);
        workoutFive=findViewById(R.id.workoutFive);
        workoutSix=findViewById(R.id.workoutSix);
        workoutSeven=findViewById(R.id.workoutSeven);
        workoutEight=findViewById(R.id.workoutEight);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.workoutOne){
            workoutOneMethod();
        }else if (v.getId()==R.id.workoutTwo){
            workoutTwoMethod();
        }else if (v.getId()==R.id.workoutThree){

        }else if (v.getId()==R.id.workoutFour){

        }else if (v.getId()==R.id.workoutFive){

        }else if (v.getId()==R.id.workoutSix){

        }else if (v.getId()==R.id.workoutSeven){

        }else if (v.getId()==R.id.workoutEight){

        }

    }

    private void workoutOneMethod() {
        Intent intent = new Intent(MainActivity.this, WorkoutOneActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }
    private void workoutTwoMethod() {
        Intent intent = new Intent(MainActivity.this, MapsActivity.class);
        intent.putExtra("message", "12345");
        startActivity(intent);
    }
}
