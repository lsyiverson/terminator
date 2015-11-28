package com.lsyiverson.terminator.ui.viewModel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lsyiverson.terminator.BR;

public class MainVM extends BaseObservable {
    private String text;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }
}
