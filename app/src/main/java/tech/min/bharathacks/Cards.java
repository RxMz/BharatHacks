package tech.min.bharathacks;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by rishabh on 18/6/17.
 */
public class  Cards extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards);
        final ProgressBar pbar = (ProgressBar)findViewById(R.id.progressBar);
        final TextView nameoflender,amount,precent,hash,funperc;
        final EditText amt,per,name;
        amt = (EditText)findViewById(R.id.ETAmount);
        per = (EditText)findViewById(R.id.ETinterestRate);
        nameoflender = (TextView)findViewById(R.id.NameOfLender);
        amount = (TextView)findViewById(R.id.amount);
        precent = (TextView)findViewById(R.id.percentageint);
        hash = (TextView)findViewById(R.id.hashtag);
        funperc = (TextView)findViewById(R.id.funPercent);
        pbar.setProgress(0);
        Button giveloan = (Button)findViewById(R.id.btnGiveLoan);
        giveloan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameoflender.setVisibility(View.VISIBLE);
                String amtt = amt.getText().toString();
                amount.setText(amtt);
                amount.setVisibility(View.VISIBLE);
                String perr = per.getText().toString();
                precent.setText(perr);
                precent.setVisibility(View.VISIBLE);
                hash.setVisibility(View.VISIBLE);

                int temp = Integer.parseInt(amtt);
                Double temp2= (temp/9000.0)*100;
                int temp3 = (int) Math.round(temp2);
                //temp3
//                funperc.setText(temp3);
                pbar.setProgress(temp3);
                Toast.makeText(getApplicationContext(),"Cash transaction successful!",Toast.LENGTH_LONG).show();

                Intent i1=new Intent();
                PendingIntent pIntent= PendingIntent.getActivity(Cards.this,0,i1,0);
                Notification noti=new Notification.Builder(Cards.this).setTicker("TickerTitle")
                        .setContentTitle("Transaction successful!")
                        .setContentText("Rishabh has received your funds!")
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pIntent).getNotification();
                noti.flags= Notification.FLAG_AUTO_CANCEL;
                NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);



            }
        });
    }
}
