package p005cm.aptoide.p006pt.utils.p015q;

import android.app.ActivityManager;
import android.app.UiModeManager;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.util.Base64;
import android.view.WindowManager;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.utils.AptoideUtils.ScreenU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.SystemU;

/* renamed from: cm.aptoide.pt.utils.q.QManager */
public class QManager {
    private final ActivityManager activityManager;
    private String cachedFilters;
    private String cpuAbi;
    private Integer densityDpi;
    private String glEs;
    private final GlExtensionsManager glExtensionsManager;
    private Integer minSdk;
    private final Resources resources;
    private String screenSize;
    private UiModeManager uiModeManager;
    private final WindowManager windowManager;

    public QManager(SharedPreferences sharedPreferences, Resources resources2, ActivityManager activityManager2, WindowManager windowManager2, UiModeManager uiModeManager2) {
        this.glExtensionsManager = new GlExtensionsManager(sharedPreferences);
        this.resources = resources2;
        this.activityManager = activityManager2;
        this.windowManager = windowManager2;
        this.uiModeManager = uiModeManager2;
    }

    public Integer getMinSdk() {
        if (this.minSdk == null) {
            this.minSdk = Integer.valueOf(computeMinSdk());
        }
        return this.minSdk;
    }

    public String getCpuAbi() {
        if (this.cpuAbi == null) {
            this.cpuAbi = computeCpuAbi();
        }
        return this.cpuAbi;
    }

    public String getScreenSize() {
        if (this.screenSize == null) {
            this.screenSize = computeScreenSize();
        }
        return this.screenSize;
    }

    public String getGlEs() {
        if (this.glEs == null) {
            this.glEs = computeGlEs();
        }
        return this.glEs;
    }

    public Integer getDensityDpi() {
        if (this.densityDpi == null) {
            this.densityDpi = Integer.valueOf(computeDensityDpi());
        }
        return this.densityDpi;
    }

    private int computeMinSdk() {
        return SystemU.getSdkVer();
    }

    private String computeScreenSize() {
        return ScreenU.getScreenSize(this.resources);
    }

    private String computeGlEs() {
        return SystemU.getGlEsVer(this.activityManager);
    }

    private int computeDensityDpi() {
        return ScreenU.getDensityDpi(this.windowManager);
    }

    private String computeCpuAbi() {
        return SystemU.getAbis();
    }

    public String getSupportedOpenGlExtensionsManager() {
        return this.glExtensionsManager.getSupportedExtensions();
    }

    public boolean isSupportedExtensionsDefined() {
        return this.glExtensionsManager.isSupportedExtensionsDefined();
    }

    public String getFilters(boolean hwSpecsFilter) {
        if (!hwSpecsFilter) {
            return null;
        }
        if (this.cachedFilters == null) {
            this.cachedFilters = computeFilters();
        }
        return this.cachedFilters;
    }

    private String hasLeanback() {
        if (this.uiModeManager.getCurrentModeType() == 4) {
            return "1";
        }
        return BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
    }

    private String computeFilters() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("maxSdk=");
        sb.append(getMinSdk());
        sb.append("&maxScreen=");
        sb.append(getScreenSize());
        sb.append("&maxGles=");
        sb.append(getGlEs());
        sb.append("&myCPU=");
        sb.append(getCpuAbi());
        sb.append("&leanback=");
        sb.append(hasLeanback());
        sb.append("&myDensity=");
        sb.append(getDensityDpi());
        String str2 = "";
        if (getSupportedOpenGlExtensionsManager().equals(str2)) {
            str = str2;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("&myGLTex=");
            sb2.append(getSupportedOpenGlExtensionsManager());
            str = sb2.toString();
        }
        sb.append(str);
        return Base64.encodeToString(sb.toString().getBytes(), 0).replace("=", str2).replace("/", "*").replace("+", "_").replace("\n", str2);
    }

    private void invalidate() {
        this.cachedFilters = null;
    }

    public void setSupportedOpenGLExtensions(String openGLExtensions) {
        this.glExtensionsManager.setSupportedOpenGLExtensions(openGLExtensions);
        invalidate();
    }
}
