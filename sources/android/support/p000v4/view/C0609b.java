package android.support.p000v4.view;

import android.os.Bundle;
import android.support.p000v4.view.p038a.C0604b;
import android.support.p000v4.view.p038a.C0607c;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.view.b */
/* compiled from: AccessibilityDelegateCompat */
class C0609b extends AccessibilityDelegate {

    /* renamed from: a */
    final /* synthetic */ C0616c f1831a;

    /* renamed from: b */
    final /* synthetic */ C0617a f1832b;

    C0609b(C0617a this$0, C0616c cVar) {
        this.f1832b = this$0;
        this.f1831a = cVar;
    }

    public boolean dispatchPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        return this.f1831a.mo5632a(host, event);
    }

    public void onInitializeAccessibilityEvent(View host, AccessibilityEvent event) {
        this.f1831a.mo4625b(host, event);
    }

    public void onInitializeAccessibilityNodeInfo(View host, AccessibilityNodeInfo info) {
        this.f1831a.mo4150a(host, C0604b.m2810a(info));
    }

    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        this.f1831a.mo4626c(host, event);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup host, View child, AccessibilityEvent event) {
        return this.f1831a.mo5633a(host, child, event);
    }

    public void sendAccessibilityEvent(View host, int eventType) {
        this.f1831a.mo5631a(host, eventType);
    }

    public void sendAccessibilityEventUnchecked(View host, AccessibilityEvent event) {
        this.f1831a.mo5634d(host, event);
    }

    public AccessibilityNodeProvider getAccessibilityNodeProvider(View host) {
        C0607c provider = this.f1831a.mo5629a(host);
        if (provider != null) {
            return (AccessibilityNodeProvider) provider.mo5617a();
        }
        return null;
    }

    public boolean performAccessibilityAction(View host, int action, Bundle args) {
        return this.f1831a.mo5565a(host, action, args);
    }
}
