package p019d.p135a.p136a.p142e;

import android.util.Log;
import java.util.Map;
import p019d.p135a.p136a.p137a.C6845a;
import p019d.p135a.p136a.p138b.C6856a;
import p320f.p321a.C13797m;
import p320f.p321a.C13804t;
import p320f.p321a.p322a.p324b.C13187b;
import p320f.p321a.p344h.C13777b;

/* renamed from: d.a.a.e.d */
/* compiled from: AsyncHttpClient */
public final class C6904d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f12683a = C6904d.class.getSimpleName();

    /* renamed from: a */
    public static void m14044a(String url, Map<String, String> headers, String data, C6845a httpResponseCallback) {
        String str = f12683a;
        StringBuilder sb = new StringBuilder();
        sb.append("POST request for url: ");
        sb.append(url);
        Log.d(str, sb.toString());
        String str2 = f12683a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("POST data: ");
        sb2.append(data);
        Log.d(str2, sb2.toString());
        C13797m.create(new C6903c(new C6856a(), url, headers, data)).subscribeOn(C13777b.m43848c()).observeOn(C13187b.m43117a()).subscribe((C13804t<? super T>) new C6902b<Object>(httpResponseCallback));
    }

    private C6904d() {
    }
}
