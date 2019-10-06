package android.support.transition;

import android.graphics.Path;

/* renamed from: android.support.transition.J */
/* compiled from: Transition */
class C0331J extends C0322A {
    C0331J() {
    }

    /* renamed from: a */
    public Path mo4721a(float startX, float startY, float endX, float endY) {
        Path path = new Path();
        path.moveTo(startX, startY);
        path.lineTo(endX, endY);
        return path;
    }
}
