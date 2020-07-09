package com.example.asynctasktest;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void,Void,String>
{
    String url = "https://www.googleapis.com/books/v1/volumes?q=";

    String myUrl;
    Context ct;
    ProgressDialog pd;
    TextView myTextView;

    public MyTask(MainActivity mainActivity, String bookname, TextView tv) {
        ct = mainActivity;
        myUrl=url+bookname;
        myTextView = tv;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(ct);
        pd.setMessage("Please wait....");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();

    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL u = new URL(myUrl);
            HttpsURLConnection connection =(HttpsURLConnection)u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line=reader.readLine())!=null){
                builder.append(line);
            }
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //Toast.makeText(ct, ""+s, Toast.LENGTH_SHORT).show();
        pd.dismiss();
        try {
            JSONObject rootJsonObject = new JSONObject(s);
            JSONArray itemsJsonArray =rootJsonObject.getJSONArray("items");
            JSONObject zeroIndexObject = itemsJsonArray.getJSONObject(0);
            JSONObject volumeInfoObject = zeroIndexObject.getJSONObject("volumeInfo");
            String title = volumeInfoObject.optString("title");
            JSONArray myArray = volumeInfoObject.getJSONArray("authors");
            String authors = myArray.get(0).toString();
            Log.i("DATA",title);
            Log.i("DATA",authors);
            myTextView.setText("Book Title:"+title+"\n"+"Authors:"+authors);
            Toast.makeText(ct, ""+title+"\n"+authors, Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }
}
