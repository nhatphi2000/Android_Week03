package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btnReset, btnSignUp, btnExit;
        btnReset = (Button) findViewById(R.id.btnReset);
        btnSignUp = (Button) findViewById(R.id.btnSign);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editUser, editPass, editRetype, editBirth;
                editUser = (EditText) findViewById(R.id.editUser);
                editPass = (EditText) findViewById(R.id.editPass);
                editRetype = (EditText) findViewById(R.id.editRetype);
                editBirth = (EditText) findViewById(R.id.editBirth);

                CheckBox boxTennis, boxFutbal, boxOthers;
                boxTennis = (CheckBox) findViewById(R.id.boxTennis);
                boxFutbal = (CheckBox) findViewById(R.id.boxFutbal);
                boxOthers = (CheckBox) findViewById(R.id.boxOthers);

                RadioButton radioMale, radioFemale;
                radioMale = (RadioButton) findViewById(R.id.radioMale);
                radioFemale = (RadioButton) findViewById(R.id.radioFemale);

                editUser.setText("");
                editPass.setText("");
                editRetype.setText("");
                editBirth.setText("");
                boxTennis.setChecked(false);
                boxFutbal.setChecked(false);
                boxOthers.setChecked(false);
                radioMale.setChecked(false);
                radioFemale.setChecked(false);
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editUser, editPass, editRetype, editBirth;
                editUser = (EditText) findViewById(R.id.editUser);
                editPass = (EditText) findViewById(R.id.editPass);
                editRetype = (EditText) findViewById(R.id.editRetype);
                editBirth = (EditText) findViewById(R.id.editBirth);

                CheckBox boxTennis, boxFutbal, boxOthers;
                boxTennis = (CheckBox) findViewById(R.id.boxTennis);
                boxFutbal = (CheckBox) findViewById(R.id.boxFutbal);
                boxOthers = (CheckBox) findViewById(R.id.boxOthers);

                RadioButton radioMale, radioFemale;
                radioMale = (RadioButton) findViewById(R.id.radioMale);
                radioFemale = (RadioButton) findViewById(R.id.radioFemale);

                String pass=editPass.getText().toString();
                String checkPass=editRetype.getText().toString();

                if((radioFemale.isChecked()||radioMale.isChecked())&& pass.compareTo(checkPass)==0 && pass.isEmpty()==false
                        && editUser.getText().toString().isEmpty()==false && editBirth.getText().toString().isEmpty()==false)
                {
                    Intent Signup_Result_intent = new Intent(MainActivity.this, ResultForm.class);
                    Bundle mainBundle=new Bundle();
                    mainBundle.putString("username",editUser.getText().toString());
                    mainBundle.putString("password",editPass.getText().toString());
                    mainBundle.putString("dob",editBirth.getText().toString());

                    String hobbies="";
                    if (boxFutbal.isChecked()) hobbies+="Fulbal";
                    if (boxTennis.isChecked())
                    {
                        if(hobbies!="") hobbies+=", ";
                        hobbies+="Tennis";
                    }
                    if (boxOthers.isChecked())
                    {
                        if(hobbies!="") hobbies+=", ";
                        hobbies+="Something";
                    }
                    mainBundle.putString("hobbies",hobbies);
                    if(radioFemale.isChecked()) mainBundle.putString("Gender","Female");
                    else mainBundle.putString("Gender","Male");
                    Signup_Result_intent.putExtras(mainBundle);
                    btnReset.callOnClick();
                    startActivityForResult(Signup_Result_intent,9);
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Nhập thông tin chưa chính xác!",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data)
    {
        if (resultCode==RESULT_OK && requestCode==9)
        {
            Toast.makeText(this,data.getExtras().getString("Result"),Toast.LENGTH_SHORT).show();
        }
    }
}