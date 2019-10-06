package com.fyber.inneractive.sdk.p180ui;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.util.IAlog;

/* renamed from: com.fyber.inneractive.sdk.ui.IAgestureDetector */
public class IAgestureDetector {

    /* renamed from: a */
    public View f16274a;

    /* renamed from: b */
    Handler f16275b = new Handler();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Runnable f16276c = new Runnable() {
        public final void run() {
            IAlog.m18019a("long press detected");
            if (IAgestureDetector.this.f16277d != null) {
                IAgestureDetector.this.f16277d.mo24744h();
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Listener f16277d;

    /* renamed from: com.fyber.inneractive.sdk.ui.IAgestureDetector$Listener */
    public interface Listener {
        /* renamed from: g */
        void mo24743g();

        /* renamed from: h */
        void mo24744h();
    }

    public IAgestureDetector(View view) {
        this.f16274a = view;
    }

    public void setClickListener(Listener listener) {
        this.f16277d = listener;
    }

    /* renamed from: a */
    static /* synthetic */ void m18009a(IAgestureDetector iAgestureDetector, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            iAgestureDetector.f16275b.postDelayed(iAgestureDetector.f16276c, 6000);
        } else if (action == 1) {
            Listener listener = iAgestureDetector.f16277d;
            if (listener != null) {
                listener.mo24743g();
            } else {
                IAlog.m18019a("onClickOccurs() is not registered.");
            }
            iAgestureDetector.f16275b.removeCallbacks(iAgestureDetector.f16276c);
        } else if (action == 3) {
            iAgestureDetector.f16275b.removeCallbacks(iAgestureDetector.f16276c);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m18011c(IAgestureDetector iAgestureDetector) {
        View view = iAgestureDetector.f16274a;
        if (view != null && !view.hasFocus()) {
            iAgestureDetector.f16274a.requestFocus();
        }
    }
}
