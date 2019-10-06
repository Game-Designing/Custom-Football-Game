package com.adyen.p081ui.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.p000v4.app.C0014p;
import android.support.p000v4.content.C0510b;
import android.support.p000v4.content.C0515e;
import android.text.TextUtils;
import android.util.Log;
import com.adyen.p081ui.C5572a;
import com.adyen.utils.RedirectUtil;
import com.adyen.utils.RedirectUtil.ResolveType;
import java.util.Iterator;
import java.util.List;
import p002b.p003c.p049c.C1163b;
import p002b.p003c.p049c.C1163b.C1164a;

/* renamed from: com.adyen.ui.activities.RedirectHandlerActivity */
public class RedirectHandlerActivity extends C0014p {
    private static final String TAG = RedirectHandlerActivity.class.getSimpleName();

    /* renamed from: a */
    private Context f9405a;

    /* renamed from: b */
    private BroadcastReceiver f9406b = new C5588g(this);

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.f9405a = this;
        Intent intent = getIntent();
        String urlString = intent.getStringExtra("url");
        if (!TextUtils.isEmpty(urlString)) {
            Intent redirectIntent = m9830a(urlString);
            redirectIntent.addFlags(67108864);
            startActivityForResult(redirectIntent, 100);
            C0515e.m2597a(getApplicationContext()).mo5313a(this.f9406b, new IntentFilter("com.adyen.core.ui.finish"));
        } else if (intent.getData() == null || !(intent.getData() instanceof Uri)) {
            String str = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append(TAG);
            sb.append(" has been started without any url. Exiting.");
            Log.w(str, sb.toString());
            finish();
        } else {
            m9831a(intent.getData());
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getData() != null && (intent.getData() instanceof Uri)) {
            m9831a(intent.getData());
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100) {
            finish();
            Intent intent = new Intent(this, CheckoutActivity.class);
            Bundle bundle = new Bundle();
            String str = "REDIRECT_RETURN";
            bundle.putString(str, str);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
        finish();
    }

    /* renamed from: a */
    private void m9831a(Uri uri) {
        Intent returnIntent = new Intent();
        returnIntent.setAction("com.adyen.core.RedirectHandled");
        returnIntent.putExtra("returnUri", uri);
        returnIntent.addFlags(67108864);
        C0515e.m2597a(this.f9405a).mo5314a(returnIntent);
        finish();
    }

    /* renamed from: a */
    private boolean m9832a() {
        boolean z = false;
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo("com.android.chrome", 0);
            int version = Integer.parseInt((packageInfo.versionName != null ? packageInfo.versionName.split("\\.") : new String[0])[0]);
            if (version < 40 || version > 58) {
                z = true;
            }
            return z;
        } catch (NameNotFoundException e) {
            return false;
        } catch (NumberFormatException e2) {
            return false;
        }
    }

    /* renamed from: a */
    private Intent m9830a(String urlString) {
        Uri uri = Uri.parse(urlString);
        String str = "android.intent.action.VIEW";
        if (RedirectUtil.determineResolveResult(this, uri).getResolveType() == ResolveType.APPLICATION) {
            return new Intent(str, uri);
        }
        C1164a aVar = new C1164a();
        aVar.mo8785a(true);
        aVar.mo8781a(C0510b.m2564a((Context) this, C5572a.white));
        C1163b customTabsIntent = aVar.mo8787b();
        customTabsIntent.f3816a.setData(uri);
        Intent result = customTabsIntent.f3816a;
        List<ResolveInfo> resolveInfoList = getPackageManager().queryIntentActivities(result, 0);
        if (m9832a()) {
            Iterator it = resolveInfoList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo resolveInfo = (ResolveInfo) it.next();
                String str2 = "com.android.chrome";
                if (str2.equals(resolveInfo.activityInfo.packageName)) {
                    result.setPackage(str2);
                    result.setClassName(str2, resolveInfo.activityInfo.name);
                    break;
                }
            }
        } else if (resolveInfoList.size() > 1) {
            return Intent.createChooser(new Intent(str, uri), null);
        }
        return result;
    }
}
