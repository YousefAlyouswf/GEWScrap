//package com.yousef.owner.scrapcalculator2;
//
//import android.content.Context;
//import android.os.AsyncTask;
//import android.os.Build;
//import android.text.Editable;
//import android.text.TextUtils;
//import android.text.TextWatcher;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
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
//public class BackgroundTask //extends AsyncTask<String, Void, String>
//{
//
//    static String response = "";
//    private Context ctx;
//
//    BackgroundTask(Context ctx) {
//        this.ctx = ctx;
//    }
//
//
//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//    }
//
//
//    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//    @Override
//    protected String doInBackground(String... params) {
//
//
//        String url_update = "http://gewscrap.com/allfolder/gewapp/update.php";
//        String url_getPrice = "http://gewscrap.com/allfolder/gewapp/getData.php";
//        String method = params[0];
//        if (method.equals("Register")) {
//            String IronH = params[1];
//            String IronL = params[2];
//            String Alum = params[3];
//            String CopperR = params[4];
//            String CopperY = params[5];
//            String Mix = params[6];
//            String IronZ = params[7];
//            String AlumQ = params[8];
//            String Steel = params[9];
//            String CopperM = params[10];
//            String CopperN = params[11];
//            String Tot = params[12];
//            String Bat = params[13];
//            String Mix2 = params[14];
//            String rAlum = params[15];
//            try {
//                URL url = new URL(url_update);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                OutputStream os = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8));
//
//                String data = URLEncoder.encode("ironH", "UTF-8") + "=" + URLEncoder.encode(IronH, "UTF-8") + "&" +
//                        URLEncoder.encode("ironL", "UTF-8") + "=" + URLEncoder.encode(IronL, "UTF-8") + "&" +
//                        URLEncoder.encode("alum", "UTF-8") + "=" + URLEncoder.encode(Alum, "UTF-8") + "&" +
//                        URLEncoder.encode("copperR", "UTF-8") + "=" + URLEncoder.encode(CopperR, "UTF-8") + "&" +
//                        URLEncoder.encode("copperY", "UTF-8") + "=" + URLEncoder.encode(CopperY, "UTF-8") + "&" +
//                        URLEncoder.encode("mix", "UTF-8") + "=" + URLEncoder.encode(Mix, "UTF-8")+ "&" +
//
//                        URLEncoder.encode("ironZ", "UTF-8") + "=" + URLEncoder.encode(IronZ, "UTF-8") + "&" +
//                        URLEncoder.encode("alumQ", "UTF-8") + "=" + URLEncoder.encode(AlumQ, "UTF-8") + "&" +
//                        URLEncoder.encode("steel", "UTF-8") + "=" + URLEncoder.encode(Steel, "UTF-8") + "&" +
//                        URLEncoder.encode("copperM", "UTF-8") + "=" + URLEncoder.encode(CopperM, "UTF-8") + "&" +
//                        URLEncoder.encode("copperN", "UTF-8") + "=" + URLEncoder.encode(CopperN, "UTF-8")+ "&" +
//
//                        URLEncoder.encode("tot", "UTF-8") + "=" + URLEncoder.encode(Tot, "UTF-8") + "&" +
//                        URLEncoder.encode("bat", "UTF-8") + "=" + URLEncoder.encode(Bat, "UTF-8") + "&" +
//                        URLEncoder.encode("mix2", "UTF-8") + "=" + URLEncoder.encode(Mix2, "UTF-8")+ "&" +
//                        URLEncoder.encode("rAlum", "UTF-8") + "=" + URLEncoder.encode(rAlum, "UTF-8");
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
//        } else if (method.equals("getPrice")) {
//            String selected = params[1];
//            try {
//                URL url = new URL(url_getPrice);
//                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//                httpURLConnection.setRequestMethod("POST");
//                httpURLConnection.setDoOutput(true);
//                httpURLConnection.setDoInput(true);
//                OutputStream outputStream = httpURLConnection.getOutputStream();
//                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
//                String data = URLEncoder.encode("selected", "UTF-8") + "=" + URLEncoder.encode(selected, "UTF-8");
//                bufferedWriter.write(data);
//                bufferedWriter.flush();
//                bufferedWriter.close();
//                outputStream.close();
//
//                InputStream inputStream = httpURLConnection.getInputStream();
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.ISO_8859_1));
//
//
//                String line;
//
//                while ((line = bufferedReader.readLine()) != null) {
//
//                    response = line;
//                }
//                bufferedReader.close();
//                inputStream.close();
//                httpURLConnection.disconnect();
//                return response;
//
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
//
//    @Override
//    protected void onPostExecute(final String result) {
//
//        try {
//            if (result.equals("تم بنجاح")) {
//                Toast.makeText(ctx, result, Toast.LENGTH_SHORT).show();
//            } else {
//
//
//                final TextView txtView = ((Home) ctx).findViewById(R.id.textView7);
//                txtView.setText(result + " ريال ");
//
//
//                final EditText editText = ((Home) ctx).findViewById(R.id.editTextWieght);
//
//                editText.addTextChangedListener(new TextWatcher() {
//                    @Override
//                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                    }
//
//                    @Override
//                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                        if (TextUtils.isEmpty(charSequence.toString().trim())) {
//                            txtView.setText("0" + " ريال ");
//                        } else {
//
//                            try {
//                                String g = charSequence.toString();
//                                double n = Double.parseDouble(g);
//
//                                double price = Double.parseDouble(result);
//                                n *= price;
//                                n = (int) n;
//                                String b = Double.toString(n);
//
//
//                                txtView.setText(b + " ريال ");
//                            }catch (Exception e){
//                                editText.setText("0.");
//                                editText.setSelection(editText.getText().length());
//                            }
//
//                        }
//                    }
//
//                    @Override
//                    public void afterTextChanged(Editable editable) {
//
//                    }
//                });
//
//
//            }
//        } catch (Exception e) {
//            Toast.makeText(ctx, "لا يوجد اتصال بالانترنت ", Toast.LENGTH_SHORT).show();
//        }
//
//    }
//
//
//}
