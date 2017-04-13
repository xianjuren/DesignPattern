package com.design.designpattern.mvp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.design.designpattern.R;
import com.design.designpattern.base.mvp.presenter.BasePresenter;
import com.design.designpattern.base.mvp.view.BaseView;
import com.design.designpattern.mvp.presenter.StudentNamePresenter;

/**
 * Created by Jone on 17/4/12.
 */

public class StudentNameLinearLayout extends LinearLayout implements BaseView, View.OnClickListener {

    public static String FLAG_ONE_CLASS = "one", FLAG_TWO_CLASS = "two";
    TextView mOneClass, mTwoClass;
    ListView mNameList;
    StudentNamePresenter mPresenter;

    public StudentNameLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mOneClass = (TextView) findViewById(R.id.tv_one_show);
        mTwoClass = (TextView) findViewById(R.id.tv_two_show);
        mNameList = (ListView) findViewById(R.id.lv_name_list);
        mOneClass.setOnClickListener(this);
        mTwoClass.setOnClickListener(this);
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        mPresenter = (StudentNamePresenter) presenter;
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_one_show:
                if (mPresenter != null) {
                    mPresenter.requestStudentName(FLAG_ONE_CLASS);
                }
                break;

            case R.id.tv_two_show:
                if (mPresenter != null) {
                    mPresenter.requestStudentName(FLAG_TWO_CLASS);
                }
                break;
        }
    }

    public ListView getListView() {
        if(mNameList!=null){
            return mNameList;
        }
        return null;
    }
}
