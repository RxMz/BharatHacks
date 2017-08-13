package tech.min.bharathacks;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by rishabh on 18/6/17.
 */
public class Aadhar extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aadhar);
        Button btn=(Button)findViewById(R.id.next);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog dialog = ProgressDialog.show(Aadhar.this, "", "Confirming Number and Name",
                        true);
                dialog.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        dialog.dismiss();
                        Intent i1=new Intent(Aadhar.this,LendOrLoan.class);
                        startActivity(i1);
                    }
                }, 3000); // 3000 milliseconds delay

            }
        });

    }
}
