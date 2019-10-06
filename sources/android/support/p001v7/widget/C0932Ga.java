package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v7.widget.Ga */
/* compiled from: RecyclerView */
class C0932Ga implements C1003b {

    /* renamed from: a */
    final /* synthetic */ RecyclerView f2985a;

    C0932Ga(RecyclerView this$0) {
        this.f2985a = this$0;
    }

    /* renamed from: a */
    public int mo7222a() {
        return this.f2985a.getChildCount();
    }

    /* renamed from: a */
    public void mo7225a(View child, int index) {
        this.f2985a.addView(child, index);
        this.f2985a.mo7534a(child);
    }

    /* renamed from: c */
    public int mo7230c(View view) {
        return this.f2985a.indexOfChild(view);
    }

    /* renamed from: c */
    public void mo7231c(int index) {
        View child = this.f2985a.getChildAt(index);
        if (child != null) {
            this.f2985a.mo7551b(child);
            child.clearAnimation();
        }
        this.f2985a.removeViewAt(index);
    }

    /* renamed from: a */
    public View mo7223a(int offset) {
        return this.f2985a.getChildAt(offset);
    }

    /* renamed from: b */
    public void mo7228b() {
        int count = mo7222a();
        for (int i = 0; i < count; i++) {
            View child = mo7223a(i);
            this.f2985a.mo7551b(child);
            child.clearAnimation();
        }
        this.f2985a.removeAllViews();
    }

    /* renamed from: b */
    public C1000w mo7227b(View view) {
        return RecyclerView.m4736j(view);
    }

    /* renamed from: a */
    public void mo7226a(View child, int index, LayoutParams layoutParams) {
        C1000w vh = RecyclerView.m4736j(child);
        if (vh != null) {
            if (vh.isTmpDetached() || vh.shouldIgnore()) {
                vh.clearTmpDetachFlag();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(vh);
                sb.append(this.f2985a.mo7625k());
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f2985a.attachViewToParent(child, index, layoutParams);
    }

    /* renamed from: b */
    public void mo7229b(int offset) {
        View view = mo7223a(offset);
        if (view != null) {
            C1000w vh = RecyclerView.m4736j(view);
            if (vh != null) {
                if (!vh.isTmpDetached() || vh.shouldIgnore()) {
                    vh.addFlags(Opcodes.ACC_NATIVE);
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("called detach on an already detached child ");
                    sb.append(vh);
                    sb.append(this.f2985a.mo7625k());
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        }
        this.f2985a.detachViewFromParent(offset);
    }

    /* renamed from: a */
    public void mo7224a(View child) {
        C1000w vh = RecyclerView.m4736j(child);
        if (vh != null) {
            vh.onEnteredHiddenState(this.f2985a);
        }
    }

    /* renamed from: d */
    public void mo7232d(View child) {
        C1000w vh = RecyclerView.m4736j(child);
        if (vh != null) {
            vh.onLeftHiddenState(this.f2985a);
        }
    }
}
