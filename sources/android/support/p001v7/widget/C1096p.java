package android.support.p001v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p000v4.content.C0510b;
import android.support.p001v7.appcompat.C0793R;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import p002b.p003c.p051e.p052a.C1181d;
import p002b.p003c.p051e.p052a.C1191k;
import p002b.p003c.p053g.p054a.C1199a;
import p002b.p003c.p053g.p054a.p055a.C1200a;
import p002b.p003c.p053g.p061f.C1253b;
import p002b.p003c.p053g.p061f.C1259h;
import p002b.p003c.p053g.p061f.C1260i;
import p002b.p003c.p053g.p061f.C1274r;
import p002b.p003c.p062h.p064b.p065a.C1282b;

/* renamed from: android.support.v7.widget.p */
/* compiled from: AppCompatDrawableManager */
public final class C1096p {

    /* renamed from: a */
    private static final Mode f3660a = Mode.SRC_IN;

    /* renamed from: b */
    private static C1096p f3661b;

    /* renamed from: c */
    private static final C1098b f3662c = new C1098b(6);

    /* renamed from: d */
    private static final int[] f3663d = {C0793R.drawable.abc_textfield_search_default_mtrl_alpha, C0793R.drawable.abc_textfield_default_mtrl_alpha, C0793R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* renamed from: e */
    private static final int[] f3664e = {C0793R.drawable.abc_ic_commit_search_api_mtrl_alpha, C0793R.drawable.abc_seekbar_tick_mark_material, C0793R.drawable.abc_ic_menu_share_mtrl_alpha, C0793R.drawable.abc_ic_menu_copy_mtrl_am_alpha, C0793R.drawable.abc_ic_menu_cut_mtrl_alpha, C0793R.drawable.abc_ic_menu_selectall_mtrl_alpha, C0793R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* renamed from: f */
    private static final int[] f3665f = {C0793R.drawable.abc_textfield_activated_mtrl_alpha, C0793R.drawable.abc_textfield_search_activated_mtrl_alpha, C0793R.drawable.abc_cab_background_top_mtrl_alpha, C0793R.drawable.abc_text_cursor_material, C0793R.drawable.abc_text_select_handle_left_mtrl_dark, C0793R.drawable.abc_text_select_handle_middle_mtrl_dark, C0793R.drawable.abc_text_select_handle_right_mtrl_dark, C0793R.drawable.abc_text_select_handle_left_mtrl_light, C0793R.drawable.abc_text_select_handle_middle_mtrl_light, C0793R.drawable.abc_text_select_handle_right_mtrl_light};

    /* renamed from: g */
    private static final int[] f3666g = {C0793R.drawable.abc_popup_background_mtrl_mult, C0793R.drawable.abc_cab_background_internal_bg, C0793R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* renamed from: h */
    private static final int[] f3667h = {C0793R.drawable.abc_tab_indicator_material, C0793R.drawable.abc_textfield_search_material};

    /* renamed from: i */
    private static final int[] f3668i = {C0793R.drawable.abc_btn_check_material, C0793R.drawable.abc_btn_radio_material};

    /* renamed from: j */
    private WeakHashMap<Context, C1274r<ColorStateList>> f3669j;

    /* renamed from: k */
    private C1253b<String, C1099c> f3670k;

    /* renamed from: l */
    private C1274r<String> f3671l;

    /* renamed from: m */
    private final Object f3672m = new Object();

    /* renamed from: n */
    private final WeakHashMap<Context, C1259h<WeakReference<ConstantState>>> f3673n = new WeakHashMap<>(0);

    /* renamed from: o */
    private TypedValue f3674o;

    /* renamed from: p */
    private boolean f3675p;

    /* renamed from: android.support.v7.widget.p$a */
    /* compiled from: AppCompatDrawableManager */
    private static class C1097a implements C1099c {
        C1097a() {
        }

        /* renamed from: a */
        public Drawable mo8570a(Context context, XmlPullParser parser, AttributeSet attrs, Theme theme) {
            try {
                return C1181d.m5645a(context, context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.p$b */
    /* compiled from: AppCompatDrawableManager */
    private static class C1098b extends C1260i<Integer, PorterDuffColorFilter> {
        public C1098b(int maxSize) {
            super(maxSize);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public PorterDuffColorFilter mo8571a(int color, Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m5445b(color, mode)));
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public PorterDuffColorFilter mo8572a(int color, Mode mode, PorterDuffColorFilter filter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m5445b(color, mode)), filter);
        }

        /* renamed from: b */
        private static int m5445b(int color, Mode mode) {
            return (((1 * 31) + color) * 31) + mode.hashCode();
        }
    }

    /* renamed from: android.support.v7.widget.p$c */
    /* compiled from: AppCompatDrawableManager */
    private interface C1099c {
        /* renamed from: a */
        Drawable mo8570a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: android.support.v7.widget.p$d */
    /* compiled from: AppCompatDrawableManager */
    private static class C1100d implements C1099c {
        C1100d() {
        }

        /* renamed from: a */
        public Drawable mo8570a(Context context, XmlPullParser parser, AttributeSet attrs, Theme theme) {
            try {
                return C1191k.createFromXmlInner(context.getResources(), parser, attrs, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    public static C1096p m5420a() {
        if (f3661b == null) {
            f3661b = new C1096p();
            m5424a(f3661b);
        }
        return f3661b;
    }

    /* renamed from: a */
    private static void m5424a(C1096p manager) {
        if (VERSION.SDK_INT < 24) {
            manager.m5425a("vector", (C1099c) new C1100d());
            manager.m5425a("animated-vector", (C1099c) new C1097a());
        }
    }

    /* renamed from: a */
    public Drawable mo8565a(Context context, int resId) {
        return mo8566a(context, resId, false);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Drawable mo8566a(Context context, int resId, boolean failIfNotKnown) {
        m5430b(context);
        Drawable drawable = m5438f(context, resId);
        if (drawable == null) {
            drawable = m5434d(context, resId);
        }
        if (drawable == null) {
            drawable = C0510b.m2572c(context, resId);
        }
        if (drawable != null) {
            drawable = m5418a(context, resId, failIfNotKnown, drawable);
        }
        if (drawable != null) {
            C1052ea.m5229b(drawable);
        }
        return drawable;
    }

    /* renamed from: a */
    public void mo8568a(Context context) {
        synchronized (this.f3672m) {
            LongSparseArray<WeakReference<ConstantState>> cache = (C1259h) this.f3673n.get(context);
            if (cache != null) {
                cache.mo9054a();
            }
        }
    }

    /* renamed from: a */
    private static long m5414a(TypedValue tv) {
        return (((long) tv.assetCookie) << 32) | ((long) tv.data);
    }

    /* renamed from: d */
    private Drawable m5434d(Context context, int resId) {
        if (this.f3674o == null) {
            this.f3674o = new TypedValue();
        }
        TypedValue tv = this.f3674o;
        context.getResources().getValue(resId, tv, true);
        long key = m5414a(tv);
        Drawable dr = m5419a(context, key);
        if (dr != null) {
            return dr;
        }
        if (resId == C0793R.drawable.abc_cab_background_top_material) {
            dr = new LayerDrawable(new Drawable[]{mo8565a(context, C0793R.drawable.abc_cab_background_internal_bg), mo8565a(context, C0793R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        if (dr != null) {
            dr.setChangingConfigurations(tv.changingConfigurations);
            m5427a(context, key, dr);
        }
        return dr;
    }

    /* renamed from: a */
    private Drawable m5418a(Context context, int resId, boolean failIfNotKnown, Drawable drawable) {
        ColorStateList tintList = mo8569b(context, resId);
        if (tintList != null) {
            if (C1052ea.m5228a(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable drawable2 = C1200a.m5741i(drawable);
            C1200a.m5726a(drawable2, tintList);
            Mode tintMode = m5415a(resId);
            if (tintMode == null) {
                return drawable2;
            }
            C1200a.m5729a(drawable2, tintMode);
            return drawable2;
        } else if (resId == C0793R.drawable.abc_seekbar_track_material) {
            LayerDrawable ld = (LayerDrawable) drawable;
            m5422a(ld.findDrawableByLayerId(16908288), C1092nb.m5402b(context, C0793R.attr.colorControlNormal), f3660a);
            m5422a(ld.findDrawableByLayerId(16908303), C1092nb.m5402b(context, C0793R.attr.colorControlNormal), f3660a);
            m5422a(ld.findDrawableByLayerId(16908301), C1092nb.m5402b(context, C0793R.attr.colorControlActivated), f3660a);
            return drawable;
        } else if (resId == C0793R.drawable.abc_ratingbar_material || resId == C0793R.drawable.abc_ratingbar_indicator_material || resId == C0793R.drawable.abc_ratingbar_small_material) {
            LayerDrawable ld2 = (LayerDrawable) drawable;
            m5422a(ld2.findDrawableByLayerId(16908288), C1092nb.m5399a(context, C0793R.attr.colorControlNormal), f3660a);
            m5422a(ld2.findDrawableByLayerId(16908303), C1092nb.m5402b(context, C0793R.attr.colorControlActivated), f3660a);
            m5422a(ld2.findDrawableByLayerId(16908301), C1092nb.m5402b(context, C0793R.attr.colorControlActivated), f3660a);
            return drawable;
        } else if (m5426a(context, resId, drawable) || !failIfNotKnown) {
            return drawable;
        } else {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0076 A[Catch:{ Exception -> 0x00a6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A[Catch:{ Exception -> 0x00a6 }] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5438f(android.content.Context r13, int r14) {
        /*
            r12 = this;
            b.c.g.f.b<java.lang.String, android.support.v7.widget.p$c> r0 = r12.f3670k
            r1 = 0
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b6
            b.c.g.f.r<java.lang.String> r0 = r12.f3671l
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x002a
            java.lang.Object r0 = r0.mo9175b(r14)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0029
            if (r0 == 0) goto L_0x0028
            b.c.g.f.b<java.lang.String, android.support.v7.widget.p$c> r3 = r12.f3670k
            java.lang.Object r3 = r3.get(r0)
            if (r3 != 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            goto L_0x0031
        L_0x0029:
            return r1
        L_0x002a:
            b.c.g.f.r r0 = new b.c.g.f.r
            r0.<init>()
            r12.f3671l = r0
        L_0x0031:
            android.util.TypedValue r0 = r12.f3674o
            if (r0 != 0) goto L_0x003c
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r12.f3674o = r0
        L_0x003c:
            android.util.TypedValue r0 = r12.f3674o
            android.content.res.Resources r1 = r13.getResources()
            r3 = 1
            r1.getValue(r14, r0, r3)
            long r4 = m5414a(r0)
            android.graphics.drawable.Drawable r6 = r12.m5419a(r13, r4)
            if (r6 == 0) goto L_0x0051
            return r6
        L_0x0051:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ae
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ae
            android.content.res.XmlResourceParser r7 = r1.getXml(r14)     // Catch:{ Exception -> 0x00a6 }
            android.util.AttributeSet r8 = android.util.Xml.asAttributeSet(r7)     // Catch:{ Exception -> 0x00a6 }
        L_0x0069:
            int r9 = r7.next()     // Catch:{ Exception -> 0x00a6 }
            r10 = r9
            r11 = 2
            if (r9 == r11) goto L_0x0074
            if (r10 == r3) goto L_0x0074
            goto L_0x0069
        L_0x0074:
            if (r10 != r11) goto L_0x009e
            java.lang.String r3 = r7.getName()     // Catch:{ Exception -> 0x00a6 }
            b.c.g.f.r<java.lang.String> r9 = r12.f3671l     // Catch:{ Exception -> 0x00a6 }
            r9.mo9173a(r14, r3)     // Catch:{ Exception -> 0x00a6 }
            b.c.g.f.b<java.lang.String, android.support.v7.widget.p$c> r9 = r12.f3670k     // Catch:{ Exception -> 0x00a6 }
            java.lang.Object r9 = r9.get(r3)     // Catch:{ Exception -> 0x00a6 }
            android.support.v7.widget.p$c r9 = (android.support.p001v7.widget.C1096p.C1099c) r9     // Catch:{ Exception -> 0x00a6 }
            if (r9 == 0) goto L_0x0093
            android.content.res.Resources$Theme r11 = r13.getTheme()     // Catch:{ Exception -> 0x00a6 }
            android.graphics.drawable.Drawable r11 = r9.mo8570a(r13, r7, r8, r11)     // Catch:{ Exception -> 0x00a6 }
            r6 = r11
        L_0x0093:
            if (r6 == 0) goto L_0x009d
            int r11 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a6 }
            r6.setChangingConfigurations(r11)     // Catch:{ Exception -> 0x00a6 }
            r12.m5427a(r13, r4, r6)     // Catch:{ Exception -> 0x00a6 }
        L_0x009d:
            goto L_0x00ae
        L_0x009e:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a6 }
            java.lang.String r9 = "No start tag found"
            r3.<init>(r9)     // Catch:{ Exception -> 0x00a6 }
            throw r3     // Catch:{ Exception -> 0x00a6 }
        L_0x00a6:
            r3 = move-exception
            java.lang.String r7 = "AppCompatDrawableManag"
            java.lang.String r8 = "Exception while inflating drawable"
            android.util.Log.e(r7, r8, r3)
        L_0x00ae:
            if (r6 != 0) goto L_0x00b5
            b.c.g.f.r<java.lang.String> r3 = r12.f3671l
            r3.mo9173a(r14, r2)
        L_0x00b5:
            return r6
        L_0x00b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C1096p.m5438f(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002e, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5419a(android.content.Context r6, long r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f3672m
            monitor-enter(r0)
            java.util.WeakHashMap<android.content.Context, b.c.g.f.h<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r1 = r5.f3673n     // Catch:{ all -> 0x002f }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x002f }
            b.c.g.f.h r1 = (p002b.p003c.p053g.p061f.C1259h) r1     // Catch:{ all -> 0x002f }
            r2 = 0
            if (r1 != 0) goto L_0x0010
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x0010:
            java.lang.Object r3 = r1.mo9058b(r7)     // Catch:{ all -> 0x002f }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002d
            java.lang.Object r4 = r3.get()     // Catch:{ all -> 0x002f }
            android.graphics.drawable.Drawable$ConstantState r4 = (android.graphics.drawable.Drawable.ConstantState) r4     // Catch:{ all -> 0x002f }
            if (r4 == 0) goto L_0x002a
            android.content.res.Resources r2 = r6.getResources()     // Catch:{ all -> 0x002f }
            android.graphics.drawable.Drawable r2 = r4.newDrawable(r2)     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x002a:
            r1.mo9055a(r7)     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.widget.C1096p.m5419a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    private boolean m5427a(Context context, long key, Drawable drawable) {
        ConstantState cs = drawable.getConstantState();
        if (cs == null) {
            return false;
        }
        synchronized (this.f3672m) {
            C1259h hVar = (C1259h) this.f3673n.get(context);
            if (hVar == null) {
                hVar = new C1259h();
                this.f3673n.put(context, hVar);
            }
            hVar.mo9063c(key, new WeakReference(cs));
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Drawable mo8567a(Context context, C0930Fb resources, int resId) {
        Drawable drawable = m5438f(context, resId);
        if (drawable == null) {
            drawable = resources.mo7217a(resId);
        }
        if (drawable != null) {
            return m5418a(context, resId, false, drawable);
        }
        return null;
    }

    /* renamed from: a */
    static boolean m5426a(Context context, int resId, Drawable drawable) {
        Mode tintMode = f3660a;
        boolean colorAttrSet = false;
        int colorAttr = 0;
        int alpha = -1;
        if (m5429a(f3663d, resId)) {
            colorAttr = C0793R.attr.colorControlNormal;
            colorAttrSet = true;
        } else if (m5429a(f3665f, resId)) {
            colorAttr = C0793R.attr.colorControlActivated;
            colorAttrSet = true;
        } else if (m5429a(f3666g, resId)) {
            colorAttr = 16842801;
            colorAttrSet = true;
            tintMode = Mode.MULTIPLY;
        } else if (resId == C0793R.drawable.abc_list_divider_mtrl_alpha) {
            colorAttr = 16842800;
            colorAttrSet = true;
            alpha = Math.round(40.8f);
        } else if (resId == C0793R.drawable.abc_dialog_material_background) {
            colorAttr = 16842801;
            colorAttrSet = true;
        }
        if (!colorAttrSet) {
            return false;
        }
        if (C1052ea.m5228a(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(m5416a(C1092nb.m5402b(context, colorAttr), tintMode));
        if (alpha != -1) {
            drawable.setAlpha(alpha);
        }
        return true;
    }

    /* renamed from: a */
    private void m5425a(String tagName, C1099c delegate) {
        if (this.f3670k == null) {
            this.f3670k = new C1253b<>();
        }
        this.f3670k.put(tagName, delegate);
    }

    /* renamed from: a */
    private static boolean m5429a(int[] array, int value) {
        for (int id : array) {
            if (id == value) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    static Mode m5415a(int resId) {
        if (resId == C0793R.drawable.abc_switch_thumb_material) {
            return Mode.MULTIPLY;
        }
        return null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public ColorStateList mo8569b(Context context, int resId) {
        ColorStateList tint = m5436e(context, resId);
        if (tint == null) {
            if (resId == C0793R.drawable.abc_edit_text_material) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_edittext);
            } else if (resId == C0793R.drawable.abc_switch_track_mtrl_alpha) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_switch_track);
            } else if (resId == C0793R.drawable.abc_switch_thumb_material) {
                tint = m5437f(context);
            } else if (resId == C0793R.drawable.abc_btn_default_mtrl_shape) {
                tint = m5435e(context);
            } else if (resId == C0793R.drawable.abc_btn_borderless_material) {
                tint = m5431c(context);
            } else if (resId == C0793R.drawable.abc_btn_colored_material) {
                tint = m5433d(context);
            } else if (resId == C0793R.drawable.abc_spinner_mtrl_am_alpha || resId == C0793R.drawable.abc_spinner_textfield_background_material) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_spinner);
            } else if (m5429a(f3664e, resId)) {
                tint = C1092nb.m5403c(context, C0793R.attr.colorControlNormal);
            } else if (m5429a(f3667h, resId)) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_default);
            } else if (m5429a(f3668i, resId)) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_btn_checkable);
            } else if (resId == C0793R.drawable.abc_seekbar_thumb_material) {
                tint = C1282b.m5997a(context, C0793R.color.abc_tint_seek_thumb);
            }
            if (tint != null) {
                m5421a(context, resId, tint);
            }
        }
        return tint;
    }

    /* renamed from: e */
    private ColorStateList m5436e(Context context, int resId) {
        WeakHashMap<Context, C1274r<ColorStateList>> weakHashMap = this.f3669j;
        ColorStateList colorStateList = null;
        if (weakHashMap == null) {
            return null;
        }
        SparseArrayCompat<ColorStateList> tints = (C1274r) weakHashMap.get(context);
        if (tints != null) {
            colorStateList = (ColorStateList) tints.mo9175b(resId);
        }
        return colorStateList;
    }

    /* renamed from: a */
    private void m5421a(Context context, int resId, ColorStateList tintList) {
        if (this.f3669j == null) {
            this.f3669j = new WeakHashMap<>();
        }
        C1274r rVar = (C1274r) this.f3669j.get(context);
        if (rVar == null) {
            rVar = new C1274r();
            this.f3669j.put(context, rVar);
        }
        rVar.mo9173a(resId, tintList);
    }

    /* renamed from: e */
    private ColorStateList m5435e(Context context) {
        return m5432c(context, C1092nb.m5402b(context, C0793R.attr.colorButtonNormal));
    }

    /* renamed from: c */
    private ColorStateList m5431c(Context context) {
        return m5432c(context, 0);
    }

    /* renamed from: d */
    private ColorStateList m5433d(Context context) {
        return m5432c(context, C1092nb.m5402b(context, C0793R.attr.colorAccent));
    }

    /* renamed from: c */
    private ColorStateList m5432c(Context context, int baseColor) {
        int[][] states = new int[4][];
        int[] colors = new int[4];
        int colorControlHighlight = C1092nb.m5402b(context, C0793R.attr.colorControlHighlight);
        int disabledColor = C1092nb.m5399a(context, C0793R.attr.colorButtonNormal);
        states[0] = C1092nb.f3636b;
        colors[0] = disabledColor;
        int i = 0 + 1;
        states[i] = C1092nb.f3639e;
        colors[i] = C1199a.m5718a(colorControlHighlight, baseColor);
        int i2 = i + 1;
        states[i2] = C1092nb.f3637c;
        colors[i2] = C1199a.m5718a(colorControlHighlight, baseColor);
        int i3 = i2 + 1;
        states[i3] = C1092nb.f3643i;
        colors[i3] = baseColor;
        int i4 = i3 + 1;
        return new ColorStateList(states, colors);
    }

    /* renamed from: f */
    private ColorStateList m5437f(Context context) {
        int[][] states = new int[3][];
        int[] colors = new int[3];
        ColorStateList thumbColor = C1092nb.m5403c(context, C0793R.attr.colorSwitchThumbNormal);
        if (thumbColor == null || !thumbColor.isStateful()) {
            states[0] = C1092nb.f3636b;
            colors[0] = C1092nb.m5399a(context, C0793R.attr.colorSwitchThumbNormal);
            int i = 0 + 1;
            states[i] = C1092nb.f3640f;
            colors[i] = C1092nb.m5402b(context, C0793R.attr.colorControlActivated);
            int i2 = i + 1;
            states[i2] = C1092nb.f3643i;
            colors[i2] = C1092nb.m5402b(context, C0793R.attr.colorSwitchThumbNormal);
            int i3 = i2 + 1;
        } else {
            states[0] = C1092nb.f3636b;
            colors[0] = thumbColor.getColorForState(states[0], 0);
            int i4 = 0 + 1;
            states[i4] = C1092nb.f3640f;
            colors[i4] = C1092nb.m5402b(context, C0793R.attr.colorControlActivated);
            int i5 = i4 + 1;
            states[i5] = C1092nb.f3643i;
            colors[i5] = thumbColor.getDefaultColor();
            int i6 = i5 + 1;
        }
        return new ColorStateList(states, colors);
    }

    /* renamed from: a */
    static void m5423a(Drawable drawable, C1106qb tint, int[] state) {
        if (!C1052ea.m5228a(drawable) || drawable.mutate() == drawable) {
            if (tint.f3687d || tint.f3686c) {
                drawable.setColorFilter(m5417a(tint.f3687d ? tint.f3684a : null, tint.f3686c ? tint.f3685b : f3660a, state));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
            return;
        }
        Log.d("AppCompatDrawableManag", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m5417a(ColorStateList tint, Mode tintMode, int[] state) {
        if (tint == null || tintMode == null) {
            return null;
        }
        return m5416a(tint.getColorForState(state, 0), tintMode);
    }

    /* renamed from: a */
    public static PorterDuffColorFilter m5416a(int color, Mode mode) {
        PorterDuffColorFilter filter = f3662c.mo8571a(color, mode);
        if (filter != null) {
            return filter;
        }
        PorterDuffColorFilter filter2 = new PorterDuffColorFilter(color, mode);
        f3662c.mo8572a(color, mode, filter2);
        return filter2;
    }

    /* renamed from: a */
    private static void m5422a(Drawable d, int color, Mode mode) {
        if (C1052ea.m5228a(d)) {
            d = d.mutate();
        }
        d.setColorFilter(m5416a(color, mode == null ? f3660a : mode));
    }

    /* renamed from: b */
    private void m5430b(Context context) {
        if (!this.f3675p) {
            this.f3675p = true;
            Drawable d = mo8565a(context, C0793R.drawable.abc_vector_test);
            if (d == null || !m5428a(d)) {
                this.f3675p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: a */
    private static boolean m5428a(Drawable d) {
        if (!(d instanceof C1191k)) {
            if (!"android.graphics.drawable.VectorDrawable".equals(d.getClass().getName())) {
                return false;
            }
        }
        return true;
    }
}
