package com.bisht.site;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private Button sub;

    private EditText mob;
    private EditText email;
    private Firebase mrootref;

    private TextInputLayout inputLayoutEmail, inputLayoutPhone;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputLayoutPhone = (TextInputLayout) findViewById(R.id.input_layout_mob);
        inputLayoutEmail = (TextInputLayout) findViewById(R.id.input_layout_mail);

        email = (EditText) findViewById(R.id.EditTextEmail);
        mob = (EditText) findViewById(R.id.EditTextPhone);

        sub = (Button) findViewById(R.id.buttonSend);
        mrootref = new Firebase("https://vqmssite.firebaseio.com/A");



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mob1=mob.getText().toString().trim();
                String email1=email.getText().toString().trim();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                String phonePattern= "^[0-9]{10}$";
                // Firebase mrefChild=mrootref.child("Name");

                String key = mrootref.child("posts").push().getKey();
                mrootref= new Firebase("https://vqmssite.firebaseio.com/A"+key);



                if (email1.isEmpty() || mob1.isEmpty()|| !email1.matches(emailPattern)|| !mob1.matches(phonePattern)) {
                    Toast.makeText(getApplicationContext(),
                            "Enter valid email and mobile",
                            Toast.LENGTH_LONG).show();
                    Intent Intent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    view.getContext().startActivity(Intent);
                }


                else {

                    Firebase mrefChildmob = mrootref.child("Mobile");
                    mrefChildmob.setValue(mob1);
                    Firebase mrefChildemail = mrootref.child("Email");
                    mrefChildemail.setValue(email1);

                    Toast.makeText(getApplicationContext(),
                            "Registered Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent Intent = new Intent(view.getContext(), MainActivity.class);
                    finish();
                    view.getContext().startActivity(Intent);
                }
                //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();



            }
        });







    }
}
