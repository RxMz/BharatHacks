package tech.min.bharathacks;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rishabh on 18/6/17.
 */
public class profileOfBorrower extends AppCompatActivity {


    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applyforloan);
        MainActivity obj=new MainActivity();
        obj.init();
        final EditText name = (EditText)findViewById(R.id.Name);
        final EditText desc= (EditText)findViewById(R.id.description);
        final EditText loanType = (EditText)findViewById(R.id.typeofloan);
        final EditText loanA = (EditText)findViewById(R.id.Amount);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        Button s=(Button)findViewById(R.id.sub);
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        String naama = name.getText().toString();

                        String descriptiona = desc.getText().toString();

                        String loanta = loanType.getText().toString();
                        String loanAmounta = loanA.getText().toString();

                        StuffInCard kaObject = new StuffInCard(naama , descriptiona , loanta,loanAmounta);
                        if(kaObject==null)
                            Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_LONG).show();
                        databaseReference.push().setValue(kaObject);
                Toast.makeText(getApplicationContext(),"Registered!",Toast.LENGTH_LONG).show();

                Intent i3=new Intent(profileOfBorrower.this,MainActivity.class);
                startActivity(i3);

                    }
                });

    }
}
