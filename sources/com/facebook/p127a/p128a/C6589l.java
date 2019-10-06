package com.facebook.p127a.p128a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.GraphRequest;
import com.facebook.GraphRequest.C6545b;
import com.facebook.p127a.p130b.C6602h;
import com.facebook.p127a.p130b.C6603i;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Timer;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* renamed from: com.facebook.a.a.l */
/* compiled from: ViewIndexer */
public class C6589l {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f11965a = C6589l.class.getCanonicalName();

    /* renamed from: b */
    private static C6589l f11966b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Handler f11967c = new Handler(Looper.getMainLooper());

    /* renamed from: d */
    private WeakReference<Activity> f11968d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Timer f11969e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f11970f = null;

    /* renamed from: com.facebook.a.a.l$a */
    /* compiled from: ViewIndexer */
    private static class C6590a implements Callable<String> {

        /* renamed from: a */
        private WeakReference<View> f11971a;

        C6590a(View rootView) {
            this.f11971a = new WeakReference<>(rootView);
        }

        public String call() {
            View view = (View) this.f11971a.get();
            if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
                return "";
            }
            Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Config.RGB_565);
            view.draw(new Canvas(bitmap));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 10, outputStream);
            return Base64.encodeToString(outputStream.toByteArray(), 2);
        }
    }

    public C6589l(Activity activity) {
        this.f11968d = new WeakReference<>(activity);
        f11966b = this;
    }

    /* renamed from: b */
    public void mo19771b() {
        Activity activity = (Activity) this.f11968d.get();
        if (activity != null) {
            C6787r.m13822l().execute(new C6586i(this, new C6585h(this, activity, activity.getClass().getSimpleName())));
        }
    }

    /* renamed from: c */
    public void mo19772c() {
        if (((Activity) this.f11968d.get()) != null) {
            Timer timer = this.f11969e;
            if (timer != null) {
                try {
                    timer.cancel();
                    this.f11969e = null;
                } catch (Exception e) {
                    Log.e(f11965a, "Error unscheduling indexing job", e);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13066a(String tree) {
        C6787r.m13822l().execute(new C6587j(this, tree));
    }

    /* renamed from: a */
    public static GraphRequest m13062a(String appIndex, AccessToken accessToken, String appId, String requestType) {
        if (appIndex == null) {
            return null;
        }
        GraphRequest postRequest = GraphRequest.m12875a(accessToken, String.format(Locale.US, "%s/app_indexing", new Object[]{appId}), (JSONObject) null, (C6545b) null);
        Bundle requestParameters = postRequest.mo19688i();
        if (requestParameters == null) {
            requestParameters = new Bundle();
        }
        requestParameters.putString("tree", appIndex);
        requestParameters.putString("app_version", C6603i.m13111c());
        requestParameters.putString("platform", "android");
        requestParameters.putString("request_type", requestType);
        if (requestType.equals("app_indexing")) {
            requestParameters.putString("device_session_id", C6602h.m13101m());
        }
        postRequest.mo19675a(requestParameters);
        postRequest.mo19677a((C6545b) new C6588k());
        return postRequest;
    }
}
