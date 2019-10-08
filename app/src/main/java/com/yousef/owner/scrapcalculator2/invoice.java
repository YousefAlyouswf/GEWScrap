//package com.yousef.owner.scrapcalculator2;
//
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedInputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.DateFormat;
//import java.util.Calendar;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
//
//public class invoice extends AppCompatActivity{
//
////        implements AdapterView.OnItemSelectedListener {
////
////    String selected = "ironH";
////    String currentDate;
////    BufferedInputStream inputStream;
////    String line = null;
////    String result = null;
////    String[] type;
////    String[] price;
////    String[] weight;
////    String[] date;
////    ListView listView;
////
////    TextView totalPrice;
////    EditText wieght;
////    EditText pricebyunit;
////    private SwipeRefreshLayout swipeContainer;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_invoice);
////
////        Calendar calendar = Calendar.getInstance();
////        currentDate = DateFormat.getDateInstance().format(calendar.getTime());
////
////        totalPrice = findViewById(R.id.textView8);
////
////        wieght = findViewById(R.id.editTextWieght1);
////
////        pricebyunit = findViewById(R.id.editforprice);
////
////        Toast.makeText(getApplicationContext(), "أسحب الى الاسفل لتحديث المشتريات", Toast.LENGTH_LONG).show();
////
////        final Spinner mySpinner = findViewById(R.id.spinner2);
////
////        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(invoice.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.scrapList));
////
////        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////
////        mySpinner.setAdapter(myAdapter);
////
////        mySpinner.setOnItemSelectedListener(this);
////
////
////        listView = findViewById(R.id.listview1);
////
////        //Allow network in main thread
////        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
////        loadData();
////        CustomListView customListView = null;
////
////        try {
////            customListView = new CustomListView(this, type, price, weight, date);
////            swipeContainer = findViewById(R.id.swipeContainer);
////            swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
////                @Override
////                public void onRefresh() {
////                    // Your code to refresh the list here.
////                    // Make sure you call swipeContainer.setRefreshing(false)
////                    // once the network request has completed successfully.
////                    refresh();
////                    swipeContainer.setRefreshing(false);
////                }
////            });
////
////        } catch (Exception e) {
////            Toast.makeText(getApplicationContext(), "لا توجد مشتريات", Toast.LENGTH_SHORT).show();
////        }
////        listView.setAdapter(customListView);
////
////        //Swipe down to refresh
////        wieght.requestFocus();
////
////    }
////
////    public void clear(View view) {
////        pricebyunit.setText("");
////        wieght.setText("");
////    }
////
////    public void refresh() {
////        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
////        loadData();
////        CustomListView customListView = null;
////
////        try {
////            customListView = new CustomListView(this, type, price, weight, date);
////
////        } catch (Exception e) {
////            Toast.makeText(getApplicationContext(), "لا توجد مشتريات", Toast.LENGTH_SHORT).show();
////        }
////        listView.setAdapter(customListView);
////
////
////    }
////
////
////    public void loadData() {
////
////
////        try {
////            URL url = new URL("http://gewscrap.com/allfolder/gewapp/readInvoice.php");
////
////            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
////
////            httpURLConnection.setRequestMethod("GET");
////
////            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
////
////            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
////
////            StringBuilder stringBuilder = new StringBuilder();
////
////            while ((line = bufferedReader.readLine()) != null) {
////                stringBuilder.append(line + "\n");
////            }
////
////            inputStream.close();
////
////            result = stringBuilder.toString();
////
////            JSONArray jsonArray = new JSONArray(result);
////
////            JSONObject jsonObject = null;
////
////            type = new String[jsonArray.length()];
////            price = new String[jsonArray.length()];
////            weight = new String[jsonArray.length()];
////            date = new String[jsonArray.length()];
////
////            for (int i = 0; i < jsonArray.length(); i++) {
////                jsonObject = jsonArray.getJSONObject(i);
////                type[i] = jsonObject.getString("type");
////                price[i] = jsonObject.getString("price");
////                weight[i] = jsonObject.getString("weight");
////                date[i] = jsonObject.getString("date");
////
////            }
////
////
////        } catch (Exception e) {
////
////        }
////
////
////    }
////
////
////    @Override
////    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////        String valueSelected = adapterView.getItemAtPosition(i).toString();
////
////
////        if (valueSelected.equals("حديد ثقيل")) {
////            selected = "ironH";
////            getPrice();
////        } else if (valueSelected.equals("حديد خفيف")) {
////            selected = "ironL";
////            getPrice();
////        } else if (valueSelected.equals("نحاس احمر")) {
////            selected = "copperR";
////            getPrice();
////        } else if (valueSelected.equals("نحاس اصفر")) {
////            selected = "copperY";
////            getPrice();
////        } else if (valueSelected.equals("المنيوم")) {
////            selected = "alum";
////            getPrice();
////        } else if (valueSelected.equals("سلك 1")) {
////            selected = "ironZ";
////            getPrice();
////        } else if (valueSelected.equals("سلك 2")) {
////            selected = "alumQ";
////            getPrice();
////        } else if (valueSelected.equals("استيل")) {
////            selected = "steel";
////            getPrice();
////        } else if (valueSelected.equals("اسفنج")) {
////            selected = "copperM";
////            getPrice();
////        } else if (valueSelected.equals("بطاريات")) {
////            selected = "bat";
////            getPrice();
////
////        } else if (valueSelected.equals("قارورة")) {
////            selected = "copperN";
////            getPrice();
////        } else if (valueSelected.equals("بلاستيك")) {
////            selected = "mix2";
////            getPrice();
////
////        } else if (valueSelected.equals("فرن")) {
////            selected = "mix";
////            getPrice();
////        } else if (valueSelected.equals("راديتور نحاس")) {
////            selected = "tot";
////            getPrice();
////        } else if (valueSelected.equals("راديتور المنيوم")) {
////            selected = "rAlum";
////            getPrice();
////        } else {
////
////        }
////    }
////
////    @Override
////    public void onNothingSelected(AdapterView<?> adapterView) {
////
////    }
////
////    public void getPrice() {
////
////
////        wieght.addTextChangedListener(new TextWatcher() {
////            @Override
////            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////
////
////            }
////
////            @Override
////            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////                if (TextUtils.isEmpty(charSequence.toString().trim()) || pricebyunit.getText().toString().isEmpty()) {
////                    totalPrice.setText("0");
////                } else {
////                    try {
////                        String g = charSequence.toString();
////                        double n = Double.parseDouble(g);
////
////                        double price = Double.parseDouble(pricebyunit.getText().toString());
////                        n *= price;
////                        n = (int) n;
////                        String b = Double.toString(n);
////
////                        totalPrice.setText(b);
////
////                    } catch (Exception e) {
////                        wieght.setText("0.");
////                        wieght.setSelection(wieght.getText().length());
////                    }
////
////
////                }
////            }
////
////            @Override
////            public void afterTextChanged(Editable editable) {
////                if (wieght.getText().toString().equals(".")) {
////                    wieght.setText("0.");
////                    wieght.setSelection(wieght.getText().length());
////
////                }
////            }
////        });
////
////
////        pricebyunit.addTextChangedListener(new TextWatcher() {
////            @Override
////            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////
////            }
////
////            @Override
////            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
////                if (TextUtils.isEmpty(charSequence.toString().trim()) || wieght.getText().toString().isEmpty()) {
////                    totalPrice.setText("0");
////                } else {
////                    try {
////                        String g = charSequence.toString();
////                        double n = Double.parseDouble(g);
////
////                        double price = Double.parseDouble(wieght.getText().toString());
////                        n *= price;
////                        n = (int) n;
////                        String b = Double.toString(n);
////
////                        totalPrice.setText(b);
////                    } catch (Exception e) {
////                        pricebyunit.setText("0.");
////                        pricebyunit.setSelection(pricebyunit.getText().length());
////
////                    }
////
////
////                }
////            }
////
////            @Override
////            public void afterTextChanged(Editable editable) {
////                if (pricebyunit.getText().toString().equals(".")) {
////                    pricebyunit.setText("0.");
////                    pricebyunit.setSelection(pricebyunit.getText().length());
////
////                }
////            }
////        });
////    }
////
////    public void addInvoice(View view) {
////
////        if (pricebyunit.getText().toString().isEmpty() || wieght.getText().toString().isEmpty()) {
////            Toast.makeText(getApplicationContext(), "أكتب الوزن و السعر", Toast.LENGTH_LONG).show();
////        } else {
////            addinvoice Addinvoice = new addinvoice(this);
////
////            String method = "Register";
////            Addinvoice.execute(method, selected, currentDate);
////        }
////
////
////    }
//
//
//}
