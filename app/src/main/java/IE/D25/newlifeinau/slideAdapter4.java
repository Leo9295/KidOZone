package IE.D25.newlifeinau;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class slideAdapter4 extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.mipmap.lunchbox1,R.mipmap.lunchbox2,R.mipmap.lunchbox3,R.mipmap.lunchbox4};
    private String[] slide_subtitle = {
            "Fruit & Veggies",
            "Protiens",
            "Hydrating",
            "Lunch Buddy"
    };
    private String[] slide_desc = {
            "Pick a fruit you like, it helps you with nutrients, don’t forget to add some raw veggies, it completes the meal.",
            "Protein is Important, choose chicken, boiled Eggs, nuts, tuna salad, butter, lentils。",
            "Don’t forget to pack water/ drinks it keeps you hydrated.",
            "A Lunch buddy is someone who you eat lunch with every day at school, lunch time is the best to find one."
    };

    public slideAdapter4(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout1, null)
                ;
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView sliedDescription = (TextView) view.findViewById(R.id.slide_desc);
        TextView sliedSlide = (TextView) view.findViewById(R.id.slide_subtitle);

        imageView.setImageResource(images[position]);
        sliedDescription.setText(slide_desc[position]);
        sliedSlide.setText(slide_subtitle[position]);

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);
    }
}