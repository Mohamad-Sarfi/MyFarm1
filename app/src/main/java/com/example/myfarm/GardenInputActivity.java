package com.example.myfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class GardenInputActivity extends AppCompatActivity {
    EditText E0,E1,E2,E3;
    TextView GPSTV1,GPSTV2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_input);

        button = findViewById(R.id.GIb);
        E0 = findViewById(R.id.ETxtGI1);
        E1 = findViewById(R.id.ETxtGI2);
        E2 = findViewById(R.id.GIType1);
        E3 = findViewById(R.id.GIType2);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.setText("Hello");
                Log.i("OUTPUT", E0.getText().toString());
                if (E0.getText().toString().trim().length() == 0 || E1.getText().toString().trim().length() == 0 || E2.getText().toString().trim().length() == 0){
                    Toast.makeText(GardenInputActivity.this,"تمام فیلدها را پر کنید!!!" , Toast.LENGTH_SHORT).show();
                    if(E0.getText().toString().trim().length() == 0 ){
                        E0.setBackgroundResource(R.drawable.wrong_back);
                        E0.setTextColor(Color.WHITE);
                        E0.setHintTextColor(Color.WHITE);
                        E0.setHint("نام باغ را وارد کنید.");
                    }
                    if(E1.getText().toString().trim().length() == 0 ){
                        E1.setBackgroundResource(R.drawable.wrong_back);
                        E1.setTextColor(Color.WHITE);
                        E1.setHintTextColor(Color.WHITE);
                    }
                    if(E2.getText().toString().trim().length() == 0 ){
                        E2.setBackgroundResource(R.drawable.wrong_back);
                        E2.setTextColor(Color.WHITE);
                        E2.setHintTextColor(Color.WHITE);
                    }
                }
                else {
                    Intent replyIntent = new Intent();

                    int age = Integer.parseInt(E1.getText().toString().trim());

                    replyIntent.putExtra("Name", E0.getText().toString().trim());
                    replyIntent.putExtra("Age", age);
                    replyIntent.putExtra("Type2", E2.getText().toString().trim());
                    if (E3.getText().toString().length() != 0) {
                        replyIntent.putExtra("type2", E3.getText().toString().trim());
                    }
                    setResult(RESULT_OK, replyIntent);
                }
            }
        });




    }
}
