//package com.yousef.owner.scrapcalculator2;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.widget.EditText;
//import android.widget.TextView;
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
//public class deleteFromDB extends AsyncTask<String, Void, String> {
//
//    private Context ctx;
//
//    deleteFromDB(Context ctx) {
//        this.ctx = ctx;
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    protected String doInBackground(String... params) {
//
//
//        String url_update = "http://gewscrap.com/allfolder/gewapp/delete.php";
//        String method = params[0];
//        if (method.equals("delete")) {
//            String Selected = params[1];
//
//
//            try {
//                URL url = new URL(url_update);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                OutputStream os = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
//
//                String data =  URLEncoder.encode("delete", "UTF-8") + "=" + URLEncoder.encode(Selected, "UTF-8");
//                bufferedWriter.write(data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                os.close();
//
//                InputStream inputStream = httpURLConnection.getInputStream();
//                inputStream.close();
//                return "تم بنجاح";
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//
//
//        return null;
//    }
//}
