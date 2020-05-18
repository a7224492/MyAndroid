package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.android1.R;
import com.example.dao.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendListViewAdapter extends BaseAdapter {
    private List<User> userList;
    private Context context;
    private Map<String, Integer> firstPinYinLetter2Index = new HashMap<>();

    public FriendListViewAdapter(List<User> userList, Context context) {
        this.userList = userList;
        this.context = context;

        for (int i = 0; i < userList.size(); ++i) {
            User user = userList.get(i);
            if (!firstPinYinLetter2Index.containsKey(user.getFirstPinYinLetter())) {
                firstPinYinLetter2Index.put(user.getFirstPinYinLetter(), i);
            }
        }
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = userList.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_friend, null);
        }

        TextView nameView = convertView.findViewById(R.id.name);
        TextView catalogView = convertView.findViewById(R.id.catalog);
        nameView.setText(user.getName());
        catalogView.setText(user.getFirstPinYinLetter().toUpperCase());

        String firstPinYinLetter = user.getFirstPinYinLetter();
        Integer index = firstPinYinLetter2Index.get(firstPinYinLetter);
        if (position == index) {
            catalogView.setVisibility(View.VISIBLE);
        } else {
            catalogView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
