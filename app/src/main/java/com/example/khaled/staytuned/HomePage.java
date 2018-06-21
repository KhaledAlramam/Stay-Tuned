package com.example.khaled.staytuned;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
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
    RecyclerView.LayoutManager layoutManager;
    List<Results> results;
    int currentPage =1;
    int pages=0;
    ImageView previousPage, nextPage;
    GetDataService service;
    TextView pagesTextView;
    ProgressDialog progressDoalog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        pagesTextView=findViewById(R.id.pages);
        previousPage =findViewById(R.id.previous);
        nextPage =findViewById(R.id.next);
        layoutManager=new LinearLayoutManager(HomePage.this);
        getResponse();
        previousPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage >1) {
                    currentPage--;
                    getResponse();
                }else {
                    Toast.makeText(HomePage.this,getString(R.string.first_page),Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                getResponse();
            }
        });


    }

    public void getResponse(){
        progressDoalog = new ProgressDialog(HomePage.this);
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();
        service=RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<ParentResponse> call=service.getResponse("/search?q=world-cup-2018&section=football&api-key=9e6c2126-8152-4cc3-9732-0c7a5ee4eb6e&show-fields=thumbnail&page="+String.valueOf(currentPage));
        call.enqueue(new Callback<ParentResponse>() {
            @Override
            public void onResponse(Call<ParentResponse> call, Response<ParentResponse> response) {
                progressDoalog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<ParentResponse> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(HomePage.this,
                        "",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void  generateDataList(ParentResponse response){
        MainResponse mainResponse=response.getResponse();
        results=mainResponse.getResults();
        pages=mainResponse.getPages();
        pagesTextView.setText(String.valueOf(currentPage)+"/");
        pagesTextView.append(String.valueOf(pages));
        recyclerView=findViewById(R.id.recycler_view);
        adapter=new NewsAdapter(results, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Results test=results.get(position);
                String url=test.getWebUrl();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(browserIntent);
            }
        });
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}
