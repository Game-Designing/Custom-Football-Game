package com.mopub.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.privacy.ConsentDialogActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

public class ManifestUtils {

    /* renamed from: a */
    private static C11287b f34593a = new C11287b();

    /* renamed from: b */
    private static final List<Class<? extends Activity>> f34594b = new ArrayList(4);

    /* renamed from: c */
    private static final List<Class<? extends Activity>> f34595c = new ArrayList(1);

    /* renamed from: d */
    private static final List<Class<? extends Activity>> f34596d = new ArrayList(1);

    /* renamed from: com.mopub.common.util.ManifestUtils$a */
    private static class C11286a {
        public boolean hasKeyboardHidden;
        public boolean hasOrientation;
        public boolean hasScreenSize;

        private C11286a() {
        }
    }

    /* renamed from: com.mopub.common.util.ManifestUtils$b */
    static class C11287b {
        C11287b() {
        }

        public boolean hasFlag(Class clazz, int bitMask, int flag) {
            return Utils.bitMaskContainsFlag(bitMask, flag);
        }
    }

    private ManifestUtils() {
    }

    static {
        try {
            Class moPubActivityClass = Class.forName("com.mopub.mobileads.MoPubActivity");
            Class mraidActivityClass = Class.forName("com.mopub.mobileads.MraidActivity");
            Class rewardedMraidActivityClass = Class.forName("com.mopub.mobileads.RewardedMraidActivity");
            f34594b.add(moPubActivityClass);
            f34594b.add(mraidActivityClass);
            f34594b.add(rewardedMraidActivityClass);
        } catch (ClassNotFoundException e) {
            MoPubLog.log(SdkLogEvent.CUSTOM, "ManifestUtils running without interstitial module");
        }
        f34594b.add(MraidVideoPlayerActivity.class);
        f34594b.add(MoPubBrowser.class);
        f34595c.add(MoPubBrowser.class);
        f34596d.add(ConsentDialogActivity.class);
    }

    public static void checkGdprActivitiesDeclared(Context context) {
        if (NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m37195b(context, f34596d);
            m37193a(context, f34596d);
        }
    }

    public static void checkWebViewActivitiesDeclared(Context context) {
        if (NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m37195b(context, f34594b);
            m37193a(context, f34594b);
        }
    }

    public static void checkNativeActivitiesDeclared(Context context) {
        if (NoThrow.checkNotNull(context, "context is not allowed to be null")) {
            m37195b(context, f34595c);
            m37193a(context, f34595c);
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    static void m37195b(Context context, List<Class<? extends Activity>> requiredActivities) {
        List<Class<? extends Activity>> undeclaredActivities = m37191a(context, requiredActivities, false);
        if (!undeclaredActivities.isEmpty()) {
            m37192a(context);
            m37194a(undeclaredActivities);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m37193a(Context context, List<Class<? extends Activity>> requiredActivities) {
        List<Class<? extends Activity>> misconfiguredActivities = m37196c(context, m37191a(context, requiredActivities, true));
        if (!misconfiguredActivities.isEmpty()) {
            m37192a(context);
            m37197d(context, misconfiguredActivities);
        }
    }

    public static boolean isDebuggable(Context context) {
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }

    /* renamed from: a */
    private static List<Class<? extends Activity>> m37191a(Context context, List<Class<? extends Activity>> requiredActivities, boolean isDeclared) {
        List<Class<? extends Activity>> activities = new ArrayList<>();
        for (Class<? extends Activity> activityClass : requiredActivities) {
            if (Intents.deviceCanHandleIntent(context, new Intent(context, activityClass)) == isDeclared) {
                activities.add(activityClass);
            }
        }
        return activities;
    }

    @TargetApi(13)
    /* renamed from: c */
    private static List<Class<? extends Activity>> m37196c(Context context, List<Class<? extends Activity>> activities) {
        List<Class<? extends Activity>> misconfiguredActivities = new ArrayList<>();
        for (Class<? extends Activity> activity : activities) {
            try {
                C11286a activityConfigChanges = m37190a(context, activity);
                if (!activityConfigChanges.hasKeyboardHidden || !activityConfigChanges.hasOrientation || !activityConfigChanges.hasScreenSize) {
                    misconfiguredActivities.add(activity);
                }
            } catch (NameNotFoundException e) {
            }
        }
        return misconfiguredActivities;
    }

    /* renamed from: a */
    private static void m37194a(List<Class<? extends Activity>> undeclaredActivities) {
        StringBuilder stringBuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        for (Class<? extends Activity> activity : undeclaredActivities) {
            stringBuilder.append("\n\t");
            stringBuilder.append(activity.getName());
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.log(SdkLogEvent.CUSTOM, stringBuilder.toString());
    }

    /* renamed from: d */
    private static void m37197d(Context context, List<Class<? extends Activity>> misconfiguredActivities) {
        StringBuilder stringBuilder = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        for (Class<? extends Activity> activity : misconfiguredActivities) {
            try {
                C11286a activityConfigChanges = m37190a(context, activity);
                String str = "\n\tThe android:configChanges param for activity ";
                if (!activityConfigChanges.hasKeyboardHidden) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(activity.getName());
                    sb.append(" must include keyboardHidden.");
                    stringBuilder.append(sb.toString());
                }
                if (!activityConfigChanges.hasOrientation) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(activity.getName());
                    sb2.append(" must include orientation.");
                    stringBuilder.append(sb2.toString());
                }
                if (!activityConfigChanges.hasScreenSize) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str);
                    sb3.append(activity.getName());
                    sb3.append(" must include screenSize.");
                    stringBuilder.append(sb3.toString());
                }
            } catch (NameNotFoundException e) {
            }
        }
        stringBuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.log(SdkLogEvent.CUSTOM, stringBuilder.toString());
    }

    /* renamed from: a */
    private static C11286a m37190a(Context context, Class<? extends Activity> activity) throws NameNotFoundException {
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(new ComponentName(context, activity.getName()), 0);
        C11286a activityConfigChanges = new C11286a();
        activityConfigChanges.hasKeyboardHidden = f34593a.hasFlag(activity, activityInfo.configChanges, 32);
        activityConfigChanges.hasOrientation = f34593a.hasFlag(activity, activityInfo.configChanges, 128);
        activityConfigChanges.hasScreenSize = true;
        activityConfigChanges.hasScreenSize = f34593a.hasFlag(activity, activityInfo.configChanges, Opcodes.ACC_ABSTRACT);
        return activityConfigChanges;
    }

    /* renamed from: a */
    private static void m37192a(Context context) {
        if (isDebuggable(context)) {
            String str = "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.";
            Toast toast = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            toast.setGravity(7, 0, 0);
            toast.show();
        }
    }
}
