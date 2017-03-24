package com.example.enro_satellite.tareajson;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by enro-satellite on 17/03/17.
 */

public class FriendAdapter extends BaseAdapter{

        private List<Friend> source;
        private Activity context;

        public FriendAdapter(Activity context,List<Friend> source ) {

            this.context=context;
            this.source=source;

        }
    @Override
    public int getCount() {
        return this.source.size();
    }

    @Override
    public Object getItem(int position) {
        return this.source.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if(view==null){
            view = context.getLayoutInflater().inflate(R.layout.row,null);
        }

        Friend f = this.source.get(position);

        TextView nameText=(TextView)view.findViewById(R.id.name);
        TextView hobbyText=(TextView)view.findViewById(R.id.hobby);

        nameText.setText(f.getName());
        hobbyText.setText(f.getHobby());

        return view;
    }
}
