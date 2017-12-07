package com.example.mohit.assignment_82;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    android.os.Handler customHandler;
    ListView list;
    String name[]=new String[]{
            "Mohit Shakya","Garima Shakya", "RamuKaka", "Rohit", "Neelam" , "Kavita","Kapil"
    } ;

    String phone[]=new String[]{
            "9808317280","9808111111", "9808222222", "9808333333", "9808444444" , "98084444444","98082222222"
    } ;
    ArrayList<CustomHandler> model= new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list= (ListView)findViewById(R.id.list);

        for(int i=0; i<name.length; i++){

            CustomHandler handler= new CustomHandler();
            handler.setName(name[i]);
            handler.setDescription("Mobile No : "+ phone[i]);
            model.add(handler);


        }


        CustomAdapter adapter= new CustomAdapter(this, model);
        list.setAdapter(adapter);

        registerForContextMenu(list);

    }

    @Override
    public void onCreateContextMenu(android.view.ContextMenu menu, View v, android.view.ContextMenu.ContextMenuInfo menuInfo)
    {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0, 1, 1, "Call");//groupId, itemId, order, title
        menu.add(0, 2, 2, "SMS");
    }




    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getItemId()==1 && item.getGroupId()==0) {

           Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9808317280"));
           try {
               startActivity(in);
           } catch (android.content.ActivityNotFoundException ex) {
               Toast.makeText(getApplicationContext(), "Could not find an activity to place the call.", Toast.LENGTH_SHORT).show();
            }


        }

        if(item.getItemId()==2 && item.getGroupId()==0) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(intent);


        }

        return true;
    }




}
