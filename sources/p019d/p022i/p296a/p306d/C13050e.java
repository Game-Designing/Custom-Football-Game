package p019d.p022i.p296a.p306d;

import android.widget.TextView;
import p019d.p022i.p296a.p297a.C13005a;
import p019d.p022i.p296a.p297a.C13007b;
import p026rx.C0120S;
import p026rx.C0120S.C0122a;
import p026rx.p027b.C0132p;

/* renamed from: d.i.a.d.e */
/* compiled from: RxTextView */
public final class C13050e {
    /* renamed from: b */
    public static C0120S<C13055j> m42504b(TextView view) {
        C13007b.m42471a(view, "view == null");
        return m42503a(view, C13005a.f39979c);
    }

    /* renamed from: a */
    public static C0120S<C13055j> m42503a(TextView view, C0132p<? super C13055j, Boolean> handled) {
        C13007b.m42471a(view, "view == null");
        C13007b.m42471a(handled, "handled == null");
        return C0120S.m634a((C0122a<T>) new C13058m<T>(view, handled));
    }

    /* renamed from: a */
    public static C0120S<C13051f> m42502a(TextView view) {
        C13007b.m42471a(view, "view == null");
        return C0120S.m634a((C0122a<T>) new C13054i<T>(view));
    }
}
