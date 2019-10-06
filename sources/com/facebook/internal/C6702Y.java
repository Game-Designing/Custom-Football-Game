package com.facebook.internal;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.common.C6655a;
import com.facebook.common.C6658d;
import com.facebook.common.C6659e;
import com.facebook.share.internal.C6797g;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import org.json.JSONArray;
import p005cm.aptoide.p006pt.reviews.RateAndReviewsFragment.BundleCons;

/* renamed from: com.facebook.internal.Y */
/* compiled from: WebDialog */
public class C6702Y extends Dialog {

    /* renamed from: a */
    private static final int f12237a = C6659e.com_facebook_activity_theme;

    /* renamed from: b */
    private static volatile int f12238b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f12239c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f12240d;

    /* renamed from: e */
    private C6705c f12241e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public WebView f12242f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ProgressDialog f12243g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f12244h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public FrameLayout f12245i;

    /* renamed from: j */
    private C6706d f12246j;

    /* renamed from: k */
    private boolean f12247k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f12248l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f12249m;

    /* renamed from: n */
    private LayoutParams f12250n;

    /* renamed from: com.facebook.internal.Y$a */
    /* compiled from: WebDialog */
    public static class C6703a {

        /* renamed from: a */
        private Context f12251a;

        /* renamed from: b */
        private String f12252b;

        /* renamed from: c */
        private String f12253c;

        /* renamed from: d */
        private int f12254d;

        /* renamed from: e */
        private C6705c f12255e;

        /* renamed from: f */
        private Bundle f12256f;

        /* renamed from: g */
        private AccessToken f12257g;

        public C6703a(Context context, String action, Bundle parameters) {
            this.f12257g = AccessToken.m12820c();
            if (!AccessToken.m12821m()) {
                String applicationId = C6694S.m13437c(context);
                if (applicationId != null) {
                    this.f12252b = applicationId;
                } else {
                    throw new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                }
            }
            m13495a(context, action, parameters);
        }

        public C6703a(Context context, String applicationId, String action, Bundle parameters) {
            if (applicationId == null) {
                applicationId = C6694S.m13437c(context);
            }
            C6697T.m13462a(applicationId, "applicationId");
            this.f12252b = applicationId;
            m13495a(context, action, parameters);
        }

        /* renamed from: a */
        public C6703a mo19933a(C6705c listener) {
            this.f12255e = listener;
            return this;
        }

        /* renamed from: a */
        public C6702Y mo19934a() {
            AccessToken accessToken = this.f12257g;
            String str = BundleCons.APP_ID;
            if (accessToken != null) {
                this.f12256f.putString(str, accessToken.mo19620b());
                this.f12256f.putString("access_token", this.f12257g.mo19631k());
            } else {
                this.f12256f.putString(str, this.f12252b);
            }
            return C6702Y.m13472a(this.f12251a, this.f12253c, this.f12256f, this.f12254d, this.f12255e);
        }

        /* renamed from: b */
        public String mo19935b() {
            return this.f12252b;
        }

        /* renamed from: c */
        public Context mo19936c() {
            return this.f12251a;
        }

        /* renamed from: f */
        public int mo19939f() {
            return this.f12254d;
        }

        /* renamed from: e */
        public Bundle mo19938e() {
            return this.f12256f;
        }

        /* renamed from: d */
        public C6705c mo19937d() {
            return this.f12255e;
        }

        /* renamed from: a */
        private void m13495a(Context context, String action, Bundle parameters) {
            this.f12251a = context;
            this.f12253c = action;
            if (parameters != null) {
                this.f12256f = parameters;
            } else {
                this.f12256f = new Bundle();
            }
        }
    }

    /* renamed from: com.facebook.internal.Y$b */
    /* compiled from: WebDialog */
    private class C6704b extends WebViewClient {
        private C6704b() {
        }

        /* synthetic */ C6704b(C6702Y x0, C6698U x1) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            StringBuilder sb = new StringBuilder();
            sb.append("Redirect URL: ");
            sb.append(url);
            C6694S.m13433b("FacebookSDK.WebDialog", sb.toString());
            if (url.startsWith(C6702Y.this.f12240d)) {
                Bundle values = C6702Y.this.mo19915a(url);
                String error = values.getString("error");
                if (error == null) {
                    error = values.getString("error_type");
                }
                String errorMessage = values.getString("error_msg");
                if (errorMessage == null) {
                    errorMessage = values.getString("error_message");
                }
                if (errorMessage == null) {
                    errorMessage = values.getString("error_description");
                }
                String errorCodeString = values.getString("error_code");
                int errorCode = -1;
                if (!C6694S.m13436b(errorCodeString)) {
                    try {
                        errorCode = Integer.parseInt(errorCodeString);
                    } catch (NumberFormatException e) {
                        errorCode = -1;
                    }
                }
                if (C6694S.m13436b(error) && C6694S.m13436b(errorMessage) && errorCode == -1) {
                    C6702Y.this.mo19916a(values);
                } else if (error != null && (error.equals("access_denied") || error.equals("OAuthAccessDeniedException"))) {
                    C6702Y.this.cancel();
                } else if (errorCode == 4201) {
                    C6702Y.this.cancel();
                } else {
                    C6702Y.this.mo19918a((Throwable) new FacebookServiceException(new FacebookRequestError(errorCode, error, errorMessage), errorMessage));
                }
                return true;
            } else if (url.startsWith("fbconnect://cancel")) {
                C6702Y.this.cancel();
                return true;
            } else if (url.contains("touch")) {
                return false;
            } else {
                try {
                    C6702Y.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                    return true;
                } catch (ActivityNotFoundException e2) {
                    return false;
                }
            }
        }

        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            C6702Y.this.mo19918a((Throwable) new FacebookDialogException(description, errorCode, failingUrl));
        }

        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            handler.cancel();
            C6702Y.this.mo19918a((Throwable) new FacebookDialogException(null, -11, null));
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            StringBuilder sb = new StringBuilder();
            sb.append("Webview loading URL: ");
            sb.append(url);
            C6694S.m13433b("FacebookSDK.WebDialog", sb.toString());
            super.onPageStarted(view, url, favicon);
            if (!C6702Y.this.f12248l) {
                C6702Y.this.f12243g.show();
            }
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (!C6702Y.this.f12248l) {
                C6702Y.this.f12243g.dismiss();
            }
            C6702Y.this.f12245i.setBackgroundColor(0);
            C6702Y.this.f12242f.setVisibility(0);
            C6702Y.this.f12244h.setVisibility(0);
            C6702Y.this.f12249m = true;
        }
    }

    /* renamed from: com.facebook.internal.Y$c */
    /* compiled from: WebDialog */
    public interface C6705c {
        /* renamed from: a */
        void mo19945a(Bundle bundle, FacebookException facebookException);
    }

    /* renamed from: com.facebook.internal.Y$d */
    /* compiled from: WebDialog */
    private class C6706d extends AsyncTask<Void, Void, String[]> {

        /* renamed from: a */
        private String f12259a;

        /* renamed from: b */
        private Bundle f12260b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public Exception[] f12261c;

        C6706d(String action, Bundle parameters) {
            this.f12259a = action;
            this.f12260b = parameters;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String[] doInBackground(Void... args) {
            String[] params = this.f12260b.getStringArray("media");
            String[] results = new String[params.length];
            this.f12261c = new Exception[params.length];
            CountDownLatch latch = new CountDownLatch(params.length);
            ConcurrentLinkedQueue<GraphRequestAsyncTask> tasks = new ConcurrentLinkedQueue<>();
            AccessToken accessToken = AccessToken.m12820c();
            int i = 0;
            while (i < params.length) {
                try {
                    if (isCancelled()) {
                        Iterator it = tasks.iterator();
                        while (it.hasNext()) {
                            ((AsyncTask) it.next()).cancel(true);
                        }
                        return null;
                    }
                    Uri uri = Uri.parse(params[i]);
                    int writeIndex = i;
                    if (C6694S.m13445d(uri)) {
                        results[writeIndex] = uri.toString();
                        latch.countDown();
                    } else {
                        tasks.add(C6797g.m13856a(accessToken, uri, new C6707Z(this, results, writeIndex, latch)).mo19681c());
                    }
                    i++;
                } catch (Exception e) {
                    Iterator it2 = tasks.iterator();
                    while (it2.hasNext()) {
                        ((AsyncTask) it2.next()).cancel(true);
                    }
                    return null;
                }
            }
            latch.await();
            return results;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(String[] results) {
            Exception[] excArr;
            C6702Y.this.f12243g.dismiss();
            for (Exception e : this.f12261c) {
                if (e != null) {
                    C6702Y.this.mo19918a((Throwable) e);
                    return;
                }
            }
            String str = "Failed to stage photos for web dialog";
            if (results == null) {
                C6702Y.this.mo19918a((Throwable) new FacebookException(str));
                return;
            }
            List<String> resultList = Arrays.asList(results);
            if (resultList.contains(null)) {
                C6702Y.this.mo19918a((Throwable) new FacebookException(str));
                return;
            }
            C6694S.m13427a(this.f12260b, "media", (Object) new JSONArray(resultList));
            String b = C6690N.m13388b();
            StringBuilder sb = new StringBuilder();
            sb.append(C6787r.m13824n());
            sb.append("/");
            sb.append("dialog/");
            sb.append(this.f12259a);
            C6702Y.this.f12239c = C6694S.m13397a(b, sb.toString(), this.f12260b).toString();
            C6702Y.this.m13479b((C6702Y.this.f12244h.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
    }

    /* renamed from: a */
    protected static void m13476a(Context context) {
        if (context != null) {
            try {
                ApplicationInfo ai = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                if (!(ai == null || ai.metaData == null || f12238b != 0)) {
                    m13475a(ai.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                }
            } catch (NameNotFoundException e) {
            }
        }
    }

    /* renamed from: a */
    public static C6702Y m13472a(Context context, String action, Bundle parameters, int theme, C6705c listener) {
        m13476a(context);
        C6702Y y = new C6702Y(context, action, parameters, theme, listener);
        return y;
    }

    /* renamed from: a */
    public static int m13470a() {
        C6697T.m13468c();
        return f12238b;
    }

    /* renamed from: a */
    public static void m13475a(int theme) {
        f12238b = theme != 0 ? theme : f12237a;
    }

    protected C6702Y(Context context, String url) {
        this(context, url, m13470a());
    }

    private C6702Y(Context context, String url, int theme) {
        super(context, theme == 0 ? m13470a() : theme);
        this.f12240d = "fbconnect://success";
        this.f12247k = false;
        this.f12248l = false;
        this.f12249m = false;
        this.f12239c = url;
    }

    private C6702Y(Context context, String action, Bundle parameters, int theme, C6705c listener) {
        super(context, theme == 0 ? m13470a() : theme);
        String str = "fbconnect://success";
        this.f12240d = str;
        this.f12247k = false;
        this.f12248l = false;
        this.f12249m = false;
        if (parameters == null) {
            parameters = new Bundle();
        }
        if (C6694S.m13448e(context)) {
            str = "fbconnect://chrome_os_success";
        }
        this.f12240d = str;
        parameters.putString("redirect_uri", this.f12240d);
        parameters.putString("display", "touch");
        parameters.putString("client_id", C6787r.m13816f());
        parameters.putString("sdk", String.format(Locale.ROOT, "android-%s", new Object[]{C6787r.m13826p()}));
        this.f12241e = listener;
        if (!action.equals("share") || !parameters.containsKey("media")) {
            String b = C6690N.m13388b();
            StringBuilder sb = new StringBuilder();
            sb.append(C6787r.m13824n());
            sb.append("/");
            sb.append("dialog/");
            sb.append(action);
            this.f12239c = C6694S.m13397a(b, sb.toString(), parameters).toString();
            return;
        }
        this.f12246j = new C6706d(action, parameters);
    }

    /* renamed from: a */
    public void mo19917a(C6705c listener) {
        this.f12241e = listener;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            cancel();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void dismiss() {
        WebView webView = this.f12242f;
        if (webView != null) {
            webView.stopLoading();
        }
        if (!this.f12248l) {
            ProgressDialog progressDialog = this.f12243g;
            if (progressDialog != null && progressDialog.isShowing()) {
                this.f12243g.dismiss();
            }
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        C6706d dVar = this.f12246j;
        if (dVar == null || dVar.getStatus() != Status.PENDING) {
            mo19925e();
            return;
        }
        this.f12246j.execute(new Void[0]);
        this.f12243g.show();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        C6706d dVar = this.f12246j;
        if (dVar != null) {
            dVar.cancel(true);
            this.f12243g.dismiss();
        }
        super.onStop();
    }

    public void onDetachedFromWindow() {
        this.f12248l = true;
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        this.f12248l = false;
        if (C6694S.m13451f(getContext())) {
            LayoutParams layoutParams = this.f12250n;
            if (layoutParams != null && layoutParams.token == null) {
                layoutParams.token = getOwnerActivity().getWindow().getAttributes().token;
                StringBuilder sb = new StringBuilder();
                sb.append("Set token on onAttachedToWindow(): ");
                sb.append(this.f12250n.token);
                C6694S.m13433b("FacebookSDK.WebDialog", sb.toString());
            }
        }
        super.onAttachedToWindow();
    }

    public void onWindowAttributesChanged(LayoutParams params) {
        if (params.token == null) {
            this.f12250n = params;
        }
        super.onWindowAttributesChanged(params);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f12243g = new ProgressDialog(getContext());
        this.f12243g.requestWindowFeature(1);
        this.f12243g.setMessage(getContext().getString(C6658d.com_facebook_loading));
        this.f12243g.setCanceledOnTouchOutside(false);
        this.f12243g.setOnCancelListener(new C6698U(this));
        requestWindowFeature(1);
        this.f12245i = new FrameLayout(getContext());
        mo19925e();
        getWindow().setGravity(17);
        getWindow().setSoftInputMode(16);
        m13485f();
        if (this.f12239c != null) {
            m13479b((this.f12244h.getDrawable().getIntrinsicWidth() / 2) + 1);
        }
        this.f12245i.addView(this.f12244h, new ViewGroup.LayoutParams(-2, -2));
        setContentView(this.f12245i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo19920b(String expectedRedirectUrl) {
        this.f12240d = expectedRedirectUrl;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bundle mo19915a(String urlString) {
        Uri u = Uri.parse(urlString);
        Bundle b = C6694S.m13443d(u.getQuery());
        b.putAll(C6694S.m13443d(u.getFragment()));
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo19921c() {
        return this.f12247k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo19923d() {
        return this.f12249m;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public WebView mo19919b() {
        return this.f12242f;
    }

    /* renamed from: e */
    public void mo19925e() {
        Display display = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int i = metrics.heightPixels;
        if (width >= i) {
            width = i;
        }
        int height = metrics.widthPixels;
        int i2 = metrics.heightPixels;
        if (height < i2) {
            height = i2;
        }
        getWindow().setLayout(Math.min(m13471a(width, metrics.density, 480, 800), metrics.widthPixels), Math.min(m13471a(height, metrics.density, 800, 1280), metrics.heightPixels));
    }

    /* renamed from: a */
    private int m13471a(int screenSize, float density, int noPaddingSize, int maxPaddingSize) {
        double scaleFactor;
        int scaledSize = (int) (((float) screenSize) / density);
        if (scaledSize <= noPaddingSize) {
            scaleFactor = 1.0d;
        } else if (scaledSize >= maxPaddingSize) {
            scaleFactor = 0.5d;
        } else {
            double d = (double) (maxPaddingSize - scaledSize);
            double d2 = (double) (maxPaddingSize - noPaddingSize);
            Double.isNaN(d);
            Double.isNaN(d2);
            scaleFactor = ((d / d2) * 0.5d) + 0.5d;
        }
        double d3 = (double) screenSize;
        Double.isNaN(d3);
        return (int) (d3 * scaleFactor);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19916a(Bundle values) {
        C6705c cVar = this.f12241e;
        if (cVar != null && !this.f12247k) {
            this.f12247k = true;
            cVar.mo19945a(values, null);
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo19918a(Throwable error) {
        FacebookException facebookException;
        if (this.f12241e != null && !this.f12247k) {
            this.f12247k = true;
            if (error instanceof FacebookException) {
                facebookException = (FacebookException) error;
            } else {
                facebookException = new FacebookException(error);
            }
            this.f12241e.mo19945a(null, facebookException);
            dismiss();
        }
    }

    public void cancel() {
        if (this.f12241e != null && !this.f12247k) {
            mo19918a((Throwable) new FacebookOperationCanceledException());
        }
    }

    /* renamed from: f */
    private void m13485f() {
        this.f12244h = new ImageView(getContext());
        this.f12244h.setOnClickListener(new C6699V(this));
        this.f12244h.setImageDrawable(getContext().getResources().getDrawable(C6655a.com_facebook_close));
        this.f12244h.setVisibility(4);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetJavaScriptEnabled"})
    /* renamed from: b */
    public void m13479b(int margin) {
        LinearLayout webViewContainer = new LinearLayout(getContext());
        this.f12242f = new C6700W(this, getContext());
        this.f12242f.setVerticalScrollBarEnabled(false);
        this.f12242f.setHorizontalScrollBarEnabled(false);
        this.f12242f.setWebViewClient(new C6704b(this, null));
        this.f12242f.getSettings().setJavaScriptEnabled(true);
        this.f12242f.loadUrl(this.f12239c);
        this.f12242f.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f12242f.setVisibility(4);
        this.f12242f.getSettings().setSavePassword(false);
        this.f12242f.getSettings().setSaveFormData(false);
        this.f12242f.setFocusable(true);
        this.f12242f.setFocusableInTouchMode(true);
        this.f12242f.setOnTouchListener(new C6701X(this));
        webViewContainer.setPadding(margin, margin, margin, margin);
        webViewContainer.addView(this.f12242f);
        webViewContainer.setBackgroundColor(-872415232);
        this.f12245i.addView(webViewContainer);
    }
}
