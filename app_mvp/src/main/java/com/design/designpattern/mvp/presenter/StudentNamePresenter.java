package com.design.designpattern.mvp.presenter;

import android.text.TextUtils;
import android.widget.ListView;

import com.design.designpattern.base.mvp.model.BaseModel;
import com.design.designpattern.base.mvp.model.ModelFactory;
import com.design.designpattern.base.mvp.presenter.BasePresenter;
import com.design.designpattern.mvp.adapter.StudentNameAdapter;
import com.design.designpattern.mvp.model.StudentNameModel;
import com.design.designpattern.mvp.view.StudentNameLinearLayout;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by Jone on 17/4/12.
 */
public class StudentNamePresenter extends BasePresenter<StudentNameLinearLayout> {

    StudentNameAdapter mAdapter;

    @Override
    public void bindView(StudentNameLinearLayout view) {
        super.bindView(view);
        if (null != view) {
            ListView mListView = view.getListView();
            if (null != mListView) {
                mAdapter = new StudentNameAdapter();
                mListView.setAdapter(mAdapter);
            }
        }
    }

    public void requestStudentName(String flag) {
        ModelFactory.getInstance().getStudentNameModel().requestName(flag);
    }

    @Override
    public void update(BaseModel model, Object arg) {
        super.update(model, arg);
        if (TextUtils.equals(model.getModelKey(), StudentNameModel.MODEL_KEY)) {
            List<String> nameList = (List<String>) arg;
            if (null != nameList && nameList.size() > 0) {
                if (null != mAdapter) {
                    mAdapter.setAdapter(nameList);
                }
            }
        }
    }

    @Override
    public Map<String, BaseModel> getModel() {
        Map<String, BaseModel> map = new HashMap<>();
        map.put(StudentNameModel.MODEL_KEY, ModelFactory.getInstance().getStudentNameModel());
        return map;
    }
}
