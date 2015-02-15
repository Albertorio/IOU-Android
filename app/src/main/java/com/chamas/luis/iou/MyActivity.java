package com.chamas.luis.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MyActivity extends Activity {
    private Button debt;
    private Button loan;
    private ListView owe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String[] Money = {"Luis", "Albertorio"};

        debt = (Button)findViewById(R.id.DebtsButton);
        loan = (Button)findViewById(R.id.LoansButton);
        owe = (ListView)findViewById(R.id.DebtsListView);
        ListAdapter theAdapter = new MyAdapter_2(this,generateData());
       // ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Money);
        owe.setAdapter(theAdapter);

        owe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                items item;

                Intent getPerson = new Intent(MyActivity.this, person.class);
                String personPicked;
                item = (items)parent.getItemAtPosition(position);
                personPicked = item.getName();
                String price = item.getPrice();
                getPerson.putExtra("owePerson",personPicked);
                getPerson.putExtra("price", price);
                startActivity(getPerson);
            }
        });

    }

    private ArrayList<items> generateData(){

        ArrayList<items> item = new ArrayList<items>();

        item.add(new items("Luis", "5.00"));
        item.add(new items("Jorge", "12.50"));

        return item;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.exit) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void DebtsPage(View view) {
        Intent getDebtsPage = new Intent(this, MyActivity.class);
        startActivity(getDebtsPage);

    }

    public void LoansPage(View view) {
        Intent getLoansPage = new Intent(this, LoansPage.class);
        startActivity(getLoansPage);
    }
}
