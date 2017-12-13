package com.digiota.moviereel.ui.topfive;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

/**
 * Created by jdiamand on 11/24/17.
 */

public class TopFiveActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory{
    public TopFiveActivityViewModelFactory() {

    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        //noinspection unchecked
        return (T) new  TopFiveActivityViewModel();
    }


}
