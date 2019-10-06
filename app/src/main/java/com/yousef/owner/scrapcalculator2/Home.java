package com.yousef.owner.scrapcalculator2;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener, dialogInvoice.SentToHome {

    Button refresh;
    EditText editTextWieght;
    TextView mytext;
    String selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        final Spinner mySpinner = findViewById(R.id.spinner);

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(Home.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.scrapList));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        mySpinner.setAdapter(myAdapter);

        mySpinner.setOnItemSelectedListener(this);


        refresh = findViewById(R.id.button4);
        editTextWieght = findViewById(R.id.editTextWieght);
        mytext = findViewById(R.id.textView7);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                mySpinner.setAdapter(myAdapter);

                editTextWieght.setText("");
            }
        });

        ImageButton button3= findViewById(R.id.button3);

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
            case R.id.manage:
                openActivity();
                break;
            case R.id.contact:
                openContact();
                break;
            case R.id.review:
                review();
                break;

        }
        return true;
    }

    public void newinvoice(){
        Intent intent = new Intent(this, newInvoice.class);
        startActivity(intent);
    }
    public void review() {
        dialogInvoice dialogInvoice = new dialogInvoice();
        dialogInvoice.show(getSupportFragmentManager(), "open dialog");
    }

    public void openActivity() {
        dialogInvoice dialogInvoice = new dialogInvoice();
        dialogInvoice.show(getSupportFragmentManager(), "open dialog");
    }

    public void openinvoice() {

        dialogInvoice dialogInvoice = new dialogInvoice();
        dialogInvoice.show(getSupportFragmentManager(), "open dialog");
    }

    public void openContact() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        // Set a title for alert dialog
        builder.setTitle("أختر الرقم للاتصال");


        // Set click listener for alert dialog buttons
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

        // Set the alert dialog yes button click listener
        builder.setPositiveButton("أبو يوسف: \n0505498449", dialogClickListener);

        // Set the alert dialog no button click listener
        builder.setNegativeButton("أبو سلطان: \n0567837975", dialogClickListener);

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();

    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String valueSelected = adapterView.getItemAtPosition(i).toString();


        if (valueSelected.equals("حديد ثقيل")) {
            selected = "ironH";
            getPrice();
        } else if (valueSelected.equals("حديد خفيف")) {
            selected = "ironL";
            getPrice();
        }else if (valueSelected.equals("نحاس احمر")) {
            selected = "copperR";
            getPrice();
        }else if (valueSelected.equals("نحاس اصفر")) {
            selected = "copperY";
            getPrice();
        } else if (valueSelected.equals("المنيوم")) {
            selected = "alum";
            getPrice();
        } else if (valueSelected.equals("سلك 1")) {
            selected = "ironZ";
            getPrice();
        } else if (valueSelected.equals("سلك 2")) {
            selected = "alumQ";
            getPrice();
        } else if (valueSelected.equals("استيل")) {
            selected = "steel";
            getPrice();
        }  else if (valueSelected.equals("اسفنج")) {
            selected = "copperM";
            getPrice();
        }else if (valueSelected.equals("بطاريات")) {
            selected = "bat";
            getPrice();

        } else if (valueSelected.equals("قارورة")) {
            selected = "copperN";
            getPrice();
        } else if (valueSelected.equals("بلاستيك")) {
            selected = "mix2";
            getPrice();

        } else if (valueSelected.equals("فرن")) {
            selected = "mix";
            getPrice();
        } else if (valueSelected.equals("راديتور نحاس")) {
            selected = "tot";
            getPrice();
        } else if (valueSelected.equals("راديتور المنيوم")) {
            selected = "rAlum";
            getPrice();
        }  else {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


    public void getPrice() {
        editTextWieght.setText("");
        String method = "getPrice";

        BackgroundTask backgroundTask = new BackgroundTask(this);

        backgroundTask.execute(method, selected);
    }

    @Override
    public void apply(String pass) {

        if (pass.equals("123")) {
            Intent intent = new Intent(this, newInvoice.class);
            startActivity(intent);
        } else if (pass.equals("123321")) {
            Intent intent = new Intent(this, Manage.class);
            startActivity(intent);
        } else if (pass.equals("147")) {
            Intent intent = new Intent(this, invoiceReview.class);
            startActivity(intent);

        } else {
            Toast.makeText(getApplicationContext(), "الرقم خاطئ", Toast.LENGTH_SHORT).show();
        }

    }
}


