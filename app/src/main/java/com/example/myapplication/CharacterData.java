package com.example.myapplication;

import android.net.Uri;

import com.facebook.common.util.UriUtil;

/**
 * Created by Jinoh on 2017-11-23.
 */

public class CharacterData {
    private int path;
    private int type;

    public static final int TYPE_GIF = 1;
    public static final int TYPE_JPG = 2;

    public CharacterData(int path, int type) {
        this.path = path;
        this.type = type;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Uri getUri(){
        Uri uri =  new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                    .path(String.valueOf(path))
                    .build();
        return uri;
    }
}
