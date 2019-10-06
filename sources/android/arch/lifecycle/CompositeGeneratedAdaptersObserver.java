package android.arch.lifecycle;

import android.arch.lifecycle.C0148d.C0000a;

public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* renamed from: a */
    private final C0147c[] f176a;

    CompositeGeneratedAdaptersObserver(C0147c[] generatedAdapters) {
        this.f176a = generatedAdapters;
    }

    /* renamed from: a */
    public void mo3724a(C0001f source, C0000a event) {
        C0157l logger = new C0157l();
        for (C0147c mGenerated : this.f176a) {
            mGenerated.mo3749a(source, event, false, logger);
        }
        for (C0147c mGenerated2 : this.f176a) {
            mGenerated2.mo3749a(source, event, true, logger);
        }
    }
}
