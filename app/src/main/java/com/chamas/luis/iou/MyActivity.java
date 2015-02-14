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

        HashMap hm = new HashMap();
        hm.put("Luis", 5.00);
        hm.put("Albertorio" ,3.25);

        debt = (Button)findViewById(R.id.DebtsButton);
        loan = (Button)findViewById(R.id.LoansButton);
        owe = (ListView)findViewById(R.id.DebtsListView);
        ListAdapter theAdapter = new MyAdapter(this,Money);
       // ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Money);
        owe.setAdapter(theAdapter);

        owe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent getPerson = new Intent(MyActivity.this, person.class);
                String personPicked = String.valueOf(parent.getItemAtPosition(position));
                getPerson.putExtra("owePerson", personPicked);
                startActivity(getPerson);
            }
        });

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
