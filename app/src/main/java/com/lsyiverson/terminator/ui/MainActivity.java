package com.lsyiverson.terminator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jakewharton.rxbinding.view.RxView;
import com.lsyiverson.terminator.R;
import com.lsyiverson.terminator.databinding.MainActivityBinding;
import com.lsyiverson.terminator.ui.viewModel.MainVM;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private MainActivityBinding binding;

    private MainVM mainVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();

        mainVM = new MainVM();
        binding.setMainVM(mainVM);
    }

    private void initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setSupportActionBar(binding.toolbar);

        RxView.clicks(binding.fab)
            .throttleFirst(500, TimeUnit.MILLISECONDS)
            .subscribe(o -> showDialog());
    }

    private void showDialog() {
        new MaterialDialog.Builder(this)
            .title("input")
            .inputType(InputType.TYPE_CLASS_TEXT)
            .input("please input", null, (materialDialog, charSequence) -> mainVM.addString(charSequence))
            .onPositive((materialDialog, dialogAction) ->
                Snackbar.make(binding.fab, "Add " + materialDialog.getInputEditText().getText(), Snackbar.LENGTH_SHORT)
                    .show())
            .show();
    }
}
