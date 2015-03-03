package com.chamas.luis.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chamas.luis.iou.R;

public class person extends Activity {
    private TextView person;
    private EditText amount2Pay;
    private Button payButton;
    private String name;
    private String price;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        Intent activityThatCalled = getIntent();
        person = (TextView)findViewById(R.id.PersonsTextView);
        name = activityThatCalled.getExtras().getString("owePerson");
        person.setText(name);
        price = activityThatCalled.getExtras().getString("price");
        TextView money = (TextView)findViewById(R.id.MoneyView);
        money.setText(price);
        position = activityThatCalled.getExtras().getInt("position");

        amount2Pay = (EditText)findViewById(R.id.editText);
        payButton = (Button)findViewById(R.id.button2);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.person, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void payDebt(View view) {
        double paying;
        double total;
        paying = Double.parseDouble(String.valueOf(amount2Pay.getText()));

        total = Double.parseDouble(price) - paying;

        if(total <= 0){
            total = 0;
        }

        Intent payDebt = new Intent(this, MyActivity.class);
        payDebt.putExtra("total", total);
        payDebt.putExtra("position", position);
        payDebt.putExtra("name", name);
        setResult(RESULT_OK,payDebt);
        finish();
    }

    public void liquidateDebt(View view) {
        double total = 0;
        Intent liquidate = new Intent(this, MyActivity.class);
        liquidate.putExtra("total", total);
        liquidate.putExtra("position", position);
        setResult(RESULT_OK, liquidate);
        finish();
    }
}
