package com.cr.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by yadu on 9/12/16.
 */

public class CustomAdapter extends BaseAdapter {

    private static LayoutInflater inflater=null;
    private List<SampleModel> datas;
    private Context context;
    public CustomAdapter(List<SampleModel> datas,Context context) {
        this.datas = datas;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


      public int getCount() {
            return datas.size();
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }


    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        if(convertView==null) {
            vi = inflater.inflate(R.layout.item_row, parent, false);
            Log.d("row id",position+" new");
        }else {
            Log.d("row id",position+" already created");
        }

        TextView name = (TextView) vi.findViewById(R.id.name);
        TextView description = (TextView)vi.findViewById(R.id.description);
        TextView date = (TextView)vi.findViewById(R.id.date);
        ImageView avatar = (ImageView)vi.findViewById(R.id.imageView);

        SampleModel data = datas.get(position);

        name.setText(data.getName());
        description.setText(data.getDescription());
        date.setText(data.getDate());

        Glide
                .with(context)
                .load(data.getImg_url())
                //.centerCrop()
                //.placeholder(R.drawable.loading_spinner)
                .crossFade()
                .into(avatar);


        return vi;
    }
}
