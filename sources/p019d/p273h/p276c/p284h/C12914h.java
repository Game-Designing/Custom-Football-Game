package p019d.p273h.p276c.p284h;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mopub.common.GpsHelper;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import p019d.p273h.p274a.C12723a;
import p019d.p273h.p274a.C12725c;
import p019d.p273h.p276c.C12747I;
import p019d.p273h.p276c.p277a.C12772a;
import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p282f.C12870f;

/* renamed from: d.h.c.h.h */
/* compiled from: GeneralPropertiesWorker */
public class C12914h implements Runnable {

    /* renamed from: A */
    private Context f39647A;

    /* renamed from: a */
    private final String f39648a = getClass().getSimpleName();

    /* renamed from: b */
    private final String f39649b = "bundleId";

    /* renamed from: c */
    private final String f39650c = "advertisingId";

    /* renamed from: d */
    private final String f39651d = GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY;

    /* renamed from: e */
    private final String f39652e = "appKey";

    /* renamed from: f */
    private final String f39653f = "deviceOS";

    /* renamed from: g */
    private final String f39654g = "osVersion";

    /* renamed from: h */
    private final String f39655h = "connectionType";

    /* renamed from: i */
    private final String f39656i = "language";

    /* renamed from: j */
    private final String f39657j = "deviceOEM";

    /* renamed from: k */
    private final String f39658k = "deviceModel";

    /* renamed from: l */
    private final String f39659l = "mobileCarrier";

    /* renamed from: m */
    private final String f39660m = "externalFreeMemory";

    /* renamed from: n */
    private final String f39661n = "internalFreeMemory";

    /* renamed from: o */
    private final String f39662o = "battery";

    /* renamed from: p */
    private final String f39663p = "lat";

    /* renamed from: q */
    private final String f39664q = "lon";

    /* renamed from: r */
    private final String f39665r = "gmtMinutesOffset";

    /* renamed from: s */
    private final String f39666s = "appVersion";

    /* renamed from: t */
    private final String f39667t = "sessionId";

    /* renamed from: u */
    private final String f39668u = "pluginType";

    /* renamed from: v */
    private final String f39669v = "pluginVersion";

    /* renamed from: w */
    private final String f39670w = "plugin_fw_v";

    /* renamed from: x */
    private final String f39671x = "jb";

    /* renamed from: y */
    private final String f39672y = "advertisingIdType";

    /* renamed from: z */
    private final String f39673z = "mt";

    public C12914h(Context ctx) {
        this.f39647A = ctx.getApplicationContext();
    }

    public void run() {
        try {
            C12870f.m41821a().mo41642a(m41930a());
            C12916j.m41968a(this.f39647A, C12870f.m41821a().mo41643b());
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append("Thread name = ");
            sb.append(getClass().getSimpleName());
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
        }
    }

    /* renamed from: a */
    private Map<String, Object> m41930a() {
        Map<String, Object> result = new HashMap<>();
        result.put("sessionId", C12747I.m41186g().mo41239m());
        String strVal = m41935e();
        if (!TextUtils.isEmpty(strVal)) {
            result.put("bundleId", strVal);
            String publAppVersion = C12723a.m41064a(this.f39647A, strVal);
            if (!TextUtils.isEmpty(publAppVersion)) {
                result.put("appVersion", publAppVersion);
            }
        }
        result.put("appKey", m41933c());
        String advertisingId = "";
        String advertisingIdType = "";
        boolean isLimitAdTrackingEnabled = false;
        try {
            String[] advertisingIdInfo = C12725c.m41090b(this.f39647A);
            if (advertisingIdInfo != null && advertisingIdInfo.length == 2) {
                if (!TextUtils.isEmpty(advertisingIdInfo[0])) {
                    advertisingId = advertisingIdInfo[0];
                }
                isLimitAdTrackingEnabled = Boolean.valueOf(advertisingIdInfo[1]).booleanValue();
            }
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(advertisingId)) {
            advertisingIdType = "GAID";
        } else {
            advertisingId = C12725c.m41105j(this.f39647A);
            if (!TextUtils.isEmpty(advertisingId)) {
                advertisingIdType = "UUID";
            }
        }
        if (!TextUtils.isEmpty(advertisingId)) {
            result.put("advertisingId", advertisingId);
            result.put("advertisingIdType", advertisingIdType);
            result.put(GpsHelper.IS_LIMIT_AD_TRACKING_ENABLED_KEY, Boolean.valueOf(isLimitAdTrackingEnabled));
        }
        result.put("deviceOS", m41938h());
        if (!TextUtils.isEmpty(m41932b())) {
            result.put("osVersion", m41932b());
        }
        String strVal2 = C12916j.m41958a(this.f39647A);
        if (!TextUtils.isEmpty(strVal2)) {
            result.put("connectionType", strVal2);
        }
        result.put("sdkVersion", m41949s());
        String strVal3 = m41942l();
        if (!TextUtils.isEmpty(strVal3)) {
            result.put("language", strVal3);
        }
        String strVal4 = m41937g();
        if (!TextUtils.isEmpty(strVal4)) {
            result.put("deviceOEM", strVal4);
        }
        String strVal5 = m41936f();
        if (!TextUtils.isEmpty(strVal5)) {
            result.put("deviceModel", strVal5);
        }
        String strVal6 = m41945o();
        if (!TextUtils.isEmpty(strVal6)) {
            result.put("mobileCarrier", strVal6);
        }
        result.put("internalFreeMemory", Long.valueOf(m41941k()));
        result.put("externalFreeMemory", Long.valueOf(m41939i()));
        result.put("battery", Integer.valueOf(m41934d()));
        if (C12916j.m41969a(this.f39647A, "GeneralProperties.ALLOW_LOCATION_SHARED_PREFS_KEY", false)) {
            double[] lastKnownLocation = m41943m();
            if (lastKnownLocation != null && lastKnownLocation.length == 2) {
                result.put("lat", Double.valueOf(lastKnownLocation[0]));
                result.put("lon", Double.valueOf(lastKnownLocation[1]));
            }
        }
        int gmtMinutesOffset = m41940j();
        if (m41931a(gmtMinutesOffset)) {
            result.put("gmtMinutesOffset", Integer.valueOf(gmtMinutesOffset));
        }
        String strVal7 = m41947q();
        if (!TextUtils.isEmpty(strVal7)) {
            result.put("pluginType", strVal7);
        }
        String strVal8 = m41948r();
        if (!TextUtils.isEmpty(strVal8)) {
            result.put("pluginVersion", strVal8);
        }
        String strVal9 = m41946p();
        if (!TextUtils.isEmpty(strVal9)) {
            result.put("plugin_fw_v", strVal9);
        }
        String strVal10 = String.valueOf(C12725c.m41104i());
        if (!TextUtils.isEmpty(strVal10)) {
            result.put("jb", strVal10);
        }
        String strVal11 = m41944n();
        if (!TextUtils.isEmpty(strVal11)) {
            result.put("mt", strVal11);
        }
        return result;
    }

    /* renamed from: q */
    private String m41947q() {
        String result = "";
        try {
            return C12772a.m41416a().mo41311c();
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.NATIVE, "getPluginType()", (Throwable) e);
            return result;
        }
    }

    /* renamed from: r */
    private String m41948r() {
        String result = "";
        try {
            return C12772a.m41416a().mo41312d();
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.NATIVE, "getPluginVersion()", (Throwable) e);
            return result;
        }
    }

    /* renamed from: p */
    private String m41946p() {
        String result = "";
        try {
            return C12772a.m41416a().mo41310b();
        } catch (Exception e) {
            C12802d.m41613c().mo41426a(C12801a.NATIVE, "getPluginFrameworkVersion()", (Throwable) e);
            return result;
        }
    }

    /* renamed from: e */
    private String m41935e() {
        try {
            return this.f39647A.getPackageName();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: c */
    private String m41933c() {
        return C12747I.m41186g().mo41232h();
    }

    /* renamed from: h */
    private String m41938h() {
        return "Android";
    }

    /* renamed from: b */
    private String m41932b() {
        String str = "";
        try {
            String release = VERSION.RELEASE;
            int sdkVersion = VERSION.SDK_INT;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(sdkVersion);
            sb.append("(");
            sb.append(release);
            sb.append(")");
            return sb.toString();
        } catch (Exception e) {
            return str;
        }
    }

    /* renamed from: s */
    private String m41949s() {
        return C12916j.m41971b();
    }

    /* renamed from: l */
    private String m41942l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: g */
    private String m41937g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: f */
    private String m41936f() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: o */
    private String m41945o() {
        String ret = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.f39647A.getSystemService("phone");
            if (telephonyManager == null) {
                return ret;
            }
            String operatorName = telephonyManager.getNetworkOperatorName();
            if (!operatorName.equals("")) {
                return operatorName;
            }
            return ret;
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f39648a);
            sb.append(":getMobileCarrier()");
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
            return ret;
        }
    }

    /* renamed from: t */
    private boolean m41950t() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: k */
    private long m41941k() {
        try {
            StatFs stat = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1048576;
        } catch (Exception e) {
            return -1;
        }
    }

    /* renamed from: i */
    private long m41939i() {
        if (!m41950t()) {
            return -1;
        }
        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) stat.getAvailableBlocks()) * ((long) stat.getBlockSize())) / 1048576;
    }

    /* renamed from: d */
    private int m41934d() {
        try {
            Intent batteryIntent = this.f39647A.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int scale = 0;
            int level = batteryIntent != null ? batteryIntent.getIntExtra("level", -1) : 0;
            if (batteryIntent != null) {
                scale = batteryIntent.getIntExtra("scale", -1);
            }
            if (level == -1 || scale == -1) {
                return -1;
            }
            return (int) ((((float) level) / ((float) scale)) * 100.0f);
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f39648a);
            sb.append(":getBatteryLevel()");
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
            return -1;
        }
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: m */
    private double[] m41943m() {
        double[] result = new double[0];
        long bestLocationTime = Long.MIN_VALUE;
        try {
            if (!m41951u()) {
                return result;
            }
            LocationManager locationManager = (LocationManager) this.f39647A.getApplicationContext().getSystemService("location");
            Location bestLocation = null;
            for (String provider : locationManager.getAllProviders()) {
                Location location = locationManager.getLastKnownLocation(provider);
                if (location != null && location.getTime() > bestLocationTime) {
                    bestLocation = location;
                    bestLocationTime = bestLocation.getTime();
                }
            }
            if (bestLocation == null) {
                return result;
            }
            return new double[]{bestLocation.getLatitude(), bestLocation.getLongitude()};
        } catch (Exception e) {
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f39648a);
            sb.append(":getLastLocation()");
            c.mo41426a(aVar, sb.toString(), (Throwable) e);
            return new double[0];
        }
    }

    /* renamed from: u */
    private boolean m41951u() {
        boolean z = false;
        try {
            if (this.f39647A.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: j */
    private int m41940j() {
        try {
            TimeZone tz = TimeZone.getDefault();
            return Math.round((float) (((tz.getOffset(GregorianCalendar.getInstance(tz).getTimeInMillis()) / 1000) / 60) / 15)) * 15;
        } catch (Exception e) {
            Exception e2 = e;
            C12802d c = C12802d.m41613c();
            C12801a aVar = C12801a.NATIVE;
            StringBuilder sb = new StringBuilder();
            sb.append(this.f39648a);
            sb.append(":getGmtMinutesOffset()");
            c.mo41426a(aVar, sb.toString(), (Throwable) e2);
            return 0;
        }
    }

    /* renamed from: a */
    private boolean m41931a(int offset) {
        return offset <= 840 && offset >= -720 && offset % 15 == 0;
    }

    /* renamed from: n */
    private String m41944n() {
        return C12747I.m41186g().mo41237k();
    }
}
