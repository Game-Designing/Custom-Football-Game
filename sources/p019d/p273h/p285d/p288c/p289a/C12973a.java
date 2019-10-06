package p019d.p273h.p285d.p288c.p289a;

import com.moat.analytics.mobile.iro.TrackerListener;

/* renamed from: d.h.d.c.a.a */
/* compiled from: MOATManager */
class C12973a implements TrackerListener {
    C12973a() {
    }

    public void onTrackingStarted(String s) {
        if (C12974b.f39930b != null) {
            C12974b.f39930b.onTrackingStarted(s);
        }
    }

    public void onTrackingFailedToStart(String s) {
        if (C12974b.f39930b != null) {
            C12974b.f39930b.onTrackingFailedToStart(s);
        }
    }

    public void onTrackingStopped(String s) {
        if (C12974b.f39930b != null) {
            C12974b.f39930b.onTrackingStopped(s);
        }
    }
}
