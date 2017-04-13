package com.design.designpattern.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.design.designpattern.R;
import com.design.designpattern.mvp.presenter.StudentNamePresenter;
import com.design.designpattern.mvp.view.StudentNameLinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StudentNameLinearLayout nameLinearLayout = (StudentNameLinearLayout) findViewById(R.id.studentNameLinearLayout);
        StudentNamePresenter mPresenter = new StudentNamePresenter();
        mPresenter.bindView(nameLinearLayout);
    }


}
