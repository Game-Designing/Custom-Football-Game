package p005cm.aptoide.p006pt.link;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.p000v4.content.C0510b;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.store.StoreTheme;

/* renamed from: cm.aptoide.pt.link.CustomTabsHelper */
public class CustomTabsHelper {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static CustomTabsHelper customTabsHelper;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1917424352945363399L, "cm/aptoide/pt/link/CustomTabsHelper", 35);
        $jacocoData = probes;
        return probes;
    }

    private CustomTabsHelper() {
        boolean[] $jacocoInit = $jacocoInit();
        if (customTabsHelper == null) {
            $jacocoInit[2] = true;
            return;
        }
        $jacocoInit[0] = true;
        IllegalStateException illegalStateException = new IllegalStateException("Already instantiated");
        $jacocoInit[1] = true;
        throw illegalStateException;
    }

    public static CustomTabsHelper getInstance() {
        boolean[] $jacocoInit = $jacocoInit();
        if (customTabsHelper != null) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            customTabsHelper = new CustomTabsHelper();
            $jacocoInit[5] = true;
        }
        CustomTabsHelper customTabsHelper2 = customTabsHelper;
        $jacocoInit[6] = true;
        return customTabsHelper2;
    }

    public void openInChromeCustomTab(String url, Context context, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        C1164a builder = getBuilder(context, theme);
        $jacocoInit[7] = true;
        C1163b customTabsIntent = builder.mo8787b();
        $jacocoInit[8] = true;
        addRefererHttpHeader(context, customTabsIntent);
        $jacocoInit[9] = true;
        customTabsIntent.f3816a.setFlags(268435456);
        $jacocoInit[10] = true;
        customTabsIntent.mo8779a(context, Uri.parse(url));
        $jacocoInit[11] = true;
    }

    private C1164a getBuilder(Context context, String theme) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[12] = true;
        Intent openInNativeIntent = new Intent(context.getApplicationContext(), CustomTabNativeReceiver.class);
        $jacocoInit[13] = true;
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, openInNativeIntent, 0);
        $jacocoInit[14] = true;
        C1164a aVar = new C1164a();
        $jacocoInit[15] = true;
        StoreTheme storeTheme = StoreTheme.get(theme);
        $jacocoInit[16] = true;
        int primaryColor = storeTheme.getPrimaryColor();
        $jacocoInit[17] = true;
        aVar.mo8781a(C0510b.m2564a(context, primaryColor));
        $jacocoInit[18] = true;
        aVar.mo8785a(true);
        $jacocoInit[19] = true;
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), C1375R.drawable.ic_arrow_back);
        $jacocoInit[20] = true;
        aVar.mo8783a(decodeResource);
        $jacocoInit[21] = true;
        aVar.mo8780a();
        $jacocoInit[22] = true;
        aVar.mo8784a(context.getString(C1375R.string.customtabs_open_native_app), pendingIntent);
        $jacocoInit[23] = true;
        aVar.mo8786b(context, C1375R.anim.slide_in_right, C1375R.anim.slide_out_left);
        $jacocoInit[24] = true;
        aVar.mo8782a(context, C1375R.anim.slide_in_left, C1375R.anim.slide_out_right);
        $jacocoInit[25] = true;
        return aVar;
    }

    private void addRefererHttpHeader(Context context, C1163b customTabsIntent) {
        boolean[] $jacocoInit = $jacocoInit();
        Bundle httpHeaders = new Bundle();
        $jacocoInit[26] = true;
        httpHeaders.putString("Referer", "http://m.aptoide.com");
        $jacocoInit[27] = true;
        customTabsIntent.f3816a.putExtra("com.android.browser.headers", httpHeaders);
        $jacocoInit[28] = true;
        customTabsIntent.f3816a.getExtras();
        if (VERSION.SDK_INT < 22) {
            $jacocoInit[29] = true;
        } else {
            $jacocoInit[30] = true;
            Intent intent = customTabsIntent.f3816a;
            StringBuilder sb = new StringBuilder();
            sb.append("android-app://");
            $jacocoInit[31] = true;
            sb.append(context.getPackageName());
            sb.append("/");
            String sb2 = sb.toString();
            $jacocoInit[32] = true;
            intent.putExtra("android.intent.extra.REFERRER_NAME", sb2);
            $jacocoInit[33] = true;
        }
        $jacocoInit[34] = true;
    }
}
