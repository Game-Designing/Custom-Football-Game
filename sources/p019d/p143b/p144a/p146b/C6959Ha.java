package p019d.p143b.p144a.p146b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* renamed from: d.b.a.b.Ha */
class C6959Ha implements OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ C6957Ga f12898a;

    C6959Ha(C6957Ga ga) {
        this.f12898a = ga;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!view.hasFocus()) {
            view.requestFocus();
        }
        return false;
    }
}
