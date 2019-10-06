package p019d.p143b.p150d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.widget.ImageView;
import java.io.File;
import p019d.p143b.p144a.p147c.C7142c;
import p019d.p143b.p144a.p147c.C7209sc;

/* renamed from: d.b.d.s */
public class C7269s {

    /* renamed from: a */
    private static final Handler f14114a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static int m15812a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: a */
    public static String m15813a(Context context) {
        Bundle e = C7209sc.m15489e(context);
        if (e == null) {
            return null;
        }
        String string = e.getString("applovin.sdk.key");
        if (string == null) {
            string = "";
        }
        return string;
    }

    /* renamed from: a */
    public static void m15814a(ImageView imageView) {
        if (imageView != null) {
            Drawable drawable = imageView.getDrawable();
            if (drawable != null && (drawable instanceof BitmapDrawable)) {
                ((BitmapDrawable) drawable).getBitmap().recycle();
            }
        }
    }

    /* renamed from: a */
    public static void m15815a(ImageView imageView, Uri uri, int i) {
        m15814a(imageView);
        Bitmap a = C7209sc.m15464a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    /* renamed from: a */
    public static void m15816a(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f14114a.post(runnable);
        }
    }

    /* renamed from: a */
    public static void m15817a(Runnable runnable, long j) {
        f14114a.postDelayed(runnable, j);
    }

    /* renamed from: a */
    public static boolean m15818a(Context context, Uri uri, C7142c cVar) {
        boolean z;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            cVar.mo23080y().mo23206a();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            C7262l b = cVar.mo23049b();
            StringBuilder sb = new StringBuilder();
            sb.append("Unable to open \"");
            sb.append(uri);
            sb.append("\".");
            b.mo22917b("AppLovinSdkUtils", sb.toString(), th);
            z = false;
        }
        if (!z) {
            cVar.mo23080y().mo23208b();
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m15819a(String str) {
        return str != null && str.length() > 1;
    }
}
