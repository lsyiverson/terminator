package com.lsyiverson.terminator.ui.viewModel;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainVMTest {
    private MainVM mainVM;

    @Before
    public void setUp() throws Exception {
        mainVM = new MainVM();
    }

    @Test
    public void should_add_M_character_when_add_char() throws Exception {
        mainVM.addMChar();

        assertThat(mainVM.getText()).isEqualTo("M");

        mainVM.addMChar();

        assertThat(mainVM.getText()).isEqualTo("MM");
    }
}