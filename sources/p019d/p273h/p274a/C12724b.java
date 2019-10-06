package p019d.p273h.p274a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: d.h.a.b */
/* compiled from: ConnectivityService */
public class C12724b {
    /* renamed from: a */
    public static String m41073a(Context context) {
        StringBuilder connectionType = new StringBuilder();
        NetworkInfo activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            String typeName = activeNetwork.getTypeName();
            int typeId = activeNetwork.getType();
            if (typeId == 0) {
                connectionType.append("3g");
            } else if (typeId == 1) {
                connectionType.append("wifi");
            } else {
                connectionType.append(typeName);
            }
        }
        return connectionType.toString();
    }

    /* renamed from: h */
    public static boolean m41080h(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m41079g(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(0);
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m41078f(Context context) {
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /* renamed from: b */
    public static int m41074b(Context context) {
        try {
            return context.getResources().getConfiguration().mcc;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /* renamed from: c */
    public static int m41075c(Context context) {
        try {
            return context.getResources().getConfiguration().mnc;
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    /* renamed from: e */
    public static String m41077e(Context context) {
        try {
            TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
            if (tm != null) {
                return tm.getSimOperator();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";
    }

    /* renamed from: d */
    public static int m41076d(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
