package android.support.p000v4.widget;

import android.widget.ListView;

/* renamed from: android.support.v4.widget.o */
/* compiled from: ListViewAutoScrollHelper */
public class C0713o extends C0684a {

    /* renamed from: s */
    private final ListView f2065s;

    public C0713o(ListView target) {
        super(target);
        this.f2065s = target;
    }

    /* renamed from: a */
    public void mo5897a(int deltaX, int deltaY) {
        C0714p.m3353b(this.f2065s, deltaY);
    }

    /* renamed from: a */
    public boolean mo5898a(int direction) {
        return false;
    }

    /* renamed from: b */
    public boolean mo5900b(int direction) {
        ListView target = this.f2065s;
        int itemCount = target.getCount();
        if (itemCount == 0) {
            return false;
        }
        int childCount = target.getChildCount();
        int firstPosition = target.getFirstVisiblePosition();
        int lastPosition = firstPosition + childCount;
        if (direction > 0) {
            if (lastPosition >= itemCount && target.getChildAt(childCount - 1).getBottom() <= target.getHeight()) {
                return false;
            }
        } else if (direction >= 0) {
            return false;
        } else {
            if (firstPosition <= 0 && target.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
