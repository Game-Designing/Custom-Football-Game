package p024io.fabric.sdk.android.p348a.p353e;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import p024io.fabric.sdk.android.C13920f;
import p024io.fabric.sdk.android.C13929o;
import p024io.fabric.sdk.android.p348a.p350b.C13852l;

/* renamed from: io.fabric.sdk.android.a.e.o */
/* compiled from: IconRequest */
public class C13901o {

    /* renamed from: a */
    public final String f42164a;

    /* renamed from: b */
    public final int f42165b;

    /* renamed from: c */
    public final int f42166c;

    /* renamed from: d */
    public final int f42167d;

    public C13901o(String hash, int iconResourceId, int width, int height) {
        this.f42164a = hash;
        this.f42165b = iconResourceId;
        this.f42166c = width;
        this.f42167d = height;
    }

    /* renamed from: a */
    public static C13901o m44191a(Context context, String iconHash) {
        String str = "Fabric";
        if (iconHash == null) {
            return null;
        }
        try {
            int iconId = C13852l.m44051d(context);
            C13929o e = C13920f.m44245e();
            StringBuilder sb = new StringBuilder();
            sb.append("App icon resource ID is ");
            sb.append(iconId);
            e.mo43326c(str, sb.toString());
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(context.getResources(), iconId, options);
            return new C13901o(iconHash, iconId, options.outWidth, options.outHeight);
        } catch (Exception e2) {
            C13920f.m44245e().mo43325b(str, "Failed to load icon", e2);
            return null;
        }
    }
}
