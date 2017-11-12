package com.bisht.site;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by Rishabh on 5/13/2017.
 */
public class Accredit extends AppCompatActivity

{   private Button sub;
    private EditText name;
    private EditText loc;
    private EditText require;
    private EditText mob;
    private EditText email;
    private EditText domain;
    private EditText purpose;


    private Firebase mrootref;
    private ImageView share;
    private TextView site;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accredit);
        name = (EditText) findViewById(R.id.EditTextName);
        loc = (EditText) findViewById(R.id.EditTextLocation);
        mob = (EditText) findViewById(R.id.EditTextMobile);
        email = (EditText) findViewById(R.id.EditTextEmail);
        domain = (EditText) findViewById(R.id.EditTextDomain);
        require = (EditText) findViewById(R.id.EditRequirements);
        purpose = (EditText) findViewById(R.id.EditTextPurpose);

        sub = (Button) findViewById(R.id.ButtonSendFeedback);

        mrootref = new Firebase("https://vqms-quality-5b65a.firebaseio.com/Accreditation");



        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name1=name.getText().toString();
                String colname1=domain.getText().toString();
                String loc1=loc.getText().toString();
                String mob1=mob.getText().toString();
                String require1=require.getText().toString();
                String email1=email.getText().toString();
                String purpose1=purpose.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+";
                String emailPattern2 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+";
                String emailPattern3 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+";
                String emailPattern4 = "[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+\\.[a-z]+";

                String phonePattern= "^[0-9]{10}$";
                // Firebase mrefChild=mrootref.child("Name");

                String key = mrootref.child("posts").push().getKey();
                mrootref= new Firebase("https://vqms-quality-5b65a.firebaseio.com/Accreditation/"+key);


                if (email1.isEmpty() || mob1.isEmpty()|| !mob1.matches(phonePattern) || !(email1.matches(emailPattern)|| email1.matches(emailPattern2)|| email1.matches(emailPattern3)|| email1.matches(emailPattern4))) {
                    Toast.makeText(getApplicationContext(),
                            "Enter valid email and mobile",
                            Toast.LENGTH_LONG).show();
                    return;
                }


                else {

                    Firebase mrefChildname = mrootref.child("Accredit: Employee Name");
                    mrefChildname.setValue(name1);
                     Firebase mrefChildColname = mrootref.child("Accredit: School/College/Univ Name ");
                    mrefChildColname.setValue(colname1);
                    Firebase mrefChildrequire = mrootref.child("Audit: Requirements");
                    mrefChildrequire.setValue(require1);
                    Firebase mrefChildloc = mrootref.child("Accredit: Loc-Address");
                    mrefChildloc.setValue(loc1);
                     Firebase mrefChildmob = mrootref.child("Accredit: Mobile");
                    mrefChildmob.setValue(mob1);
                    Firebase mrefChildemail = mrootref.child("Accredit: Email");
                    mrefChildemail.setValue(email1);
                    Firebase mrefChildpurpose = mrootref.child("Accredit: Purpose");
                    mrefChildpurpose.setValue(purpose1);

                    Toast.makeText(getApplicationContext(),
                            "Registered Successfully",
                            Toast.LENGTH_LONG).show();
                    Intent Intent = new Intent(view.getContext(), Front1.class);
                    finish();
                    view.getContext().startActivity(Intent);
                    //Toast.makeText(getApplicationContext(), key, Toast.LENGTH_LONG).show();

                }

            }
        });

        share=(ImageView)findViewById(R.id.send);

        share.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                try {

                    String message = "I am sharing you this app https://play.google.com/store/apps/details?id=com.bisht.qualitysite which helps you towards  organizational performance development through Quality and Management services, like Quality Certification, Corporate Training, Consulting and Implementation for Industrial best practices e.g ISO QMS, TS, LEAN SIX SIGMA, CMMI5, PMP, ITIL.... more";
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.putExtra(Intent.EXTRA_TEXT, message);

                    startActivity(Intent.createChooser(share, "choose among these"));

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again later!",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
                // TODO DO whatever you want to do here

            }
        });
        site=(TextView) findViewById(R.id.webadd);
        site.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.vqms.co.in"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }

        });



    }

}


