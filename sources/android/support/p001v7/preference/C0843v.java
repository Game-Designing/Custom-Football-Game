package android.support.p001v7.preference;

import android.support.p001v7.preference.C0847y.C0851d;
import java.util.List;
import p002b.p003c.p062h.p070f.C1292d.C1293a;

/* renamed from: android.support.v7.preference.v */
/* compiled from: PreferenceGroupAdapter */
class C0843v extends C1293a {

    /* renamed from: a */
    final /* synthetic */ List f2529a;

    /* renamed from: b */
    final /* synthetic */ List f2530b;

    /* renamed from: c */
    final /* synthetic */ C0851d f2531c;

    /* renamed from: d */
    final /* synthetic */ C0844w f2532d;

    C0843v(C0844w this$0, List list, List list2, C0851d dVar) {
        this.f2532d = this$0;
        this.f2529a = list;
        this.f2530b = list2;
        this.f2531c = dVar;
    }

    /* renamed from: b */
    public int mo6489b() {
        return this.f2529a.size();
    }

    /* renamed from: a */
    public int mo6487a() {
        return this.f2530b.size();
    }

    /* renamed from: b */
    public boolean mo6490b(int oldItemPosition, int newItemPosition) {
        return this.f2531c.mo6523b((Preference) this.f2529a.get(oldItemPosition), (Preference) this.f2530b.get(newItemPosition));
    }

    /* renamed from: a */
    public boolean mo6488a(int oldItemPosition, int newItemPosition) {
        return this.f2531c.mo6522a((Preference) this.f2529a.get(oldItemPosition), (Preference) this.f2530b.get(newItemPosition));
    }
}
