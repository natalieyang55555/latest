package com.dji.mediaManagerDemo;

import android.app.Application;
import android.content.Context;

import com.secneo.sdk.Helper;

import dji.sdk.base.BaseProduct;
import dji.sdk.sdkmanager.DJISDKManager;

public class VideoDecodingApplication extends Application {

    private static BaseProduct mProduct;

    public static synchronized BaseProduct getProductInstance() {
        if (null == mProduct) {
            mProduct = DJISDKManager.getInstance().getProduct();
        }
        return mProduct;
    }

    public static synchronized void updateProduct(BaseProduct product) {
        mProduct = product;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        Helper.install(VideoDecodingApplication.this);
    }
}
