package com.example.fragmentimage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class MenuFrag extends ListFragment {
    String[] menus = {"Flowers", "Animals", "Foods"};
    ArrayAdapter<String> adapter;
    ListView list;
//    private AdapterView.OnItemClickListener onclick = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            // ...
//        }
//    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.menu_frag, container, false);
        list = view.findViewById(android.R.id.list);
        adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_list_item_1, new ArrayList<String>( Arrays.asList(menus)));
        setListAdapter(adapter);
        return view;
    }

    public interface IFragmentClickListener{
        public void onMenuItemClick(int position);

    }

    IFragmentClickListener itemFragment;

    @Override public void onAttach(@NonNull Context context){
        super.onAttach(context);

        try {itemFragment = (IFragmentClickListener) context;}
        catch (ClassCastException e){e.printStackTrace();}
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        itemFragment.onMenuItemClick(position);
    }
}
