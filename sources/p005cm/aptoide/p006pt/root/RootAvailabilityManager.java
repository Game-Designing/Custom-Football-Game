package p005cm.aptoide.p006pt.root;

import p026rx.C0117M;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.root.RootAvailabilityManager */
public class RootAvailabilityManager {
    private RootValueSaver rootValueSaver;

    public RootAvailabilityManager(RootValueSaver rootValueSaver2) {
        this.rootValueSaver = rootValueSaver2;
    }

    public Single<Boolean> isRootAvailable() {
        return this.rootValueSaver.isPhoneRoot();
    }

    public C0117M updateRootAvailability() {
        return this.rootValueSaver.save(RootShell.isRootAvailable());
    }
}
