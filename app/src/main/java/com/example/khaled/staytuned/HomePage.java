package com.example.khaled.staytuned;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khaled.staytuned.model.MainResponse;
import com.example.khaled.staytuned.model.ParentResponse;
import com.example.khaled.staytuned.model.Results;
import com.example.khaled.staytuned.network.GetDataService;
import com.example.khaled.staytuned.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {

    RecyclerView recyclerView;
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ParentResponse> call=service.getResponse("/search?q=world-cup-2018&section=football&api-key=test&show-fields=thumbnail");
        call.enqueue(new Callback<ParentResponse>() {
            @Override
            public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {

                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ParentResponse> call, Throwable t) {
                Toast.makeText(HomePage.this,
                        "Something went wrong...Please try later!",
                         Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void  generateDataList(ParentResponse response){
        MainResponse mainResponse=response.getResponse();
        List<Results> results=mainResponse.getResults();
        recyclerView=findViewById(R.id.recycler_view);
        adapter=new NewsAdapter(results);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(HomePage.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
