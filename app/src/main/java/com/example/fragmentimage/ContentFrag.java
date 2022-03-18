package com.example.fragmentimage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.fragment.app.Fragment;

public class ContentFrag extends Fragment {
    GridView gridView;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.content_frag, container, false);
        gridView = view.getRootView().findViewById(R.id.gridView);
        gridView.setOnItemClickListener((adapterView, view, i, l) -> {
            String s =adapterView.getItemAtPosition(i).toString();
            Intent intent = new Intent(view.getContext(), ViewImage.class);
            intent.putExtra("url", s);
            startActivity(intent);
        });
        return view;
    }

    String[] flower = {
            "https://cdn.pixabay.com/photo/2014/04/10/11/24/rose-320868__340.jpg",
            "https://cdn.pixabay.com/photo/2022/03/01/10/59/cherry-blossom-7041079__340.jpg",
            "https://cdn.pixabay.com/photo/2018/03/16/17/24/lotus-3231910__340.jpg",
            "https://cdn.pixabay.com/photo/2014/03/14/10/22/peony-287062__340.jpg"

    };

    String[] animal = {
            "https://cdn.pixabay.com/photo/2017/08/16/10/39/hare-2647220__340.jpg",
            "https://cdn.pixabay.com/photo/2019/05/10/13/21/husky-4193503__340.jpg",
            "https://cdn.pixabay.com/photo/2018/06/28/12/34/panda-3503779__340.jpg",
            "https://cdn.pixabay.com/photo/2018/07/13/10/20/kittens-3535404__340.jpg"
    };

    String[] food = {
            "https://cdn.pixabay.com/photo/2010/12/13/10/05/berries-2277__340.jpg",
            "https://cdn.pixabay.com/photo/2016/08/11/08/04/vegetables-1584999__340.jpg",
            "https://cdn.pixabay.com/photo/2017/03/23/19/57/asparagus-2169305__340.jpg",
            "https://cdn.pixabay.com/photo/2016/01/22/02/13/meat-1155132__340.jpg"
    };

    public void updateContent(int position){
        switch (position){
            case 0:
                gridView.setAdapter(new ImageAdapter(getContext(),flower));
                break;
            case 1:
                gridView.setAdapter(new ImageAdapter(getContext(),animal));
                break;
            case 2:
                gridView.setAdapter(new ImageAdapter(getContext(),food));
                break;
        }
    }
}
