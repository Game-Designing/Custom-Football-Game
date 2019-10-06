package android.support.p000v4.view;

import android.support.p000v4.view.p038a.C0604b;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.view.d */
/* compiled from: AccessibilityDelegateCompat */
class C0619d extends AccessibilityDelegate {

    /* renamed from: a */
    final /* synthetic */ C0616c f1843a;

    /* renamed from: b */
    final /* synthetic */ C0618b f1844b;

    C0619d(C0618b this$0, C0616c cVar) {
        this.f1844b = this$0;
        this.f1843a = cVar;
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return this.f1843a.mo5632a(host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        this.f1843a.mo4625b(host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
        this.f1843a.mo4150a(host, C0604b.m2810a(info));
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        this.f1843a.mo4626c(host, event);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return this.f1843a.mo5633a(host, child, event);
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        this.f1843a.mo5631a(host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        this.f1843a.mo5634d(host, event);
    }
}
