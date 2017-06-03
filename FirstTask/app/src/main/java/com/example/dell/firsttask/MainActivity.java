package com.example.dell.firsttask;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int s1=0,s2=0,s3=0;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        int a = mSettings.getInt("s1", 0);
        int b = mSettings.getInt("s2", 0);
        int c = mSettings.getInt("s3", 0);
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        TextView textView = (TextView) findViewById(R.id.textbox);
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(a, b, c));
        textView.setText("(" + a + "," + b + "," + c + ")");
        b1.setText("" + a);
        b2.setText("" + b);
        b3.setText("" + c);
        s1 = a;
        s2 = b;
        s3 = c;

    }



    public void but1(View view){
        s1+=3;
        if(s1>255)
            s1=0;
        Button b1 = (Button) findViewById(R.id.button1);
        b1.setText("" + s1);
        setTextBox();
        sp();
    }

    public void but2(View view){
        s2+=8;
        if(s2>255)
            s2=0;
        Button b2 = (Button) findViewById(R.id.button2);
        b2.setText("" + s2);
        setTextBox();
        sp();
    }

    public void but3(View view){
        s3+=20;
        if(s3>255)
            s3=0;
        Button b3 = (Button) findViewById(R.id.button3);
        b3.setText("" + s3);
        setTextBox();
        sp();
    }

    public void reset(View view){
        Button b1 = (Button) findViewById(R.id.button1);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);
        b1.setText("0");
        b2.setText("0");
        b3.setText("0");
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(0,0,0));
        TextView textView = (TextView) findViewById(R.id.textbox);
        textView.setText("(" + 0 + "," + 0 + "," + 0 + ")");
        s1=0;
        s2=0;
        s3=0;
        sp();
    }
    public void setTextBox(){
        TextView textView = (TextView) findViewById(R.id.textbox);
        textView.setText("(" + s1 + "," + s2 + "," + s3 + ")");
        LinearLayout layout = (LinearLayout) findViewById(R.id.lay);
        layout.setBackgroundColor(Color.rgb(s1,s2,s3));
        sp();
    }
    public void sp(){
        SharedPreferences mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putInt("s1",s1);
        editor.putInt("s2",s2);
        editor.putInt("s3",s3);
        editor.apply();
    }
}
