package android.support.p001v7.preference;

import android.os.Bundle;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p001v7.widget.RecyclerView.C0970a;
import android.view.View;

/* renamed from: android.support.v7.preference.z */
/* compiled from: PreferenceRecyclerViewAccessibilityDelegate */
class C0852z extends C0616c {

    /* renamed from: d */
    final /* synthetic */ C0795A f2564d;

    C0852z(C0795A this$0) {
        this.f2564d = this$0;
    }

    /* renamed from: a */
    public void mo4150a(View host, C0604b info) {
        this.f2564d.f2386g.mo4150a(host, info);
        int position = this.f2564d.f2385f.mo7583f(host);
        C0970a adapter = this.f2564d.f2385f.getAdapter();
        if (adapter instanceof C0844w) {
            Preference preference = ((C0844w) adapter).getItem(position);
            if (preference != null) {
                preference.mo6346a(info);
            }
        }
    }

    /* renamed from: a */
    public boolean mo5565a(View host, int action, Bundle args) {
        return this.f2564d.f2386g.mo5565a(host, action, args);
    }
}
