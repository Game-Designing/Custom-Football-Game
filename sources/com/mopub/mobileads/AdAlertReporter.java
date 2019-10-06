package com.mopub.mobileads;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.widget.Toast;
import com.mopub.common.AdReport;
import com.mopub.common.util.DateAndTime;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import java.io.ByteArrayOutputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AdAlertReporter {

    /* renamed from: a */
    private final String f34638a = new SimpleDateFormat("M/d/yy hh:mm:ss a z", Locale.US).format(DateAndTime.now());

    /* renamed from: b */
    private final View f34639b;

    /* renamed from: c */
    private final Context f34640c;

    /* renamed from: d */
    private Intent f34641d;

    /* renamed from: e */
    private String f34642e;

    /* renamed from: f */
    private String f34643f;

    public AdAlertReporter(Context context, View view, AdReport adReport) {
        this.f34639b = view;
        this.f34640c = context;
        m37231b();
        String screenShotString = m37228a(m37232c());
        String str = "";
        this.f34642e = str;
        this.f34643f = str;
        if (adReport != null) {
            this.f34642e = adReport.toString();
            this.f34643f = adReport.getResponseString();
        }
        m37229a();
        m37230a(this.f34642e, this.f34643f, screenShotString);
    }

    public void send() {
        try {
            Intents.startActivity(this.f34640c, this.f34641d);
        } catch (IntentNotResolvableException e) {
            Toast.makeText(this.f34640c, "No email client available", 0).show();
        }
    }

    /* renamed from: b */
    private void m37231b() {
        this.f34641d = new Intent("android.intent.action.SENDTO");
        this.f34641d.setData(Uri.parse("mailto:creative-review@mopub.com"));
    }

    /* renamed from: c */
    private Bitmap m37232c() {
        View view = this.f34639b;
        if (view == null || view.getRootView() == null) {
            return null;
        }
        View rootView = this.f34639b.getRootView();
        boolean wasDrawingCacheEnabled = rootView.isDrawingCacheEnabled();
        rootView.setDrawingCacheEnabled(true);
        Bitmap drawingCache = rootView.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmap = Bitmap.createBitmap(drawingCache);
        rootView.setDrawingCacheEnabled(wasDrawingCacheEnabled);
        return bitmap;
    }

    /* renamed from: a */
    private String m37228a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(CompressFormat.JPEG, 25, byteArrayOutputStream);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    private void m37229a() {
        Intent intent = this.f34641d;
        StringBuilder sb = new StringBuilder();
        sb.append("New creative violation report - ");
        sb.append(this.f34638a);
        intent.putExtra("android.intent.extra.SUBJECT", sb.toString());
    }

    /* renamed from: a */
    private void m37230a(String... data) {
        StringBuilder body = new StringBuilder();
        body.append("Thank you for taking the time to tell us about your ad experience.\n\nPlease share with us how the ad experience was poor:\n\n");
        String str = "\n=================\n";
        body.append(str);
        for (int i = 0; i < data.length; i++) {
            body.append(data[i]);
            if (i != data.length - 1) {
                body.append(str);
            }
        }
        this.f34641d.putExtra("android.intent.extra.TEXT", body.toString());
    }
}
