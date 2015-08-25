package com.sunshine.bbreaker.appet_i;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.cards.actions.BaseSupplementalAction;
import it.gmariotti.cardslib.library.cards.actions.TextSupplementalAction;
import it.gmariotti.cardslib.library.cards.material.MaterialLargeImageCard;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;


public class Products extends ActionBarActivity {
    private ListView ProductlistView;
    ProductsListViewAdapter Adapter;
    Context context;
    final int TOTAL_CARDS = 3;
    //private CardArrayAdapter
    private CardArrayRecyclerViewAdapter mCardArrayAdapter;
    private CardRecyclerView mRecyclerView;
    String productname;
    String price;
    String title;
    int pimage[]={R.drawable.ghewar,R.drawable.lehsunsev,R.drawable.morecomingsoon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        context = this;
        Intent intent = getIntent();
        title = intent.getStringExtra("title");
//        getSupportActionBar().setTitle(title);


        //  code of cards 2   //
        ArrayList<Card> cards = new ArrayList<>();
        mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, cards);
        CardRecyclerView mRecyclerView = (CardRecyclerView) findViewById(R.id.card_recyclerview);
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);


        }
        //Load cards
        new LoaderAsyncTask().execute();
    }

    private String titlereturn(){
        return title;
    }


    private ArrayList<Card> initCard() {

        ArrayList<Card> cards = new ArrayList<Card>();
        int[] pximage;
        // code of product image array //
        if(title.equals("Rajasthan")) {

            pximage = new int[]{R.drawable.ghewar, R.drawable.bikaneripapad, R.drawable.kalakand};
            pimage = pximage;
        } else if(title.equals("Gujarat")){
            pximage = new int[]{R.drawable.khakra,R.drawable.halwasn,R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Maharashtra")){
            pximage = new int[]{R.drawable.icehalwa, R.drawable.bhakarwadi, R.drawable.chivda};
            pimage = pximage;
        }else if(title.equals("Haryana")){
            pximage = new int[]{R.drawable.kairiaachar,R.drawable.mangopanchrangaaachar,R.drawable.mixedpanchrangaaachar};
            pimage = pximage;
        }else if(title.equals("Uttar Pradesh")){
            pximage = new int[]{R.drawable.petha, R.drawable.morecomingsoon, R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Jammu and Kashmir")){
            pximage = new int[]{R.drawable.kashmirichikki, R.drawable.morecomingsoon,R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Karnataka")){
            pximage = new int[]{R.drawable.mysorepak, R.drawable.morecomingsoon,R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Andhra Pradesh")){
            pximage = new int[]{R.drawable.fruitbiscuits,R.drawable.morecomingsoon,R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Kerela")){
            pximage = new int[]{R.drawable.morecomingsoon,R.drawable.morecomingsoon,R.drawable.morecomingsoon};
            pimage = pximage;
        }else if(title.equals("Madhya Pradesh")){
            pximage = new int[]{R.drawable.lehsunsev, R.drawable.morecomingsoon, R.drawable.morecomingsoon};
            pimage = pximage;
        }



        for (int i = 0; i < TOTAL_CARDS; i++) {
            final ArrayList<BaseSupplementalAction> actions = new ArrayList<BaseSupplementalAction>();
          final String title= titlereturn();
            final int j= i;
            // Set supplemental actions
            TextSupplementalAction t1 = new TextSupplementalAction(this, R.id.action1);
            t1.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
                Intent intent;

                @Override
                public void onClick(Card card, View view) {
                        if (title.equals("Rajasthan")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Paneer Ghewar");
                                break;
                            case 1:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Bikaneri Papad");
                                break;
                            case 2:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Alwar Ka Kalakand");
                                break;
                        }
                    }   if (title.equals("Gujarat")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Gujrati Khakra");
                                break;
                            case 1:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Halwasan Pak");
                                break;
                            case 2:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();

                        }
                    }  if (title.equals("Maharashtra")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Bombay Ice Halwa");
                                break;
                            case 1:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Bhakharvadi");
                                break;
                            case 2:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Chivda");
                                break;
                        }
                    }
                    if (title.equals("Uttar Pradesh")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Kesar Angoori Petha");
                                break;
                            case 1:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                    } if (title.equals("Haryana")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Sweet Lime Pachranga Achaar");
                                break;
                            case 1:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Mango Pachranga Achaar");
                                break;
                            case 2:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Mixed Pachranga Achar");
                                break;
                        }
                    }  if (title.equals("Jammu and Kashmir")) {
                        switch (j) {
                            case 0:
                                intent = new Intent(Products.this, ProductActivity.class);
                                intent.putExtra("producttitle", "Kashmiri Chikki");
                                break;
                            case 1:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }


                    }
                        if (title.equals("Karnataka")) {
                            switch (j) {
                                case 0:
                                    intent = new Intent(Products.this, ProductActivity.class);
                                    intent.putExtra("producttitle", "Mysore Pak");
                                    break;
                                case 1:
                                    Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                            Toast.LENGTH_LONG).show();
                                    break;
                                case 2:
                                    Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                            Toast.LENGTH_LONG).show();
                                    break;
                            }
                    }
                    if (title.equals("Madhya Pradesh")) {
                            switch (j) {
                                case 0:
                                    intent = new Intent(Products.this, ProductActivity.class);
                                    intent.putExtra("producttitle", "Ratlami Sev");
                                    break;
                                case 1:
                                    Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                            Toast.LENGTH_LONG).show();
                                    break;
                                case 2:
                                    Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                            Toast.LENGTH_LONG).show();
                                    break;
                            }
                    } if (title.equals("Kerela")) {
                        switch (j) {
                            case 0:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 1:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                            case 2:
                                Toast.makeText(Products.this,"Sorry :( Nothing Here Right Now. Check Out Other Delicacies!",
                                        Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                    Products.this.startActivity(intent);

                }
            });
            actions.add(t1);
            if(title.equals("Rajasthan")) {

                switch (i) {
                    case 0:
                        productname = "Paneer Ghewar";
                        price = "Rs.600.00 per piece";
                        break;
                    case 1:
                        productname = "Bikaneri Papad";
                        price = "Rs.130.00 per 500gm";
                        break;
                    case 2:
                        productname = "Alwar Ka Kalakand";
                        price = "Rs.450.00 per Kg";
                        break;
                }
            }
             else if(title.equals("Gujarat")) {
                switch (i) {
                    case 0:
                        productname = "Gujrati Khakra";
                        price = "Rs.160.00 for 100 pieces";

                        break;
                    case 1:
                        productname = "Halwasn Pak";
                        price = "Rs.340.00 per KG";

                        break;
                    case 2:
                        productname = "Coming Soon";
                        price = "This one is going to be more delicious! ";

                        break;
                }
            }
            else if(title.equals("Maharashtra")) {

                switch (i) {
                    case 0:
                        productname = "Bombay Ice Halwa";
                        price = "Rs.700.00 per KG";

                        break;
                    case 1:
                        productname = "Bhakarwadi";
                        price = "Rs.260.00 per KG";

                        break;
                    case 2:
                        productname = "Chivda";
                        price = "Rs.310.00 per KG";

                        break;
                }
            }
            else if(title.equals("Haryana")) {
                switch (i) {
                    case 0:
                        productname = "Sweet Lime Pachranga Achaar";
                        price = "Rs.1,150.00 per KG";

                        break;
                    case 1:
                        productname = "Mango Pachranga Achaar";
                        price = "Rs.720.00 per KG";

                        break;
                    case 2:
                        productname = "Mixed Pachranga Achar";
                        price = "Rs.1200.00 per KG";

                        break;
                }
            }
            else if(title.equals("Uttar Pradesh")) {
                switch (i) {
                    case 0:
                        productname = "Kesar Angoori Petha";
                        price = "Rs.500.00 per KG";

                        break;
                    case 1:
                        productname = "Coming Soon";
                        price = "This one is made for your Craving!";

                        break;
                    case 2:
                        productname = "Coming Soon";
                        price = "The one you desire!! ";

                        break;
                }

            }
            else if(title.equals("Jammu and Kashmir")) {

                switch (i) {
                    case 0:
                        productname = "Kashmiri Chikki";
                        price = "Rs.600.00 per KG";

                        break;
                    case 1:
                        productname = "Coming Soon!";
                        price = "You are going to love this!!";

                        break;
                    case 2:
                        productname = "Coming soon";
                        price = "Perfect for your Taste buds!!";

                        break;
                }
            }
            else if(title.equals("Karnataka")) {

                switch (i) {
                    case 0:
                        productname = "Mysore Pak";
                        price = "Rs.400.00 per KG";

                        break;
                    case 1:
                        productname = "Coming Soon";
                        price = "This one is going to be your favourite!!";

                        break;
                    case 2:
                        productname = "Coming Soon";
                        price = "Ahha! You will love this too!!";

                        break;
                }
            }
            else if(title.equals("Andhra Pradesh")) {

                switch (i) {
                    case 0:
                        productname = "Fruit Biscuits";
                        price = "Rs.140.00 for 400 gm";

                        break;
                    case 1:
                        productname = "Coming Soon!";
                        price = "We will deliver it right at your doorstep!! ";

                        break;
                    case 2:
                        productname = "Coming Soon!";
                        price = "A fresh and luscious dish for you!!";

                        break;
                }
            }
            else if(title.equals("Kerela")) {

                switch (i) {
                    case 0:
                        productname = " Coming Soon! ";
                        price = "The Delicacies Of Kerela";

                        break;
                    case 1:
                        productname = "Coming Soon";
                        price = "Wait will be over soon!";

                        break;
                    case 2:
                        productname = "Coming Soon";
                        price = "The Taste Of India!";

                        break;
                }
            }
            else if(title.equals("Madhya Pradesh")) {

                switch (i) {
                    case 0:
                        productname = "Ratlami Sev";
                        price = "Rs.400.00 per KG";

                        break;
                    case 1:
                        productname = "Coming Soon!";
                        price = "Taste The Heart Of India!!";

                        break;
                    case 2:
                        productname = "Coming Soon!";
                        price = "This One Is Going To Steal Your Heart!!";

                        break;
                }
            }
            //Create a Card, set the title over the image and set the thumbnail
            MaterialLargeImageCard card =
                    MaterialLargeImageCard.with(this)
                            .setTextOverImage(productname)
                            .setTitle("")
                            .setSubTitle(price)
                            .useDrawableId(pimage[i])
                            .setupSupplementalActions(R.layout.products_supplimental_actions_layout, actions)
                            .build();

            card.setOnClickListener(new Card.OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    Toast.makeText(Products.this," Click on ActionArea ",Toast.LENGTH_SHORT).show();
                }
            });

            card.build();
            cards.add(card);

        }
        return cards;
    }



    private void updateAdapter(ArrayList<Card> cards) {
        if (cards != null) {
            mCardArrayAdapter.addAll(cards);
        }
    }

    class LoaderAsyncTask extends AsyncTask<Void, Void, ArrayList<Card>> {

        LoaderAsyncTask() {
        }

        @Override
        protected ArrayList<Card> doInBackground(Void... params) {
            //elaborate images
            //SystemClock.sleep(1000); //delay to simulate download, don't use it in a real app

            ArrayList<Card> cards = initCard();
            return cards;

        }

        @Override
        protected void onPostExecute(ArrayList<Card> cards) {
            //Update the adapter
            updateAdapter(cards);
            //displayList();
        }

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_products, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_products, container, false);

            return rootView;
        }
    }
}
