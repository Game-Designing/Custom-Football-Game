package com.smaato.soma.p258g;

import android.content.Context;
import android.graphics.Rect;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import com.smaato.soma.C12142b;
import java.util.List;

/* renamed from: com.smaato.soma.g.a */
/* compiled from: CarouselGestureDetector */
class C12372a extends SimpleOnGestureListener {

    /* renamed from: a */
    private final Context f38647a;

    /* renamed from: b */
    private final HorizontalScrollView f38648b;

    /* renamed from: c */
    private final List<ImageView> f38649c;

    /* renamed from: d */
    private String f38650d;

    C12372a(Context context, HorizontalScrollView horizontalScrollView, List<ImageView> layouts) {
        this.f38647a = context;
        this.f38648b = horizontalScrollView;
        this.f38649c = layouts;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int currPosition;
        if (e1.getX() < e2.getX()) {
            currPosition = m40684b("left");
        } else {
            currPosition = m40684b("right");
        }
        HorizontalScrollView horizontalScrollView = this.f38648b;
        if (horizontalScrollView != null) {
            List<ImageView> list = this.f38649c;
            if (list != null) {
                horizontalScrollView.smoothScrollTo(((ImageView) list.get(currPosition)).getLeft(), 0);
            }
        }
        return true;
    }

    public boolean onSingleTapUp(MotionEvent e) {
        String str = this.f38650d;
        if (str != null) {
            C12142b.m39962a(str, this.f38647a);
        }
        return false;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo39844a(String clickURL) {
        this.f38650d = clickURL;
    }

    /* renamed from: b */
    private int m40684b(String direction) {
        Rect hitRect = new Rect();
        int position = 0;
        int rightCounter = 0;
        int i = 0;
        while (true) {
            List<ImageView> list = this.f38649c;
            if (list == null || i >= list.size()) {
                return position;
            }
            if (((ImageView) this.f38649c.get(i)).getLocalVisibleRect(hitRect)) {
                if (direction.equals("left")) {
                    return i;
                }
                if (direction.equals("right")) {
                    rightCounter++;
                    position = i;
                    if (rightCounter == 2) {
                        return position;
                    }
                } else {
                    continue;
                }
            }
            i++;
        }
    }
}
