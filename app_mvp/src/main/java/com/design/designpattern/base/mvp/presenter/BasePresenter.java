package com.design.designpattern.base.mvp.presenter;


import com.design.designpattern.base.mvp.model.BaseModel;
import com.design.designpattern.base.mvp.view.BaseView;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Jone on 17/4/12.
 */

public class BasePresenter<T extends BaseView> implements Observer {

    Map<String, BaseModel> mModelMap;
    T mView;

    public BasePresenter() {
        mModelMap = getModel();
        if (null != mModelMap && mModelMap.size() > 0) {
            for (BaseModel model : mModelMap.values()) {
                model.addObserver(this);
            }
        }
    }

    public Map<String, BaseModel> getModel() {
        return null;
    }

    public void bindView(T view) {
        mView = view;
        view.setPresenter(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if (mView == null) {
            if (null != mModelMap && mModelMap.size() > 0) {
                for (BaseModel model : mModelMap.values()) {
                    model.deleteObserver(this);
                }
            }
            mModelMap.clear();
        }else {
            update((BaseModel)o,arg);
        }
    }

    public void update(BaseModel model,Object arg){

    }

}
