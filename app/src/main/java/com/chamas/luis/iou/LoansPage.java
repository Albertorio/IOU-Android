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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.chamas.luis.iou.R;

import java.util.ArrayList;

public class LoansPage extends Activity {
    private Button debt;
    private Button loan;
    private ListView owe;
    private String newName="";
    private String newAmount="";
    private ArrayList<items> go = new ArrayList<items>();
    private ListAdapter theAdapter;
    private TextView noLoan;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loans_page);

        debt = (Button)findViewById(R.id.LoansPageDebtsButton);
        loan = (Button)findViewById(R.id.LoansPageLoansButton);
        owe = (ListView)findViewById(R.id.LoansListView);
        noLoan = (TextView)findViewById(R.id.NoLoansTextView);

        owe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                items item;
                item = (items) parent.getItemAtPosition(position);
                String personPicked = item.getName();


                AlertDialog.Builder adb = new AlertDialog.Builder(LoansPage.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + personPicked);
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        go.remove(positionToRemove);
                        owe.invalidateViews();
                        if(theAdapter.isEmpty())noLoan.setText("You Have No Debts!!");
                    }
                });
                adb.show();
                return true;
            }
        });

        owe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                items item;

                Intent getPerson = new Intent(LoansPage.this, LoanPerson.class);
                String personPicked;
                item = (items)parent.getItemAtPosition(position);
                personPicked = item.getName();
                String price = item.getPrice();
                getPerson.putExtra("owePerson",personPicked);
                getPerson.putExtra("price", price);
                getPerson.putExtra("position", position);
                startActivityForResult(getPerson, 2);
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
            finish();
        }else if(id == R.id.add_loan){
            Intent new_loan = new Intent(this, AddLoan.class);
            startActivityForResult(new_loan, 1);
        }
        return super.onOptionsItemSelected(item);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                newName = data.getExtras().getString("newName");
                newAmount = data.getExtras().getString("newAmount");
                go.add(new items(newName, newAmount));

                theAdapter = new MyAdapter_2(this, go);
                if(!theAdapter.isEmpty()){
                    noLoan.setText(" ");
                }
                owe = (ListView)findViewById(R.id.LoansListView);
                owe.setAdapter(theAdapter);
            }else{
                //write code if there's no result
            }
        }


    }


    public void DebtsPage(View view) {
        Intent getDebtsPage = new Intent(this, MyActivity.class);
        startActivity(getDebtsPage);
    }

    public void LoansPage(View view) {
//        Intent getLoansPage = new Intent(this, LoansPage.class);
//        startActivity(getLoansPage);
        Toast.makeText(LoansPage.this, "Already in Loans page", Toast.LENGTH_SHORT).show();
    }
}
