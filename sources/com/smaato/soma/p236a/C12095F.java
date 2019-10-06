package com.smaato.soma.p236a;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.VideoView;
import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;

/* renamed from: com.smaato.soma.a.F */
/* compiled from: VideoChrome */
public class C12095F {

    /* renamed from: a */
    C12125n f37968a;

    /* renamed from: com.smaato.soma.a.F$a */
    /* compiled from: VideoChrome */
    class C12096a extends WebChromeClient {

        /* renamed from: a */
        protected C12108P f37969a = null;

        /* renamed from: a */
        public void mo39326a() {
            throw null;
        }

        C12096a() {
        }

        /* renamed from: b */
        public C12108P mo39328b() {
            return this.f37969a;
        }

        /* renamed from: a */
        public void mo39327a(C12108P delegate) {
            this.f37969a = delegate;
        }
    }

    /* renamed from: com.smaato.soma.a.F$b */
    /* compiled from: VideoChrome */
    class C12097b extends C12096a implements OnCompletionListener, OnErrorListener {
        /* access modifiers changed from: private */

        /* renamed from: c */
        public CustomViewCallback f37971c = null;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public VideoView f37972d = null;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public FrameLayout f37973e = null;

        C12097b() {
            super();
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public FrameLayout m39895a(View view) {
            C12146d.m39966a((Object) new C12099G(this));
            return (FrameLayout) view.getRootView().findViewById(16908290);
        }

        /* renamed from: a */
        public void mo39326a() {
            C12146d.m39966a((Object) new C12100H(this));
            if (this.f37972d != null) {
                C12146d.m39965a(new C12147e("VideoChromeClient", "closeVideo", 1, C12143a.DEBUG));
                this.f37972d.stopPlayback();
                this.f37973e.removeView(this.f37972d);
                this.f37971c.onCustomViewHidden();
                this.f37972d = null;
            }
        }

        public void onShowCustomView(View v, CustomViewCallback callback) {
            C12146d.m39966a((Object) new C12101I(this));
            super.onShowCustomView(v, callback);
            new C12104L(this, callback, v, this).execute();
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public View m39900c() {
            return C12095F.this.f37968a.mo39361l();
        }

        public void onCompletion(MediaPlayer mp) {
            new C12105M(this).execute();
        }

        public boolean onError(MediaPlayer mp, int what, int extra) {
            return ((Boolean) new C12106N(this).execute()).booleanValue();
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            StringBuilder sb = new StringBuilder();
            sb.append("JSAlert ");
            sb.append(message);
            C12146d.m39965a(new C12147e("Javascript", sb.toString(), 1, C12143a.INFO));
            return super.onJsAlert(view, url, message, result);
        }

        public void onCloseWindow(WebView window) {
            super.onCloseWindow(window);
        }

        public void onReceivedTitle(WebView view, String title) {
            C12108P p = this.f37969a;
            if (p != null) {
                p.mo39243a(title);
            }
        }

        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            new C12107O(this, view, newProgress).execute();
        }
    }

    /* renamed from: com.smaato.soma.a.F$c */
    /* compiled from: VideoChrome */
    class C12098c implements OnCompletionListener, OnErrorListener {
    }

    public C12095F(C12125n mBannerPackage) {
        this.f37968a = mBannerPackage;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C12096a mo39325a() {
        return new C12097b();
    }
}
