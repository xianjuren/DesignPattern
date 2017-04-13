package com.design.designpattern.base.mvp.model;

import android.graphics.Rect;

import com.design.designpattern.mvp.model.StudentNameModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jone on 17/4/12.
 */

public class ModelFactory {

    static ModelFactory mFactory;

    Map<String,BaseModel> mModelMap =new HashMap<>();

    public static synchronized ModelFactory getInstance() {
        if (mFactory == null) {
            mFactory = new ModelFactory();
        }
        return mFactory;
    }

   //添加Model到map中。

    public StudentNameModel getStudentNameModel(){
        BaseModel baseModel =mModelMap.get(StudentNameModel.MODEL_KEY);
        StudentNameModel studentNameModel ;
        if(baseModel==null){
            studentNameModel =new StudentNameModel();
            mModelMap.put(StudentNameModel.MODEL_KEY,studentNameModel);
        }else {
            studentNameModel= (StudentNameModel) baseModel;
        }
        return studentNameModel;
    }
}
