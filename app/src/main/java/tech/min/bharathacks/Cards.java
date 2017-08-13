package tech.min.bharathacks;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rishabh on 18/6/17.
 */
public class Cards extends AppCompatActivity {
    DatabaseReference databaseReference;
    private List<StuffInCardTwo> allTask;
    int tempamount;
    String namee;
    private RecyclerViewForProfile recyclerViewAdapter;
    private RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);
        recyclerView = (RecyclerView) findViewById(R.id.rv_give_loan);
        linearLayoutManager = new LinearLayoutManager(this);

        allTask = new ArrayList<StuffInCardTwo>();
        recyclerView.setLayoutManager(linearLayoutManager);
        final ProgressBar pbar = (ProgressBar) findViewById(R.id.progressBar);
        final TextView name, amount, interest, hash, funperc;
        final EditText amt, per;
        amt = (EditText) findViewById(R.id.ETAmount);
        per = (EditText) findViewById(R.id.ETinterestRate);
        pbar.setProgress(0);
        Intent i = getIntent();
        final String sessionID = getIntent().getStringExtra("loanid");


        databaseReference = FirebaseDatabase.getInstance().getReference(sessionID);

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
                for (int i = 0; i < allTask.size(); i++) {
                    tempamount = Integer.parseInt(allTask.get(i).getAmount());
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                getAllTask(dataSnapshot);
                for (int i = 0; i < allTask.size(); i++) {
                    tempamount = Integer.parseInt(allTask.get(i).getAmount());
                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        Toast.makeText(getApplicationContext(), sessionID, Toast.LENGTH_LONG).show();
        Button giveloan = (Button) findViewById(R.id.btnGiveLoan);
        giveloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String amtt = amt.getText().toString();
                String interest = per.getText().toString();
                pbar.setProgress(tempamount);
                Toast.makeText(getApplicationContext(), "Cash transaction successful!", Toast.LENGTH_LONG).show();

                SharedPreferences prefs = getSharedPreferences("BharatHacks", MODE_PRIVATE);
                String nameee = prefs.getString("name", "Anonymous");//Anonymous is the default value.


                StuffInCardTwo obj = new StuffInCardTwo(nameee, amtt, interest);
                databaseReference.push().setValue(obj);
                // Notify that the transaction is successful
             /*   Intent i1 = new Intent();
                PendingIntent pIntent = PendingIntent.getActivity(Cards.this, 0, i1, 0);
                Notification noti = new Notification.Builder(Cards.this).setTicker("TickerTitle")
                        .setContentTitle("Transaction successful!")
                        .setContentText("Rishabh has received your funds!")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent).getNotification();
                noti.flags = Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, noti);*/


            }
        });
    }

    private void getAllTask(DataSnapshot dataSnapshot) {
        //for(DataSnapshot singleSnapshot : dataSnapshot.getChildren()){
        StuffInCardTwo stuff = dataSnapshot.getValue(StuffInCardTwo.class);
        allTask.add(stuff);

        // String taskTitle = singleSnapshot.getValue(String.class);
        // String other = singleSnapshot.getValue(String.class);
        // allTask.add(new StuffInCard(taskTitle));
        //  }

        recyclerViewAdapter = new RecyclerViewForProfile(Cards.this, allTask);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
