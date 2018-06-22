package tech.min.bharathacks;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerViewAdapter recyclerViewAdapter;
    private EditText addTaskBox;
    String mNameou;
    private DatabaseReference databaseReference;
    private List<StuffInCard> allTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);

        getUsername();
        allTask = new ArrayList<StuffInCard>();
        databaseReference = FirebaseDatabase.getInstance().getReference("LoanTaker");
        recyclerView = (RecyclerView)findViewById(R.id.task_list);
        recyclerView.setLayoutManager(linearLayoutManager);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                //taskDeletion(dataSnapshot);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    private void getAllTask(DataSnapshot dataSnapshot){
        //for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
            StuffInCard stuff = dataSnapshot.getValue(StuffInCard.class);
            allTask.add(stuff);

           // String taskTitle = singleSnapshot.getValue(String.class);
           // String other = singleSnapshot.getValue(String.class);
           // allTask.add(new StuffInCard(taskTitle));
      //  }

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, allTask);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    public void init() {
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
    }

    private void getUsername(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Enter your name");
        final EditText input=new EditText(this);
        builder.setView(input);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mNameou = input.getText().toString();
                SharedPreferences.Editor editor = getSharedPreferences("BharatHacks", MODE_PRIVATE).edit();
                editor.putString("name", mNameou);
                editor.apply();

                Toast.makeText(getApplicationContext(),mNameou,Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Please enter your name",Toast.LENGTH_LONG).show();
                getUsername();
            }
        });
        builder.show();


    }
}