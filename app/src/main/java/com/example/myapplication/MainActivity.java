package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private RecyclerView recyclerView;
    private ArrayList<CharacterData> characterData;
    private GallaryAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        init();
    }


    private void init(){
        characterData = new ArrayList<>();
        characterData.add(new CharacterData(R.drawable.ls_bear, CharacterData.TYPE_JPG));
        characterData.add(new CharacterData(R.drawable.normal, CharacterData.TYPE_GIF));
        recyclerView = binding.recycler;
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        float dp = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
        recyclerView.addItemDecoration(new SpacesItemDecoration((int) dp));
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new GallaryAdapter(this,  characterData);

        recyclerView.setAdapter(adapter);
    }
}
