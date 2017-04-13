package com.example.administrator.searchview;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener
{
    String name[]={"india","america","england","japan","nepal","newzealand","russian","srilanka","canada","brazil"};
    int cflags[]={R.drawable.india,R.drawable.america,R.drawable.england,R.drawable.japan,R.drawable.nepal,R.drawable.newzealand,R.drawable.russian,R.drawable.srilanka,R.drawable.canada,R.drawable.brazil};
Toolbar toolbar;
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<Country>arrayList=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=(Toolbar)findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        int count=0;
        for (String Name : name)
        {
            arrayList.add(new Country(Name,cflags[count]));
            count++;
        }

        recyclerAdapter=new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(recyclerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
       {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
      //  searchView.setOnQueryTextListener(this);


           Log.i("onCreateOptionsMenu: ", "I made it in here");

           MenuItemCompat.setOnActionExpandListener(item,
                   new MenuItemCompat.OnActionExpandListener() {
                       @Override
                       public boolean onMenuItemActionCollapse(MenuItem item) {
                           recyclerAdapter.setFilter(mUsers);
                           Log.i("ActionCollapse: ", "Collapsed");
                           return true;
                       }
                       @Override
                       public boolean onMenuItemActionExpand(MenuItem item) {
                           Log.i("ActionExpand: ", "Expanded");
                           return true;
                       }
                   });
        return true;
    }


    @Override
    public boolean onQueryTextSubmit(String query)
    {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText)
    {
        newText=newText.toLowerCase();
        ArrayList<Country>newList=new ArrayList<>();
        for (Country country : arrayList)
        {
            String name=country.getName().toLowerCase();
            if (name.contains(newText))
                newList.add(country);


        }
        recyclerAdapter.setFilter(newList);
        return true;
    }
}
