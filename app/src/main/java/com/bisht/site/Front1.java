package com.bisht.site;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Rishabh on 5/13/2017.
 */

public class Front1 extends AppCompatActivity {
        private ImageView logo;
    private Button butt1;
    private Button butt2;
    private Button butt3;
    private Button butt4;

    private ImageView share;
    private TextView site;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front1);

        logo=(ImageView)findViewById(R.id.vqms_site);
        logo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("http://www.vqms.co.in"); // missing 'http://' will cause crashed
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
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

        butt1 = (Button) findViewById(R.id.button1);
        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Consult.class);
                view.getContext().startActivity(Intent);
            }
        });

        butt2 = (Button) findViewById(R.id.button2);
        butt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Audit.class);
                view.getContext().startActivity(Intent);
            }
        });

        butt3 = (Button) findViewById(R.id.button3);
        butt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Accredit.class);
                view.getContext().startActivity(Intent);
            }
        });
        butt4 = (Button) findViewById(R.id.button4);
        butt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Intent = new Intent(view.getContext(), Corporate.class);
                view.getContext().startActivity(Intent);
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

    }
}
