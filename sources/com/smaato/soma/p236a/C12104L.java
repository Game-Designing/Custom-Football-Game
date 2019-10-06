package com.smaato.soma.p236a;

import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.smaato.soma.C12398ha;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.a.L */
/* compiled from: VideoChrome */
class C12104L extends C12398ha<Void> {

    /* renamed from: a */
    final /* synthetic */ CustomViewCallback f37983a;

    /* renamed from: b */
    final /* synthetic */ View f37984b;

    /* renamed from: c */
    final /* synthetic */ C12097b f37985c;

    /* renamed from: d */
    final /* synthetic */ C12097b f37986d;

    C12104L(C12097b this$1, CustomViewCallback customViewCallback, View view, C12097b bVar) {
        this.f37986d = this$1;
        this.f37983a = customViewCallback;
        this.f37984b = view;
        this.f37985c = bVar;
    }

    public Void process() throws Exception {
        C12146d.m39965a(new C12147e("Banner Client", "onShowCustomView()", 1, C12143a.ERROR));
        this.f37986d.f37971c = this.f37983a;
        View view = this.f37984b;
        if (view instanceof FrameLayout) {
            FrameLayout frame = (FrameLayout) view;
            if (frame.getFocusedChild() instanceof VideoView) {
                this.f37986d.f37972d = (VideoView) frame.getFocusedChild();
                frame.removeView(this.f37986d.f37972d);
                C12097b bVar = this.f37986d;
                bVar.f37973e = bVar.m39895a(bVar.m39900c());
                this.f37986d.f37973e.addView(this.f37986d.f37972d);
                this.f37986d.f37972d.setOnCompletionListener(this.f37985c);
                this.f37986d.f37972d.setOnErrorListener(this.f37985c);
                this.f37986d.f37972d.setOnKeyListener(new C12103K(this));
                this.f37986d.f37972d.start();
            }
        }
        return null;
    }
}
