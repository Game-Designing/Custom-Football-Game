package com.asf.appcoins.sdk.core.util.wallet;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.asf.appcoins.sdk.core.util.AndroidUtils;
import p320f.p321a.C13810v;
import p320f.p321a.C13813y;
import p320f.p321a.p326c.C13204f;

public class WalletUtils {
    public static boolean hasWalletInstalled(Context context) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("ethereum:"));
        return AndroidUtils.hasHandlerAvailable(intent, context);
    }

    public static C13810v<Boolean> promptToInstallWallet(Activity activity, String message) {
        return showWalletInstallDialog(activity, message).mo43153a((C13204f<? super T>) new C5873b<Object>(activity));
    }

    /* renamed from: a */
    static /* synthetic */ void m10688a(Activity activity, Boolean aBoolean) throws Exception {
        if (aBoolean.booleanValue()) {
            gotoStore(activity);
        }
    }

    private static C13810v<Boolean> showWalletInstallDialog(Context context, String message) {
        return C13810v.m43897a((C13813y<T>) new C5872a<T>(context, message));
    }

    private static void gotoStore(Context activity) {
        String str = "android.intent.action.VIEW";
        String appPackageName = "com.asfoundation.wallet";
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("market://details?id=");
            sb.append(appPackageName);
            activity.startActivity(new Intent(str, Uri.parse(sb.toString())));
        } catch (ActivityNotFoundException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("https://play.google.com/store/apps/details?id=");
            sb2.append(appPackageName);
            activity.startActivity(new Intent(str, Uri.parse(sb2.toString())));
        }
    }
}
