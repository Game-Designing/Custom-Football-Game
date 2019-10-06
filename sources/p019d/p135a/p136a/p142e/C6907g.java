package p019d.p135a.p136a.p142e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.FileNotFoundException;
import java.net.URL;
import p002b.p003c.p053g.p061f.C1260i;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p322a.p324b.C13187b;
import p320f.p321a.p344h.C13777b;

/* renamed from: d.a.a.e.g */
/* compiled from: AsyncImageDownloader */
public final class C6907g {

    /* renamed from: a */
    private static final String f12688a = C6907g.class.getSimpleName();

    /* renamed from: b */
    private static final C1260i<String, Bitmap> f12689b = new C1260i<>(50);

    /* renamed from: d.a.a.e.g$a */
    /* compiled from: AsyncImageDownloader */
    public interface C6908a {
        /* renamed from: a */
        void mo17708a(Bitmap bitmap, String str);
    }

    /* renamed from: a */
    public static void m14048a(Context context, C6908a imageListener, String url, Bitmap fallbackImage) {
        C13797m.create(new C6906f(context, url, fallbackImage)).subscribeOn(C13777b.m43848c()).observeOn(C13187b.m43117a()).subscribe((C13804t<? super T>) new C6905e<Object>(imageListener));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static Bitmap m14050c(Context context, String url, Bitmap fallbackImage) {
        Bitmap icon = (Bitmap) f12689b.get(url);
        if (icon != null) {
            return icon;
        }
        Bitmap icon2 = C6910i.m14052a(context, url);
        if (icon2 == null) {
            return m14049b(context, url, fallbackImage);
        }
        return icon2;
    }

    /* renamed from: b */
    private static Bitmap m14049b(Context context, String url, Bitmap fallbackImage) {
        Bitmap icon;
        Bitmap icon2 = null;
        try {
            String str = f12688a;
            StringBuilder sb = new StringBuilder();
            sb.append("Downloading image from: ");
            sb.append(url);
            Log.d(str, sb.toString());
            icon2 = BitmapFactory.decodeStream(new URL(url).openStream());
            f12689b.put(url, icon2);
            C6910i.m14053a(context, icon2, url);
            return icon2;
        } catch (FileNotFoundException e) {
            String str2 = f12688a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("This URL is invalid: ");
            sb2.append(url);
            Log.v(str2, sb2.toString());
            if (fallbackImage == null) {
                Log.d(f12688a, "Create an empty bitmap for this URL in the cache");
                icon = Bitmap.createBitmap(50, 50, Config.ARGB_8888);
            } else {
                Log.d(f12688a, "Use default bitmap for this URL");
                icon = fallbackImage;
            }
            f12689b.put(url, icon);
            return icon;
        } catch (Exception e2) {
            Log.e("Error", e2.getMessage());
            e2.printStackTrace();
            return icon2;
        }
    }

    private C6907g() {
    }
}
