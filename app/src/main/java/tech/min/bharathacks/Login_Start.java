package tech.min.bharathacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.andexert.library.RippleView;

/**
 * Created by rishabh on 18/6/17.
 */
public class Login_Start extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main_1);
        Button btnSignUpAadhar = (Button)findViewById(R.id.signUpAdhar);
        btnSignUpAadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Login_Start.this, Aadhar.class);
                startActivity(intent);

            }
        });

    }
}
