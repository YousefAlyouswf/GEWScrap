package com.yousef.owner.scrapcalculator2;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import androidx.annotation.RequiresApi;

public class addNewInvoice extends AsyncTask<String, Void, String> {


    private Context ctx;

    addNewInvoice(Context ctx) {
        this.ctx = ctx;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected String doInBackground(String... params) {

        try {
            String url_update = "http://gewscrap.com/allfolder/gewapp/addNewInvoice.php";
            String method = params[0];
            if (method.equals("Register")) {
                String selected1 = params[1];
                String selected2 = params[2];
                String selected3 = params[3];
                String selected4 = params[4];
                String selected5 = params[5];
                String selected6 = params[6];
                String selected7 = params[7];


                String date = params[8];


                final EditText weight1 = ((newInvoice) ctx).findViewById(R.id.weight1);
                final TextView total1 = ((newInvoice) ctx).findViewById(R.id.total1);
                final EditText priceunit1 = ((newInvoice) ctx).findViewById(R.id.priceunit1);


                final EditText weight2 = ((newInvoice) ctx).findViewById(R.id.weight2);
                final TextView total2 = ((newInvoice) ctx).findViewById(R.id.total2);
                final EditText priceunit2 = ((newInvoice) ctx).findViewById(R.id.priceunit2);

                final EditText weight3 = ((newInvoice) ctx).findViewById(R.id.weight3);
                final TextView total3 = ((newInvoice) ctx).findViewById(R.id.total3);
                final EditText priceunit3 = ((newInvoice) ctx).findViewById(R.id.priceunit3);

                final EditText weight4 = ((newInvoice) ctx).findViewById(R.id.weight4);
                final TextView total4 = ((newInvoice) ctx).findViewById(R.id.total4);
                final EditText priceunit4 = ((newInvoice) ctx).findViewById(R.id.priceunit4);

                final EditText weight5 = ((newInvoice) ctx).findViewById(R.id.weight5);
                final TextView total5 = ((newInvoice) ctx).findViewById(R.id.total5);
                final EditText priceunit5 = ((newInvoice) ctx).findViewById(R.id.priceunit5);

                final EditText weight6 = ((newInvoice) ctx).findViewById(R.id.weight6);
                final TextView total6 = ((newInvoice) ctx).findViewById(R.id.total6);
                final EditText priceunit6 = ((newInvoice) ctx).findViewById(R.id.priceunit6);

                final EditText weight7 = ((newInvoice) ctx).findViewById(R.id.weight7);
                final TextView total7 = ((newInvoice) ctx).findViewById(R.id.total7);
                final EditText priceunit7 = ((newInvoice) ctx).findViewById(R.id.priceunit7);

                final EditText ID = ((newInvoice) ctx).findViewById(R.id.EditIDnational);

                try {
                    URL url = new URL(url_update);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream os = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
                    String data =

                                    URLEncoder.encode("spinner1", "UTF-8") + "=" + URLEncoder.encode(selected1, "UTF-8") + "&" +
                                    URLEncoder.encode("price1", "UTF-8") + "=" + URLEncoder.encode(total1.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight1", "UTF-8") + "=" + URLEncoder.encode(weight1.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit1", "UTF-8") + "=" + URLEncoder.encode(priceunit1.getText().toString(), "UTF-8") + "&" +

                                    URLEncoder.encode("spinner2", "UTF-8") + "=" + URLEncoder.encode(selected2, "UTF-8") + "&" +
                                    URLEncoder.encode("price2", "UTF-8") + "=" + URLEncoder.encode(total2.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight2", "UTF-8") + "=" + URLEncoder.encode(weight2.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit2", "UTF-8") + "=" + URLEncoder.encode(priceunit2.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("spinner3", "UTF-8") + "=" + URLEncoder.encode(selected3, "UTF-8") + "&" +
                                            URLEncoder.encode("price3", "UTF-8") + "=" + URLEncoder.encode(total3.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight3", "UTF-8") + "=" + URLEncoder.encode(weight3.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit3", "UTF-8") + "=" + URLEncoder.encode(priceunit3.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("spinner4", "UTF-8") + "=" + URLEncoder.encode(selected4, "UTF-8") + "&" +
                                            URLEncoder.encode("price4", "UTF-8") + "=" + URLEncoder.encode(total4.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight4", "UTF-8") + "=" + URLEncoder.encode(weight4.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit4", "UTF-8") + "=" + URLEncoder.encode(priceunit4.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("spinner5", "UTF-8") + "=" + URLEncoder.encode(selected5, "UTF-8") + "&" +
                                            URLEncoder.encode("price5", "UTF-8") + "=" + URLEncoder.encode(total5.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight5", "UTF-8") + "=" + URLEncoder.encode(weight5.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit5", "UTF-8") + "=" + URLEncoder.encode(priceunit5.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("spinner6", "UTF-8") + "=" + URLEncoder.encode(selected6, "UTF-8") + "&" +
                                            URLEncoder.encode("price6", "UTF-8") + "=" + URLEncoder.encode(total6.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight6", "UTF-8") + "=" + URLEncoder.encode(weight6.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit6", "UTF-8") + "=" + URLEncoder.encode(priceunit6.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("spinner7", "UTF-8") + "=" + URLEncoder.encode(selected7, "UTF-8") + "&" +
                                            URLEncoder.encode("price7", "UTF-8") + "=" + URLEncoder.encode(total7.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("weight7", "UTF-8") + "=" + URLEncoder.encode(weight7.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("pricebyunit7", "UTF-8") + "=" + URLEncoder.encode(priceunit7.getText().toString(), "UTF-8") + "&" +

                                            URLEncoder.encode("idnat", "UTF-8") + "=" + URLEncoder.encode(ID.getText().toString(), "UTF-8") + "&" +
                                    URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    os.close();
                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    return "تم تسجيل البضاعه بنجاح";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        } catch (Exception e) {
            Toast.makeText(ctx, "ERROR", Toast.LENGTH_LONG).show();
        }


        return null;
    }

    @Override
    protected void onPostExecute(final String result) {
        try {
            Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
            final EditText weight1 = ((newInvoice) ctx).findViewById(R.id.weight1);
            final EditText priceunit1 = ((newInvoice) ctx).findViewById(R.id.priceunit1);

            final EditText weight2 = ((newInvoice) ctx).findViewById(R.id.weight2);
            final EditText priceunit2 = ((newInvoice) ctx).findViewById(R.id.priceunit2);

            final EditText weight3 = ((newInvoice) ctx).findViewById(R.id.weight3);
            final EditText priceunit3 = ((newInvoice) ctx).findViewById(R.id.priceunit3);

            final EditText weight4 = ((newInvoice) ctx).findViewById(R.id.weight4);
            final EditText priceunit4 = ((newInvoice) ctx).findViewById(R.id.priceunit4);

            final EditText weight5 = ((newInvoice) ctx).findViewById(R.id.weight5);
            final EditText priceunit5 = ((newInvoice) ctx).findViewById(R.id.priceunit5);

            final EditText weight6 = ((newInvoice) ctx).findViewById(R.id.weight6);
            final EditText priceunit6 = ((newInvoice) ctx).findViewById(R.id.priceunit6);

            final EditText weight7 = ((newInvoice) ctx).findViewById(R.id.weight7);
            final EditText priceunit7 = ((newInvoice) ctx).findViewById(R.id.priceunit7);

            final EditText ID = ((newInvoice) ctx).findViewById(R.id.EditIDnational);

            ID.setText("");

            weight1.setText("");
            priceunit1.setText("");

            weight2.setText("");
            priceunit2.setText("");

            weight3.setText("");
            priceunit3.setText("");

            weight4.setText("");
            priceunit4.setText("");

            weight5.setText("");
            priceunit5.setText("");

            weight6.setText("");
            priceunit6.setText("");

            weight7.setText("");
            priceunit7.setText("");
        } catch (Exception e) {
            Toast.makeText(ctx, "لا يوجد اتصال بالانترنت", Toast.LENGTH_SHORT).show();
        }
    }
}
