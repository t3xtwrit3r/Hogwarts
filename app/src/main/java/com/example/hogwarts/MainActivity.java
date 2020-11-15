package com.example.hogwarts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.hogwarts.Adapter.CharacterAdapter;
import com.example.hogwarts.Interface.MyWebService;
import com.example.hogwarts.Model.Characters;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.charactersView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        MyWebService myWebService = MyWebService.retrofit.create(MyWebService.class);
        Call<List<Characters>> call = myWebService.getCharacters();
        call.enqueue(new Callback<List<Characters>>() {
            @Override
            public void onResponse(Call<List<Characters>> call, Response<List<Characters>> response) {

                if(response.code() == 200){
                    showCharacter(response.body());
                }

                Log.i("Testing", "onResponse: "+response.message());

            }

            @Override
            public void onFailure(Call<List<Characters>> call, Throwable t) {
                Log.i("Testing", "onFailure: "+t.getMessage());
            }
        });


    }
    private void showCharacter(List<Characters> posts) {

        Log.i("Testing", "showCharacter: "+posts.size());
         CharacterAdapter characterAdapter = new CharacterAdapter( MainActivity.this, posts);
         recyclerView.setAdapter(characterAdapter);

    }
}