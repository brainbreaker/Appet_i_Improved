package com.sunshine.bbreaker.appet_i;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import appeti.widgets.AnimatedExpandableListView;


public class Regional_Specialities extends Home {

    private AnimatedExpandableListView listView;
    private ExampleAdapter adapter;
    private ArrayList<String> groups;
    private ArrayList<ArrayList<ArrayList<String>>> childs;
    TextView bg;
    @Override
        protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regional__specialities);
        List<GroupItem> items = new ArrayList<GroupItem>();
        ChildHolder imageholder;
        imageholder= new ChildHolder();
        bg= (TextView) findViewById(R.id.textTitle);

        int bg[][]={{R.drawable.jalmahal,R.drawable.rannofkutch,R.drawable.marinedrive},
                {R.drawable.haryana,R.drawable.dallake,R.drawable.tajmahal},
                {R.drawable.mysorepalace,R.drawable.hyderabad,R.drawable.kerela},{R.drawable.madhyapradesh}
        };

        // Populate our list with groups and it's children
        for(int i = 0; i < 4; i++) {
            GroupItem item = new GroupItem();

      switch(i){

          case 0: item.title = "Western India";
          for (int j = 0; j < 3; j++)

          {
              ChildItem child = new ChildItem();

              switch(j)
              {

              case 0: child.title = "Rajasthan";
                      child.bg[0]= bg[0][0];
                      break;
              case 1: child.title = "Gujarat";

                      child.bg[0]= bg[0][1];
                      break;
              case 2: child.title = "Maharashtra";

                       child.bg[0]= bg[0][2];
                      break;
              }


              item.items.add(child);
          }
        break;
      case 1: item.title = "Northern India";
          for (int j = 0; j < 3; j++)

          {
              ChildItem child = new ChildItem();

              switch(j)
              {
                  case 0: child.title = "Haryana";
                      child.bg[1]= bg[1][0];

                      break;
                  case 1: child.title = "Jammu and Kashmir";

                      child.bg[1]= bg[1][1];
                      break;
                  case 2: child.title = "Uttar Pradesh";

                      child.bg[1]= bg[1][2];
                      break;
              }


              item.items.add(child);
          }

          break;
      case 2: item.title = "Southern India";
          for (int j = 0; j < 3; j++)

              {
              ChildItem child = new ChildItem();

              switch(j)
              {
                  case 0: child.title = "Karnataka";

                      child.bg[2]= bg[2][0];
                      break;
                  case 1: child.title = "Andhra Pradesh";

                      child.bg[2]= bg[2][1];
                      break;
                  case 2: child.title = "Kerela";

                      child.bg[2]= bg[2][2];
                      break;
              }


              item.items.add(child);
          }

          break;
      case 3: item.title = "Central India";
          for (int j = 0; j < 1; j++)

          {
              ChildItem child = new ChildItem();

              switch(j) {
                  case 0:
                      child.title = "Madhya Pradesh";
                      child.bg[3]= bg[3][0];

                      break;
              }


              item.items.add(child);
          }

          break;

      }
            items.add(item);



      }

        adapter = new ExampleAdapter(this);
        adapter.setData(items);

        listView = (AnimatedExpandableListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        // In order to show animations, we need to use a custom click handler
        // for our ExpandableListView.
        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {

            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                // We call collapseGroupWithAnimation(int) and
                // expandGroupWithAnimation(int) to animate group
                // expansion/collapse.
                if (listView.isGroupExpanded(groupPosition)) {
                    listView.collapseGroupWithAnimation(groupPosition);
                } else {
                    listView.expandGroupWithAnimation(groupPosition);
                }
                return true;
            }

        });

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Intent productintent;
               if(groupPosition==0) {

                   switch (childPosition) {
                       case 0:
                           productintent = new Intent(Regional_Specialities.this, Products.class);
                           productintent.putExtra("title", "Rajasthan");
                           Regional_Specialities.this.startActivity(productintent);


                            break;
                       case 1:

                           productintent = new Intent(Regional_Specialities.this, Products.class);
                           productintent.putExtra("title", "Gujarat");
                           Regional_Specialities.this.startActivity(productintent);
                           break;
                       case 2:

                           productintent = new Intent(Regional_Specialities.this, Products.class);
                           productintent.putExtra("title", "Maharashtra");
                           Regional_Specialities.this.startActivity(productintent);
                           break;
                   }
               }
                if(groupPosition==1) {
                    switch (childPosition) {
                        case 0:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Haryana");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                        case 1:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Jammu and Kashmir");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                        case 2:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Uttar Pradesh");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                    }
                }
                if(groupPosition==2) {
                    switch (childPosition) {
                        case 0:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Karnataka");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                        case 1:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Andhra Pradesh");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                        case 2:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Kerela");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                    }
                }
                if(groupPosition==3) {
                    switch (childPosition) {
                        case 0:

                            productintent = new Intent(Regional_Specialities.this, Products.class);
                            productintent.putExtra("title", "Madhya Pradesh");
                            Regional_Specialities.this.startActivity(productintent);
                            break;
                    }
                }
                return true;
            }
        });

}


        @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_regional__specialities, menu);
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
    private static class GroupItem {
        String title;
        List<ChildItem> items = new ArrayList<ChildItem>();
    }

    private static class ChildItem {
        String title;
        int[]  bg ={R.drawable.hawamahal, R.drawable.tajmahal, R.drawable.mysorepalace, R.drawable.madhyapradesh};

        String hint;
    }

    private static class ChildHolder {
        TextView title;
        TextView hint;
    }

    private static class GroupHolder {
        TextView title;
    }

    /**
     * Adapter for our list of {@link GroupItem}s.
     */
    private class ExampleAdapter extends AnimatedExpandableListView.AnimatedExpandableListAdapter {
        private LayoutInflater inflater;

        private List<GroupItem> items;

        public ExampleAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        public void setData(List<GroupItem> items) {
            this.items = items;
        }

        @Override
        public ChildItem getChild(int groupPosition, int childPosition) {
            return items.get(groupPosition).items.get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getRealChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder holder;

            ChildItem item = getChild(groupPosition, childPosition);
            if (convertView == null) {
                holder = new ChildHolder();
                convertView = inflater.inflate(R.layout.list_item, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);

                convertView.setTag(holder);
            } else {
                holder = (ChildHolder) convertView.getTag();
            }
            holder.title.setText(item.title);
            holder.title.setBackgroundResource(item.bg[groupPosition]);
            return convertView;
        }

        @Override
        public int getRealChildrenCount(int groupPosition) {
            return items.get(groupPosition).items.size();
        }

        @Override
        public GroupItem getGroup(int groupPosition) {
            return items.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return items.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder holder;
            GroupItem item = getGroup(groupPosition);
            if (convertView == null) {
                holder = new GroupHolder();
                convertView = inflater.inflate(R.layout.group_item, parent, false);
                holder.title = (TextView) convertView.findViewById(R.id.textTitle);
                convertView.setTag(holder);
            } else {
                holder = (GroupHolder) convertView.getTag();
            }
            holder.title.setText(item.title);

    return convertView;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int arg0, int arg1) {
            return true;
        }


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


            View rootView = inflater.inflate(R.layout.fragment_regional__specialities, container, false);

            return rootView;
        }
    }
}
