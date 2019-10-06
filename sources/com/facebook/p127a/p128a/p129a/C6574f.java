package com.facebook.p127a.p128a.p129a;

import android.support.p000v4.view.C0636m;
import android.util.Log;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import com.facebook.internal.C6694S;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p005cm.aptoide.p006pt.BuildConfig;
import p005cm.aptoide.p006pt.deprecated.tables.Repo;
import p005cm.aptoide.p006pt.store.view.StoreTabGridRecyclerFragment.BundleCons;

/* renamed from: com.facebook.a.a.a.f */
/* compiled from: ViewHierarchy */
public class C6574f {

    /* renamed from: a */
    private static final String f11922a = C6574f.class.getCanonicalName();

    /* renamed from: b */
    private static WeakReference<View> f11923b = new WeakReference<>(null);

    /* renamed from: c */
    private static Method f11924c = null;

    /* renamed from: b */
    public static List<View> m13025b(View view) {
        ArrayList<View> children = new ArrayList<>();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int count = viewGroup.getChildCount();
            for (int i = 0; i < count; i++) {
                children.add(viewGroup.getChildAt(i));
            }
        }
        return children;
    }

    /* renamed from: a */
    public static JSONObject m13022a(View view, JSONObject json) {
        try {
            String text = m13030g(view);
            String hint = m13029f(view);
            Object tag = view.getTag();
            CharSequence description = view.getContentDescription();
            json.put("classname", view.getClass().getCanonicalName());
            json.put("classtypebitmask", m13033j(view));
            json.put("id", view.getId());
            boolean a = C6572d.m13010a(view);
            String str = CommandHandler.TEXT;
            String str2 = "";
            if (!a) {
                json.put(str, C6694S.m13403a(C6694S.m13446e(text), str2));
            } else {
                json.put(str, str2);
                json.put("is_user_input", true);
            }
            json.put("hint", C6694S.m13403a(C6694S.m13446e(hint), str2));
            if (tag != null) {
                json.put(BundleCons.TAG, C6694S.m13403a(C6694S.m13446e(tag.toString()), str2));
            }
            if (description != null) {
                json.put(Repo.COLUMN_DESCRIPTION, C6694S.m13403a(C6694S.m13446e(description.toString()), str2));
            }
            json.put("dimension", m13034k(view));
        } catch (JSONException e) {
            C6694S.m13422a(f11922a, (Exception) e);
        }
        return json;
    }

    /* renamed from: c */
    public static JSONObject m13026c(View view) {
        if (view.getClass().getName().equals("com.facebook.react.ReactRootView")) {
            f11923b = new WeakReference<>(view);
        }
        JSONObject json = new JSONObject();
        try {
            m13022a(view, json);
            JSONArray childViews = new JSONArray();
            List<View> children = m13025b(view);
            for (int i = 0; i < children.size(); i++) {
                childViews.put(m13026c((View) children.get(i)));
            }
            json.put("childviews", childViews);
        } catch (JSONException e) {
            Log.e(f11922a, "Failed to create JSONObject for view.", e);
        }
        return json;
    }

    /* renamed from: j */
    private static int m13033j(View view) {
        int bitmask = 0;
        if (view instanceof ImageView) {
            bitmask = 0 | 2;
        }
        if (m13031h(view)) {
            bitmask |= 32;
        }
        if (m13036m(view)) {
            bitmask |= 512;
        }
        if (view instanceof TextView) {
            int bitmask2 = bitmask | Opcodes.ACC_ABSTRACT | 1;
            if (view instanceof Button) {
                bitmask2 |= 4;
                if (view instanceof Switch) {
                    bitmask2 |= Opcodes.ACC_ANNOTATION;
                } else if (view instanceof CheckBox) {
                    bitmask2 |= Opcodes.ACC_MANDATED;
                }
            }
            if (view instanceof EditText) {
                return bitmask2 | Opcodes.ACC_STRICT;
            }
            return bitmask2;
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return bitmask | Opcodes.ACC_SYNTHETIC;
        } else {
            if (view instanceof RatingBar) {
                return bitmask | 65536;
            }
            if (view instanceof RadioGroup) {
                return bitmask | Opcodes.ACC_ENUM;
            }
            if (!(view instanceof ViewGroup) || !m13024a(view, (View) f11923b.get())) {
                return bitmask;
            }
            return bitmask | 64;
        }
    }

    /* renamed from: h */
    public static boolean m13031h(View view) {
        boolean z = false;
        try {
            Field listenerInfoField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (listenerInfoField != null) {
                listenerInfoField.setAccessible(true);
                Object listenerObj = listenerInfoField.get(view);
                if (listenerObj == null) {
                    return false;
                }
                Field listenerField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener");
                if (listenerField != null) {
                    if (((OnClickListener) listenerField.get(listenerObj)) != null) {
                        z = true;
                    }
                    return z;
                }
            }
        } catch (Exception e) {
            Log.e(f11922a, "Failed to check if the view is clickable.", e);
        }
        return false;
    }

    /* renamed from: m */
    private static boolean m13036m(View view) {
        ViewParent parent = view.getParent();
        return (parent instanceof AdapterView) || (parent instanceof C0636m);
    }

    /* renamed from: g */
    public static String m13030g(View view) {
        Object textObj = null;
        if (view instanceof TextView) {
            textObj = ((TextView) view).getText();
            if (view instanceof Switch) {
                textObj = ((Switch) view).isChecked() ? "1" : BuildConfig.MOPUB_NATIVE_HOME_PLACEMENT_ID;
            }
        } else if (view instanceof Spinner) {
            if (((Spinner) view).getCount() > 0) {
                Object selectedItem = ((Spinner) view).getSelectedItem();
                if (selectedItem != null) {
                    textObj = selectedItem.toString();
                }
            }
        } else if (view instanceof DatePicker) {
            DatePicker picker = (DatePicker) view;
            textObj = String.format("%04d-%02d-%02d", new Object[]{Integer.valueOf(picker.getYear()), Integer.valueOf(picker.getMonth()), Integer.valueOf(picker.getDayOfMonth())});
        } else if (view instanceof TimePicker) {
            TimePicker picker2 = (TimePicker) view;
            textObj = String.format("%02d:%02d", new Object[]{Integer.valueOf(picker2.getCurrentHour().intValue()), Integer.valueOf(picker2.getCurrentMinute().intValue())});
        } else if (view instanceof RadioGroup) {
            RadioGroup radioGroup = (RadioGroup) view;
            int checkedId = radioGroup.getCheckedRadioButtonId();
            int childCount = radioGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View child = radioGroup.getChildAt(i);
                if (child.getId() == checkedId && (child instanceof RadioButton)) {
                    textObj = ((RadioButton) child).getText();
                    break;
                }
                i++;
            }
        } else if (view instanceof RatingBar) {
            textObj = String.valueOf(((RatingBar) view).getRating());
        }
        return textObj == null ? "" : textObj.toString();
    }

    /* renamed from: f */
    public static String m13029f(View view) {
        CharSequence hintObj = null;
        if (view instanceof EditText) {
            hintObj = ((EditText) view).getHint();
        } else if (view instanceof TextView) {
            hintObj = ((TextView) view).getHint();
        }
        return hintObj == null ? "" : hintObj.toString();
    }

    /* renamed from: k */
    private static JSONObject m13034k(View view) {
        JSONObject dimension = new JSONObject();
        try {
            dimension.put("top", view.getTop());
            dimension.put("left", view.getLeft());
            dimension.put("width", view.getWidth());
            dimension.put("height", view.getHeight());
            dimension.put("scrollx", view.getScrollX());
            dimension.put("scrolly", view.getScrollY());
            dimension.put("visibility", view.getVisibility());
        } catch (JSONException e) {
            Log.e(f11922a, "Failed to create JSONObject for dimension.", e);
        }
        return dimension;
    }

    /* renamed from: d */
    public static AccessibilityDelegate m13027d(View view) {
        try {
            return (AccessibilityDelegate) view.getClass().getMethod("getAccessibilityDelegate", new Class[0]).invoke(view, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | NullPointerException | SecurityException | InvocationTargetException e) {
            return null;
        }
    }

    /* renamed from: e */
    public static OnTouchListener m13028e(View view) {
        try {
            Field listenerInfoField = Class.forName("android.view.View").getDeclaredField("mListenerInfo");
            if (listenerInfoField != null) {
                listenerInfoField.setAccessible(true);
            }
            Object listenerObj = listenerInfoField.get(view);
            if (listenerObj == null) {
                return null;
            }
            OnTouchListener listener = null;
            Field listenerField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener");
            if (listenerField != null) {
                listenerField.setAccessible(true);
                listener = (OnTouchListener) listenerField.get(listenerObj);
            }
            return listener;
        } catch (NoSuchFieldException e) {
            C6694S.m13422a(f11922a, (Exception) e);
            return null;
        } catch (ClassNotFoundException e2) {
            C6694S.m13422a(f11922a, (Exception) e2);
            return null;
        } catch (IllegalAccessException e3) {
            C6694S.m13422a(f11922a, (Exception) e3);
            return null;
        }
    }

    /* renamed from: a */
    public static View m13021a(float[] location, View RCTRootView) {
        m13023a();
        Method method = f11924c;
        View view = null;
        if (method == null || RCTRootView == null) {
            return null;
        }
        try {
            View nativeTargetView = (View) method.invoke(null, new Object[]{location, RCTRootView});
            if (nativeTargetView != null && nativeTargetView.getId() > 0) {
                View reactTargetView = (View) nativeTargetView.getParent();
                if (reactTargetView != null) {
                    view = reactTargetView;
                }
                return view;
            }
        } catch (IllegalAccessException e) {
            C6694S.m13422a(f11922a, (Exception) e);
        } catch (InvocationTargetException e2) {
            C6694S.m13422a(f11922a, (Exception) e2);
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m13024a(View view, View RCTRootView) {
        boolean z = false;
        if (!view.getClass().getName().equals("com.facebook.react.views.view.ReactViewGroup")) {
            return false;
        }
        View touchTargetView = m13021a(m13035l(view), RCTRootView);
        if (touchTargetView != null && touchTargetView.getId() == view.getId()) {
            z = true;
        }
        return z;
    }

    /* renamed from: i */
    public static boolean m13032i(View view) {
        return view.getClass().getName().equals("com.facebook.react.ReactRootView");
    }

    /* renamed from: a */
    public static View m13020a(View view) {
        while (view != null) {
            if (!m13032i(view)) {
                ViewParent viewParent = view.getParent();
                if (!(viewParent instanceof View)) {
                    break;
                }
                view = (View) viewParent;
            } else {
                return view;
            }
        }
        return null;
    }

    /* renamed from: l */
    private static float[] m13035l(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new float[]{(float) location[0], (float) location[1]};
    }

    /* renamed from: a */
    private static void m13023a() {
        if (f11924c == null) {
            try {
                f11924c = Class.forName("com.facebook.react.uimanager.TouchTargetHelper").getDeclaredMethod("findTouchTargetView", new Class[]{float[].class, ViewGroup.class});
                f11924c.setAccessible(true);
            } catch (ClassNotFoundException e) {
                C6694S.m13422a(f11922a, (Exception) e);
            } catch (NoSuchMethodException e2) {
                C6694S.m13422a(f11922a, (Exception) e2);
            }
        }
    }
}
