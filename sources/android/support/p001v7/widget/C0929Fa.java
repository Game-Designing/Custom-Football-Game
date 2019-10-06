package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0975f.C0978c;
import android.support.p001v7.widget.RecyclerView.C1000w;

/* renamed from: android.support.v7.widget.Fa */
/* compiled from: RecyclerView */
class C0929Fa implements C0943b {

    /* renamed from: a */
    final /* synthetic */ RecyclerView f2979a;

    C0929Fa(RecyclerView this$0) {
        this.f2979a = this$0;
    }

    /* renamed from: b */
    public void mo7215b(C1000w viewHolder, C0978c info, C0978c postInfo) {
        this.f2979a.f3144l.mo7909c(viewHolder);
        this.f2979a.mo7550b(viewHolder, info, postInfo);
    }

    /* renamed from: a */
    public void mo7214a(C1000w viewHolder, C0978c preInfo, C0978c info) {
        this.f2979a.mo7533a(viewHolder, preInfo, info);
    }

    /* renamed from: c */
    public void mo7216c(C1000w viewHolder, C0978c preInfo, C0978c postInfo) {
        viewHolder.setIsRecyclable(false);
        RecyclerView recyclerView = this.f2979a;
        if (recyclerView.f3122N) {
            if (recyclerView.f3131W.mo7725a(viewHolder, viewHolder, preInfo, postInfo)) {
                this.f2979a.mo7680v();
            }
        } else if (recyclerView.f3131W.mo7732c(viewHolder, preInfo, postInfo)) {
            this.f2979a.mo7680v();
        }
    }

    /* renamed from: a */
    public void mo7213a(C1000w viewHolder) {
        RecyclerView recyclerView = this.f2979a;
        recyclerView.f3166w.removeAndRecycleView(viewHolder.itemView, recyclerView.f3144l);
    }
}
