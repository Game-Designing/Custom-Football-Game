package p005cm.aptoide.p006pt.billing;

import p026rx.C0120S;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.billing.Customer */
public interface Customer {
    Single<String> getId();

    C0120S<Boolean> isAuthenticated();
}
