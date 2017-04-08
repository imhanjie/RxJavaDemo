package com.melodyxxx.rxjavademo;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by hanjie on 2017/4/5.
 */

public abstract class BaseObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {
        // 统一做错误判断
    }

    @Override
    public void onComplete() {

    }

}
