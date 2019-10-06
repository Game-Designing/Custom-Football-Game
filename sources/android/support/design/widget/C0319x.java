package android.support.design.widget;

import android.support.p000v4.view.C0616c;
import android.support.p000v4.view.p038a.C0604b;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.design.widget.x */
/* compiled from: CheckableImageButton */
class C0319x extends C0616c {

    /* renamed from: d */
    final /* synthetic */ CheckableImageButton f1133d;

    C0319x(CheckableImageButton this$0) {
        this.f1133d = this$0;
    }

    /* renamed from: b */
    public void mo4625b(View host, AccessibilityEvent event) {
        super.mo4625b(host, event);
        event.setChecked(this.f1133d.isChecked());
    }

    /* renamed from: a */
    public void mo4150a(View host, C0604b info) {
        super.mo4150a(host, info);
        info.mo5584a(true);
        info.mo5589b(this.f1133d.isChecked());
    }
}
