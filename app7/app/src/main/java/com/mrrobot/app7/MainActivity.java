package com.mrrobot.app7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Runnable runnable;//Bir işlemi birden fazla kez belirttiğimiz sayıda veya belirttiğimiz periyotta yapmamıza olanak sağlayan bir arayüz
    Handler handler;//Handler, runnable ile çalışmamızı sağlayan bir arayüz
    int sayac;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        sayac=0;
        button=findViewById(R.id.button);
    }

    public void start(View view){

        handler=new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {//run metodu içerisinde yazığımız her şey bizim belirttiğimiz periyot içerisinde olacaktır
                textView.setText("Time: "+sayac);
                sayac++;
                textView.setText("Time: "+sayac);
                //Son olarak handler'i kullanarak bu runnable'i başlatacağız.
                handler.postDelayed(runnable,1000);
            }
        };
        handler.post(runnable);
        button.setEnabled(false);//Start butonuna basıldıktan sonra tekrar basılmasını önledik.


    }
    public void stop(View view){
        button.setEnabled(true);
        handler.removeCallbacks(runnable);//Arkaplanda çalışan runnable'i kapattık
        sayac=0;
        textView.setText("Time: "+sayac);

    }
}