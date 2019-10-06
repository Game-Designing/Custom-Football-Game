package p005cm.aptoide.p006pt.actions;

import p026rx.C0120S.C0122a;
import p026rx.C14980ia;

/* renamed from: cm.aptoide.pt.actions.RequestAccessToExternalFileSystemOnSubscribe */
public class RequestAccessToExternalFileSystemOnSubscribe implements C0122a<Void> {
    private final PermissionService permissionService;

    public RequestAccessToExternalFileSystemOnSubscribe(PermissionService permissionService2) {
        this.permissionService = permissionService2;
    }

    public void call(C14980ia<? super Void> subscriber) {
        this.permissionService.requestAccessToExternalFileSystem(new C1640a(subscriber), new C1641b(subscriber));
    }

    /* renamed from: a */
    static /* synthetic */ void m6396a(C14980ia subscriber) {
        if (!subscriber.isUnsubscribed()) {
            subscriber.onNext(null);
            subscriber.onCompleted();
        }
    }
}
