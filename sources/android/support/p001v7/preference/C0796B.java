package android.support.p001v7.preference;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.util.SparseArray;
import android.view.View;

/* renamed from: android.support.v7.preference.B */
/* compiled from: PreferenceViewHolder */
public class C0796B extends C1000w {

    /* renamed from: a */
    private final SparseArray<View> f2388a = new SparseArray<>(4);

    /* renamed from: b */
    private boolean f2389b;

    /* renamed from: c */
    private boolean f2390c;

    C0796B(View itemView) {
        super(itemView);
        this.f2388a.put(16908310, itemView.findViewById(16908310));
        this.f2388a.put(16908304, itemView.findViewById(16908304));
        this.f2388a.put(16908294, itemView.findViewById(16908294));
        SparseArray<View> sparseArray = this.f2388a;
        int i = C0802E.icon_frame;
        sparseArray.put(i, itemView.findViewById(i));
        this.f2388a.put(16908350, itemView.findViewById(16908350));
    }

    /* renamed from: a */
    public View mo6283a(int id) {
        View cachedView = (View) this.f2388a.get(id);
        if (cachedView != null) {
            return cachedView;
        }
        View v = this.itemView.findViewById(id);
        if (v != null) {
            this.f2388a.put(id, v);
        }
        return v;
    }

    /* renamed from: h */
    public boolean mo6286h() {
        return this.f2389b;
    }

    /* renamed from: a */
    public void mo6284a(boolean allowed) {
        this.f2389b = allowed;
    }

    /* renamed from: i */
    public boolean mo6287i() {
        return this.f2390c;
    }

    /* renamed from: b */
    public void mo6285b(boolean allowed) {
        this.f2390c = allowed;
    }
}
