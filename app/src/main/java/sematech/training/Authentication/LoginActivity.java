package sematech.training.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import es.dmoral.toasty.Toasty;
import sematech.training.MainActivity;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyEditText;

public class LoginActivity extends AppCompatActivity {

    private MyEditText emailAddressLogin;
    private MyEditText passwordLogin;
    private FirebaseAuth mAuth;
    MyButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bind();
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnLoginClickedMethod();
            }
        });
    }

    private void bind() {
        emailAddressLogin = findViewById(R.id.emailAddressLogin);
        passwordLogin = findViewById(R.id.passwordLogin);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private void btnLoginClickedMethod() {
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Please Wait ...", "Processing", true);
        (mAuth.signInWithEmailAndPassword(emailAddressLogin.text(), passwordLogin.text())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(LoginActivity.this,MainActivity.class);
                    i.putExtra("Email",mAuth.getCurrentUser().getEmail());
                    startActivity(i);

                } else {
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(LoginActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
