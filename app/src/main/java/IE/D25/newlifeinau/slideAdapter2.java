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

public class slideAdapter2 extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.mipmap.staysafe1,R.mipmap.staysafe2,R.mipmap.staysafe3};
    private String[] slide_subtitle = {
            "Your Body",
            "Good Touch",
            "Bad Touch"
    };
    private String[] slide_desc = {
            "Your Body belongs to you, from head to toes you are the Boss, you have the power to say “NO”",
            "Hugging, patting on your back or holding your hands to make you feel safe.",
            "Touches you on the places you don’t want to be touched, you should tell someone you trust straight away."
    };

    public slideAdapter2(Context context) {
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
