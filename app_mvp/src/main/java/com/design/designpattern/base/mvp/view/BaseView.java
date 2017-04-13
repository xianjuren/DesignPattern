package com.design.designpattern.base.mvp.view;

import android.view.View;

import com.design.designpattern.base.mvp.presenter.BasePresenter;


/**
 * Created by Jone on 17/4/12.
 */
public interface BaseView {

    void setPresenter(BasePresenter presenter);

    View getView();

}
