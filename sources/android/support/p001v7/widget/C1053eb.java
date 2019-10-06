package android.support.p001v7.widget;

import android.support.p001v7.widget.RecyclerView.C0975f;
import android.support.p001v7.widget.RecyclerView.C0975f.C0978c;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.View;

/* renamed from: android.support.v7.widget.eb */
/* compiled from: SimpleItemAnimator */
public abstract class C1053eb extends C0975f {

    /* renamed from: g */
    boolean f3504g = true;

    /* renamed from: a */
    public abstract boolean mo8401a(C1000w wVar, int i, int i2, int i3, int i4);

    /* renamed from: a */
    public abstract boolean mo8402a(C1000w wVar, C1000w wVar2, int i, int i2, int i3, int i4);

    /* renamed from: f */
    public abstract boolean mo8404f(C1000w wVar);

    /* renamed from: g */
    public abstract boolean mo8405g(C1000w wVar);

    /* renamed from: a */
    public void mo8413a(boolean supportsChangeAnimations) {
        this.f3504g = supportsChangeAnimations;
    }

    /* renamed from: b */
    public boolean mo7728b(C1000w viewHolder) {
        return !this.f3504g || viewHolder.isInvalid();
    }

    /* renamed from: b */
    public boolean mo7729b(C1000w viewHolder, C0978c preLayoutInfo, C0978c postLayoutInfo) {
        int oldLeft = preLayoutInfo.f3181a;
        int oldTop = preLayoutInfo.f3182b;
        View disappearingItemView = viewHolder.itemView;
        int newLeft = postLayoutInfo == null ? disappearingItemView.getLeft() : postLayoutInfo.f3181a;
        int newTop = postLayoutInfo == null ? disappearingItemView.getTop() : postLayoutInfo.f3182b;
        if (viewHolder.isRemoved() || (oldLeft == newLeft && oldTop == newTop)) {
            return mo8405g(viewHolder);
        }
        disappearingItemView.layout(newLeft, newTop, disappearingItemView.getWidth() + newLeft, disappearingItemView.getHeight() + newTop);
        return mo8401a(viewHolder, oldLeft, oldTop, newLeft, newTop);
    }

    /* renamed from: a */
    public boolean mo7724a(C1000w viewHolder, C0978c preLayoutInfo, C0978c postLayoutInfo) {
        if (preLayoutInfo == null || (preLayoutInfo.f3181a == postLayoutInfo.f3181a && preLayoutInfo.f3182b == postLayoutInfo.f3182b)) {
            return mo8404f(viewHolder);
        }
        return mo8401a(viewHolder, preLayoutInfo.f3181a, preLayoutInfo.f3182b, postLayoutInfo.f3181a, postLayoutInfo.f3182b);
    }

    /* renamed from: c */
    public boolean mo7732c(C1000w viewHolder, C0978c preInfo, C0978c postInfo) {
        if (preInfo.f3181a == postInfo.f3181a && preInfo.f3182b == postInfo.f3182b) {
            mo8419j(viewHolder);
            return false;
        }
        return mo8401a(viewHolder, preInfo.f3181a, preInfo.f3182b, postInfo.f3181a, postInfo.f3182b);
    }

    /* renamed from: a */
    public boolean mo7725a(C1000w oldHolder, C1000w newHolder, C0978c preInfo, C0978c postInfo) {
        int toTop;
        int toLeft;
        int fromLeft = preInfo.f3181a;
        int fromTop = preInfo.f3182b;
        if (newHolder.shouldIgnore()) {
            toLeft = preInfo.f3181a;
            toTop = preInfo.f3182b;
        } else {
            toLeft = postInfo.f3181a;
            toTop = postInfo.f3182b;
        }
        return mo8402a(oldHolder, newHolder, fromLeft, fromTop, toLeft, toTop);
    }

    /* renamed from: l */
    public final void mo8421l(C1000w item) {
        mo8427r(item);
        mo7731c(item);
    }

    /* renamed from: j */
    public final void mo8419j(C1000w item) {
        mo8425p(item);
        mo7731c(item);
    }

    /* renamed from: h */
    public final void mo8417h(C1000w item) {
        mo8423n(item);
        mo7731c(item);
    }

    /* renamed from: a */
    public final void mo8412a(C1000w item, boolean oldItem) {
        mo8415c(item, oldItem);
        mo7731c(item);
    }

    /* renamed from: m */
    public final void mo8422m(C1000w item) {
        mo8428s(item);
    }

    /* renamed from: k */
    public final void mo8420k(C1000w item) {
        mo8426q(item);
    }

    /* renamed from: i */
    public final void mo8418i(C1000w item) {
        mo8424o(item);
    }

    /* renamed from: b */
    public final void mo8414b(C1000w item, boolean oldItem) {
        mo8416d(item, oldItem);
    }

    /* renamed from: s */
    public void mo8428s(C1000w item) {
    }

    /* renamed from: r */
    public void mo8427r(C1000w item) {
    }

    /* renamed from: o */
    public void mo8424o(C1000w item) {
    }

    /* renamed from: n */
    public void mo8423n(C1000w item) {
    }

    /* renamed from: q */
    public void mo8426q(C1000w item) {
    }

    /* renamed from: p */
    public void mo8425p(C1000w item) {
    }

    /* renamed from: d */
    public void mo8416d(C1000w item, boolean oldItem) {
    }

    /* renamed from: c */
    public void mo8415c(C1000w item, boolean oldItem) {
    }
}
