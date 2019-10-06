package p019d.p151c.p152a.p153a;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;

/* renamed from: d.c.a.a.e */
/* compiled from: ExpirationDateItemAdapter */
class C7275e implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f14146a;

    /* renamed from: b */
    final /* synthetic */ C7276f f14147b;

    C7275e(C7276f this$0, int i) {
        this.f14147b = this$0;
        this.f14146a = i;
    }

    public void onClick(View v) {
        this.f14147b.f14151d = this.f14146a;
        this.f14147b.notifyDataSetChanged();
        C7277g.m15845a(this.f14147b.getContext(), 10);
        if (this.f14147b.f14150c != null) {
            OnItemClickListener a = this.f14147b.f14150c;
            int i = this.f14146a;
            a.onItemClick(null, v, i, (long) i);
        }
    }
}
