package com.example.philipclark.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ToDoList extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {
    ArrayList<String> toDoItems = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        ListView itemList = (ListView) findViewById(R.id.itemList);
        itemList.setOnItemLongClickListener(this);

        toDoItems = new ArrayList<>();
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                toDoItems
        );

        itemList.setAdapter(adapter);

    }

    public void addItem(View view) {
        TextView newItem = (TextView) findViewById(R.id.newItem);
        String addedTask = newItem.getText().toString();
        toDoItems.add(0, addedTask);
        adapter.notifyDataSetChanged();
        newItem.setText("");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int index, long id) {
        toDoItems.remove(index);
        adapter.notifyDataSetChanged();
        return false;
    }


}
