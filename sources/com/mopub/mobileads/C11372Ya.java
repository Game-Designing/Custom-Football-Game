package com.mopub.mobileads;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Utils;
import com.mopub.network.Networking;

/* renamed from: com.mopub.mobileads.Ya */
/* compiled from: VastWebView */
class C11372Ya extends BaseWebView {

    /* renamed from: c */
    C11373a f35185c;

    /* renamed from: com.mopub.mobileads.Ya$a */
    /* compiled from: VastWebView */
    interface C11373a {
        void onVastWebViewClick();
    }

    /* renamed from: com.mopub.mobileads.Ya$b */
    /* compiled from: VastWebView */
    class C11374b implements OnTouchListener {

        /* renamed from: a */
        private boolean f35186a;

        C11374b() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            int action = event.getAction();
            if (action == 0) {
                this.f35186a = true;
            } else if (action != 1 || !this.f35186a) {
                return false;
            } else {
                this.f35186a = false;
                C11373a aVar = C11372Ya.this.f35185c;
                if (aVar != null) {
                    aVar.onVastWebViewClick();
                }
            }
            return false;
        }
    }

    C11372Ya(Context context) {
        super(context);
        m37736c();
        getSettings().setJavaScriptEnabled(true);
        enablePlugins(true);
        setBackgroundColor(0);
        setOnTouchListener(new C11374b());
        setId((int) Utils.generateUniqueId());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37433a(String data) {
        StringBuilder sb = new StringBuilder();
        sb.append(Networking.getBaseUrlScheme());
        sb.append("://");
        sb.append(Constants.HOST);
        sb.append("/");
        loadDataWithBaseURL(sb.toString(), data, "text/html", "utf-8", null);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo37432a(C11373a vastWebViewClickListener) {
        this.f35185c = vastWebViewClickListener;
    }

    /* renamed from: c */
    private void m37736c() {
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        getSettings().setSupportZoom(false);
        setScrollBarStyle(0);
    }

    /* renamed from: a */
    static C11372Ya m37735a(Context context, C11321Ja vastResource) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(vastResource);
        C11372Ya webView = new C11372Ya(context);
        vastResource.initializeWebView(webView);
        return webView;
    }
}
