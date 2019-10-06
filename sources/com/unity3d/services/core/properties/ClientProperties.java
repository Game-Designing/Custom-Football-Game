package com.unity3d.services.core.properties;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import com.unity3d.services.banners.view.BannerPosition;
import com.unity3d.services.core.log.DeviceLog;
import java.io.ByteArrayInputStream;
import java.lang.ref.WeakReference;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;

public class ClientProperties {
    private static final X500Principal DEBUG_CERT = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static WeakReference<Activity> _activity;
    private static Application _application;
    private static Context _applicationContext;
    private static BannerPosition _bannerDefaultPosition;
    private static String _gameId;

    public static Activity getActivity() {
        return (Activity) _activity.get();
    }

    public static void setActivity(Activity activity) {
        _activity = new WeakReference<>(activity);
    }

    public static Context getApplicationContext() {
        return _applicationContext;
    }

    public static void setApplicationContext(Context context) {
        _applicationContext = context;
    }

    public static Application getApplication() {
        return _application;
    }

    public static void setApplication(Application application) {
        _application = application;
    }

    public static String getGameId() {
        return _gameId;
    }

    public static void setGameId(String gameId) {
        _gameId = gameId;
    }

    public static String getAppName() {
        return _applicationContext.getPackageName();
    }

    public static String getAppVersion() {
        try {
            return getApplicationContext().getPackageManager().getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            DeviceLog.exception("Error getting package info", e);
            return null;
        }
    }

    public static BannerPosition getbannerDefaultPosition() {
        return _bannerDefaultPosition;
    }

    public static void setBannerDefaultPosition(BannerPosition position) {
        _bannerDefaultPosition = position;
    }

    public static boolean isAppDebuggable() {
        String str = "Could not find name";
        boolean debuggable = false;
        boolean couldNotGetApplicationInfo = false;
        if (getApplicationContext() == null) {
            return false;
        }
        PackageManager pm = getApplicationContext().getPackageManager();
        String pkgName = getApplicationContext().getPackageName();
        try {
            ApplicationInfo appinfo = pm.getApplicationInfo(pkgName, 0);
            int i = appinfo.flags & 2;
            appinfo.flags = i;
            if (i != 0) {
                debuggable = true;
            }
        } catch (NameNotFoundException e) {
            DeviceLog.exception(str, e);
            couldNotGetApplicationInfo = true;
        }
        if (couldNotGetApplicationInfo) {
            try {
                for (Signature signature : pm.getPackageInfo(pkgName, 64).signatures) {
                    debuggable = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getSubjectX500Principal().equals(DEBUG_CERT);
                    if (debuggable) {
                        break;
                    }
                }
            } catch (NameNotFoundException e2) {
                DeviceLog.exception(str, e2);
            } catch (CertificateException e3) {
                DeviceLog.exception("Certificate exception", e3);
            }
        }
        return debuggable;
    }
}
