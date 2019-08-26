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

public class slideAdapter6 extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.mipmap.wantingfit1,R.mipmap.wantingfit2};
    private String[] slide_subtitle = {
            "Feel we belong here!",
            "Make a initiative to make friends",
    };
    private String[] slide_desc = {
            "It might be really hard to fit into a new place initially, Don't worry we can help you.",
            "Sometimes it's really hard to fit into a new place, make an initiate to make friends and hang out with them.",
    };

    public slideAdapter6(Context context) {
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