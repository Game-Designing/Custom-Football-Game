package android.support.p000v4.view;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0607c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.view.c */
/* compiled from: AccessibilityDelegateCompat */
public class C0616c {

    /* renamed from: a */
    private static final C0618b f1840a;

    /* renamed from: b */
    private static final AccessibilityDelegate f1841b = new AccessibilityDelegate();

    /* renamed from: c */
    final AccessibilityDelegate f1842c = f1840a.mo5636a(this);

    /* renamed from: android.support.v4.view.c$a */
    /* compiled from: AccessibilityDelegateCompat */
    static class C0617a extends C0618b {
        C0617a() {
        }

        /* renamed from: a */
        public AccessibilityDelegate mo5636a(C0616c compat) {
            return new C0609b(this, compat);
        }

        /* renamed from: a */
        public C0607c mo5635a(AccessibilityDelegate delegate, View host) {
            Object provider = delegate.getAccessibilityNodeProvider(host);
            if (provider != null) {
                return new C0607c(provider);
            }
            return null;
        }

        /* renamed from: a */
        public boolean mo5637a(AccessibilityDelegate delegate, View host, int action, Bundle args) {
            return delegate.performAccessibilityAction(host, action, args);
        }
    }

    /* renamed from: android.support.v4.view.c$b */
    /* compiled from: AccessibilityDelegateCompat */
    static class C0618b {
        C0618b() {
        }

        /* renamed from: a */
        public AccessibilityDelegate mo5636a(C0616c compat) {
            return new C0619d(this, compat);
        }

        /* renamed from: a */
        public C0607c mo5635a(AccessibilityDelegate delegate, View host) {
            return null;
        }

        /* renamed from: a */
        public boolean mo5637a(AccessibilityDelegate delegate, View host, int action, Bundle args) {
            return false;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1840a = new C0617a();
        } else {
            f1840a = new C0618b();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public AccessibilityDelegate mo5630a() {
        return this.f1842c;
    }

    /* renamed from: a */
    public void mo5631a(View host, int eventType) {
        f1841b.sendAccessibilityEvent(host, eventType);
    }

    /* renamed from: d */
    public void mo5634d(View host, AccessibilityEvent event) {
        f1841b.sendAccessibilityEventUnchecked(host, event);
    }

    /* renamed from: a */
    public boolean mo5632a(View host, AccessibilityEvent event) {
        return f1841b.dispatchPopulateAccessibilityEvent(host, event);
    }

    /* renamed from: c */
    public void mo4626c(View host, AccessibilityEvent event) {
        f1841b.onPopulateAccessibilityEvent(host, event);
    }

    /* renamed from: b */
    public void mo4625b(View host, AccessibilityEvent event) {
        f1841b.onInitializeAccessibilityEvent(host, event);
    }

    /* renamed from: a */
    public void mo4150a(View host, C0604b info) {
        f1841b.onInitializeAccessibilityNodeInfo(host, info.mo5610r());
    }

    /* renamed from: a */
    public boolean mo5633a(ViewGroup host, View child, AccessibilityEvent event) {
        return f1841b.onRequestSendAccessibilityEvent(host, child, event);
    }

    /* renamed from: a */
    public C0607c mo5629a(View host) {
        return f1840a.mo5635a(f1841b, host);
    }

    /* renamed from: a */
    public boolean mo5565a(View host, int action, Bundle args) {
        return f1840a.mo5637a(f1841b, host, action, args);
    }
}
