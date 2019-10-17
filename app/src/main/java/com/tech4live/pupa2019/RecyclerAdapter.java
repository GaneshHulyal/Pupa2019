package com.tech4live.pupa2019;

/**
 * Created by Shade on 5/9/2016.
 */
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] titles = {"Burger-Mojito Combo at Rs. 259", "Burger Milkshake Combo at Rs. 309","Pizza Mojito Combo at Rs. 359","Burger Mojito Combo at Rs. 309( Without Double Decker) Rs. 359 (With Double Decker)","Burger-Milkshake Combo at Rs. 359( Without Double Decker) Rs. 409 (With Double Decker)", "Pizza-Mojito combo at Rs. 399", "Pizza-Milkshake Combo at Rs.409", "Pizza-Milkshake Combo at Rs.449"};

    private String[] details = {"Detailed Offer: Any veg Burger + Original Fries + Any Mojito", "Detailed offer: Any veg Burger+Original Fries + Milkshake(killer drink/ Superb Drink/ shake from menu", "Detailed Offer: Any veg Pizza+ Original Fries+  Any Mojito", "Detailed Offer: Any non Veg Burger+Original Fries+ Mojito(Choice of any one)", "Detailed Offer: Any non beg Burger+ original Fries+ Milkshake(Killer Drink/Superb Drink/Shake from Menu)", "Detailed Offer: Any non veg Pizza + Original Fries+ Any Mojito", "Detailed Offer: Any veg pizza + Original Fries+ Milkshake(Killer Drink/Superb Drink/ Shake from Menu)", "Detailed Offer: Any  non veg Pizza + Original Fries+ Milkshake(Killer Drink/ Superb Drink/shake from menu)"};

    private int[] images = { R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice,
            R.drawable.juice };

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail =
                    (TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();

                    //Snackbar.make(v, "Click detected on item " + position,
                            //Snackbar.LENGTH_LONG)
                            //.setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}