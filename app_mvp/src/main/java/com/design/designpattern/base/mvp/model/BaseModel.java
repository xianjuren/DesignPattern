package com.design.designpattern.base.mvp.model;

import java.util.Observable;


/**
 * Created by Jone on 17/4/12.
 */

public abstract class BaseModel extends Observable {

    public abstract String  getModelKey();
    //当工程中同时触发大量的通知时，会导致刷新UI线程阻塞，这里需要进一步优化。
    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }
}
