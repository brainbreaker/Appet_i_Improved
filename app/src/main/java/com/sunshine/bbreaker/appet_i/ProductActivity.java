package com.sunshine.bbreaker.appet_i;

import android.app.AlertDialog;
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
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import fr.ganfra.materialspinner.MaterialSpinner;


public class ProductActivity extends ActionBarActivity {

    Button addtocart;
    TextView title;
    TextView description;
    Double totalamount;
    ImageView productimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

         totalamount= 0.00;


        Bundle bundle = getIntent().getExtras();
        String producttitle = bundle.getString("producttitle");
//        getSupportActionBar().setTitle(producttitle);
        addtocart = (Button) findViewById(R.id.AddToCartButton);
        title= (TextView) findViewById(R.id.ProductTitle);
        description= (TextView) findViewById(R.id.ProductDescription);
        //quantity = (EditText) findViewById(R.id.QuantityEditText);
        productimage= (ImageView) findViewById(R.id.ProductImage);
        final MaterialSpinner spinnerquantity = (MaterialSpinner) findViewById(R.id.spinnerquantity);
        final MaterialSpinner spinnertype = (MaterialSpinner) findViewById(R.id.spinnertype);
        final MaterialEditText amount = (MaterialEditText) findViewById(R.id.metamountedittext);
//        amount.setVisibility(View.INVISIBLE);
//        amount.setText("HELL OF A THING!!");

        if(producttitle.equals("Paneer Ghewar"))
        {
            productimage.setImageResource(R.drawable.ghewar);
            title.setText("Paneer Ghewar");
            description.setText(R.string.ghewar);
            String[] ITEMSQUANTITY = {"1 pc"};
            String[] ITEMTYPE = {"Sweet", "Plain"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position)
                    {
                        case 0:
                            totalamount= 600.00;
                            break;
                        case 1:
                            totalamount= 600.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs."+ totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }
        else if(producttitle.equals("Alwar Ka Kalakand"))
        {
            productimage.setImageResource(R.drawable.kalakand);
            title.setText("Alwar Ka Kalakand");
            description.setText(R.string.kalakand);
            String[] ITEMSQUANTITY = {"1 KG"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 450.00;
                            break;

                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
       else if(producttitle.equals("Bombay Ice Halwa"))
        {
            productimage.setImageResource(R.drawable.icehalwa);
            title.setText("Bombay Ice Halwa");
            description.setText(R.string.bombayicehalwa);
            String[] ITEMSQUANTITY = {"1 KG"};
            String[] ITEMTYPE = {"Bombay Ice Halwa", "Golden Ice Halwa", "Kesar Golden Halwa","Mohini Halwa",
                    "Tansen Halwa","Kismat Halwa","Gulab Halwa","Mango Halwa", "Strawberry Halwa",
                    "Orange Halwa","Anjeer Halwa","Cocum Halwa"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 700.00;
                            break;
                        case 1:
                            totalamount = 720.00;
                            break;
                        case 2:
                            totalamount = 750.00;
                            break;
                        case 3:
                            totalamount = 780.00;
                            break;
                        case 4:
                            totalamount = 780.00;
                            break;
                        case 5:
                            totalamount = 720.00;
                            break;
                        case 6:
                            totalamount = 720.00;
                            break;
                        case 7:
                            totalamount = 720.00;
                            break;
                        case 8:
                            totalamount = 720.00;
                            break;
                        case 9:
                            totalamount = 720.00;
                            break;
                        case 10:
                            totalamount = 780.00;
                            break;
                        case 11:
                            totalamount = 780.00;
                            break;

                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }
       else if(producttitle.equals("Kashmiri Chikki"))
        {
            productimage.setImageResource(R.drawable.kashmirichikki);
            title.setText("Kashmiri Chikki");
            description.setText(R.string.kashmirichikki);
            String[] ITEMSQUANTITY = {"1 KG"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 600.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
       else if(producttitle.equals("Gujrati Khakra"))
        {
            productimage.setImageResource(R.drawable.khakra);
            title.setText("Gujrati Khakra");
            description.setText(R.string.khakra);
            String[] ITEMSQUANTITY = {"500gm"};
            String[] ITEMTYPE = {"Sada Khakra", "Masala Khakra", " Diet Sada Khakra", "Diet Masala Khakra"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 80.00;
                            break;
                        case 1:
                            totalamount = 80.00;
                            break;
                        case 2:
                            totalamount = 90.00;
                            break;
                        case 3:
                            totalamount = 90.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
       else if(producttitle.equals("Ratlami Sev"))
        {
            productimage.setImageResource(R.drawable.lehsunsev);
            title.setText("Ratlami Sev");
            description.setText(R.string.ratlamisev);
            String[] ITEMSQUANTITY = {"1 KG"};
            String[] ITEMTYPE = {"Ratlami Sev","Barik Sev", "Laung Sev", "Garlic Sev"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 400.00;
                            break;
                        case 1:
                            totalamount = 300.00;
                            break;
                        case 2:
                            totalamount = 300.00;
                            break;
                        case 3:
                            totalamount = 300.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }
        else if(producttitle.equals("Mysore Pak"))
        {
            productimage.setImageResource(R.drawable.mysorepak);
            title.setText("Mysore Pak");
            description.setText(R.string.mysorepak);
            String[] ITEMSQUANTITY = {"1 KG"};
//          spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 400.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }
       else if(producttitle.equals("Kesar Angoori Petha"))
        {
            productimage.setImageResource(R.drawable.petha);
            title.setText("Kesar Angoori Petha");
            description.setText(R.string.petha);
            String[] ITEMSQUANTITY = {"1 KG", "500 gm"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnerquantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 500.00;
                            break;
                        case 1:
                            totalamount = 280.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Til Ke Laddoo"))
        {
            productimage.setImageResource(R.drawable.tilkeladdoo);
            title.setText("Til Ke Laddoo");
            description.setText(R.string.tilekeladdoo);
            String[] ITEMSQUANTITY = {"10 pc", "20 pc"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 150.00;
                            break;
                        case 1:
                            totalamount = 250.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Bikaneri Papad"))
        {
            productimage.setImageResource(R.drawable.bikaneripapad);
            title.setText("Bikaneri Papad");
            description.setText(R.string.bikaneripapad);
            String[] ITEMSQUANTITY = {"400 gm"};
            String[] ITEMTYPE = {"Moth Sada Masala Papad", "Moth Sada Masala Papad", "Channa Chatpata Papad", "Udad Sada Masala Papad"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 120.00;
                            break;
                        case 1:
                            totalamount = 140.00;
                            break;
                        case 2:
                            totalamount = 125.00;
                            break;
                        case 3:
                            totalamount = 140.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Mixed Pachranga Achar"))
        {
            productimage.setImageResource(R.drawable.mixedpanchrangaaachar);
            title.setText("Mixed Pachranga Achar");
            description.setText(R.string.mixedpachrangaachar);
            String[] ITEMSQUANTITY = {"1 KG", "400 gm"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnerquantity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 480.00;
                            break;
                        case 1:
                            totalamount = 720.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }
        else if(producttitle.equals("Sweet Lime Pachranga Achaar"))
        {
            productimage.setImageResource(R.drawable.kairiaachar);
            title.setText("Sweet Lime Pachranga Achaar");
            description.setText(R.string.sweetlimepachrangaachaar);
            String[] ITEMSQUANTITY = {"1 KG", "400gm"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 700.00;
                            break;
                        case 1:
                            totalamount = 1150.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Mango Pachranga Achaar"))
        {
            productimage.setImageResource(R.drawable.mixedpanchrangaaachar);
            title.setText("Mango Pachranga Achaar");
            description.setText(R.string.mangopachrangaachaar);
            String[] ITEMSQUANTITY = {"1 KG", "400 gm"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 480.00;
                            break;
                        case 1:
                            totalamount = 720.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Bhakarwadi"))
        {
            productimage.setImageResource(R.drawable.bhakarwadi);
            title.setText("Bhakarwadi");
            description.setText(R.string.bhakarwadi);
            String[] ITEMSQUANTITY = {"0.5 KG"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 130.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if (producttitle.equals("Fruit Biscuits"))
        {
            productimage.setImageResource(R.drawable.fruitbiscuits);
            title.setText("Fruit Biscuits");
            description.setText(R.string.fruitbiscuits);
            String[] ITEMSQUANTITY = {"400 gm"};
//            spinnertype.setVisibility(View.INVISIBLE);
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 140.00;
                            break;

                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });


        }
        else if(producttitle.equals("Halwasan Pak"))
        {
            productimage.setImageResource(R.drawable.mysorepak);
            title.setText("Halwasan Pak");
            description.setText(R.string.halwasanpak);
            String[] ITEMSQUANTITY = {"1 KG"};
            String[] ITEMSTYPE = {"Plain", "Special(With Dry Fruits)"};
            ArrayAdapter<String> quantadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSQUANTITY);
            ArrayAdapter<String> typeadapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMSTYPE);
            quantadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            typeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerquantity.setAdapter(quantadapter);
            spinnertype.setAdapter(typeadapter);
            spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    switch (position) {
                        case 0:
                            totalamount = 300.00;
                            break;
                        case 1:
                            totalamount = 400.00;
                            break;
                    }
                    amount.setVisibility(View.VISIBLE);
                    amount.setText("Rs." + totalamount);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    amount.setText("Rs. 0.00");
                }
            });

        }

        // OnClickListener for AddToCart button.
                addtocart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String checktype= spinnertype.getSelectedItem().toString();
                String checkquant= spinnerquantity.getSelectedItem().toString();
                if(checktype.equals("Select A Type...") || checkquant.equals("Choose an option..."))
                {
                    new AlertDialog.Builder(ProductActivity.this)
                            .setTitle("Select Type And Quantity")
                            .setMessage("Please Select A Valid Type & Quantity From Drop Down Menu.")
                            .setNeutralButton(android.R.string.ok, null)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
                else
                {
                Intent opencart = new Intent(getApplicationContext(), Cart.class);
                String ProductTitle = title.getText().toString();
                String quantity = spinnerquantity.getSelectedItem().toString();
                String type = spinnertype.getSelectedItem().toString();
                String amount = totalamount.toString();
                opencart.putExtra("producttitle",ProductTitle);
                opencart.putExtra("quantity",quantity);
                opencart.putExtra("type",type);
                opencart.putExtra("amount",amount);
                startActivity(opencart);
        }}
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
        getMenuInflater().inflate(R.menu.menu_product, menu);
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
            final View rootView = inflater.inflate(R.layout.fragment_product_detail, container, false);



            return rootView;
        }
    }
}
