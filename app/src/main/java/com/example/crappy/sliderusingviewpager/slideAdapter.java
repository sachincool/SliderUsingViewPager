package com.example.crappy.sliderusingviewpager;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by crappy on 21/11/17.
 */

public class slideAdapter extends PagerAdapter{
    Context context;
    LayoutInflater inflater;
    // List of images
    public int[] lst_images={R.drawable.image_1,R.drawable.image_2,R.drawable.image_3,R.drawable.image_4};
    //list of titles
    public String[] lst_title={
    "Cosmonaut","Satelite","Galaxy","Rocket"
        };
    // list of descriptions
    public String[] lst_description={"Description1","Description 2","Description 3","Descriotion 4"};

    public slideAdapter(Context context) {
        this.context = context;
    }

    // list of background colors
    public int[] lst_backgroundcolor={
            Color.rgb(55,55,55),Color.rgb(239,85,85),Color.rgb(110,49,89),Color.rgb(1,188,212)

    };
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        inflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.slide,container,false);
        LinearLayout slidelayout=view.findViewById(R.id.slidelinearlayout);
        ImageView slideimageview=view.findViewById(R.id.slideImage);
        TextView slidetxttitle=view.findViewById(R.id.slidetitle);
        TextView slidedescription=view.findViewById(R.id.txtdescription);
        slidelayout.setBackgroundColor(lst_backgroundcolor[position]);
        slideimageview.setImageResource(lst_images[position]);
        slidetxttitle.setText(lst_title[position]);
        slidedescription.setText(lst_description[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
container.removeView((LinearLayout)object);    }
}
