package ru.orehovai.easycar.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ru.orehovai.easycar.R;
import ru.orehovai.easycar.model.TrainingSlide;
import ru.orehovai.easycar.viewmodel.TrainingViewModel;

public class MainActivity extends AppCompatActivity {

    TrainingViewModel model;
    TrainingFragment trainingFragment;
    LoginFragment loginFragment;

    private boolean isFirstLaunch;
    private SharedPreferences sPref;
    private static final String FIRST_LAUNCH_FLAG = "firstLaunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<TrainingSlide> slides = new ArrayList<>();
        model = ViewModelProviders.of(this).get(TrainingViewModel.class);

        TrainingSlide firstSlide = new TrainingSlide();
        firstSlide.setIvTrainingID(R.drawable.giftcard);
        firstSlide.setTvTitleTraining("Получайте бонусы за заказы");
        firstSlide.setTvDescrTraining("Мы поощряем корректный ввод артикулов на запчасти, " +
                "что облегчает и ускоряет работу нашей команды, " +
                "а Вам - новые бонусы для оплаты заказов!");
        firstSlide.setBtnTraining("Дальше");
        slides.add(firstSlide);

        TrainingSlide secondSlide = new TrainingSlide();
        secondSlide.setIvTrainingID(R.drawable.people);
        secondSlide.setTvTitleTraining("Делитесь с друзьями");
        secondSlide.setTvDescrTraining("Ваш знакомый или друг пользуется этим приложением? " +
                "спроситеу него промокод, " +
                "используя который, " +
                "Вы сможете получить бонусы! " +
                "Здесь работает эффект бумеранга!");
        secondSlide.setBtnTraining("Завершить");
        slides.add(secondSlide);

        model.setListSlides(slides);

        setContentView(R.layout.activity_main);

        loginFragment = new LoginFragment();

        sPref = getSharedPreferences("loginSavedData", MODE_PRIVATE);
        saveLaunchFlag(true);//для отладки первого запуска
        isFirstLaunch = sPref.getBoolean(FIRST_LAUNCH_FLAG, true);
        if(isFirstLaunch){
            trainingFragment = new TrainingFragment();
            setFragment(trainingFragment);
        } else setFragment(loginFragment);
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container_login, fragment);
        transaction.commit();
    }
    public void setFragment() {
        setFragment(loginFragment);
    }

    public void saveLaunchFlag(){
        SharedPreferences.Editor editor = sPref.edit();
        editor.putBoolean(FIRST_LAUNCH_FLAG, false);
        editor.apply();
    }
    public void saveLaunchFlag(boolean reset){//для отладки первого запуска
        SharedPreferences.Editor editor = sPref.edit();
        editor.putBoolean(FIRST_LAUNCH_FLAG, reset);
        editor.apply();
    }
}
