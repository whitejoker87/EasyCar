package ru.orehovai.easycar.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.orehovai.easycar.R;
import ru.orehovai.easycar.model.TrainingSlide;

public class TrainingViewPagerAdapter extends PagerAdapter {

//    @BindView(R.id.iv_slide)
//    ImageView ivSlide;
//    @BindView(R.id.tv_slide_title)
//    TextView tvTitleSlide;
//    @BindView(R.id.tv_slide_descr)
//    TextView tvDescrSlide;
//    @BindView(R.id.btn_slide)
//    Button btnSlide;

    private Context context;
    private List<TrainingSlide> slides;
    private int adapterPosition;
    private IOnclickBtnSlide onclickBtnSlide;

    public TrainingViewPagerAdapter(Context context, List<TrainingSlide> slides, IOnclickBtnSlide onclickBtnSlide) {
        this.context = context;
        this.slides = slides;
        this.onclickBtnSlide = onclickBtnSlide;
    }

    @Override
    public Object instantiateItem(@NonNull ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);

        adapterPosition = position;

        //String imageUrl = Media.getImageUrl(myObject.getObjectId(), images.get(position).getImageId());
        int ivId = slides.get(position).getIvTrainingID();
        String tvTitle = slides.get(position).getTvTitleTraining();
        String tvDescr = slides.get(position).getTvDescrTraining();
        String textBtn = slides.get(position).getBtnTraining();

        //ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.object_details_image, collection, false);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.slide_details, collection, false);

        //ImageView pagerImage = layout.findViewById(R.id.pagerImage);
        ImageView ivSlide = layout.findViewById(R.id.iv_slide);
        TextView tvTitleSlide = layout.findViewById(R.id.tv_slide_title);
        TextView tvDescrSlide = layout.findViewById(R.id.tv_slide_descr);
        Button btnSlide = layout.findViewById(R.id.btn_slide);


        //Media.setImageFromUrl(pagerImage, imageUrl);//call to GlideApp or Picasso to load the image into the ImageView
        ivSlide.setImageResource(ivId);
        tvTitleSlide.setText(tvTitle);
        tvDescrSlide.setText(tvDescr);
        btnSlide.setText(textBtn);

        collection.addView(layout);
        return layout;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object view) {
        container.removeView((View) view);
    }

    @Override
    public int getCount() {
        return this.slides.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @OnClick(R.id.btn_slide)
    void onClickBtnSlide() {
        Toast.makeText(context, "переход на другой фрагмент", Toast.LENGTH_LONG).show();
        onclickBtnSlide.onClickButtonCallback(adapterPosition);

    }

}
