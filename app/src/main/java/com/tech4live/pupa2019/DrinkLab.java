package com.tech4live.pupa2019;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.Random;


public class DrinkLab extends AppCompatActivity {

        	    ListView listView;
        	    long selected;
				Random Number;
				int Rnumber;
	    //items to show in listview 
        	    String [] items = {"  Burger-Mojito Combo at Rs. 259\nDetailed Offer: Any veg Burger + Original Fries + Any Mojito\nOffer No: 00",
				                   "  Burger Milkshake Combo at Rs. 309\nDetailed offer: Any veg Burger+Original Fries + Milkshake(killer drink/ Superb Drink/ shake from menu\nOffer No: 01",
									"  Pizza Mojito Combo at Rs. 359\nDetailed Offer: Any veg Pizza+ Original Fries+  Any Mojito\nOffer No: 02",
									"  Burger Mojito Combo at Rs. 309( Without Double Decker) Rs. 359 (With Double Decker)\nDetailed Offer: Any non Veg Burger+Original Fries+ Mojito(Choice of any one)\nOffer No: 03",
									"  Burger-Milkshake Combo at Rs. 359( Without Double Decker) Rs. 409 (With Double Decker)\nDetailed Offer: Any non beg Burger+ original Fries+ Milkshake(Killer Drink/Superb Drink/Shake from Menu)\nOffer No: 04",
									"  Pizza-Mojito combo at Rs. 399\nDetailed Offer: Any non veg Pizza + Original Fries+ Any Mojitov\nOffer No: 05",
									"  Pizza-Milkshake Combo at Rs.409\nDetailed Offer: Any veg pizza + Original Fries+ Milkshake(Killer Drink/Superb Drink/ Shake from Menu)\nOffer No: 06",
									"  Pizza-Milkshake Combo at Rs.449\nDetailed Offer: Any  non veg Pizza + Original Fries+ Milkshake(Killer Drink/ Superb Drink/shake from menu)\nOffer No: 07"};


        	    Integer [] logo = {R.drawable.juice, R.drawable.pizzaria, R.drawable.juice, R.drawable.pizzaria, R.drawable.pizzaria,R.drawable.juice,R.drawable.pizzaria,R.drawable.juice};

        	    @Override 
	    protected void onCreate(Bundle savedInstanceState) {
        	        super.onCreate(savedInstanceState);
        	        setContentView(R.layout.activity_drink_lab);
					Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
					setSupportActionBar(myToolbar);
					myToolbar.setTitle("Drink Lab");
        
        
        	        //call the CustomAdapter constructor and pass the values you want to be shown in the listview 
        	        CustomAdapter adapter = new CustomAdapter(DrinkLab.this, items, logo);
        
        	        listView = (ListView)findViewById(R.id.listView);
        
        	        listView.setAdapter(adapter);
        
        	        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { 

        	            @Override 
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
                	                String  itemValue    = (String) listView.getItemAtPosition(position);
                	                Intent i=new Intent(DrinkLab.this,Activity_Coupan.class);
									Number = new Random();
									Rnumber = Number.nextInt(100);
									Rnumber=Rnumber+1;
									i.putExtra("position",Integer.toString(position));
									i.putExtra("name","Drink_LAB");
									i.putExtra("number",Integer.toString(Rnumber));
                					startActivity(i);
                	                Toast.makeText(DrinkLab.this, itemValue, Toast.LENGTH_SHORT).show();
                
                	            } 
	        });
        	    } 
	} 

        	//create a seperate ArrayAdapter class for your specific layout design for the listview 
        	class CustomAdapter extends ArrayAdapter<String> { 

        	    private final Context context; 
	    private final String[] items; 
	    private final Integer[] logo; 

        	    //the constructor gets the values to be shown on the listview 
        	    public CustomAdapter(Context context, String[] items, Integer[] logo) {
        	        super(context, R.layout.custom_layout, items);
        	        this.context = context;
        	        this.items = items;
        	        this.logo = logo;
        	    } 

        	    //getview method inflates the values given from the mainactivity on the custom design layout for listview and returns the layout with inflated values in it 
        	    @Override 
	    public View getView(int position, View view, ViewGroup parent) {
        	        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        	        View rowView= inflater.inflate(R.layout.custom_layout, null, true);
        
        	        //initialize the textview and imageview we declared in the custom_list.xml file 
        
        	        TextView title = (TextView) rowView.findViewById(R.id.text);
        	        ImageView image = (ImageView) rowView.findViewById(R.id.image);
        
        	        title.setText(items[position]);
        
        	        image.setImageResource(logo[position]);
        
        	        return rowView;
        	    } 
	} 