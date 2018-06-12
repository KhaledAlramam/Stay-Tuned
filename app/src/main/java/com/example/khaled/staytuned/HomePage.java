package com.example.khaled.staytuned;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khaled.staytuned.model.Response;
import com.example.khaled.staytuned.network.GetDataService;
import com.example.khaled.staytuned.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class HomePage extends AppCompatActivity {

    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tx=findViewById(R.id.txt);

        GetDataService service=RetrofitClientInstance
                .getRetrofitInstance()
                .create(GetDataService.class);
        Call<Response> call=service.getAllNews();
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                Response response1=response.body();
               /* List<Response.News> newsList=response1.getResults();
                Response.News news=newsList.get(0);
                tx.setText(news.getWebTitle());*/
               tx.setText(String.valueOf(response1.getPages()));
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

                Toast.makeText(HomePage.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
