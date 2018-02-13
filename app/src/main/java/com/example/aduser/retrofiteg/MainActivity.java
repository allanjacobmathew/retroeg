package com.example.aduser.retrofiteg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.aduser.retrofiteg.networking.ApiRequest;
import com.example.aduser.retrofiteg.networking.response.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<UserResponse> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdaptor mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView =findViewById(R.id.recycle_id);

        mAdapter = new DataAdaptor(dataList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        dummydata();
    }

    private void dummydata() {

        Call<List<UserResponse>> userDeatils = ApiRequest.provideInterface().getUserDeatils();

        userDeatils.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                if(response.isSuccessful()){
                    procees(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {

            }
        });
//        DataClass dataClass=new DataClass("ALLAN","8089195505");
//        dataList.add(dataClass);
//         dataClass=new DataClass("abu","8089195504");
//        dataList.add(dataClass);
//         dataClass=new DataClass("abc","8089195505");
//        dataList.add(dataClass);
//        dataClass=new DataClass("efg","8089195510");
//        dataList.add(dataClass);
//        dataClass=new DataClass("hig","878647366");
//        dataList.add(dataClass);
//        dataClass=new DataClass("xyz","12647647");
//        dataList.add(dataClass);
//        dataClass=new DataClass("pqr","18274891648");
//        dataList.add(dataClass);
//        mAdapter.notifyDataSetChanged();
    }

    private void procees(List<UserResponse> body) {
        mAdapter.addAll(body);
        mAdapter.notifyDataSetChanged();

    }
}
