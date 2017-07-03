package tech.min.bharathacks;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

/**
 * Created by rishabh on 18/6/17.
 */
public class LendOrLoan extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lendorloan);
        String temp ="";

        URL url;
        HttpURLConnection urlConnection = null;
        try {


            Toast.makeText(getApplicationContext(),"Connected",Toast.LENGTH_LONG).show();
            url = new URL("https://us-central1-bharathacks-a0e70.cloudfunctions.net/addMessage");

            urlConnection = (HttpURLConnection) url
                    .openConnection();

            InputStream in = urlConnection.getInputStream();

            InputStreamReader isw = new InputStreamReader(in);


            int data = isw.read();

            Toast.makeText(getApplicationContext(),"CHECK"+data,Toast.LENGTH_LONG).show();
            while (data != -1) {
                char current = (char) data;
                data = isw.read();
                Log.i("Something", ""+current);
                //System.out.print(current);
                temp=temp+current;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        final String temp2=temp;

        Button btnlend = (Button)findViewById(R.id.btnGiveLoan);
        btnlend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),temp2,Toast.LENGTH_LONG).show();
                Intent i1= new Intent(LendOrLoan.this,MainActivity.class);
                startActivity(i1);


            }
        });
        Button btnBorrow = (Button)findViewById(R.id.btntakeLoan);
        btnBorrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2=new Intent(LendOrLoan.this,profileOfBorrower.class);
                startActivity(i2);
            }
        });
    }
}
