package p002b.p003c.p062h.p070f;

import android.support.p001v7.widget.RecyclerView.C0970a;

/* renamed from: b.c.h.f.a */
/* compiled from: AdapterListUpdateCallback */
public final class C1289a implements C1298e {

    /* renamed from: a */
    private final C0970a f4097a;

    public C1289a(C0970a adapter) {
        this.f4097a = adapter;
    }

    /* renamed from: a */
    public void mo9211a(int position, int count) {
        this.f4097a.notifyItemRangeInserted(position, count);
    }

    /* renamed from: b */
    public void mo9213b(int position, int count) {
        this.f4097a.notifyItemRangeRemoved(position, count);
    }

    /* renamed from: c */
    public void mo9214c(int fromPosition, int toPosition) {
        this.f4097a.notifyItemMoved(fromPosition, toPosition);
    }

    /* renamed from: a */
    public void mo9212a(int position, int count, Object payload) {
        this.f4097a.notifyItemRangeChanged(position, count, payload);
    }
}
