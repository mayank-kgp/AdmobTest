package com.example.mayank.admobtest;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by mayank on 19/5/16.
 */
public class ToastAdListener extends AdListener {

    private Context context;
    private String errorreason;

    public ToastAdListener(Context context) {
        this.context = context;
    }

    @Override
    public void onAdLeftApplication() {
        Toast.makeText(context,"onAdLeftApplication()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdFailedToLoad(int errorCode) {
        errorreason = " ";
        switch (errorCode){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                errorreason = "Internal error";
                break;
            case  AdRequest.ERROR_CODE_INVALID_REQUEST:
                errorreason = "Invalid Request";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                errorreason = "Network Error";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                errorreason = "No Fill";
                break;
        }
        Toast.makeText(context,String.format("onAdFailedToLoad(%s)",errorreason),Toast.LENGTH_SHORT).show();

    }

    public String getErrorreason(){
        return errorreason ==null ? "" : errorreason;
    }

    @Override
    public void onAdClosed() {
        Toast.makeText(context,"onAdClosed()",Toast.LENGTH_SHORT).show();
    }



    @Override
    public void onAdOpened() {
        Toast.makeText(context,"onAdOpened()",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAdLoaded() {
        Toast.makeText(context,"onAdLoaded()",Toast.LENGTH_SHORT).show();
    }
}
