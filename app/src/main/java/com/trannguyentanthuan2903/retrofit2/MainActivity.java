package com.trannguyentanthuan2903.retrofit2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.trannguyentanthuan2903.retrofit2.adapter.AdapterPhoto;
import com.trannguyentanthuan2903.retrofit2.api.ApiClient;
import com.trannguyentanthuan2903.retrofit2.api.ApiInterface;
import com.trannguyentanthuan2903.retrofit2.models.Example;
import com.trannguyentanthuan2903.retrofit2.models.Photo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private String API_KEY = "PK9RQiY19rTiLnmdAWaeEhZSexny6uWxRRNxFhR1";
    private String feature = "popular";
    private int page = 1;

    private AdapterPhoto adapter;
    private List<Photo> photos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Add your APi", Toast.LENGTH_LONG).show();
            return;
        }
        photos = new ArrayList<>();
        getData();
        adapter = new AdapterPhoto(MainActivity.this, photos);
        RecyclerView.LayoutManager managerLayout = new GridLayoutManager(getApplicationContext(), 2);
        recyclerView.setLayoutManager(managerLayout);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);


    }

    private void getData() {
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

//        Call<PhotoResponse> call = apiService.getPhotos(feature, page, API_KEY);
        Call<Example> call = apiService.getPhotos(feature, page, API_KEY);
        call.enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                Log.d(TAG, "onResponse: " + response.toString());
                photos = response.body().getPhotos();
                Toast.makeText(MainActivity.this,photos.get(0).getImageUrl(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
