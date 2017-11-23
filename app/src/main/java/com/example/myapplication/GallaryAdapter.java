package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


import java.util.ArrayList;


public class GallaryAdapter extends RecyclerView.Adapter<GallaryAdapter.ViewHolder>{
    private Context con;
    private ArrayList<CharacterData> characterData;

    public GallaryAdapter(Context con, ArrayList<CharacterData> characterData) {
        this.con = con;
        this.characterData = characterData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_gallary, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(GallaryAdapter.ViewHolder holder, int position) {
        final CharacterData data = characterData.get(position);
        if(data.getType() == CharacterData.TYPE_GIF){
            holder.imageView.setController(Fresco.newDraweeControllerBuilder()
                    .setUri(data.getUri())
                    .setAutoPlayAnimations(true)
                    .build());
        }else{
            holder.imageView.setImageURI(data.getUri());
        }
    }


    @Override
    public int getItemCount() {
        return characterData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public SimpleDraweeView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = (SimpleDraweeView) itemView.findViewById(R.id.image);
        }
    }
}
