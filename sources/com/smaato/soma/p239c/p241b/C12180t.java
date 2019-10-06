package com.smaato.soma.p239c.p241b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.view.View;
import com.smaato.soma.p239c.p252i.C12278d;
import com.smaato.soma.p239c.p252i.C12280f;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.smaato.soma.c.b.t */
/* compiled from: MraidConnectorHelper */
public class C12180t {
    /* renamed from: a */
    static String m40074a(float... sizeParams) {
        List<String> sizes = new ArrayList<>();
        for (float size : sizeParams) {
            sizes.add(String.valueOf(C12278d.m40415a().mo39669a(size)));
        }
        return C12280f.m40425a(",", sizes);
    }

    /* renamed from: b */
    static boolean m40079b(Context context) {
        Intent telIntent = new Intent("android.intent.action.DIAL");
        telIntent.setData(Uri.parse("tel:"));
        return m40077a(context, telIntent);
    }

    /* renamed from: a */
    static boolean m40076a(Context context) {
        Intent smsIntent = new Intent("android.intent.action.VIEW");
        smsIntent.setData(Uri.parse("sms:"));
        return m40077a(context, smsIntent);
    }

    /* renamed from: a */
    static View m40073a(Context context, View view) {
        View rootViewFromActivity = m40080c(context);
        return rootViewFromActivity != null ? rootViewFromActivity : m40078b(view);
    }

    /* renamed from: a */
    static Rect m40072a(View view) {
        int[] location = new int[2];
        view.getLocationInWindow(location);
        return new Rect(location[0], location[1], location[0] + view.getWidth(), location[1] + view.getHeight());
    }

    /* renamed from: a */
    static int m40071a(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        if (rotation == 0) {
            return 1;
        }
        if (rotation == 1) {
            return 0;
        }
        if (rotation == 2) {
            return 9;
        }
        if (rotation != 3) {
            return -1;
        }
        return 8;
    }

    /* renamed from: a */
    static boolean m40075a(int bitMask, int flag) {
        return (bitMask & flag) != 0;
    }

    /* renamed from: c */
    private static View m40080c(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView().findViewById(16908290);
        }
        return null;
    }

    /* renamed from: b */
    private static View m40078b(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        if (rootView == null) {
            return null;
        }
        View rootContentView = rootView.findViewById(16908290);
        return rootContentView != null ? rootContentView : rootView;
    }

    /* renamed from: a */
    private static boolean m40077a(Context context, Intent intent) {
        try {
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        } catch (NullPointerException e) {
            return false;
        }
    }
}
