package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C1000w;

/* renamed from: android.support.v7.widget.Ha */
/* compiled from: RecyclerView */
class C0940Ha implements C1069a {

    /* renamed from: a */
    final /* synthetic */ RecyclerView f2997a;

    C0940Ha(RecyclerView this$0) {
        this.f2997a = this$0;
    }

    /* renamed from: a */
    public C1000w mo7300a(int position) {
        C1000w vh = this.f2997a.mo7519a(position, true);
        if (vh != null && !this.f2997a.f3150o.mo8009c(vh.itemView)) {
            return vh;
        }
        return null;
    }

    /* renamed from: d */
    public void mo7308d(int start, int count) {
        this.f2997a.mo7525a(start, count, true);
        RecyclerView recyclerView = this.f2997a;
        recyclerView.f3163ua = true;
        recyclerView.f3157ra.f3220d += count;
    }

    /* renamed from: b */
    public void mo7304b(int positionStart, int itemCount) {
        this.f2997a.mo7525a(positionStart, itemCount, false);
        this.f2997a.f3163ua = true;
    }

    /* renamed from: a */
    public void mo7302a(int positionStart, int itemCount, Object payload) {
        this.f2997a.mo7524a(positionStart, itemCount, payload);
        this.f2997a.f3165va = true;
    }

    /* renamed from: b */
    public void mo7305b(C1070b op) {
        mo7307c(op);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public void mo7307c(C1070b op) {
        int i = op.f3539a;
        if (i == 1) {
            RecyclerView recyclerView = this.f2997a;
            recyclerView.f3166w.onItemsAdded(recyclerView, op.f3540b, op.f3542d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.f2997a;
            recyclerView2.f3166w.onItemsRemoved(recyclerView2, op.f3540b, op.f3542d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.f2997a;
            recyclerView3.f3166w.onItemsUpdated(recyclerView3, op.f3540b, op.f3542d, op.f3541c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.f2997a;
            recyclerView4.f3166w.onItemsMoved(recyclerView4, op.f3540b, op.f3542d, 1);
        }
    }

    /* renamed from: a */
    public void mo7303a(C1070b op) {
        mo7307c(op);
    }

    /* renamed from: c */
    public void mo7306c(int positionStart, int itemCount) {
        this.f2997a.mo7586f(positionStart, itemCount);
        this.f2997a.f3163ua = true;
    }

    /* renamed from: a */
    public void mo7301a(int from, int to) {
        this.f2997a.mo7591g(from, to);
        this.f2997a.f3163ua = true;
    }
}
