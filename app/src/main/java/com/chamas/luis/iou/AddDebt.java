package com.chamas.luis.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.chamas.luis.iou.R;

public class AddDebt extends Activity {
    private EditText name;
    private EditText amount;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_debt);

        name = (EditText)findViewById(R.id.AddDebtNameEditText);
        amount = (EditText)findViewById(R.id.AddDebtAmountEditText);
        phone = (EditText)findViewById(R.id.AddDebtPhoneEditText);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.add_debt, menu);
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

    public void newDebt(View view) {
        String newName = String.valueOf(name.getText());
        String newAmount = String.valueOf(amount.getText());
        Intent addNewDebt = new Intent(this, MyActivity.class);
        addNewDebt.putExtra("newName", newName);
        addNewDebt.putExtra("newAmount", newAmount);
        setResult(RESULT_OK,addNewDebt);
        finish();
    }
}
