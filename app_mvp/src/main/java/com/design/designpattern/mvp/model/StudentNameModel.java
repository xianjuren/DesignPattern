package com.design.designpattern.mvp.model;

import android.text.TextUtils;

import com.design.designpattern.base.mvp.model.BaseModel;
import com.design.designpattern.mvp.view.StudentNameLinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jone on 17/4/12.
 */
public class StudentNameModel extends BaseModel {

    public static String MODEL_KEY = "student_model";
    private List<String> mNameList;

    @Override
    public String getModelKey() {
        return MODEL_KEY;
    }


    public void requestName(String flag) {
        getStudentNameList(flag);
    }

    private void getStudentNameList(String flag) {
        if(null==mNameList){
            mNameList =new ArrayList<>(5);
        }else {
            mNameList.clear();
        }
        if(TextUtils.equals(flag, StudentNameLinearLayout.FLAG_ONE_CLASS)){
            mNameList.add("张无忌");
            mNameList.add("谢敏");
            mNameList.add("周芷若");
            mNameList.add("小昭");
            mNameList.add("谢逊");
        }else {
            mNameList.add("白百合");
            mNameList.add("杨颖");
            mNameList.add("钟丽缇");
            mNameList.add("钟欣桐");
            mNameList.add("马蓉");
        }
        setChanged();
        notifyObservers(mNameList);
    }
}
