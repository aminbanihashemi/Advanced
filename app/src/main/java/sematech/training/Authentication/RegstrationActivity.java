package sematech.training.Authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import sematech.training.MainActivity;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyEditText;
import sematech.training.utils.BaseActivity;

public class RegstrationActivity extends BaseActivity {

    private EditText emailAddress;
    private EditText password;
    private FirebaseAuth mAuth;
    MyButton btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regstration);
        bind();
        mAuth = FirebaseAuth.getInstance();
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRegisterClickedMethod();
            }
        });

    }

    private void bind() {
        emailAddress = findViewById(R.id.emailAddressRegister);
        password = findViewById(R.id.passwordRegister);
        btnRegister = findViewById(R.id.btnRegister );
    }

    public void btnRegisterClickedMethod() {
        final ProgressDialog progressDialog = ProgressDialog.show(RegstrationActivity.this, "Please Wait .....", "Processing...", true);

        (mAuth.createUserWithEmailAndPassword(emailAddress.getText().toString(), password.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(RegstrationActivity.this, "Registration Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegstrationActivity.this,LoginActivity.class));
                }
                else{
                    Log.e("Error",task.getException().toString());
                    Toast.makeText(RegstrationActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
