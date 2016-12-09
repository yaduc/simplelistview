package com.cr.customlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yadu on 9/12/16.
 */

public class CustomAdapter extends BaseAdapter {

    private static LayoutInflater inflater=null;
    private List<SampleModel> datas;

    public CustomAdapter(List<SampleModel> datas,Context context) {
        this.datas = datas;
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
        if(convertView==null)
            vi = inflater.inflate(R.layout.item_row, null);

        TextView name = (TextView)vi.findViewById(R.id.name);
        TextView description = (TextView)vi.findViewById(R.id.description);
        TextView date = (TextView)vi.findViewById(R.id.date);

        SampleModel data = datas.get(position);

        name.setText(data.getName());
        description.setText(data.getDescription());
        date.setText(data.getDate());

        return vi;
    }
}
