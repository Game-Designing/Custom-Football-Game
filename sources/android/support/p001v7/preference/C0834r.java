package android.support.p001v7.preference;

import android.support.p001v7.preference.PreferenceGroup.C0815b;
import android.support.p001v7.widget.RecyclerView.C0970a;

/* renamed from: android.support.v7.preference.r */
/* compiled from: PreferenceFragmentCompat */
class C0834r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Preference f2516a;

    /* renamed from: b */
    final /* synthetic */ String f2517b;

    /* renamed from: c */
    final /* synthetic */ C0835s f2518c;

    C0834r(C0835s this$0, Preference preference, String str) {
        this.f2518c = this$0;
        this.f2516a = preference;
        this.f2517b = str;
    }

    public void run() {
        int position;
        C0970a adapter = this.f2518c.mList.getAdapter();
        if (adapter instanceof C0815b) {
            Preference preference = this.f2516a;
            if (preference != null) {
                position = ((C0815b) adapter).mo6403b(preference);
            } else {
                position = ((C0815b) adapter).mo6402a(this.f2517b);
            }
            if (position != -1) {
                this.f2518c.mList.mo7618i(position);
            } else {
                adapter.registerAdapterDataObserver(new C0840e(adapter, this.f2518c.mList, this.f2516a, this.f2517b));
            }
        } else if (adapter != null) {
            throw new IllegalStateException("Adapter must implement PreferencePositionCallback");
        }
    }
}
