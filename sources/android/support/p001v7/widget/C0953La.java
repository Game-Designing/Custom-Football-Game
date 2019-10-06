package android.support.p001v7.widget;

import android.os.Bundle;
import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.p038a.C0604b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v7.widget.La */
/* compiled from: RecyclerViewAccessibilityDelegate */
public class C0953La extends C0616c {

    /* renamed from: d */
    final RecyclerView f3022d;

    /* renamed from: e */
    final C0616c f3023e = new C0954a(this);

    /* renamed from: android.support.v7.widget.La$a */
    /* compiled from: RecyclerViewAccessibilityDelegate */
    public static class C0954a extends C0616c {

        /* renamed from: d */
        final C0953La f3024d;

        public C0954a(C0953La recyclerViewDelegate) {
            this.f3024d = recyclerViewDelegate;
        }

        /* renamed from: a */
        public void mo4150a(View host, C0604b info) {
            super.mo4150a(host, info);
            if (!this.f3024d.mo7349c() && this.f3024d.f3022d.getLayoutManager() != null) {
                this.f3024d.f3022d.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(host, info);
            }
        }

        /* renamed from: a */
        public boolean mo5565a(View host, int action, Bundle args) {
            if (super.mo5565a(host, action, args)) {
                return true;
            }
            if (this.f3024d.mo7349c() || this.f3024d.f3022d.getLayoutManager() == null) {
                return false;
            }
            return this.f3024d.f3022d.getLayoutManager().performAccessibilityActionForItem(host, action, args);
        }
    }

    public C0953La(RecyclerView recyclerView) {
        this.f3022d = recyclerView;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public boolean mo7349c() {
        return this.f3022d.mo7628l();
    }

    /* renamed from: a */
    public boolean mo5565a(View host, int action, Bundle args) {
        if (super.mo5565a(host, action, args)) {
            return true;
        }
        if (mo7349c() || this.f3022d.getLayoutManager() == null) {
            return false;
        }
        return this.f3022d.getLayoutManager().performAccessibilityAction(action, args);
    }

    /* renamed from: a */
    public void mo4150a(View host, C0604b info) {
        super.mo4150a(host, info);
        info.mo5582a((CharSequence) RecyclerView.class.getName());
        if (!mo7349c() && this.f3022d.getLayoutManager() != null) {
            this.f3022d.getLayoutManager().onInitializeAccessibilityNodeInfo(info);
        }
    }

    /* renamed from: b */
    public void mo4625b(View host, AccessibilityEvent event) {
        super.mo4625b(host, event);
        event.setClassName(RecyclerView.class.getName());
        if ((host instanceof RecyclerView) && !mo7349c()) {
            RecyclerView rv = (RecyclerView) host;
            if (rv.getLayoutManager() != null) {
                rv.getLayoutManager().onInitializeAccessibilityEvent(event);
            }
        }
    }

    /* renamed from: b */
    public C0616c mo6282b() {
        return this.f3023e;
    }
}
