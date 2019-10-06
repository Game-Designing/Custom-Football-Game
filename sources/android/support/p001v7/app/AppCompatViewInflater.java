package android.support.p001v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.widget.AppCompatButton;
import android.support.p001v7.widget.AppCompatImageView;
import android.support.p001v7.widget.AppCompatRadioButton;
import android.support.p001v7.widget.AppCompatRatingBar;
import android.support.p001v7.widget.C0897A;
import android.support.p001v7.widget.C0939H;
import android.support.p001v7.widget.C1075k;
import android.support.p001v7.widget.C1085m;
import android.support.p001v7.widget.C1088n;
import android.support.p001v7.widget.C1103pb;
import android.support.p001v7.widget.C1104q;
import android.support.p001v7.widget.C1110s;
import android.support.p001v7.widget.C1116u;
import android.support.p001v7.widget.C1130x;
import android.util.AttributeSet;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.view.View.OnClickListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p062h.p071g.C1303d;

/* renamed from: android.support.v7.app.AppCompatViewInflater */
public class AppCompatViewInflater {

    /* renamed from: a */
    private static final Class<?>[] f2172a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final int[] f2173b = {16843375};

    /* renamed from: c */
    private static final String[] f2174c = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: d */
    private static final Map<String, Constructor<? extends View>> f2175d = new C1253b();

    /* renamed from: e */
    private final Object[] f2176e = new Object[2];

    /* renamed from: android.support.v7.app.AppCompatViewInflater$a */
    private static class C0734a implements OnClickListener {

        /* renamed from: a */
        private final View f2177a;

        /* renamed from: b */
        private final String f2178b;

        /* renamed from: c */
        private Method f2179c;

        /* renamed from: d */
        private Context f2180d;

        public C0734a(View hostView, String methodName) {
            this.f2177a = hostView;
            this.f2178b = methodName;
        }

        public void onClick(View v) {
            if (this.f2179c == null) {
                m3414a(this.f2177a.getContext(), this.f2178b);
            }
            try {
                this.f2179c.invoke(this.f2180d, new Object[]{v});
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }

        /* renamed from: a */
        private void m3414a(Context context, String name) {
            String idText;
            while (context != null) {
                try {
                    if (!context.isRestricted()) {
                        Method method = context.getClass().getMethod(this.f2178b, new Class[]{View.class});
                        if (method != null) {
                            this.f2179c = method;
                            this.f2180d = context;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
                if (context instanceof ContextWrapper) {
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    context = null;
                }
            }
            int id = this.f2177a.getId();
            if (id == -1) {
                idText = "";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(" with id '");
                sb.append(this.f2177a.getContext().getResources().getResourceEntryName(id));
                sb.append("'");
                idText = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Could not find method ");
            sb2.append(this.f2178b);
            sb2.append("(View) in a parent or ancestor Context for android:onClick ");
            sb2.append("attribute defined on view ");
            sb2.append(this.f2177a.getClass());
            sb2.append(idText);
            throw new IllegalStateException(sb2.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final View mo6060a(View parent, String name, Context context, AttributeSet attrs, boolean inheritContext, boolean readAndroidTheme, boolean readAppTheme, boolean wrapContext) {
        View view;
        Context originalContext = context;
        if (inheritContext && parent != null) {
            context = parent.getContext();
        }
        if (readAndroidTheme || readAppTheme) {
            context = m3394a(context, attrs, readAndroidTheme, readAppTheme);
        }
        if (wrapContext) {
            context = C1103pb.m5450a(context);
        }
        char c = 65535;
        switch (name.hashCode()) {
            case -1946472170:
                if (name.equals("RatingBar")) {
                    c = 11;
                    break;
                }
                break;
            case -1455429095:
                if (name.equals("CheckedTextView")) {
                    c = 8;
                    break;
                }
                break;
            case -1346021293:
                if (name.equals("MultiAutoCompleteTextView")) {
                    c = 10;
                    break;
                }
                break;
            case -938935918:
                if (name.equals("TextView")) {
                    c = 0;
                    break;
                }
                break;
            case -937446323:
                if (name.equals("ImageButton")) {
                    c = 5;
                    break;
                }
                break;
            case -658531749:
                if (name.equals("SeekBar")) {
                    c = 12;
                    break;
                }
                break;
            case -339785223:
                if (name.equals("Spinner")) {
                    c = 4;
                    break;
                }
                break;
            case 776382189:
                if (name.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                break;
            case 1125864064:
                if (name.equals("ImageView")) {
                    c = 1;
                    break;
                }
                break;
            case 1413872058:
                if (name.equals("AutoCompleteTextView")) {
                    c = 9;
                    break;
                }
                break;
            case 1601505219:
                if (name.equals("CheckBox")) {
                    c = 6;
                    break;
                }
                break;
            case 1666676343:
                if (name.equals("EditText")) {
                    c = 3;
                    break;
                }
                break;
            case 2001146706:
                if (name.equals("Button")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                view = mo6072m(context, attrs);
                m3397a(view, name);
                break;
            case 1:
                view = mo6066g(context, attrs);
                m3397a(view, name);
                break;
            case 2:
                view = mo6061b(context, attrs);
                m3397a(view, name);
                break;
            case 3:
                view = mo6064e(context, attrs);
                m3397a(view, name);
                break;
            case 4:
                view = mo6071l(context, attrs);
                m3397a(view, name);
                break;
            case 5:
                view = mo6065f(context, attrs);
                m3397a(view, name);
                break;
            case 6:
                view = mo6062c(context, attrs);
                m3397a(view, name);
                break;
            case 7:
                view = mo6068i(context, attrs);
                m3397a(view, name);
                break;
            case 8:
                view = mo6063d(context, attrs);
                m3397a(view, name);
                break;
            case 9:
                view = mo6058a(context, attrs);
                m3397a(view, name);
                break;
            case 10:
                view = mo6067h(context, attrs);
                m3397a(view, name);
                break;
            case 11:
                view = mo6069j(context, attrs);
                m3397a(view, name);
                break;
            case 12:
                view = mo6070k(context, attrs);
                m3397a(view, name);
                break;
            default:
                view = mo6059a(context, name, attrs);
                break;
        }
        if (view == null && originalContext != context) {
            view = m3398b(context, name, attrs);
        }
        if (view != null) {
            m3396a(view, attrs);
        }
        return view;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public C0939H mo6072m(Context context, AttributeSet attrs) {
        return new C0939H(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public AppCompatImageView mo6066g(Context context, AttributeSet attrs) {
        return new AppCompatImageView(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public AppCompatButton mo6061b(Context context, AttributeSet attrs) {
        return new AppCompatButton(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C1104q mo6064e(Context context, AttributeSet attrs) {
        return new C1104q(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public C0897A mo6071l(Context context, AttributeSet attrs) {
        return new C0897A(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C1110s mo6065f(Context context, AttributeSet attrs) {
        return new C1110s(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public C1085m mo6062c(Context context, AttributeSet attrs) {
        return new C1085m(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public AppCompatRadioButton mo6068i(Context context, AttributeSet attrs) {
        return new AppCompatRadioButton(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C1088n mo6063d(Context context, AttributeSet attrs) {
        return new C1088n(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1075k mo6058a(Context context, AttributeSet attrs) {
        return new C1075k(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public C1116u mo6067h(Context context, AttributeSet attrs) {
        return new C1116u(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public AppCompatRatingBar mo6069j(Context context, AttributeSet attrs) {
        return new AppCompatRatingBar(context, attrs);
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public C1130x mo6070k(Context context, AttributeSet attrs) {
        return new C1130x(context, attrs);
    }

    /* renamed from: a */
    private void m3397a(View view, String name) {
        if (view == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(getClass().getName());
            sb.append(" asked to inflate view for <");
            sb.append(name);
            sb.append(">, but returned null");
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo6059a(Context context, String name, AttributeSet attrs) {
        return null;
    }

    /* renamed from: b */
    private View m3398b(Context context, String name, AttributeSet attrs) {
        if (name.equals("view")) {
            name = attrs.getAttributeValue(null, "class");
        }
        try {
            this.f2176e[0] = context;
            this.f2176e[1] = attrs;
            if (-1 == name.indexOf(46)) {
                for (String a : f2174c) {
                    View view = m3395a(context, name, a);
                    if (view != null) {
                        return view;
                    }
                }
                Object[] objArr = this.f2176e;
                objArr[0] = null;
                objArr[1] = null;
                return null;
            }
            View a2 = m3395a(context, name, (String) null);
            Object[] objArr2 = this.f2176e;
            objArr2[0] = null;
            objArr2[1] = null;
            return a2;
        } catch (Exception e) {
            return null;
        } finally {
            Object[] objArr3 = this.f2176e;
            objArr3[0] = null;
            objArr3[1] = null;
        }
    }

    /* renamed from: a */
    private void m3396a(View view, AttributeSet attrs) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && (VERSION.SDK_INT < 15 || C0646w.m2983q(view))) {
            TypedArray a = context.obtainStyledAttributes(attrs, f2173b);
            String handlerName = a.getString(0);
            if (handlerName != null) {
                view.setOnClickListener(new C0734a(view, handlerName));
            }
            a.recycle();
        }
    }

    /* renamed from: a */
    private View m3395a(Context context, String name, String prefix) throws ClassNotFoundException, InflateException {
        String str;
        Constructor constructor = (Constructor) f2175d.get(name);
        if (constructor == null) {
            try {
                ClassLoader classLoader = context.getClassLoader();
                if (prefix != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(prefix);
                    sb.append(name);
                    str = sb.toString();
                } else {
                    str = name;
                }
                constructor = classLoader.loadClass(str).asSubclass(View.class).getConstructor(f2172a);
                f2175d.put(name, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f2176e);
    }

    /* renamed from: a */
    private static Context m3394a(Context context, AttributeSet attrs, boolean useAndroidTheme, boolean useAppTheme) {
        TypedArray a = context.obtainStyledAttributes(attrs, C0793R.styleable.View, 0, 0);
        int themeId = 0;
        if (useAndroidTheme) {
            themeId = a.getResourceId(C0793R.styleable.View_android_theme, 0);
        }
        if (useAppTheme && themeId == 0) {
            themeId = a.getResourceId(C0793R.styleable.View_theme, 0);
            if (themeId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        a.recycle();
        if (themeId == 0) {
            return context;
        }
        if (!(context instanceof C1303d) || ((C1303d) context).mo9231a() != themeId) {
            return new C1303d(context, themeId);
        }
        return context;
    }
}
