package com.siamsoft.admission_form;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;
    CheckBox chb1, chb2;
    Spinner spn,spn1;
    TextView tp,ta;
    EditText dt,etvill,etname;
    DatePickerDialog pickerdia;



    Button b;


    String[] pain = {"hentai","pain","love","hate","anger","mercy"};
    String[] akatsu = {"Madara","Tobi","Pain","Itachi","Konan","Hidan"};

    ArrayAdapter<String> aradp;
    ArrayAdapter<String> aradp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ////-------------RatingBar--------////

        final RatingBar ratingBar = findViewById(R.id.ratebar);




        ////-------------Spinner1--------////



        spn1 = findViewById(R.id.sp1);
        ta = findViewById(R.id.spn1tx);

        aradp2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,akatsu);
        spn1.setAdapter(aradp2);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String tx1 = parent.getItemAtPosition(position).toString();

                ta.setText(tx1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        ////-------------Spinner2--------////

        spn =findViewById(R.id.sp2);

        tp = findViewById(R.id.spn2tx);

        aradp = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,pain);

        spn.setAdapter(aradp);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String txt2 = parent.getItemAtPosition(position).toString();
                tp.setText(txt2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ////-------------Name------////
         etname = findViewById(R.id.txtname);

        ////-------------Village------////

        etvill = findViewById(R.id.txtvil);



        ////-------------Date of Birth------////

       dt = findViewById(R.id.txtdob);


       dt.setInputType(InputType.TYPE_NULL);

       dt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               final Calendar cldr = Calendar.getInstance();

               int day = cldr.get(Calendar.DAY_OF_MONTH);
               int month = cldr.get(Calendar.MONTH);
               int year = cldr.get(Calendar.YEAR);
               pickerdia = new DatePickerDialog(MainActivity.this,new DatePickerDialog.OnDateSetListener() {
                   @Override
                   public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                     String  eddata =  (dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                       dt.setText(eddata);
                   }
               }, year, month, day);
               pickerdia.show();



           }
       });

        
        


        ////-------------CheckBox--------////


        chb1 =findViewById(R.id.checkboxnin);
        chb2 = findViewById(R.id.checkboxtai);
        b = findViewById(R.id.print);

        ////-------------Radio-Button------////
        rg = findViewById(R.id.radiogroup);


        ////-------------------------------------------------------------------------------Intent----------------------------------------------------------------------////


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


////-------------Name------////

                Intent nam = new Intent(getApplicationContext(),Print.class);

                String sname = etname.getText().toString();
                  nam.putExtra("name",sname);




                ////-------------Village------////


                String svil = etvill.getText().toString();
                nam.putExtra("village",svil);

                ////-------------RateingBar------////

                String msg = String.valueOf(ratingBar.getRating());

                nam.putExtra("rate",msg);



                ////-------------Date of Birth------////

                String dp = dt.getText().toString();

                nam.putExtra("dtp",dp);



                ////-------------Radio-Button------////


                int select = rg.getCheckedRadioButtonId();

                rb = findViewById(select);

                String show = rb.getText().toString().trim();

                nam.putExtra("mf", show);




                ////-------------CheckBox--------////


                if(chb1.isChecked())
                {
                    String nin = "Ninjutsu";
                    nam.putExtra("n",nin);
                }

                if(chb2.isChecked())
                {
                    String tai= "Taijutsu";
                    nam.putExtra("t",tai);
                }




                ////-------------Spinner1------////




                String sel1 = ta.getText().toString();

                nam.putExtra("spin1",sel1);


                ////-------------Spinner2------////



                String sel2 = tp.getText().toString();

                nam.putExtra("spin2",sel2);



                startActivity(nam);

            }
        });



    }




}