package com.cr.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    List<SampleModel>datas;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = (ListView)findViewById(R.id.listView);
        datas = new ArrayList<>();
        loadDummyDatas();

        customAdapter = new CustomAdapter(datas,this);
        listView.setAdapter(customAdapter);
    }

    private void loadDummyDatas() {
        SampleModel sampleModel = new SampleModel("A1","A1 Description","Today");
        datas.add(sampleModel);

        SampleModel sampleModel2 = new SampleModel("A2","A2 Description","Tomorrow");
        datas.add(sampleModel2);

        SampleModel sampleModel3 = new SampleModel("A3","A3 Description","Yesterday");
        datas.add(sampleModel3);
    }
}
