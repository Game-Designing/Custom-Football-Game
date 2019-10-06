package p019d.p273h.p276c.p283g;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Pair;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Vector;
import p019d.p273h.p274a.C12723a;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p284h.C12915i;
import p019d.p273h.p276c.p284h.C12916j;

/* renamed from: d.h.c.g.b */
/* compiled from: ServerURL */
public class C12903b {

    /* renamed from: a */
    private static String f39618a = "https://init.supersonicads.com/sdk/v";

    /* renamed from: b */
    private static String f39619b = "?request=";

    /* renamed from: a */
    public static String m41872a(Context context, String applicationKey, String applicationUserId, String gaid, String mediationType, Vector<Pair<String, String>> segmentParamVector) throws UnsupportedEncodingException {
        Vector<Pair<String, String>> vector = segmentParamVector;
        Vector<Pair<String, String>> array = new Vector<>();
        array.add(new Pair("platform", "android"));
        array.add(new Pair("applicationKey", applicationKey));
        array.add(new Pair("applicationUserId", applicationUserId));
        array.add(new Pair("sdkVersion", C12916j.m41971b()));
        if (C12916j.m41979c() == 0) {
            array.add(new Pair("serr", String.valueOf(C12916j.m41979c())));
        }
        if (!TextUtils.isEmpty(C12772a.m41416a().mo41311c())) {
            array.add(new Pair("pluginType", C12772a.m41416a().mo41311c()));
        }
        if (!TextUtils.isEmpty(C12772a.m41416a().mo41312d())) {
            array.add(new Pair("pluginVersion", C12772a.m41416a().mo41312d()));
        }
        if (!TextUtils.isEmpty(C12772a.m41416a().mo41310b())) {
            array.add(new Pair("plugin_fw_v", C12772a.m41416a().mo41310b()));
        }
        if (!TextUtils.isEmpty(gaid)) {
            array.add(new Pair("advId", gaid));
        } else {
            String str = gaid;
        }
        if (!TextUtils.isEmpty(mediationType)) {
            array.add(new Pair("mt", mediationType));
        } else {
            String str2 = mediationType;
        }
        String appVersion = C12723a.m41064a(context, context.getPackageName());
        if (!TextUtils.isEmpty(appVersion)) {
            array.add(new Pair("appVer", appVersion));
        }
        int osVersion = VERSION.SDK_INT;
        StringBuilder sb = new StringBuilder();
        sb.append(osVersion);
        sb.append("");
        array.add(new Pair("osVer", sb.toString()));
        array.add(new Pair("devMake", Build.MANUFACTURER));
        array.add(new Pair("devModel", Build.MODEL));
        String connection = C12916j.m41958a(context);
        if (!TextUtils.isEmpty(connection)) {
            array.add(new Pair("connType", connection));
        }
        if (vector != null) {
            array.addAll(vector);
        }
        String encodedEncryptedParams = URLEncoder.encode(C12915i.m41954b("C38FB23A402222A0C17D34A92F971D1F", m41874a(array)), "UTF-8");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(m41873a(C12916j.m41971b()));
        sb2.append(encodedEncryptedParams);
        return sb2.toString();
    }

    /* renamed from: a */
    private static String m41874a(Vector<Pair<String, String>> array) throws UnsupportedEncodingException {
        String str = "";
        Iterator it = array.iterator();
        while (it.hasNext()) {
            Pair<String, String> pair = (Pair) it.next();
            if (str.length() > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("&");
                str = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append((String) pair.first);
            sb2.append("=");
            sb2.append(URLEncoder.encode((String) pair.second, "UTF-8"));
            str = sb2.toString();
        }
        return str;
    }

    /* renamed from: a */
    private static String m41873a(String sdkVersion) {
        StringBuilder sb = new StringBuilder();
        sb.append(f39618a);
        sb.append(sdkVersion);
        sb.append(f39619b);
        return sb.toString();
    }
}
