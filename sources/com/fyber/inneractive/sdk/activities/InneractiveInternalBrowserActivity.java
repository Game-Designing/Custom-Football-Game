package com.fyber.inneractive.sdk.activities;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ZoomButtonsController;
import com.fyber.inneractive.sdk.C7636R;
import com.fyber.inneractive.sdk.util.C8006j;
import com.fyber.inneractive.sdk.util.IAlog;
import java.net.MalformedURLException;
import java.net.URL;

public class InneractiveInternalBrowserActivity extends Activity {
    public static final String URL_EXTRA = "extra_url";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static InternalBrowserListener f15165a;

    /* renamed from: b */
    private LinearLayout f15166b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public WebView f15167c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ImageButton f15168d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageButton f15169e;

    /* renamed from: f */
    private ImageButton f15170f;

    /* renamed from: g */
    private ImageButton f15171g;

    public interface InternalBrowserListener {
        void onApplicationInBackground();

        void onInternalBrowserDismissed();
    }

    public static void setInternalBrowserListener(InternalBrowserListener internalBrowserListener) {
        f15165a = internalBrowserListener;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x01cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            android.view.Window r0 = r7.getWindow()
            r1 = 2
            r0.requestFeature(r1)
            android.view.Window r0 = r7.getWindow()
            r2 = -1
            r0.setFeatureInt(r1, r2)
            super.onCreate(r8)
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x01e1 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x01e1 }
            r7.f15166b = r8     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout$LayoutParams r8 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x01e1 }
            r8.<init>(r2, r2)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r0 = r7.f15166b     // Catch:{ Exception -> 0x01e1 }
            r0.setLayoutParams(r8)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r8 = r7.f15166b     // Catch:{ Exception -> 0x01e1 }
            r0 = 1
            r8.setOrientation(r0)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r8 = r7.f15166b     // Catch:{ Exception -> 0x01e1 }
            java.lang.String r3 = "IAInternalBrowserView"
            r8.setContentDescription(r3)     // Catch:{ Exception -> 0x01e1 }
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ Exception -> 0x01e1 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams     // Catch:{ Exception -> 0x01e1 }
            r4 = -2
            r3.<init>(r2, r4)     // Catch:{ Exception -> 0x01e1 }
            r8.setLayoutParams(r3)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r3 = r7.f15166b     // Catch:{ Exception -> 0x01e1 }
            r3.addView(r8)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r3 = new android.widget.LinearLayout     // Catch:{ Exception -> 0x01e1 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x01e1 }
            r3.setId(r0)     // Catch:{ Exception -> 0x01e1 }
            android.widget.RelativeLayout$LayoutParams r4 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x01e1 }
            android.content.res.Resources r5 = r7.getResources()     // Catch:{ Exception -> 0x01e1 }
            int r6 = com.fyber.inneractive.sdk.C7636R.integer.ia_ib_toolbar_height_dp     // Catch:{ Exception -> 0x01e1 }
            int r5 = r5.getInteger(r6)     // Catch:{ Exception -> 0x01e1 }
            int r5 = com.fyber.inneractive.sdk.util.C8006j.m18072b(r5)     // Catch:{ Exception -> 0x01e1 }
            r4.<init>(r2, r5)     // Catch:{ Exception -> 0x01e1 }
            r5 = 12
            r4.addRule(r5)     // Catch:{ Exception -> 0x01e1 }
            r3.setLayoutParams(r4)     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.drawable.ia_ib_background     // Catch:{ Exception -> 0x01e1 }
            android.graphics.drawable.Drawable r4 = com.fyber.inneractive.sdk.util.C8006j.m18074c(r4)     // Catch:{ Exception -> 0x01e1 }
            com.fyber.inneractive.sdk.util.C8006j.m18071a(r3, r4)     // Catch:{ Exception -> 0x01e1 }
            r8.addView(r3)     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.drawable.ia_ib_left_arrow     // Catch:{ Exception -> 0x01e1 }
            android.graphics.drawable.Drawable r4 = com.fyber.inneractive.sdk.util.C8006j.m18074c(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.m16882a(r4)     // Catch:{ Exception -> 0x01e1 }
            r7.f15168d = r4     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.drawable.ia_ib_right_arrow     // Catch:{ Exception -> 0x01e1 }
            android.graphics.drawable.Drawable r4 = com.fyber.inneractive.sdk.util.C8006j.m18074c(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.m16882a(r4)     // Catch:{ Exception -> 0x01e1 }
            r7.f15169e = r4     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.drawable.ia_ib_refresh     // Catch:{ Exception -> 0x01e1 }
            android.graphics.drawable.Drawable r4 = com.fyber.inneractive.sdk.util.C8006j.m18074c(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.m16882a(r4)     // Catch:{ Exception -> 0x01e1 }
            r7.f15170f = r4     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.drawable.ia_ib_close     // Catch:{ Exception -> 0x01e1 }
            android.graphics.drawable.Drawable r4 = com.fyber.inneractive.sdk.util.C8006j.m18074c(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.m16882a(r4)     // Catch:{ Exception -> 0x01e1 }
            r7.f15171g = r4     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.f15168d     // Catch:{ Exception -> 0x01e1 }
            r3.addView(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.f15169e     // Catch:{ Exception -> 0x01e1 }
            r3.addView(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.f15170f     // Catch:{ Exception -> 0x01e1 }
            r3.addView(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.ImageButton r4 = r7.f15171g     // Catch:{ Exception -> 0x01e1 }
            r3.addView(r4)     // Catch:{ Exception -> 0x01e1 }
            android.webkit.WebView r3 = new android.webkit.WebView     // Catch:{ Exception -> 0x01e1 }
            r3.<init>(r7)     // Catch:{ Exception -> 0x01e1 }
            r7.f15167c = r3     // Catch:{ Exception -> 0x01e1 }
            android.webkit.WebView r3 = r7.f15167c     // Catch:{ Exception -> 0x01e1 }
            int r4 = com.fyber.inneractive.sdk.C7636R.C7637id.inneractive_webview_internal_browser     // Catch:{ Exception -> 0x01e1 }
            r3.setId(r4)     // Catch:{ Exception -> 0x01e1 }
            android.widget.RelativeLayout$LayoutParams r3 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ Exception -> 0x01e1 }
            r3.<init>(r2, r2)     // Catch:{ Exception -> 0x01e1 }
            r3.addRule(r1, r0)     // Catch:{ Exception -> 0x01e1 }
            android.webkit.WebView r1 = r7.f15167c     // Catch:{ Exception -> 0x01e1 }
            r1.setLayoutParams(r3)     // Catch:{ Exception -> 0x01e1 }
            android.webkit.WebView r1 = r7.f15167c     // Catch:{ Exception -> 0x01e1 }
            r8.addView(r1)     // Catch:{ Exception -> 0x01e1 }
            android.widget.LinearLayout r8 = r7.f15166b     // Catch:{ Exception -> 0x01e1 }
            r7.setContentView(r8)     // Catch:{ Exception -> 0x01e1 }
            android.content.Intent r8 = r7.getIntent()
            android.webkit.WebView r1 = r7.f15167c
            android.webkit.WebSettings r1 = r1.getSettings()
            r1.setJavaScriptEnabled(r0)
            r1.setSupportZoom(r0)
            r1.setBuiltInZoomControls(r0)
            r1.setUseWideViewPort(r0)
            r1.setLoadWithOverviewMode(r0)
            android.webkit.WebView r0 = r7.f15167c
            disableWebviewZoomControls(r0)
            android.webkit.WebView r0 = r7.f15167c
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$1 r1 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$1
            r1.<init>()
            r0.setWebViewClient(r1)
            android.webkit.WebView r0 = r7.f15167c
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$2 r1 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$2
            r1.<init>()
            r0.setWebChromeClient(r1)
            java.lang.String r0 = "extra_url"
            java.lang.String r8 = r8.getStringExtra(r0)
            boolean r0 = m16888b(r8)
            if (r0 == 0) goto L_0x016a
            java.lang.String r0 = "http%3A%2F%2F"
            boolean r0 = r8.startsWith(r0)
            if (r0 != 0) goto L_0x013f
            java.lang.String r0 = "https%3A%2F%2F"
            boolean r0 = r8.startsWith(r0)
            if (r0 == 0) goto L_0x012e
            goto L_0x013f
        L_0x012e:
            boolean r8 = r7.m16890c(r8)
            if (r8 == 0) goto L_0x013b
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$InternalBrowserListener r8 = f15165a
            if (r8 == 0) goto L_0x013b
            r8.onApplicationInBackground()
        L_0x013b:
            r7.finish()
            goto L_0x016f
        L_0x013f:
            java.lang.String r0 = "utf-8"
            java.lang.String r0 = java.net.URLDecoder.decode(r8, r0)     // Catch:{ Exception -> 0x0154 }
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x0154 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0154 }
            android.webkit.WebView r8 = r7.f15167c     // Catch:{ Exception -> 0x0151 }
            r8.loadUrl(r0)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0169
        L_0x0151:
            r8 = move-exception
            r8 = r0
            goto L_0x0155
        L_0x0154:
            r0 = move-exception
        L_0x0155:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to open Url: "
            r0.<init>(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            com.fyber.inneractive.sdk.util.IAlog.m18023d(r8)
            r7.finish()
        L_0x0169:
            goto L_0x016f
        L_0x016a:
            android.webkit.WebView r0 = r7.f15167c
            r0.loadUrl(r8)
        L_0x016f:
            android.widget.ImageButton r8 = r7.f15168d
            r0 = 0
            r8.setBackgroundColor(r0)
            android.widget.ImageButton r8 = r7.f15168d
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$3 r1 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$3
            r1.<init>()
            r8.setOnClickListener(r1)
            android.widget.ImageButton r8 = r7.f15168d
            java.lang.String r1 = "IABackButton"
            r8.setContentDescription(r1)
            android.widget.ImageButton r8 = r7.f15169e
            r8.setBackgroundColor(r0)
            android.widget.ImageButton r8 = r7.f15169e
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$4 r1 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$4
            r1.<init>()
            r8.setOnClickListener(r1)
            android.widget.ImageButton r8 = r7.f15169e
            java.lang.String r1 = "IAForwardButton"
            r8.setContentDescription(r1)
            android.widget.ImageButton r8 = r7.f15170f
            r8.setBackgroundColor(r0)
            android.widget.ImageButton r8 = r7.f15170f
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$5 r1 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$5
            r1.<init>()
            r8.setOnClickListener(r1)
            android.widget.ImageButton r8 = r7.f15170f
            java.lang.String r1 = "IARefreshButton"
            r8.setContentDescription(r1)
            android.widget.ImageButton r8 = r7.f15171g
            r8.setBackgroundColor(r0)
            android.widget.ImageButton r8 = r7.f15171g
            com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$6 r0 = new com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity$6
            r0.<init>()
            r8.setOnClickListener(r0)
            android.widget.ImageButton r8 = r7.f15171g
            java.lang.String r0 = "IACloseButton"
            r8.setContentDescription(r0)
            int r8 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r8 >= r0) goto L_0x01dd
            android.content.Context r8 = com.fyber.inneractive.sdk.util.C8006j.m18075n()
            android.webkit.CookieSyncManager.createInstance(r8)
            android.webkit.CookieSyncManager r8 = android.webkit.CookieSyncManager.getInstance()
            r8.startSync()
        L_0x01dd:
            com.fyber.inneractive.sdk.util.C8006j.m18079r()
            return
        L_0x01e1:
            r8 = move-exception
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (VERSION.SDK_INT < 21) {
            CookieSyncManager.getInstance().stopSync();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C8006j.m18079r();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setVisible(false);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        LinearLayout linearLayout = this.f15166b;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        WebView webView = this.f15167c;
        if (webView != null) {
            webView.destroy();
            this.f15167c = null;
        }
        super.onDestroy();
    }

    public void onBackPressed() {
        finish();
        InternalBrowserListener internalBrowserListener = f15165a;
        if (internalBrowserListener != null) {
            internalBrowserListener.onInternalBrowserDismissed();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m16888b(String str) {
        if (str.startsWith("tel:") || str.startsWith("voicemail:") || str.startsWith("sms:") || str.startsWith("mailto:") || str.startsWith("geo:") || str.startsWith("google.streetview:")) {
            return true;
        }
        try {
            new URL(str);
            return false;
        } catch (MalformedURLException e) {
            StringBuilder sb = new StringBuilder("Failed to open Url: ");
            sb.append(str);
            IAlog.m18023d(sb.toString());
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public boolean m16890c(String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            startActivity(intent);
            return true;
        } catch (ActivityNotFoundException e) {
            StringBuilder sb = new StringBuilder("Failed to start activity for ");
            sb.append(str);
            sb.append(". Please ensure that your phone can handle this intent.");
            IAlog.m18023d(sb.toString());
            return false;
        }
    }

    public static void disableWebviewZoomControls(WebView webView) {
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        if (VERSION.SDK_INT < 11) {
            try {
                ((ZoomButtonsController) webView.getClass().getMethod("getZoomButtonsController", new Class[0]).invoke(webView, null)).getContainer().setVisibility(8);
            } catch (Exception e) {
                IAlog.m18021b("Could not set zoom visibility");
            }
        } else {
            new Runnable(webView) {

                /* renamed from: a */
                final /* synthetic */ WebView f16336a;

                {
                    this.f16336a = r1;
                }

                public final void run() {
                    this.f16336a.getSettings().setDisplayZoomControls(false);
                }
            }.run();
        }
    }

    /* renamed from: a */
    private ImageButton m16882a(Drawable drawable) {
        ImageButton imageButton = new ImageButton(this);
        LayoutParams layoutParams = new LayoutParams(C8006j.m18072b(getResources().getInteger(C7636R.integer.ia_ib_button_size_dp)), C8006j.m18072b(getResources().getInteger(C7636R.integer.ia_ib_button_size_dp)), 1.0f);
        layoutParams.gravity = 16;
        imageButton.setLayoutParams(layoutParams);
        imageButton.setScaleType(ScaleType.FIT_CENTER);
        imageButton.setImageDrawable(drawable);
        return imageButton;
    }
}
