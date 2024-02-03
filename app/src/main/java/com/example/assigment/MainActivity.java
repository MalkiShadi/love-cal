package com.example.assigment;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button choose;
    private View screen1;
    private ImageView photo;
    private ImageView loveimg;
    private EditText dateg;
    private EditText mong;
    private EditText yearg;

   private EditText dateb;
    private EditText monb;
    private EditText yearb;
    private TextView caltext;
    private TextView show;
    private Button resetbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       choose=(Button) findViewById(R.id.btn1);
        resetbtn=(Button) findViewById(R.id.rebtn);
        screen1 = (View) findViewById(R.id.ac1);
        photo = (ImageView) findViewById(R.id.img1);
        loveimg = (ImageView) findViewById(R.id.imglv);
        dateb = (EditText) findViewById(R.id.db);
        dateg = (EditText) findViewById(R.id.dg);
        monb = (EditText) findViewById(R.id.mb);
        mong = (EditText) findViewById(R.id.mg);
        yearb = (EditText) findViewById(R.id.yb);
        yearg = (EditText) findViewById(R.id.yg);
        caltext = (TextView) findViewById(R.id.txtcal);
        show = (TextView) findViewById(R.id.output);

        //screen1.setBackgroundColor(Color.rgb(242, 124, 143));
        //choose.setBackgroundColor(Color.rgb(196,16,10));
        caltext.setTextColor(Color.rgb(230,220,223));
        resetbtn.setBackgroundColor(Color.WHITE);
        resetbtn.setTextColor(Color.RED);

        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gdate = Integer.parseInt(dateg.getText().toString());
                int gmonth = Integer.parseInt(mong.getText().toString());
                int gyear = Integer.parseInt(yearg.getText().toString());
                int gtot = gdate + gmonth + gyear;

                int bdate = Integer.parseInt(dateb.getText().toString());
                int bmonth = Integer.parseInt(monb.getText().toString());
                int byear = Integer.parseInt(yearb.getText().toString());
                int btot = bdate + bmonth + byear;
                double both;
                double answer;



                if (gtot>btot){
                    both = gtot - btot;
                }else {
                    both = btot - gtot;
                }

                if (both<10){
                    answer = (both/10)*100;
                }else {
                    answer = (100-both);
                }


                if (answer>70){
                    choose.setText(answer+"%");
                    show.setText("MATCH MADE IN HEAVEN");
                    show.setTextColor(Color.WHITE);

                } else if (answer>=30) {
                    choose.setText(answer+"%");
                    show.setText("TIME TO THINK TWICE");
                    show.setTextColor(Color.GRAY);
                }else{
                    choose.setText(answer+"%");
                    show.setText("SHOULD BREAKUP NOW");
                    show.setTextColor(Color.BLACK);
                }

            }
        });

        resetbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateg.getText().clear();
                dateb.getText().clear();
                mong.getText().clear();
                monb.getText().clear();
                yearg.getText().clear();
                yearb.getText().clear();
                choose.setText("Calculator");
                show.setText("");
            }
        });

    }
}