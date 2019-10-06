package p002b.p003c.p062h.p071g;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.support.p000v4.view.C0620e;
import android.support.p000v4.view.C0629j;
import android.support.p001v7.appcompat.C0793R;
import android.support.p001v7.view.menu.C0879p;
import android.support.p001v7.view.menu.C0880q;
import android.support.p001v7.widget.C1052ea;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p053g.p056b.p057a.C1223a;

/* renamed from: b.c.h.g.g */
/* compiled from: SupportMenuInflater */
public class C1307g extends MenuInflater {

    /* renamed from: a */
    static final Class<?>[] f4144a = {Context.class};

    /* renamed from: b */
    static final Class<?>[] f4145b = f4144a;

    /* renamed from: c */
    final Object[] f4146c;

    /* renamed from: d */
    final Object[] f4147d = this.f4146c;

    /* renamed from: e */
    Context f4148e;

    /* renamed from: f */
    private Object f4149f;

    /* renamed from: b.c.h.g.g$a */
    /* compiled from: SupportMenuInflater */
    private static class C1308a implements OnMenuItemClickListener {

        /* renamed from: a */
        private static final Class<?>[] f4150a = {MenuItem.class};

        /* renamed from: b */
        private Object f4151b;

        /* renamed from: c */
        private Method f4152c;

        public C1308a(Object realOwner, String methodName) {
            this.f4151b = realOwner;
            Class<?> c = realOwner.getClass();
            try {
                this.f4152c = c.getMethod(methodName, f4150a);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Couldn't resolve menu item onClick handler ");
                sb.append(methodName);
                sb.append(" in class ");
                sb.append(c.getName());
                InflateException ex = new InflateException(sb.toString());
                ex.initCause(e);
                throw ex;
            }
        }

        public boolean onMenuItemClick(MenuItem item) {
            try {
                if (this.f4152c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f4152c.invoke(this.f4151b, new Object[]{item})).booleanValue();
                }
                this.f4152c.invoke(this.f4151b, new Object[]{item});
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: b.c.h.g.g$b */
    /* compiled from: SupportMenuInflater */
    private class C1309b {

        /* renamed from: A */
        C0620e f4153A;

        /* renamed from: B */
        private CharSequence f4154B;

        /* renamed from: C */
        private CharSequence f4155C;

        /* renamed from: D */
        private ColorStateList f4156D = null;

        /* renamed from: E */
        private Mode f4157E = null;

        /* renamed from: a */
        private Menu f4159a;

        /* renamed from: b */
        private int f4160b;

        /* renamed from: c */
        private int f4161c;

        /* renamed from: d */
        private int f4162d;

        /* renamed from: e */
        private int f4163e;

        /* renamed from: f */
        private boolean f4164f;

        /* renamed from: g */
        private boolean f4165g;

        /* renamed from: h */
        private boolean f4166h;

        /* renamed from: i */
        private int f4167i;

        /* renamed from: j */
        private int f4168j;

        /* renamed from: k */
        private CharSequence f4169k;

        /* renamed from: l */
        private CharSequence f4170l;

        /* renamed from: m */
        private int f4171m;

        /* renamed from: n */
        private char f4172n;

        /* renamed from: o */
        private int f4173o;

        /* renamed from: p */
        private char f4174p;

        /* renamed from: q */
        private int f4175q;

        /* renamed from: r */
        private int f4176r;

        /* renamed from: s */
        private boolean f4177s;

        /* renamed from: t */
        private boolean f4178t;

        /* renamed from: u */
        private boolean f4179u;

        /* renamed from: v */
        private int f4180v;

        /* renamed from: w */
        private int f4181w;

        /* renamed from: x */
        private String f4182x;

        /* renamed from: y */
        private String f4183y;

        /* renamed from: z */
        private String f4184z;

        public C1309b(Menu menu) {
            this.f4159a = menu;
            mo9265d();
        }

        /* renamed from: d */
        public void mo9265d() {
            this.f4160b = 0;
            this.f4161c = 0;
            this.f4162d = 0;
            this.f4163e = 0;
            this.f4164f = true;
            this.f4165g = true;
        }

        /* renamed from: a */
        public void mo9261a(AttributeSet attrs) {
            TypedArray a = C1307g.this.f4148e.obtainStyledAttributes(attrs, C0793R.styleable.MenuGroup);
            this.f4160b = a.getResourceId(C0793R.styleable.MenuGroup_android_id, 0);
            this.f4161c = a.getInt(C0793R.styleable.MenuGroup_android_menuCategory, 0);
            this.f4162d = a.getInt(C0793R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f4163e = a.getInt(C0793R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f4164f = a.getBoolean(C0793R.styleable.MenuGroup_android_visible, true);
            this.f4165g = a.getBoolean(C0793R.styleable.MenuGroup_android_enabled, true);
            a.recycle();
        }

        /* renamed from: b */
        public void mo9263b(AttributeSet attrs) {
            TypedArray a = C1307g.this.f4148e.obtainStyledAttributes(attrs, C0793R.styleable.MenuItem);
            this.f4167i = a.getResourceId(C0793R.styleable.MenuItem_android_id, 0);
            this.f4168j = (-65536 & a.getInt(C0793R.styleable.MenuItem_android_menuCategory, this.f4161c)) | (65535 & a.getInt(C0793R.styleable.MenuItem_android_orderInCategory, this.f4162d));
            this.f4169k = a.getText(C0793R.styleable.MenuItem_android_title);
            this.f4170l = a.getText(C0793R.styleable.MenuItem_android_titleCondensed);
            this.f4171m = a.getResourceId(C0793R.styleable.MenuItem_android_icon, 0);
            this.f4172n = m6100a(a.getString(C0793R.styleable.MenuItem_android_alphabeticShortcut));
            this.f4173o = a.getInt(C0793R.styleable.MenuItem_alphabeticModifiers, Opcodes.ACC_SYNTHETIC);
            this.f4174p = m6100a(a.getString(C0793R.styleable.MenuItem_android_numericShortcut));
            this.f4175q = a.getInt(C0793R.styleable.MenuItem_numericModifiers, Opcodes.ACC_SYNTHETIC);
            if (a.hasValue(C0793R.styleable.MenuItem_android_checkable)) {
                this.f4176r = a.getBoolean(C0793R.styleable.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f4176r = this.f4163e;
            }
            this.f4177s = a.getBoolean(C0793R.styleable.MenuItem_android_checked, false);
            this.f4178t = a.getBoolean(C0793R.styleable.MenuItem_android_visible, this.f4164f);
            this.f4179u = a.getBoolean(C0793R.styleable.MenuItem_android_enabled, this.f4165g);
            this.f4180v = a.getInt(C0793R.styleable.MenuItem_showAsAction, -1);
            this.f4184z = a.getString(C0793R.styleable.MenuItem_android_onClick);
            this.f4181w = a.getResourceId(C0793R.styleable.MenuItem_actionLayout, 0);
            this.f4182x = a.getString(C0793R.styleable.MenuItem_actionViewClass);
            this.f4183y = a.getString(C0793R.styleable.MenuItem_actionProviderClass);
            boolean hasActionProvider = this.f4183y != null;
            if (hasActionProvider && this.f4181w == 0 && this.f4182x == null) {
                this.f4153A = (C0620e) m6101a(this.f4183y, C1307g.f4145b, C1307g.this.f4147d);
            } else {
                if (hasActionProvider) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f4153A = null;
            }
            this.f4154B = a.getText(C0793R.styleable.MenuItem_contentDescription);
            this.f4155C = a.getText(C0793R.styleable.MenuItem_tooltipText);
            if (a.hasValue(C0793R.styleable.MenuItem_iconTintMode)) {
                this.f4157E = C1052ea.m5227a(a.getInt(C0793R.styleable.MenuItem_iconTintMode, -1), this.f4157E);
            } else {
                this.f4157E = null;
            }
            if (a.hasValue(C0793R.styleable.MenuItem_iconTint)) {
                this.f4156D = a.getColorStateList(C0793R.styleable.MenuItem_iconTint);
            } else {
                this.f4156D = null;
            }
            a.recycle();
            this.f4166h = false;
        }

        /* renamed from: a */
        private char m6100a(String shortcutString) {
            if (shortcutString == null) {
                return 0;
            }
            return shortcutString.charAt(0);
        }

        /* renamed from: a */
        private void m6102a(MenuItem item) {
            item.setChecked(this.f4177s).setVisible(this.f4178t).setEnabled(this.f4179u).setCheckable(this.f4176r >= 1).setTitleCondensed(this.f4170l).setIcon(this.f4171m);
            int i = this.f4180v;
            if (i >= 0) {
                item.setShowAsAction(i);
            }
            if (this.f4184z != null) {
                if (!C1307g.this.f4148e.isRestricted()) {
                    item.setOnMenuItemClickListener(new C1308a(C1307g.this.mo9257a(), this.f4184z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (item instanceof C0879p) {
                C0879p pVar = (C0879p) item;
            }
            if (this.f4176r >= 2) {
                if (item instanceof C0879p) {
                    ((C0879p) item).mo6775c(true);
                } else if (item instanceof C0880q) {
                    ((C0880q) item).mo6824a(true);
                }
            }
            boolean actionViewSpecified = false;
            String str = this.f4182x;
            if (str != null) {
                item.setActionView((View) m6101a(str, C1307g.f4144a, C1307g.this.f4146c));
                actionViewSpecified = true;
            }
            int i2 = this.f4181w;
            if (i2 > 0) {
                if (!actionViewSpecified) {
                    item.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            C0620e eVar = this.f4153A;
            if (eVar != null) {
                C0629j.m2889a(item, eVar);
            }
            C0629j.m2894a(item, this.f4154B);
            C0629j.m2896b(item, this.f4155C);
            C0629j.m2891a(item, this.f4172n, this.f4173o);
            C0629j.m2895b(item, this.f4174p, this.f4175q);
            Mode mode = this.f4157E;
            if (mode != null) {
                C0629j.m2893a(item, mode);
            }
            ColorStateList colorStateList = this.f4156D;
            if (colorStateList != null) {
                C0629j.m2892a(item, colorStateList);
            }
        }

        /* renamed from: a */
        public void mo9260a() {
            this.f4166h = true;
            m6102a(this.f4159a.add(this.f4160b, this.f4167i, this.f4168j, this.f4169k));
        }

        /* renamed from: b */
        public SubMenu mo9262b() {
            this.f4166h = true;
            SubMenu subMenu = this.f4159a.addSubMenu(this.f4160b, this.f4167i, this.f4168j, this.f4169k);
            m6102a(subMenu.getItem());
            return subMenu;
        }

        /* renamed from: c */
        public boolean mo9264c() {
            return this.f4166h;
        }

        /* renamed from: a */
        private <T> T m6101a(String className, Class<?>[] constructorSignature, Object[] arguments) {
            try {
                Constructor<?> constructor = C1307g.this.f4148e.getClassLoader().loadClass(className).getConstructor(constructorSignature);
                constructor.setAccessible(true);
                return constructor.newInstance(arguments);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot instantiate class: ");
                sb.append(className);
                Log.w("SupportMenuInflater", sb.toString(), e);
                return null;
            }
        }
    }

    public C1307g(Context context) {
        super(context);
        this.f4148e = context;
        this.f4146c = new Object[]{context};
    }

    public void inflate(int menuRes, Menu menu) {
        String str = "Error inflating menu XML";
        if (!(menu instanceof C1223a)) {
            super.inflate(menuRes, menu);
            return;
        }
        XmlResourceParser parser = null;
        try {
            parser = this.f4148e.getResources().getLayout(menuRes);
            m6098a(parser, Xml.asAttributeSet(parser), menu);
            if (parser != null) {
                parser.close();
            }
        } catch (XmlPullParserException e) {
            throw new InflateException(str, e);
        } catch (IOException e2) {
            throw new InflateException(str, e2);
        } catch (Throwable th) {
            if (parser != null) {
                parser.close();
            }
            throw th;
        }
    }

    /* renamed from: a */
    private void m6098a(XmlPullParser parser, AttributeSet attrs, Menu menu) throws XmlPullParserException, IOException {
        String str;
        C1309b menuState = new C1309b(menu);
        int eventType = parser.getEventType();
        boolean lookingForEndOfUnknownTag = false;
        String unknownTagName = null;
        while (true) {
            str = "menu";
            if (eventType != 2) {
                eventType = parser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String tagName = parser.getName();
                if (tagName.equals(str)) {
                    eventType = parser.next();
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Expecting menu, got ");
                    sb.append(tagName);
                    throw new RuntimeException(sb.toString());
                }
            }
        }
        boolean reachedEndOfMenu = false;
        while (!reachedEndOfMenu) {
            if (eventType != 1) {
                String str2 = "item";
                String str3 = "group";
                if (eventType != 2) {
                    if (eventType == 3) {
                        String tagName2 = parser.getName();
                        if (lookingForEndOfUnknownTag && tagName2.equals(unknownTagName)) {
                            lookingForEndOfUnknownTag = false;
                            unknownTagName = null;
                        } else if (tagName2.equals(str3)) {
                            menuState.mo9265d();
                        } else if (tagName2.equals(str2)) {
                            if (!menuState.mo9264c()) {
                                C0620e eVar = menuState.f4153A;
                                if (eVar == null || !eVar.mo5649a()) {
                                    menuState.mo9260a();
                                } else {
                                    menuState.mo9262b();
                                }
                            }
                        } else if (tagName2.equals(str)) {
                            reachedEndOfMenu = true;
                        }
                    }
                } else if (!lookingForEndOfUnknownTag) {
                    String tagName3 = parser.getName();
                    if (tagName3.equals(str3)) {
                        menuState.mo9261a(attrs);
                    } else if (tagName3.equals(str2)) {
                        menuState.mo9263b(attrs);
                    } else if (tagName3.equals(str)) {
                        m6098a(parser, attrs, menuState.mo9262b());
                    } else {
                        lookingForEndOfUnknownTag = true;
                        unknownTagName = tagName3;
                    }
                }
                eventType = parser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public Object mo9257a() {
        if (this.f4149f == null) {
            this.f4149f = m6097a(this.f4148e);
        }
        return this.f4149f;
    }

    /* renamed from: a */
    private Object m6097a(Object owner) {
        if (!(owner instanceof Activity) && (owner instanceof ContextWrapper)) {
            return m6097a(((ContextWrapper) owner).getBaseContext());
        }
        return owner;
    }
}
