package com.sunshine.bbreaker.appet_i;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;


public class Cart extends ActionBarActivity {
    Button checkout;
    MaterialEditText ProductTitle;
    ImageView ProductImage;
    MaterialEditText Quantity;
    MaterialEditText Amount;
    MaterialSpinner cityspinner;
    MaterialEditText Type;
    MaterialEditText Line1;
    MaterialEditText Line2;
    MaterialEditText PINCODE;
    String[] city_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Bundle bundle= getIntent().getExtras();
        final String producttitle = bundle.getString("producttitle");
        String quantity = bundle.getString("quantity");
        String type = bundle.getString("type");
        String amount= bundle.getString("amount");

        ProductTitle=(MaterialEditText) findViewById(R.id.ProductTitleTextView);
        ProductImage=(ImageView) findViewById(R.id.ProductImageView);
        Quantity= (MaterialEditText) findViewById(R.id.QuantityEditText);
        Amount=(MaterialEditText) findViewById(R.id.AmountEditText);
        Type = (MaterialEditText) findViewById(R.id.TypeEditText);
        Line1 = (MaterialEditText) findViewById(R.id.line1);
        Line2 = (MaterialEditText) findViewById(R.id.line2);
        cityspinner = (MaterialSpinner) findViewById(R.id.cityspinner);
        PINCODE = (MaterialEditText) findViewById(R.id.pincode);

        ProductTitle.setText(producttitle);
        Amount.setText(amount);
        Quantity.setText(quantity);
        Type.setText(type);

        city_array = getResources().getStringArray(R.array.city_arrays);
        ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, city_array);
        quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cityspinner.setAdapter(quantadapter);



        // Setting up of image view based on the product selected
        if (producttitle.equals("Paneer Ghewar"))
        {
            ProductImage.setImageResource(R.drawable.ghewar);
        }
        if (producttitle.equals("Til Ke Laddoo"))
        {
            ProductImage.setImageResource(R.drawable.tilkeladdoo);

        }

        if(producttitle.equals("Kalakand"))
        {
            ProductImage.setImageResource(R.drawable.kalakand);

        }

        if(producttitle.equals("Kesar Angoori Petha"))
        {
            ProductImage.setImageResource(R.drawable.petha);

        }

        if(producttitle.equals("Gujarati Khakhra"))
        {
            ProductImage.setImageResource(R.drawable.khakra);

        }

        if(producttitle.equals("Mysore Pak"))
        {
            ProductImage.setImageResource(R.drawable.mysorepak);

        }

        if(producttitle.equals("Bombay Ice Halwa"))
        {
            ProductImage.setImageResource(R.drawable.icehalwa);

        }

        if(producttitle.equals("Ratlami Sev"))
        {
            ProductImage.setImageResource(R.drawable.lehsunsev);

        }

        if(producttitle.equals("Kashmiri Chikki"))
        {
            ProductImage.setImageResource(R.drawable.kashmirichikki);

        }



        // OnClickListener for checkout button
        checkout =(Button) findViewById(R.id.checkoutbutton);
        checkout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent opencheckout = new Intent(getApplicationContext(), Checkout.class);
                opencheckout.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                opencheckout.putExtra("PName", producttitle);
                String quantity = Quantity.getText().toString();
                String type = Type.getText().toString();
                String amount = Amount.getText().toString();
                String line1 = Line1.getText().toString();
                String line2 = Line2.getText().toString();
                String city = cityspinner.getSelectedItem().toString();
                String pincode = PINCODE.getText().toString();
                opencheckout.putExtra("quantity", quantity);
                opencheckout.putExtra("type", type);
                opencheckout.putExtra("amount",amount);
                opencheckout.putExtra("line1",line1);
                opencheckout.putExtra("line2",line2);
                opencheckout.putExtra("city",city);
                opencheckout.putExtra("pincode",pincode);
                getApplicationContext().startActivity(opencheckout);
            }
        });

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cart, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_cart, container, false);


            return rootView;
        }
    }
}
