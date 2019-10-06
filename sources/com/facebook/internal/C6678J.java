package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.internal.NativeProtocol.NativeAppInfo;
import com.facebook.login.C6757b;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import p005cm.aptoide.p006pt.account.view.LoginActivity;

/* renamed from: com.facebook.internal.J */
/* compiled from: NativeProtocol */
public final class C6678J {

    /* renamed from: a */
    private static final String f12191a = C6678J.class.getName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final List<C6683e> f12192b = m13358g();

    /* renamed from: c */
    private static final List<C6683e> f12193c = m13357f();

    /* renamed from: d */
    private static final Map<String, List<C6683e>> f12194d = m13356e();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final AtomicBoolean f12195e = new AtomicBoolean(false);

    /* renamed from: f */
    private static final List<Integer> f12196f = Arrays.asList(new Integer[]{Integer.valueOf(20170417), Integer.valueOf(20160327), Integer.valueOf(20141218), Integer.valueOf(20141107), Integer.valueOf(20141028), Integer.valueOf(20141001), Integer.valueOf(20140701), Integer.valueOf(20140324), Integer.valueOf(20140204), Integer.valueOf(20131107), Integer.valueOf(20130618), Integer.valueOf(20130502), Integer.valueOf(20121101)});

    /* renamed from: com.facebook.internal.J$a */
    /* compiled from: NativeProtocol */
    private static class C6679a extends C6683e {
        private C6679a() {
            super(null);
        }

        /* synthetic */ C6679a(C6677I x0) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public String mo19894c() {
            return "com.facebook.arstudio.player";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo19893b() {
            return null;
        }
    }

    /* renamed from: com.facebook.internal.J$b */
    /* compiled from: NativeProtocol */
    private static class C6680b extends C6683e {
        private C6680b() {
            super(null);
        }

        /* synthetic */ C6680b(C6677I x0) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public String mo19894c() {
            return "com.facebook.lite";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo19893b() {
            return "com.facebook.lite.platform.LoginGDPDialogActivity";
        }
    }

    /* renamed from: com.facebook.internal.J$c */
    /* compiled from: NativeProtocol */
    private static class C6681c extends C6683e {
        private C6681c() {
            super(null);
        }

        /* synthetic */ C6681c(C6677I x0) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public String mo19894c() {
            return "com.facebook.katana";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo19893b() {
            return "com.facebook.katana.ProxyAuth";
        }
    }

    /* renamed from: com.facebook.internal.J$d */
    /* compiled from: NativeProtocol */
    private static class C6682d extends C6683e {
        private C6682d() {
            super(null);
        }

        /* synthetic */ C6682d(C6677I x0) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public String mo19894c() {
            return "com.facebook.orca";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo19893b() {
            return null;
        }
    }

    /* renamed from: com.facebook.internal.J$e */
    /* compiled from: NativeProtocol */
    private static abstract class C6683e {

        /* renamed from: a */
        private TreeSet<Integer> f12197a;

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public abstract String mo19893b();

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract String mo19894c();

        private C6683e() {
        }

        /* synthetic */ C6683e(C6677I x0) {
            this();
        }

        /* renamed from: a */
        public TreeSet<Integer> mo19895a() {
            TreeSet<Integer> treeSet = this.f12197a;
            if (treeSet == null || treeSet.isEmpty()) {
                m13368a(false);
            }
            return this.f12197a;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x000d, code lost:
            if (r1.f12197a.isEmpty() == false) goto L_0x0015;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized void m13368a(boolean r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                if (r2 != 0) goto L_0x000f
                java.util.TreeSet<java.lang.Integer> r0 = r1.f12197a     // Catch:{ all -> 0x0017 }
                if (r0 == 0) goto L_0x000f
                java.util.TreeSet<java.lang.Integer> r0 = r1.f12197a     // Catch:{ all -> 0x0017 }
                boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0017 }
                if (r0 == 0) goto L_0x0015
            L_0x000f:
                java.util.TreeSet r0 = com.facebook.internal.C6678J.m13354c(r1)     // Catch:{ all -> 0x0017 }
                r1.f12197a = r0     // Catch:{ all -> 0x0017 }
            L_0x0015:
                monitor-exit(r1)
                return
            L_0x0017:
                r2 = move-exception
                monitor-exit(r1)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.C6678J.C6683e.m13368a(boolean):void");
        }
    }

    /* renamed from: com.facebook.internal.J$f */
    /* compiled from: NativeProtocol */
    public static class C6684f {

        /* renamed from: a */
        private C6683e f12198a;

        /* renamed from: b */
        private int f12199b;

        /* renamed from: a */
        public static C6684f m13373a(C6683e nativeAppInfo, int protocolVersion) {
            C6684f result = new C6684f();
            result.f12198a = nativeAppInfo;
            result.f12199b = protocolVersion;
            return result;
        }

        /* renamed from: a */
        public static C6684f m13372a() {
            C6684f result = new C6684f();
            result.f12199b = -1;
            return result;
        }

        private C6684f() {
        }

        /* renamed from: b */
        public int mo19896b() {
            return this.f12199b;
        }
    }

    /* renamed from: com.facebook.internal.J$g */
    /* compiled from: NativeProtocol */
    private static class C6685g extends C6683e {
        private C6685g() {
            super(null);
        }

        /* synthetic */ C6685g(C6677I x0) {
            this();
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public String mo19894c() {
            return "com.facebook.wakizashi";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String mo19893b() {
            return "com.facebook.katana.ProxyAuth";
        }
    }

    /* renamed from: g */
    private static List<C6683e> m13358g() {
        List<NativeAppInfo> list = new ArrayList<>();
        list.add(new C6681c(null));
        list.add(new C6685g(null));
        return list;
    }

    /* renamed from: f */
    private static List<C6683e> m13357f() {
        List<NativeAppInfo> list = new ArrayList<>(m13358g());
        list.add(0, new C6679a(null));
        return list;
    }

    /* renamed from: e */
    private static Map<String, List<C6683e>> m13356e() {
        Map<String, List<NativeAppInfo>> map = new HashMap<>();
        ArrayList<NativeAppInfo> messengerAppInfoList = new ArrayList<>();
        messengerAppInfoList.add(new C6682d(null));
        map.put("com.facebook.platform.action.request.OGACTIONPUBLISH_DIALOG", f12192b);
        map.put("com.facebook.platform.action.request.FEED_DIALOG", f12192b);
        map.put("com.facebook.platform.action.request.LIKE_DIALOG", f12192b);
        map.put("com.facebook.platform.action.request.APPINVITES_DIALOG", f12192b);
        map.put("com.facebook.platform.action.request.MESSAGE_DIALOG", messengerAppInfoList);
        map.put("com.facebook.platform.action.request.OGMESSAGEPUBLISH_DIALOG", messengerAppInfoList);
        map.put("com.facebook.platform.action.request.CAMERA_EFFECT", f12193c);
        map.put("com.facebook.platform.action.request.SHARE_STORY", f12192b);
        return map;
    }

    /* renamed from: a */
    static Intent m13336a(Context context, Intent intent, C6683e appInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfo != null && C6733u.m13564a(context, resolveInfo.activityInfo.packageName)) {
            return intent;
        }
        return null;
    }

    /* renamed from: b */
    static Intent m13346b(Context context, Intent intent, C6683e appInfo) {
        if (intent == null) {
            return null;
        }
        ResolveInfo resolveInfo = context.getPackageManager().resolveService(intent, 0);
        if (resolveInfo != null && C6733u.m13564a(context, resolveInfo.serviceInfo.packageName)) {
            return intent;
        }
        return null;
    }

    /* renamed from: a */
    public static Intent m13337a(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, C6757b defaultAudience, String clientState, String authType) {
        C6680b bVar = new C6680b(null);
        Context context2 = context;
        return m13336a(context, m13339a((C6683e) bVar, applicationId, permissions, e2e, isRerequest, isForPublish, defaultAudience, clientState, authType), (C6683e) bVar);
    }

    /* renamed from: a */
    private static Intent m13339a(C6683e appInfo, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, C6757b defaultAudience, String clientState, String authType) {
        String activityName = appInfo.mo19893b();
        if (activityName == null) {
            return null;
        }
        Intent intent = new Intent().setClassName(appInfo.mo19894c(), activityName).putExtra("client_id", applicationId);
        intent.putExtra("facebook_sdk_version", C6787r.m13826p());
        if (!C6694S.m13430a(permissions)) {
            intent.putExtra("scope", TextUtils.join(",", permissions));
        }
        if (!C6694S.m13436b(e2e)) {
            intent.putExtra("e2e", e2e);
        }
        intent.putExtra("state", clientState);
        intent.putExtra("response_type", "token,signed_request");
        intent.putExtra("return_scopes", "true");
        if (isForPublish) {
            intent.putExtra("default_audience", defaultAudience.mo20097e());
        }
        intent.putExtra("legacy_override", C6787r.m13824n());
        intent.putExtra(LoginActivity.AUTH_TYPE, authType);
        return intent;
    }

    /* renamed from: b */
    public static Intent m13347b(Context context, String applicationId, Collection<String> permissions, String e2e, boolean isRerequest, boolean isForPublish, C6757b defaultAudience, String clientState, String authType) {
        for (C6683e appInfo : f12192b) {
            Context context2 = context;
            Intent intent = m13336a(context, m13339a(appInfo, applicationId, permissions, e2e, isRerequest, isForPublish, defaultAudience, clientState, authType), appInfo);
            if (intent != null) {
                return intent;
            }
        }
        Context context3 = context;
        return null;
    }

    /* renamed from: c */
    public static final int m13352c() {
        return ((Integer) f12196f.get(0)).intValue();
    }

    /* renamed from: b */
    public static boolean m13351b(int version) {
        return f12196f.contains(Integer.valueOf(version)) && version >= 20140701;
    }

    /* renamed from: a */
    public static Intent m13338a(Intent requestIntent, Bundle results, FacebookException error) {
        UUID callId = m13344a(requestIntent);
        if (callId == null) {
            return null;
        }
        Intent resultIntent = new Intent();
        resultIntent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", m13353c(requestIntent));
        Bundle bridgeArguments = new Bundle();
        bridgeArguments.putString("action_id", callId.toString());
        if (error != null) {
            bridgeArguments.putBundle("error", m13340a(error));
        }
        resultIntent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", bridgeArguments);
        if (results != null) {
            resultIntent.putExtra("com.facebook.platform.protocol.RESULT_ARGS", results);
        }
        return resultIntent;
    }

    /* renamed from: a */
    public static Intent m13335a(Context context) {
        for (C6683e appInfo : f12192b) {
            Intent intent = m13346b(context, new Intent("com.facebook.platform.PLATFORM_SERVICE").setPackage(appInfo.mo19894c()).addCategory("android.intent.category.DEFAULT"), appInfo);
            if (intent != null) {
                return intent;
            }
        }
        return null;
    }

    /* renamed from: c */
    public static int m13353c(Intent intent) {
        return intent.getIntExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 0);
    }

    /* renamed from: a */
    public static UUID m13344a(Intent intent) {
        if (intent == null) {
            return null;
        }
        String callIdString = null;
        if (m13351b(m13353c(intent))) {
            Bundle bridgeArgs = intent.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            if (bridgeArgs != null) {
                callIdString = bridgeArgs.getString("action_id");
            }
        } else {
            callIdString = intent.getStringExtra("com.facebook.platform.protocol.CALL_ID");
        }
        UUID callId = null;
        if (callIdString != null) {
            try {
                callId = UUID.fromString(callIdString);
            } catch (IllegalArgumentException e) {
            }
        }
        return callId;
    }

    /* renamed from: b */
    public static Bundle m13349b(Intent intent) {
        if (!m13351b(m13353c(intent))) {
            return intent.getExtras();
        }
        return intent.getBundleExtra("com.facebook.platform.protocol.METHOD_ARGS");
    }

    /* renamed from: a */
    public static FacebookException m13341a(Bundle errorData) {
        if (errorData == null) {
            return null;
        }
        String type = errorData.getString("error_type");
        if (type == null) {
            type = errorData.getString("com.facebook.platform.status.ERROR_TYPE");
        }
        String description = errorData.getString("error_description");
        if (description == null) {
            description = errorData.getString("com.facebook.platform.status.ERROR_DESCRIPTION");
        }
        if (type == null || !type.equalsIgnoreCase("UserCanceled")) {
            return new FacebookException(description);
        }
        return new FacebookOperationCanceledException(description);
    }

    /* renamed from: a */
    public static Bundle m13340a(FacebookException e) {
        if (e == null) {
            return null;
        }
        Bundle errorBundle = new Bundle();
        errorBundle.putString("error_description", e.toString());
        if (e instanceof FacebookOperationCanceledException) {
            errorBundle.putString("error_type", "UserCanceled");
        }
        return errorBundle;
    }

    /* renamed from: a */
    public static int m13333a(int minimumVersion) {
        return m13342a(f12192b, new int[]{minimumVersion}).mo19896b();
    }

    /* renamed from: a */
    private static C6684f m13342a(List<C6683e> appInfoList, int[] versionSpec) {
        m13355d();
        if (appInfoList == null) {
            return C6684f.m13372a();
        }
        for (C6683e appInfo : appInfoList) {
            int protocolVersion = m13334a(appInfo.mo19895a(), m13352c(), versionSpec);
            if (protocolVersion != -1) {
                return C6684f.m13373a(appInfo, protocolVersion);
            }
        }
        return C6684f.m13372a();
    }

    /* renamed from: d */
    public static void m13355d() {
        if (f12195e.compareAndSet(false, true)) {
            C6787r.m13822l().execute(new C6677I());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static TreeSet<Integer> m13354c(C6683e appInfo) {
        ProviderInfo pInfo;
        String str = "Failed to query content resolver.";
        TreeSet treeSet = new TreeSet();
        ContentResolver contentResolver = C6787r.m13815e().getContentResolver();
        String str2 = MediationMetaData.KEY_VERSION;
        String[] projection = {str2};
        Uri uri = m13348b(appInfo);
        Cursor c = null;
        try {
            PackageManager pm = C6787r.m13815e().getPackageManager();
            StringBuilder sb = new StringBuilder();
            sb.append(appInfo.mo19894c());
            sb.append(".provider.PlatformProvider");
            pInfo = pm.resolveContentProvider(sb.toString(), 0);
        } catch (RuntimeException e) {
            Log.e(f12191a, str, e);
            pInfo = null;
        } catch (Throwable th) {
            if (c != null) {
                c.close();
            }
            throw th;
        }
        if (pInfo != null) {
            try {
                c = contentResolver.query(uri, projection, null, null, null);
            } catch (IllegalArgumentException | NullPointerException | SecurityException e2) {
                Log.e(f12191a, str);
                c = null;
            }
            if (c != null) {
                while (c.moveToNext()) {
                    treeSet.add(Integer.valueOf(c.getInt(c.getColumnIndex(str2))));
                }
            }
        }
        if (c != null) {
            c.close();
        }
        return treeSet;
    }

    /* renamed from: a */
    public static int m13334a(TreeSet<Integer> allAvailableFacebookAppVersions, int latestSdkVersion, int[] versionSpec) {
        int i;
        int fbAppVersion;
        int versionSpecIndex = versionSpec.length - 1;
        Iterator<Integer> fbAppVersionsIterator = allAvailableFacebookAppVersions.descendingIterator();
        int latestFacebookAppVersion = -1;
        do {
            i = -1;
            if (!fbAppVersionsIterator.hasNext()) {
                return -1;
            }
            fbAppVersion = ((Integer) fbAppVersionsIterator.next()).intValue();
            latestFacebookAppVersion = Math.max(latestFacebookAppVersion, fbAppVersion);
            while (versionSpecIndex >= 0 && versionSpec[versionSpecIndex] > fbAppVersion) {
                versionSpecIndex--;
            }
            if (versionSpecIndex < 0) {
                return -1;
            }
        } while (versionSpec[versionSpecIndex] != fbAppVersion);
        if (versionSpecIndex % 2 == 0) {
            i = Math.min(latestFacebookAppVersion, latestSdkVersion);
        }
        return i;
    }

    /* renamed from: b */
    private static Uri m13348b(C6683e appInfo) {
        StringBuilder sb = new StringBuilder();
        sb.append("content://");
        sb.append(appInfo.mo19894c());
        sb.append(".provider.PlatformProvider/versions");
        return Uri.parse(sb.toString());
    }
}
