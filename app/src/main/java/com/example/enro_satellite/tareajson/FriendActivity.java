package com.example.enro_satellite.tareajson;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FriendActivity extends AppCompatActivity {

    private TextView name, phone, age, hobby, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        Intent i = this.getIntent();

        String name = i.getStringExtra("name");
        String hobby = i.getStringExtra("hobby");
        String address = i.getStringExtra("address");
        int  age = i.getIntExtra("age", 0);
        int  phone = i.getIntExtra("phone", 0);

        this.name = (TextView)this.findViewById(R.id.friendName);
        this.address = (TextView)this.findViewById(R.id.friendAddress);
        this.hobby = (TextView)this.findViewById(R.id.friendHobby);
        this.phone = (TextView)this.findViewById(R.id.friendPhone);
        this.age = (TextView)this.findViewById(R.id.friendAge);

        this.name.setText("Name: "+name);
        this.phone.setText("Phone: "+phone);
        this.age.setText("Age: "+age);
        this.hobby.setText("Hobby: "+hobby);
        this.address.setText("Address: "+address);
    }
}
