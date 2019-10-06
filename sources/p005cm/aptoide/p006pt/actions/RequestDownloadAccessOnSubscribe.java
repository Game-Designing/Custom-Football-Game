package p005cm.aptoide.p006pt.actions;

import p026rx.C0120S.C0122a;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.actions.RequestDownloadAccessOnSubscribe */
public class RequestDownloadAccessOnSubscribe implements C0122a<Void> {
    private final boolean allowDownloadOnMobileData;
    private final PermissionService permissionRequest;

    public RequestDownloadAccessOnSubscribe(PermissionService permissionRequest2, boolean allowDownloadOnMobileData2) {
        this.permissionRequest = permissionRequest2;
        this.allowDownloadOnMobileData = allowDownloadOnMobileData2;
    }

    public void call(C14980ia<? super Void> subscriber) {
        this.permissionRequest.requestDownloadAccess(new C1642c(subscriber), new C1643d(subscriber), this.allowDownloadOnMobileData);
    }

    /* renamed from: a */
    static /* synthetic */ void m6398a(C14980ia subscriber) {
        if (!subscriber.isUnsubscribed()) {
            subscriber.onNext(null);
            subscriber.onCompleted();
        }
    }
}
