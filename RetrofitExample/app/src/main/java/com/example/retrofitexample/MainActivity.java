package com.example.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;


public class MainActivity extends AppCompatActivity {

    TextView tv;
    Retrofit retrofit;
    ProgressDialog pd;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pd = new ProgressDialog(this);
        pd.setMessage("Please wait..");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        rv = findViewById(R.id.recycler);
    }

    public void getResponse(View view) {
        pd.show();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        GitHubService service = retrofit.create(GitHubService.class);
        Call<List<Pojo>> response = service.getRepos("mastan511");
        response.enqueue(new Callback<List<Pojo>>() {
            @Override
            public void onResponse(Call<List<Pojo>> call, Response<List<Pojo>> response) {
                List<Pojo> pojos = response.body();
                Log.d("SIZE",""+pojos.size());
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rv.setAdapter(new MyAdapter(MainActivity.this,pojos));
                for (Pojo pojo:pojos){
                    String data = " ";
                    data += "name:"+pojo.getName()+"\n";
                    data+="Full Name"+pojo.getFull_name()+"\n\n";
                    tv.append(data);
                }
                pd.dismiss();
            }

            @Override
            public void onFailure(Call<List<Pojo>> call, Throwable t) {

            }
        });
    }
}
