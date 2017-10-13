package com.cosmo.arquitecturamvpbase.presenter;

import com.cosmo.arquitecturamvpbase.helper.IValidateInternet;
import com.cosmo.arquitecturamvpbase.views.IBaseView;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class BasePresenter <T extends IBaseView>{

    private T view;
    private IValidateInternet validateInternet;


    public void inject(T view, IValidateInternet validateInternet) {
        this.view = view;
        this.validateInternet = validateInternet;
    }


    public T getView() {
        return view;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }
}
