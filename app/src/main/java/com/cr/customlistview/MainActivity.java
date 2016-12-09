package com.cr.customlistview;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Switch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ArrayList<SampleModel>datas;
    CustomAdapter customAdapter;

    JSONObject response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);

        datas = new ArrayList<>();
        //loadDummyDatas();
        loadFromServer();
        customAdapter = new CustomAdapter(datas,this);
        listView.setAdapter(customAdapter);


    }

    private void loadFromServer() {
        new NetworkAsyncTask().execute();
    }

    private void loadData(){
        try {
            JSONArray data = response.getJSONArray("data");
            for (int i=0;i<data.length();i++){
                JSONObject eachPerson = data.getJSONObject(i);
                SampleModel model = new SampleModel(eachPerson.getString("first_name"),eachPerson.getString("last_name"),"Today",eachPerson.getString("avatar"));
                datas.add(model);
            }
            customAdapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.print(response.toString());
    }
    private void loadDummyDatas() {
        SampleModel sampleModel = new SampleModel("A1","A1 Description","Today","String img_url");
        datas.add(sampleModel);

        SampleModel sampleModel2 = new SampleModel("A2","A2 Description","Tomorrow","String img_url");
        datas.add(sampleModel2);

        SampleModel sampleModel3 = new SampleModel("A3","A3 Description","Yesterday","String img_url");
        datas.add(sampleModel3);

    }


    public class NetworkAsyncTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... params) {
            String url = "http://reqres.in/api/users?page=2";


            try {
                // defaultHttpClient
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpPost = new HttpGet(url);
                HttpResponse httpResponse = httpClient.execute(httpPost);
                HttpEntity httpEntity = httpResponse.getEntity();
                response = new JSONObject(EntityUtils.toString(httpEntity));

                handler.sendEmptyMessage(0);

            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}

    }

    private final Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch(msg.what){
                case 0:
                    loadData();
                    break;
            }
        }
    };
}
