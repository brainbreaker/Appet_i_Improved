package com.sunshine.bbreaker.appet_i;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.ArrayList;
import java.util.List;


public class Checkout extends ActionBarActivity {
    MaterialEditText FirstNameET;
    MaterialEditText PhoneET;
    MaterialEditText EmailET;
    MaterialEditText AddressET;
    MaterialEditText LastNameET;
    MaterialEditText productname;
    MaterialEditText Quantity;
    MaterialEditText Amount;
    MaterialEditText Type;
    String Name;
    String Phone;
    String Email;
    String Address;
    String City;
    String Pin;
    String State;

    Button COD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        Intent producttitle = getIntent();
        final String PTitle= producttitle.getStringExtra("PName");
        String quantity = producttitle.getStringExtra("quantity");
        String type = producttitle.getStringExtra("type");
        String amount = producttitle.getStringExtra("amount");
        String line1 = producttitle.getStringExtra("line1");
        String line2 = producttitle.getStringExtra("line2");
        String city = producttitle.getStringExtra("city");
        String pincode = producttitle.getStringExtra("pincode");


        FirstNameET= (MaterialEditText) findViewById(R.id.FirstName);
        PhoneET= (MaterialEditText) findViewById(R.id.Phone);
        EmailET= (MaterialEditText) findViewById(R.id.Email);
        AddressET= (MaterialEditText) findViewById(R.id.ShippingAddress);
        LastNameET= (MaterialEditText) findViewById(R.id.LastName);
        productname = (MaterialEditText) findViewById(R.id.PTitle);
        Quantity = (MaterialEditText) findViewById(R.id.Quantity);
        Amount = (MaterialEditText) findViewById(R.id.totalamount);
        Type = (MaterialEditText) findViewById(R.id.Type);


        AddressET.setText(line1+ "\t"+","+ line2 + "\t"+ "," +city+ "-" +pincode);
        Quantity.setText(quantity);
        Amount.setText(amount);
        Type.setText(type);

        Name = FirstNameET.getText().toString();
        Phone=PhoneET.getText().toString();
        Email=EmailET.getText().toString();
        Address=AddressET.getText().toString();

        COD= (Button) findViewById(R.id.CODbutton);
        COD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Toast.makeText(Checkout.this, "Not Yet Implemeted",Toast.LENGTH_LONG).show();

//                Intent opencart = new Intent(getApplicationContext(), Order_Summary.class);
//
//                opencart.putExtra("ShippingAddress", Address);
//                opencart.putExtra("PTitle", PTitle);
//                startActivity(opencart);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_checkout, menu);
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
}
