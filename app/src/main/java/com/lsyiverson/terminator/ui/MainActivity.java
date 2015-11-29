package com.lsyiverson.terminator.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.lsyiverson.terminator.R;
import com.lsyiverson.terminator.databinding.MainActivityBinding;
import com.lsyiverson.terminator.ui.viewModel.MainVM;

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

        binding.fab.setOnClickListener(view -> {
            Snackbar.make(view, "Add a 'M'", Snackbar.LENGTH_SHORT)
                .setAction("Action", null).show();
            String originText = TextUtils.isEmpty(mainVM.getText()) ? "" : mainVM.getText();
            mainVM.setText(originText + "M");
        });
    }
}
