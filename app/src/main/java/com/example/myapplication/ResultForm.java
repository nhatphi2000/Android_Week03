package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultForm extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_form);

        Intent callInten = getIntent();
        Bundle resultBundle=callInten.getExtras();
        String username = resultBundle.getString("username");
        String password = resultBundle.getString("password");
        String hiddenPass ="";
        for (int i=0;i<password.length();i++) hiddenPass+="*";
        String dob = resultBundle.getString("dob");
        String gender=resultBundle.getString("Gender");
        String hobbie=resultBundle.getString("hobbies");

        TextView tv2,tv3,tv4,tv5,tv6;
        tv2=(TextView)findViewById(R.id.inforuser);
        tv3=(TextView)findViewById(R.id.inforpass);
        tv4=(TextView)findViewById(R.id.inforbirth);
        tv5=(TextView)findViewById(R.id.inforgender);
        tv6=(TextView)findViewById(R.id.inforhobbies);

        tv2.setText("Username: "+username);
        tv3.setText("Password: "+hiddenPass);
        tv4.setText("Birthdate: "+dob);
        tv5.setText("Gender: "+gender);
        tv6.setText("Hobbies: "+hobbie);

        Button btnExit=(Button)findViewById(R.id.btnExit);
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }
    @Override
    public void finish()
    {
        Intent data=new Intent();
        data.putExtra("Result", "Đã xem xong thông tin đăng kí!");
        setResult(RESULT_OK,data);
        super.finish();
    }
}