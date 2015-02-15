package com.chamas.luis.iou;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MyActivity extends Activity {
    private Button debt;
    private Button loan;
    private ListView owe;
    private String newName="";
    private String newAmount="";
    private ArrayList<items> go = new ArrayList<items>();
    private ListAdapter theAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        debt = (Button) findViewById(R.id.DebtsButton);
        loan = (Button) findViewById(R.id.LoansButton);
        owe = (ListView) findViewById(R.id.DebtsListView);
        // ListAdapter theAdapter = new MyAdapter_2(this, generateData());
        // ListAdapter theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Money);
        //  owe.setAdapter(theAdapter);

        if(theAdapter.isEmpty()){

        }

        owe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                items item;
                item = (items)parent.getItemAtPosition(position);
                String personPicked = item.getName();

                
                AlertDialog.Builder adb=new AlertDialog.Builder(MyActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + personPicked);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        go.remove(positionToRemove);
                        owe.invalidateViews();
                    }});
                adb.show();

                return true;
            }
        });
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

    //might not need this
    private ArrayList<items> generateData(){

        ArrayList<items> item = new ArrayList<items>();

        item.add(new items("Luis", "5.00"));
        item.add(new items("Jorge", "12.50"));



        return item;
    }

    //overloaded generateData function
    private ArrayList<items> generateData(String name, String price){

        ArrayList<items> item = new ArrayList<items>();

        item.add(new items(name, price));

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
        if (id == R.id.add_debt) {
            Intent new_debt = new Intent(this, AddDebt.class);
            startActivityForResult(new_debt, 1);
        }else if(id == R.id.exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK){
                newName = data.getExtras().getString("newName");
                newAmount = data.getExtras().getString("newAmount");
                go.add(new items(newName,newAmount));

               theAdapter = new MyAdapter_2(this, go);
                owe = (ListView) findViewById(R.id.DebtsListView);
                owe.setAdapter(theAdapter);
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

    public void DebtsPage(View view) {
        Intent getDebtsPage = new Intent(this, MyActivity.class);
        startActivity(getDebtsPage);

    }

    public void LoansPage(View view) {
        Intent getLoansPage = new Intent(this, LoansPage.class);
        startActivity(getLoansPage);
    }
}
