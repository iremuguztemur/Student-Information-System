package com.example.mobilodeviobs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.mobilodeviobs.inventory.Universiteler;

import java.util.List;

/********************************************
 *     Created by DailyCoding on 15-May-21.  *
 ********************************************/

public class UniversitelerAdapter extends BaseAdapter {
    private Context context;
    private List<Universiteler> universitelerList;

    public UniversitelerAdapter(Context context, List<Universiteler> universitelerList) {
        this.context = context;
        this.universitelerList = universitelerList;
    }

    @Override
    public int getCount() {
        return universitelerList != null ? universitelerList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rootView = LayoutInflater.from(context)
                .inflate(R.layout.item_universite, viewGroup, false);

        TextView txtName = rootView.findViewById(R.id.name);
        ImageView image = rootView.findViewById(R.id.image);

        txtName.setText(universitelerList.get(i).getName());
        image.setImageResource(universitelerList.get(i).getImage());

        return rootView;
    }
}
