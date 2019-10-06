package android.support.p000v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.util.Log;

/* renamed from: android.support.v4.app.Y */
/* compiled from: NavUtils */
public final class C0445Y {
    /* renamed from: b */
    public static boolean m2297b(Activity sourceActivity, Intent targetIntent) {
        if (VERSION.SDK_INT >= 16) {
            return sourceActivity.shouldUpRecreateTask(targetIntent);
        }
        String action = sourceActivity.getIntent().getAction();
        return action != null && !action.equals("android.intent.action.MAIN");
    }

    /* renamed from: a */
    public static void m2294a(Activity sourceActivity, Intent upIntent) {
        if (VERSION.SDK_INT >= 16) {
            sourceActivity.navigateUpTo(upIntent);
            return;
        }
        upIntent.addFlags(67108864);
        sourceActivity.startActivity(upIntent);
        sourceActivity.finish();
    }

    /* renamed from: a */
    public static Intent m2292a(Activity sourceActivity) {
        Intent intent;
        if (VERSION.SDK_INT >= 16) {
            Intent result = sourceActivity.getParentActivityIntent();
            if (result != null) {
                return result;
            }
        }
        String parentName = m2295b(sourceActivity);
        if (parentName == null) {
            return null;
        }
        ComponentName target = new ComponentName(sourceActivity, parentName);
        try {
            if (m2296b((Context) sourceActivity, target) == null) {
                intent = Intent.makeMainActivity(target);
            } else {
                intent = new Intent().setComponent(target);
            }
            return intent;
        } catch (NameNotFoundException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getParentActivityIntent: bad parentActivityName '");
            sb.append(parentName);
            sb.append("' in manifest");
            Log.e("NavUtils", sb.toString());
            return null;
        }
    }

    /* renamed from: a */
    public static Intent m2293a(Context context, ComponentName componentName) throws NameNotFoundException {
        Intent parentIntent;
        String parentActivity = m2296b(context, componentName);
        if (parentActivity == null) {
            return null;
        }
        ComponentName target = new ComponentName(componentName.getPackageName(), parentActivity);
        if (m2296b(context, target) == null) {
            parentIntent = Intent.makeMainActivity(target);
        } else {
            parentIntent = new Intent().setComponent(target);
        }
        return parentIntent;
    }

    /* renamed from: b */
    public static String m2295b(Activity sourceActivity) {
        try {
            return m2296b((Context) sourceActivity, sourceActivity.getComponentName());
        } catch (NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: b */
    public static String m2296b(Context context, ComponentName componentName) throws NameNotFoundException {
        ActivityInfo info = context.getPackageManager().getActivityInfo(componentName, 128);
        if (VERSION.SDK_INT >= 16) {
            String result = info.parentActivityName;
            if (result != null) {
                return result;
            }
        }
        if (info.metaData == null) {
            return null;
        }
        String parentActivity = info.metaData.getString("android.support.PARENT_ACTIVITY");
        if (parentActivity == null) {
            return null;
        }
        if (parentActivity.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder();
            sb.append(context.getPackageName());
            sb.append(parentActivity);
            parentActivity = sb.toString();
        }
        return parentActivity;
    }
}
