package com.chamas.luis.iou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class AddLoan extends Activity {
    private EditText name;
    private EditText amount;
    private EditText phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_loan);

        name = (EditText)findViewById(R.id.AddLoanNameEditText);
        amount = (EditText)findViewById(R.id.AddLoanAmountEditText);
        phone = (EditText)findViewById(R.id.AddLoanPhoneEditText);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_loan, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void newLoan(View view) {
        String newName = String.valueOf(name.getText());
        String newAmount = String.valueOf(amount.getText());
        Intent addNewLoan = new Intent(this, MyActivity.class);
        addNewLoan.putExtra("newName", newName);
        addNewLoan.putExtra("newAmount", newAmount);
        setResult(RESULT_OK,addNewLoan);
        finish();

    }
}
