package com.fyber.inneractive.sdk.p163d;

import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;

/* renamed from: com.fyber.inneractive.sdk.d.c */
public interface C7719c extends InneractiveAdRenderer {

    /* renamed from: com.fyber.inneractive.sdk.d.c$a */
    public interface C7720a {
        void destroy();

        ViewGroup getLayout();

        void onClosedByAd(boolean z);

        void showCloseButton(boolean z);

        boolean wasDismissedByUser();
    }

    /* renamed from: a */
    void mo24233a(C7720a aVar);

    /* renamed from: a */
    boolean mo24234a();

    /* renamed from: b */
    void mo24235b();

    /* renamed from: d */
    void mo24236d();

    void destroy();

    /* renamed from: e */
    void mo24237e();

    void initialize(InneractiveAdSpot inneractiveAdSpot);

    /* renamed from: k_ */
    boolean mo24238k_();
}
