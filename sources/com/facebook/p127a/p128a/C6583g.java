package com.facebook.p127a.p128a;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.facebook.C6787r;
import com.facebook.p127a.p128a.p129a.C6566a;
import com.facebook.p127a.p128a.p129a.C6574f;
import com.facebook.p127a.p130b.C6603i;
import java.lang.ref.WeakReference;

/* renamed from: com.facebook.a.a.g */
/* compiled from: RCTCodelessLoggingEventListener */
public class C6583g {

    /* renamed from: a */
    private static final String f11952a = C6583g.class.getCanonicalName();

    /* renamed from: com.facebook.a.a.g$a */
    /* compiled from: RCTCodelessLoggingEventListener */
    public static class C6584a implements OnTouchListener {

        /* renamed from: a */
        private C6566a f11953a;

        /* renamed from: b */
        private WeakReference<View> f11954b;

        /* renamed from: c */
        private WeakReference<View> f11955c;

        /* renamed from: d */
        private OnTouchListener f11956d;

        /* renamed from: e */
        private boolean f11957e = false;

        public C6584a(C6566a mapping, View rootView, View hostView) {
            if (mapping != null && rootView != null && hostView != null) {
                this.f11956d = C6574f.m13028e(hostView);
                this.f11953a = mapping;
                this.f11954b = new WeakReference<>(hostView);
                this.f11955c = new WeakReference<>(rootView);
                this.f11957e = true;
            }
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                m13058i();
            }
            OnTouchListener onTouchListener = this.f11956d;
            if (onTouchListener == null || !onTouchListener.onTouch(view, motionEvent)) {
                return false;
            }
            return true;
        }

        /* renamed from: i */
        private void m13058i() {
            C6566a aVar = this.f11953a;
            if (aVar != null) {
                String eventName = aVar.mo19748b();
                Bundle parameters = C6579e.m13041a(this.f11953a, (View) this.f11955c.get(), (View) this.f11954b.get());
                String str = "_valueToSum";
                if (parameters.containsKey(str)) {
                    parameters.putDouble(str, C6603i.m13107a(parameters.getString(str)));
                }
                parameters.putString("_is_fb_codeless", "1");
                C6787r.m13822l().execute(new C6582f(this, eventName, parameters));
            }
        }

        /* renamed from: h */
        public boolean mo19766h() {
            return this.f11957e;
        }
    }

    /* renamed from: a */
    public static C6584a m13057a(C6566a mapping, View rootView, View hostView) {
        return new C6584a(mapping, rootView, hostView);
    }
}
