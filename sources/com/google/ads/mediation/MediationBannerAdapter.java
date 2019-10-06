package com.google.ads.mediation;

import android.app.Activity;
import android.view.View;
import com.google.ads.mediation.C8092e;
import com.google.ads.mediation.MediationServerParameters;
import p019d.p271g.p272a.C12722c;

@Deprecated
public interface MediationBannerAdapter<ADDITIONAL_PARAMETERS extends C8092e, SERVER_PARAMETERS extends MediationServerParameters> extends C8082b<ADDITIONAL_PARAMETERS, SERVER_PARAMETERS> {
    View getBannerView();

    void requestBannerAd(C8083c cVar, Activity activity, SERVER_PARAMETERS server_parameters, C12722c cVar2, C8081a aVar, ADDITIONAL_PARAMETERS additional_parameters);
}
