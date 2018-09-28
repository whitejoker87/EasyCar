package ru.orehovai.easycar.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import ru.orehovai.easycar.model.TrainingSlide;

public class TrainingViewModel extends ViewModel {
    private final MutableLiveData<List<TrainingSlide>> listSlides = new MutableLiveData<List<TrainingSlide>>();

    public void setListSlides(List<TrainingSlide> list) {
        listSlides.setValue(list);
    }

    public LiveData<List<TrainingSlide>> getListSlides() {
        return listSlides;
    }
}
