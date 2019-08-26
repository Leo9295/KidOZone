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

public class slideAdapter3 extends PagerAdapter {
    private Context context;
    private LayoutInflater layoutInflater;
    private Integer[] images = {R.mipmap.nobully1,R.mipmap.nobully2,R.mipmap.nobully3,R.mipmap.nobully4};
    private String[] slide_subtitle = {
            "What is Bullying?",
            "Not your Problem",
            "Talk to someone",
            "Be calm"
    };
    private String[] slide_desc = {
            "When someone is making you feel bad intentionally, by calling you names, swearing at you, hurting you.",
            "Its not your fault, sometimes people bully because there are having a hard time going through.",
            "Talk to your parents or teacher, always remember its not your fault. No one deserves to be bullied.",
            "Don’t hurt your bully, say “NO” to him and walk away, be calm."
    };

    public slideAdapter3(Context context) {
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
