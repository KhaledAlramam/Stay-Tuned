package com.example.khaled.staytuned;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.khaled.staytuned.model.ParentResponse;
import com.example.khaled.staytuned.network.GetDataService;
import com.example.khaled.staytuned.network.RetrofitClientInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePage extends AppCompatActivity {

    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tx=findViewById(R.id.txt);


        GetDataService service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ParentResponse> call=service.getResponse();
        call.enqueue(new Callback<ParentResponse>() {
            @Override
            public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {
                tx.setText(response.body().getResponse().getResults().get(0).getWebTitle());
            }

            @Override
            public void onFailure(Call<ParentResponse> call, Throwable t) {

            }
        });

    }
}
