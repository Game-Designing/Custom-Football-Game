package p005cm.aptoide.p006pt.database.accessors;

import p024io.realm.C13990F;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.pt.database.accessors.Ea */
/* compiled from: lambda */
public final /* synthetic */ class C2728Ea implements C0132p {

    /* renamed from: a */
    private final /* synthetic */ Integer[] f5930a;

    /* renamed from: b */
    private final /* synthetic */ long f5931b;

    /* renamed from: c */
    private final /* synthetic */ long f5932c;

    public /* synthetic */ C2728Ea(Integer[] numArr, long j, long j2) {
        this.f5930a = numArr;
        this.f5931b = j;
        this.f5932c = j2;
    }

    public final Object call(Object obj) {
        return NotificationAccessor.m241a(this.f5930a, this.f5931b, this.f5932c, (C13990F) obj);
    }
}
