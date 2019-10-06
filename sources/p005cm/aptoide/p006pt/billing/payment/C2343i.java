package p005cm.aptoide.p006pt.billing.payment;

import android.net.Uri;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.billing.payment.i */
/* compiled from: lambda */
public final /* synthetic */ class C2343i implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Uri f5480a;

    public /* synthetic */ C2343i(Uri uri) {
        this.f5480a = uri;
    }

    public final Object call(Object obj) {
        return Adyen.m173a(this.f5480a, (AdyenPaymentStatus) obj);
    }
}
