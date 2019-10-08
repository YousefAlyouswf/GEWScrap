package com.yousef.owner.scrapcalculator2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements dialogInvoice.SentToHome {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ImageButton button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogInvoice dialogInvoice = new dialogInvoice();
                dialogInvoice.show(getSupportFragmentManager(), "open dialog");
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.contact:
                openContact();
                break;
            case R.id.review:
                review();
                break;

        }
        return true;
    }

    public void review() {
        dialogInvoice dialogInvoice = new dialogInvoice();
        dialogInvoice.show(getSupportFragmentManager(), "open dialog");
    }


    public void openContact() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setTitle("أختر الرقم للاتصال");


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        try {
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+966505498449", null)));
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }

                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        try {
                            startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+966567837975", null)));
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                        break;
                }
            }
        };
        builder.setPositiveButton("أبو يوسف: \n0505498449", dialogClickListener);
        builder.setNegativeButton("أبو سلطان: \n0567837975", dialogClickListener);
        AlertDialog dialog = builder.create();
        dialog.show();

    }


    @Override
    public void apply(String pass) {

        if (pass.equals("123")) {
            Intent intent = new Intent(this, newInvoice.class);
            startActivity(intent);
        } else if (pass.equals("147")) {
            Intent intent = new Intent(this, invoiceReview.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "الرقم خاطئ", Toast.LENGTH_SHORT).show();
        }

    }
}


