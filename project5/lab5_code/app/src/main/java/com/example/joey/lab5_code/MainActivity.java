package com.example.joey.lab5_code;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.goods_list);
        init_goods_list();
        init_shoppinglist();
    }

    public void init_goods_list() {
        RecyclerView recycler_view = (RecyclerView)findViewById(R.id.recycler_view);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        String category[] = {"goods", "prices"};
        String goods[] = {"cookie", "penius", "dick", "cola"};
        String prices[] = {"100", "200", "300", "390"};
        ArrayList<Map<String, Object>> commonAdapter = new ArrayList<>();
        for (int i = 0; i < goods.length; i++) {
            Map<String, Object> temp = new LinkedHashMap<>():
            temp.put(category[0], goods[i]);
            temp.put(category[1], prices[i]);
            commonAdapter.add(temp);
        }
        recycler_view.setAdapter(goods);
    }

    public void init_shoppinglist() {
        final String from[] = {"name", "price"};
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        final String booksName[] = {"one", "two", "three"};
        final String bookPrices[] = {"1", "2", "3"};
        for (int i = 0; i < booksName.length; i++) {
            Map<String, Object> temp = new LinkedHashMap<>();
            temp.put(from[0], booksName[i]);
            temp.put(from[1], bookPrices[i]);
            data.add(temp);
        }
        ListView listview = (ListView) findViewById(R.id.shoppinglist);
        SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.shoppingadapterlist, from, new int[] {R.id.name, R.id.price});
        listview.setAdapter(sa);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, booksName[position], Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        data.remove(2);
        sa.notifyDataSetChanged();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, bookPrices[position], Toast.LENGTH_SHORT).show();
            }
        });
        /*
        String context[] = {"Amy", "Bob"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.shoppingadapterlist, R.id.adapterlist, context);
        ListView shoppinglist = (ListView) findViewById(R.id.shoppinglist);
        shoppinglist.setAdapter(arrayAdapter);
        */
    }
}
