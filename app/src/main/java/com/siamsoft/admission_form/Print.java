package com.siamsoft.admission_form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;


public class Print extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);

        ////-------------Name--------////

        TextView tname  = findViewById(R.id.txtname1);

        String nim = getIntent().getExtras().getString("name");

        tname.setText(nim);

        ////-------------Village--------////

        TextView tvil  = findViewById(R.id.txtvil1);

        String val = getIntent().getExtras().getString("village");

        tvil.setText(val);

        ////-------------Date-of-Birth--------////

        TextView dob  = findViewById(R.id.txtdob);

        String db = getIntent().getExtras().getString("dtp");

        dob.setText(db);

        ////-------------RateingBar------////

        TextView rbs = findViewById(R.id.ratebartxt);

        String rbss = getIntent().getExtras().getString("rate");

        rbs.setText(rbss);



        ////-------------Spinner1--------////


        TextView sptx1 = findViewById(R.id.spntx1);

        String st1 = getIntent().getExtras().getString("spin1");

        sptx1.setText(st1);

        ////-------------Spinner2--------////


        TextView sptx2 = findViewById(R.id.spntx2);

        String st2 = getIntent().getExtras().getString("spin2");

        sptx2.setText(st2);



        ////-------------CheckBox--------////

        TextView tvnin = findViewById(R.id.tecnin);
        TextView tvtai = findViewById(R.id.tectai);

        String ninj = getIntent().getExtras().getString("n");

        tvnin.setText(ninj);

        String taij = getIntent().getExtras().getString("t");

        tvtai.setText(taij);



        ////-------------Radio-Button------////

            TextView tvg = findViewById(R.id.gender);
            String g = getIntent().getExtras().getString("mf");
            tvg.setText(g);





    }







}