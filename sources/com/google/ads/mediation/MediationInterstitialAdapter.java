package com.google.ads.mediation;

import android.app.Activity;
import com.google.ads.mediation.C8092e;
import com.google.ads.mediation.MediationServerParameters;

@Deprecated
public interface MediationInterstitialAdapter<ADDITIONAL_PARAMETERS extends C8092e, SERVER_PARAMETERS extends MediationServerParameters> extends C8082b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    void requestInterstitialAd(C8091d dVar, Activity activity, SERVER_PARAMETERS server_parameters, C8081a aVar, ADDITIONAL_PARAMETERS additional_parameters);

    void showInterstitial();
}
