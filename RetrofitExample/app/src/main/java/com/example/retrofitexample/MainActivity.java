package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Retrofit retrofit;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setMessage("Please wait..");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        tv = findViewById(R.id.result);
    }

    public void getResponse(View view) {
        pd.show();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(ScalarsConverterFactory.create()).build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<String> response = service.getRepos();
        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this,
                        ""+response.body(), Toast.LENGTH_SHORT).show();
                try {
                    JSONArray jsonArray = new JSONArray(response.body());
                    JSONObject zeroIndexobject = jsonArray.getJSONObject(0);
                    String name = zeroIndexobject.getString("name");
                    String fullname = zeroIndexobject.getString("full_name");
                    tv.setText(name+"\n"+fullname);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                pd.dismiss();

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }
}
