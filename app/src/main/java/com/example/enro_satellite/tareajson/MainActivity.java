package com.example.enro_satellite.tareajson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RemoteTask.RemoteTaskCallback, AdapterView.OnItemClickListener{

    private Button load;
    private ListView list;

    private List<Friend> friends;

    private FriendAdapter adapter;

    private static final int FRIEND_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.load=(Button)this.findViewById(R.id.load);

        this.friends=new ArrayList<>();

        adapter=new FriendAdapter(this,this.friends);

        this.list=(ListView)this.findViewById(R.id.list);

        this.list.setAdapter(this.adapter);

        this.list.setOnItemClickListener(this);

        this.load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRemote(v);
            }
        });
    }

    public void loadRemote(View v){
        this.friends.clear();
        this.adapter.notifyDataSetChanged();
        RemoteTask task = new RemoteTask(this);
        task.execute("https://amigos-b261f.firebaseio.com./.json");
    }

    @Override
    public void done(JSONObject json) {

        String name,address,hobby;
        int age,phone;

        try {
            JSONArray friends = json.getJSONArray("Friends");

            for(int i=0;i<friends.length();i++){

                JSONObject row = friends.getJSONObject(i);
                name=row.getString("name");
                address=row.getString("address");
                hobby=row.getString("hobby");
                age=row.getInt("age");
                phone=row.getInt("phone");

                this.friends.add(new Friend(name,hobby,address,age,phone));
            }

            this.adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Friend f = this.friends.get((int)id);

        Intent i = new Intent(this,FriendActivity.class);

        i.putExtra("name",f.getName());
        i.putExtra("age",f.getAge());
        i.putExtra("phone",f.getPhone());
        i.putExtra("hobby",f.getHobby());
        i.putExtra("address",f.getAddress());

        this.startActivity(i);
    }
}
