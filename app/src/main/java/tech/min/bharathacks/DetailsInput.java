package tech.min.bharathacks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by rishabh on 17/6/17.
 */
public class DetailsInput extends AppCompatActivity {


    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.putinlist);
        final EditText name = (EditText)findViewById(R.id.Name);
         final EditText desc= (EditText)findViewById(R.id.Desc);
        final EditText loanType = (EditText)findViewById(R.id.loanType);
        final EditText loanA = (EditText)findViewById(R.id.amountRequired);

        databaseReference = FirebaseDatabase.getInstance().getReference("loanGuy");
        Button btn = (Button) findViewById(R.id.Submit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String naam = name.getText().toString();

                String description = desc.getText().toString();

                String loant = loanType.getText().toString();
                String loanAmount = loanA.getText().toString();
                String loanID = databaseReference.push().getKey();
                StuffInCard kaObject = new StuffInCard(naam , description , loant,loanAmount,loanID);
                if(kaObject==null)
                    Toast.makeText(getApplicationContext(),"NULL",Toast.LENGTH_LONG).show();
                databaseReference.child(loanID).setValue(kaObject);

            }
        });
    }
}
