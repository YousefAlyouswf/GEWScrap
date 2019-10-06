//package com.yousef.owner.scrapcalculator2;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//
//import androidx.annotation.RequiresApi;
//
//public class addinvoice extends AsyncTask<String, Void, String> {
//
//    private Context ctx;
//
//    addinvoice(Context ctx) {
//        this.ctx = ctx;
//    }
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    protected String doInBackground(String... params) {
//        String url_update = "http://gewscrap.com/allfolder/gewapp/addInvoice.php";
//        String method = params[0];
//        if (method.equals("Register")) {
//            String Selected = params[1];
//            String date = params[2];
//            final EditText editText = ((invoice) ctx).findViewById(R.id.editTextWieght1);
//            final TextView textView = ((invoice) ctx).findViewById(R.id.textView8);
//            final EditText editTextUnit = ((invoice) ctx).findViewById(R.id.editforprice);
//            try {
//                URL url = new URL(url_update);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                OutputStream os = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
//                String data = URLEncoder.encode("selected", "UTF-8") + "=" + URLEncoder.encode(Selected, "UTF-8") + "&" +
//                        URLEncoder.encode("price", "UTF-8") + "=" + URLEncoder.encode(textView.getText().toString(), "UTF-8") + "&" +
//                        URLEncoder.encode("weight", "UTF-8") + "=" + URLEncoder.encode(editText.getText().toString(), "UTF-8") + "&" +
//                        URLEncoder.encode("date", "UTF-8") + "=" + URLEncoder.encode(date, "UTF-8")+ "&" +
//                        URLEncoder.encode("pricebyunit", "UTF-8") + "=" + URLEncoder.encode(editTextUnit.getText().toString(), "UTF-8");
//                bufferedWriter.write(data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                os.close();
//                InputStream inputStream = httpURLConnection.getInputStream();
//                inputStream.close();
//                return "تم بنجاح";
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//    @Override
//    protected void onProgressUpdate(Void... values) {
//        super.onProgressUpdate(values);
//    }
//
//    @Override
//    protected void onPostExecute(final String result) {
//        try {
//            Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
//            EditText editText = ((invoice) ctx).findViewById(R.id.editTextWieght1);
//            EditText editText1 = ((invoice) ctx).findViewById(R.id.editforprice);
//            editText.setText("");
//            editText1.setText("");
//        } catch (Exception e) {
//            Toast.makeText(ctx, "لا يوجد اتصال بالانترنت", Toast.LENGTH_SHORT).show();
//        }
//    }
//}
