package com.yousef.owner.scrapcalculator2;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class newInvoice extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String selected1 = "";
    String selected2 = "";
    String selected3 = "";
    String selected4 = "";
    String selected5 = "";
    String selected6 = "";
    String selected7 = "";


    String currentDate;
    ArrayAdapter<String> myAdapter = null;
    int check = 0;
    //Spinner
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    //EditText Weight
    private EditText weight1;
    private EditText weight2;
    private EditText weight3;
    private EditText weight4;
    private EditText weight5;
    private EditText weight6;
    private EditText weight7;
    private EditText weight8;
    //EditText PriceUnit
    private EditText priceUnit1;
    private EditText priceUnit2;
    private EditText priceUnit3;
    private EditText priceUnit4;
    private EditText priceUnit5;
    private EditText priceUnit6;
    private EditText priceUnit7;
    private EditText priceUnit8;
    //Total
    private TextView Total1;
    private TextView Total2;
    private TextView Total3;
    private TextView Total4;
    private TextView Total5;
    private TextView Total6;
    private TextView Total7;
    private TextView alltotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new_invoice);
        Calendar calendar = Calendar.getInstance();
        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        Init();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String valueSelected = adapterView.getItemAtPosition(i).toString();

        if (adapterView.getId() == R.id.typeinvoice1) {
            selected1 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice2) {
            selected2 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice3) {
            selected3 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice4) {
            selected4 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice5) {
            selected5 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice6) {
            selected6 = selected(valueSelected);
        }
        if (adapterView.getId() == R.id.typeinvoice7) {
            selected7 = selected(valueSelected);
        }

    }

    public String selected(String valueSelected) {
        String selected = "";
        if (valueSelected.equals("أختر البضاعه")) {
            selected = "أختر البضاعه";
        } else if (valueSelected.equals("حديد ثقيل")) {
            selected = "حديد ثقيل";
        } else if (valueSelected.equals("حديد خفيف")) {
            selected = "حديد خفيف";
        } else if (valueSelected.equals("نحاس احمر")) {
            selected = "نحاس احمر";
        } else if (valueSelected.equals("نحاس اصفر")) {
            selected = "نحاس اصفر";
        } else if (valueSelected.equals("المنيوم")) {
            selected = "المنيوم";
        } else if (valueSelected.equals("سلك 1")) {
            selected = "سلك 1";
        } else if (valueSelected.equals("سلك 2")) {
            selected = "سلك 2";
        } else if (valueSelected.equals("استيل")) {
            selected = "استيل";
        } else if (valueSelected.equals("اسفنج")) {
            selected = "اسفنج";
        } else if (valueSelected.equals("بطاريات")) {
            selected = "بطاريات";
        } else if (valueSelected.equals("قارورة")) {
            selected = "قارورة";
        } else if (valueSelected.equals("بلاستيك")) {
            selected = "بلاستيك";
        } else if (valueSelected.equals("فرن")) {
            selected = "فرن";
        } else if (valueSelected.equals("راديتور نحاس")) {
            selected = "راديتور نحاس";
        } else if (valueSelected.equals("راديتور المنيوم")) {
            selected = "راديتور المنيوم";
        } else {

        }
        return selected;
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void Init() {
        spinner1 = findViewById(R.id.typeinvoice1);
        spinner2 = findViewById(R.id.typeinvoice2);
        spinner3 = findViewById(R.id.typeinvoice3);
        spinner4 = findViewById(R.id.typeinvoice4);
        spinner5 = findViewById(R.id.typeinvoice5);
        spinner6 = findViewById(R.id.typeinvoice6);
        spinner7 = findViewById(R.id.typeinvoice7);

        weight1 = findViewById(R.id.weight1);
        weight2 = findViewById(R.id.weight2);
        weight3 = findViewById(R.id.weight3);
        weight4 = findViewById(R.id.weight4);
        weight5 = findViewById(R.id.weight5);
        weight6 = findViewById(R.id.weight6);
        weight7 = findViewById(R.id.weight7);
        weight8 = findViewById(R.id.weight8);

        priceUnit1 = findViewById(R.id.priceunit1);
        priceUnit2 = findViewById(R.id.priceunit2);
        priceUnit3 = findViewById(R.id.priceunit3);
        priceUnit4 = findViewById(R.id.priceunit4);
        priceUnit5 = findViewById(R.id.priceunit5);
        priceUnit6 = findViewById(R.id.priceunit6);
        priceUnit7 = findViewById(R.id.priceunit7);
        priceUnit8 = findViewById(R.id.priceunit8);

        Total1 = findViewById(R.id.total1);
        Total2 = findViewById(R.id.total2);
        Total3 = findViewById(R.id.total3);
        Total4 = findViewById(R.id.total4);
        Total5 = findViewById(R.id.total5);
        Total6 = findViewById(R.id.total6);
        Total7 = findViewById(R.id.total7);

        Total1.setText("0");
        Total2.setText("0");
        Total3.setText("0");
        Total4.setText("0");
        Total5.setText("0");
        Total6.setText("0");
        Total7.setText("0");
        alltotal = findViewById(R.id.alltotal);

        myAdapter = new ArrayAdapter<String>(newInvoice.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.scrapList));

        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(myAdapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(myAdapter);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setAdapter(myAdapter);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setAdapter(myAdapter);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setAdapter(myAdapter);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setAdapter(myAdapter);
        spinner6.setOnItemSelectedListener(this);
        spinner7.setAdapter(myAdapter);
        spinner7.setOnItemSelectedListener(this);

        weight2.setEnabled(false);
        priceUnit2.setEnabled(false);
        weight3.setEnabled(false);
        priceUnit3.setEnabled(false);
        weight4.setEnabled(false);
        priceUnit4.setEnabled(false);
        weight5.setEnabled(false);
        priceUnit5.setEnabled(false);
        weight6.setEnabled(false);
        priceUnit6.setEnabled(false);
        weight7.setEnabled(false);
        priceUnit7.setEnabled(false);

        textWatcher(weight1, Total1, priceUnit1, priceUnit2, weight2);
        textWatcher(priceUnit1, Total1, weight1, weight2, priceUnit2);

        textWatcher(weight2, Total2, priceUnit2, priceUnit3, weight3);
        textWatcher(priceUnit2, Total2, weight2, weight3, priceUnit3);

        textWatcher(weight3, Total3, priceUnit3, priceUnit4, weight4);
        textWatcher(priceUnit3, Total3, weight3, weight4, priceUnit4);

        textWatcher(weight4, Total4, priceUnit4, priceUnit5, weight5);
        textWatcher(priceUnit4, Total4, weight4, weight5, priceUnit5);

        textWatcher(weight5, Total5, priceUnit5, priceUnit6, weight6);
        textWatcher(priceUnit5, Total5, weight5, weight6, priceUnit6);

        textWatcher(weight6, Total6, priceUnit6, priceUnit7, weight7);
        textWatcher(priceUnit6, Total6, weight6, weight7, priceUnit7);

        textWatcher(weight7, Total7, priceUnit7, priceUnit8, weight8);
        textWatcher(priceUnit7, Total7, weight7, weight8, priceUnit8);
    }

    public void textWatcher(final EditText editText, final TextView textView, final EditText editText1, final EditText enable1, final EditText enable2) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (TextUtils.isEmpty(charSequence.toString().trim()) || editText1.getText().toString().isEmpty()) {
                    textView.setText("0");
                    enable1.setEnabled(false);
                    enable2.setEnabled(false);
                } else {
                    enable1.setEnabled(true);
                    enable2.setEnabled(true);
                    try {
                        String g = charSequence.toString();
                        double n = Double.parseDouble(g);

                        double price = Double.parseDouble(editText1.getText().toString());
                        n *= price;
                        n = (int) n;
                        String b = Double.toString(n);

                        textView.setText(b);


                    } catch (Exception e) {
                        editText.setText("0.");
                        editText.setSelection(editText.getText().length());
                    }


                }
            }

            @Override
            public void afterTextChanged(Editable editable) {


                if (editText.getText().toString().equals(".")) {
                    editText.setText("0.");
                    editText.setSelection(editText.getText().length());

                }

                Double total1 = Double.parseDouble(Total1.getText().toString());
                Double total2 = Double.parseDouble(Total2.getText().toString());
                Double total3 = Double.parseDouble(Total3.getText().toString());
                Double total4 = Double.parseDouble(Total4.getText().toString());
                Double total5 = Double.parseDouble(Total5.getText().toString());
                Double total6 = Double.parseDouble(Total6.getText().toString());
                Double total7 = Double.parseDouble(Total7.getText().toString());

                Double t = total1 + total2 + total3 + total4 + total5 + total6 + total7;

                String s = Double.toString(t);

                alltotal.setText(s + " ريال");

            }
        });


    }

    public void clear1(View view) {
        weight1.setText("");
        priceUnit1.setText("");
        spinner1.setAdapter(myAdapter);
        spinner1.setOnItemSelectedListener(this);
    }

    public void clear2(View view) {
        weight2.setText("");
        priceUnit2.setText("");
        spinner2.setAdapter(myAdapter);
        spinner2.setOnItemSelectedListener(this);
    }

    public void clear3(View view) {
        weight3.setText("");
        priceUnit3.setText("");
        spinner3.setAdapter(myAdapter);
        spinner3.setOnItemSelectedListener(this);
    }

    public void clear4(View view) {
        weight4.setText("");
        priceUnit4.setText("");
        spinner4.setAdapter(myAdapter);
        spinner4.setOnItemSelectedListener(this);
    }

    public void clear5(View view) {
        weight5.setText("");
        priceUnit5.setText("");
        spinner5.setAdapter(myAdapter);
        spinner5.setOnItemSelectedListener(this);
    }

    public void clear6(View view) {
        weight6.setText("");
        priceUnit6.setText("");
        spinner6.setAdapter(myAdapter);
        spinner6.setOnItemSelectedListener(this);
    }

    public void clear7(View view) {
        weight7.setText("");
        priceUnit7.setText("");
        spinner7.setAdapter(myAdapter);
        spinner7.setOnItemSelectedListener(this);
    }

    public void addInvoice(View view) {
        if (priceUnit1.getText().toString().equals("") || weight1.getText().toString().equals("") || selected1.equals("أختر البضاعه")) {
            Toast.makeText(getApplicationContext(), "أدخل البضاعه الوزن السعر", Toast.LENGTH_LONG).show();
        } else {


            if (selected2.equals("أختر البضاعه") && !weight2.getText().toString().equals("") ||
                    selected3.equals("أختر البضاعه") && !weight3.getText().toString().equals("")||
                    selected4.equals("أختر البضاعه") && !weight4.getText().toString().equals("")
                    || selected5.equals("أختر البضاعه") && !weight5.getText().toString().equals("")
                    || selected6.equals("أختر البضاعه") && !weight6.getText().toString().equals("")
                    || selected7.equals("أختر البضاعه") && !weight7.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "أختر نوع البضاعه", Toast.LENGTH_LONG).show();

            } else {
                final EditText editText = findViewById(R.id.EditIDnational);
                if (editText.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(newInvoice.this);
                    builder.setTitle("------------- تذكير -------------");
                    builder.setMessage("أدخل هوية البائع");
                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which) {
                                case DialogInterface.BUTTON_POSITIVE:
                                    editText.requestFocus();
                                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
                                    break;
                                case DialogInterface.BUTTON_NEGATIVE:
                                    submitted();
                                    break;
                            }
                        }
                    };
                    builder.setPositiveButton("ادخال الهوية", dialogClickListener);
                    // Set the alert dialog no button click listener
                    builder.setNegativeButton("لا توجد", dialogClickListener);
                    AlertDialog dialog = builder.create();
                    // Display the alert dialog on interface
                    dialog.show();
                } else {
                    submitted();
                }
            }
        }

    }

    public void clearID(View view) {
        EditText text = findViewById(R.id.EditIDnational);
        text.setText("");
    }

    public void submitted() {

        EditText editText = findViewById(R.id.EditIDnational);
        String ID = "";
        if (editText.getText().toString().equals("")) {
            ID = "لا توجد هويه";
        } else {
            ID = editText.getText().toString();
        }
        final addNewInvoice addinvoice = new addNewInvoice(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(newInvoice.this);
        builder.setTitle("------------- تأكــيــد -------------");
        if (selected2.equals("أختر البضاعه") || weight2.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        } else if (selected3.equals("أختر البضاعه") || weight3.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +

                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        } else if (selected4.equals("أختر البضاعه") || weight4.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +
                    selected3 + "\n --- الوزن: " + weight3.getText().toString() + " --- السعر: " + priceUnit3.getText().toString() + " المبلغ " + Total3.getText().toString() + "\n" + "\n" +

                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        } else if (selected5.equals("أختر البضاعه") || weight5.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +
                    selected3 + "\n --- الوزن: " + weight3.getText().toString() + " --- السعر: " + priceUnit3.getText().toString() + " المبلغ " + Total3.getText().toString() + "\n" + "\n" +
                    selected4 + "\n --- الوزن: " + weight4.getText().toString() + " --- السعر: " + priceUnit4.getText().toString() + " المبلغ " + Total4.getText().toString() + "\n" + "\n" +

                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        } else if (selected6.equals("أختر البضاعه") || weight6.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +
                    selected3 + "\n --- الوزن: " + weight3.getText().toString() + " --- السعر: " + priceUnit3.getText().toString() + " المبلغ " + Total3.getText().toString() + "\n" + "\n" +
                    selected4 + "\n --- الوزن: " + weight4.getText().toString() + " --- السعر: " + priceUnit4.getText().toString() + " المبلغ " + Total4.getText().toString() + "\n" + "\n" +
                    selected5 + "\n --- الوزن: " + weight5.getText().toString() + " --- السعر: " + priceUnit5.getText().toString() + " المبلغ " + Total5.getText().toString() + "\n" + "\n" +

                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        } else if (selected7.equals("أختر البضاعه") || weight7.getText().toString().equals("")) {
            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +
                    selected3 + "\n --- الوزن: " + weight3.getText().toString() + " --- السعر: " + priceUnit3.getText().toString() + " المبلغ " + Total3.getText().toString() + "\n" + "\n" +
                    selected4 + "\n --- الوزن: " + weight4.getText().toString() + " --- السعر: " + priceUnit4.getText().toString() + " المبلغ " + Total4.getText().toString() + "\n" + "\n" +
                    selected5 + "\n --- الوزن: " + weight5.getText().toString() + " --- السعر: " + priceUnit5.getText().toString() + " المبلغ " + Total5.getText().toString() + "\n" + "\n" +
                    selected6 + "\n --- الوزن: " + weight6.getText().toString() + " --- السعر: " + priceUnit6.getText().toString() + " المبلغ " + Total6.getText().toString() + "\n" + "\n" +

                    "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);

        } else {

            builder.setMessage(selected1 + "\n --- الوزن: " + weight1.getText().toString() + " --- السعر: " + priceUnit1.getText().toString() + " المبلغ " + Total1.getText().toString() + "\n" + "\n" +
                    selected2 + "\n --- الوزن: " + weight2.getText().toString() + " --- السعر: " + priceUnit2.getText().toString() + " المبلغ " + Total2.getText().toString() + "\n" + "\n" +
                    selected3 + "\n --- الوزن: " + weight3.getText().toString() + " --- السعر: " + priceUnit3.getText().toString() + " المبلغ " + Total3.getText().toString() + "\n" + "\n" +
                    selected4 + "\n --- الوزن: " + weight4.getText().toString() + " --- السعر: " + priceUnit4.getText().toString() + " المبلغ " + Total4.getText().toString() + "\n" + "\n" +
                    selected5 + "\n --- الوزن: " + weight5.getText().toString() + " --- السعر: " + priceUnit5.getText().toString() + " المبلغ " + Total5.getText().toString() + "\n" + "\n" +
                    selected6 + "\n --- الوزن: " + weight6.getText().toString() + " --- السعر: " + priceUnit6.getText().toString() + " المبلغ " + Total6.getText().toString() + "\n" + "\n" +
                    selected7 + "\n --- الوزن: " + weight7.getText().toString() + " --- السعر: " + priceUnit7.getText().toString() + " المبلغ " + Total7.getText().toString()

                    + "\n" + "\n" + "الاجمالي: " + alltotal.getText().toString() + "\n" + "\n" + "الهويه: " + ID);
        }


        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        try {

                            String method = "Register";
                            addinvoice.execute(method,
                                    selected1,
                                    selected2,
                                    selected3,
                                    selected4,
                                    selected5,
                                    selected6,
                                    selected7,
                                    currentDate);
                                    clearSpinner(spinner1);clearSpinner(spinner2);clearSpinner(spinner3);clearSpinner(spinner4);clearSpinner(spinner5);clearSpinner(spinner6);clearSpinner(spinner7);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                        }
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:

                        break;
                }
            }
        };
        builder.setPositiveButton("تأكيد", dialogClickListener);

        // Set the alert dialog no button click listener
        builder.setNegativeButton("الغاء", dialogClickListener);

        AlertDialog dialog = builder.create();
        // Display the alert dialog on interface
        dialog.show();



    }

    private void clearSpinner(Spinner spinner){
        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

}
