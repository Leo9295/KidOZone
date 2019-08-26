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

public class slideAdapter5 extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.mipmap.makefriend1,R.mipmap.makefriend2,R.mipmap.makefriend3,R.mipmap.makefriend4};
    private String[] slide_subtitle = {
            "How to make new friends",
            "Getting Involved",
            "Getting Along",
            "Common Interests"
    };
    private String[] slide_desc = {
            "Make new friends by initiating the conversation. Smile when you greet them",
            "Involve yourself in all fun activities, talk to everyone and be approachable.",
            "Help them in their work and compliment them to get along. ",
            "Try to find the common interests between you both and talk about it"
    };

    public slideAdapter5(Context context) {
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