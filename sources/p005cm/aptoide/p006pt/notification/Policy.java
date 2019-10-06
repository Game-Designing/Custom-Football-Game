package p005cm.aptoide.p006pt.notification;

import p026rx.Single;

/* renamed from: cm.aptoide.pt.notification.Policy */
public interface Policy {
    Single<Boolean> shouldShow();
}
