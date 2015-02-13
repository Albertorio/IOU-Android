package com.chamas.luis.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

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
        ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Money);
        owe.setAdapter(theAdapter);

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