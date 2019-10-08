package com.yousef.owner.scrapcalculator2;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class invoiceReview extends AppCompatActivity {

    BufferedInputStream inputStream;
    String line = null;
    String result = null;
    String[] type;
    String[] price;
    String[] weight;
    String[] date;
    String[] id;
    ListView listView;
    String idForDelete;
    CustomListView customListView = null;
    List<String> listDate = new ArrayList<String>();
    //    public void del() {
////        String method = "delete";
////        deleteFromDB df = new deleteFromDB(this);
////        df.execute(method, idForDelete);
////        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
////        loadData();
////
////
////        try {
////            customListView = new CustomListView(this, type, price, weight, date);
////
////        } catch (Exception e) {
////            Toast.makeText(getApplicationContext(), "Here error1", Toast.LENGTH_SHORT).show();
////        }
////        listView.setAdapter(customListView);
//    }
    String selectedDate;
    String dateSelected;
    private SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_invoice_review);


        listView = findViewById(R.id.list);
        Toast.makeText(getApplicationContext(), "أسحب الى الاسفل لتحديث المشتريات", Toast.LENGTH_LONG).show();

        //Allow network in main thread
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        loadData();


        try {
            customListView = new CustomListView(this, type, price, weight, date);
            //Swipe down to refresh

            swipeContainer = findViewById(R.id.swipeContainer);
            swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    // Your code to refresh the list here.
                    // Make sure you call swipeContainer.setRefreshing(false)
                    // once the network request has completed successfully.
                    refresh2();
                    swipeContainer.setRefreshing(false);
                }
            });

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "لا توجد مشتريات", Toast.LENGTH_SHORT).show();
        }
        listView.setAdapter(customListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                idForDelete = id[i];

                AlertDialog.Builder builder = new AlertDialog.Builder(invoiceReview.this);
                // Set a title for alert dialog
                builder.setTitle("رقم العملية");
                builder.setMessage(idForDelete);


//                // Set click listener for alert dialog buttons
//                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        switch (which) {
//                            case DialogInterface.BUTTON_POSITIVE:
//                                try {
//                                    Toast.makeText(getApplicationContext(), idForDelete, Toast.LENGTH_LONG).show();
//                                } catch (Exception e) {
//                                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                                }
//
//                                break;
//
//                            case DialogInterface.BUTTON_NEGATIVE:
//
//                                break;
//                        }
//                    }
//                };
//
//                // Set the alert dialog yes button click listener
//                builder.setPositiveButton("موافق", dialogClickListener);
//
//                // Set the alert dialog no button click listener
//                builder.setNegativeButton("إلغاء", dialogClickListener);

                AlertDialog dialog = builder.create();
                // Display the alert dialog on interface
                dialog.show();
            }
        });


    }

    public void refresh2() {
        StrictMode.setThreadPolicy((new StrictMode.ThreadPolicy.Builder().permitNetwork().build()));
        loadData();

        try {
            customListView = new CustomListView(this, type, price, weight, date);

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "لا توجد مشتريات", Toast.LENGTH_SHORT).show();
        }
        listView.setAdapter(customListView);
    }

    public void loadData() {


        try {
            URL url = new URL("http://gewscrap.com/allfolder/gewapp/readInvoice.php");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("GET");

            inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            inputStream.close();

            result = stringBuilder.toString();

            JSONArray jsonArray = new JSONArray(result);

            JSONObject jsonObject = null;

            type = new String[jsonArray.length()];
            price = new String[jsonArray.length()];
            weight = new String[jsonArray.length()];
            date = new String[jsonArray.length()];
            id = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                type[i] = jsonObject.getString("type");
                price[i] = jsonObject.getString("price");
                weight[i] = jsonObject.getString("weight");
                date[i] = jsonObject.getString("date");
                id[i] = jsonObject.getString("id");

            }

            for (int i = 0; i < date.length; i++) {
                listDate.add(date[i]);
            }

            HashSet hashSet = new HashSet();
            hashSet.addAll(listDate);
            listDate.clear();
            listDate.addAll(hashSet);
            Collections.sort(listDate);
            System.out.println(Arrays.toString(listDate.toArray()));

            dateSpinner();
            findPriceByDate();

        } catch (Exception e) {

        }


    }

    public void dateSpinner() {
        Spinner spinnerDate = findViewById(R.id.date);
        String[] newdate = listDate.toArray(new String[listDate.size()]);
        Arrays.sort(newdate, Collections.reverseOrder());
        ArrayAdapter<String> adapterDate = new ArrayAdapter<String>(invoiceReview.this
                , android.R.layout.simple_spinner_item, newdate);
        spinnerDate.setAdapter(adapterDate);

        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                dateSelected = (String) adapterView.getItemAtPosition(i);
                String[] price2 = new String[price.length];

                for (int j = 0; j < date.length; j++) {

                    if (date[j].equals(dateSelected)) {
                        price2[j] = price[j];
                    }
                }
                System.out.println(Arrays.toString(price2));

                double sum = 0;
                for (String element : price2) {
                    try {
                        double num = Double.parseDouble(element);
                        sum += num;
                    } catch (Exception e) {
                        continue;
                    }

                }

                TextView textView = findViewById(R.id.textTotal);

                String strSum = Double.toString(sum);
                textView.setText(strSum + " ريال");


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void findPriceByDate() {


    }


}
