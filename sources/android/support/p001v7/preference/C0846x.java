package android.support.p001v7.preference;

import android.content.Context;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import com.mopub.common.Constants;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: android.support.v7.preference.x */
/* compiled from: PreferenceInflater */
class C0846x {

    /* renamed from: a */
    private static final Class<?>[] f2544a = {Context.class, AttributeSet.class};

    /* renamed from: b */
    private static final HashMap<String, Constructor> f2545b = new HashMap<>();

    /* renamed from: c */
    private final Context f2546c;

    /* renamed from: d */
    private final Object[] f2547d = new Object[2];

    /* renamed from: e */
    private C0847y f2548e;

    /* renamed from: f */
    private String[] f2549f;

    public C0846x(Context context, C0847y preferenceManager) {
        this.f2546c = context;
        m3976a(preferenceManager);
    }

    /* renamed from: a */
    private void m3976a(C0847y preferenceManager) {
        this.f2548e = preferenceManager;
        mo6504a(new String[]{"android.support.v14.preference.", "android.support.v7.preference."});
    }

    /* renamed from: a */
    public void mo6504a(String[] defaultPackage) {
        this.f2549f = defaultPackage;
    }

    /* renamed from: a */
    public Context mo6500a() {
        return this.f2546c;
    }

    /* renamed from: a */
    public Preference mo6501a(int resource, PreferenceGroup root) {
        XmlResourceParser parser = mo6500a().getResources().getXml(resource);
        try {
            return mo6503a((XmlPullParser) parser, root);
        } finally {
            parser.close();
        }
    }

    /* renamed from: a */
    public Preference mo6503a(XmlPullParser parser, PreferenceGroup root) {
        int type;
        Preference result;
        synchronized (this.f2547d) {
            AttributeSet attrs = Xml.asAttributeSet(parser);
            this.f2547d[0] = this.f2546c;
            do {
                try {
                    type = parser.next();
                    if (type == 2) {
                        break;
                    }
                } catch (InflateException e) {
                    throw e;
                } catch (XmlPullParserException e2) {
                    InflateException ex = new InflateException(e2.getMessage());
                    ex.initCause(e2);
                    throw ex;
                } catch (IOException e3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(parser.getPositionDescription());
                    sb.append(": ");
                    sb.append(e3.getMessage());
                    InflateException ex2 = new InflateException(sb.toString());
                    ex2.initCause(e3);
                    throw ex2;
                }
            } while (type != 1);
            if (type == 2) {
                result = m3975a(root, (PreferenceGroup) m3979b(parser.getName(), attrs));
                m3978a(parser, result, attrs);
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(parser.getPositionDescription());
                sb2.append(": No start tag found!");
                throw new InflateException(sb2.toString());
            }
        }
        return result;
    }

    /* renamed from: a */
    private PreferenceGroup m3975a(PreferenceGroup givenRoot, PreferenceGroup xmlRoot) {
        if (givenRoot != null) {
            return givenRoot;
        }
        xmlRoot.mo6351a(this.f2548e);
        return xmlRoot;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0036, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0037, code lost:
        r5 = r9;
        r7 = r7 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007c, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
        r4 = new java.lang.StringBuilder();
        r4.append(r13.getPositionDescription());
        r4.append(r1);
        r4.append(r11);
        r1 = new android.view.InflateException(r4.toString());
        r1.initCause(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009c, code lost:
        throw r1;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c A[ExcHandler: Exception (r2v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:2:0x000d] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.support.p001v7.preference.Preference m3974a(java.lang.String r11, java.lang.String[] r12, android.util.AttributeSet r13) throws java.lang.ClassNotFoundException, android.view.InflateException {
        /*
            r10 = this;
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r0 = f2545b
            java.lang.Object r0 = r0.get(r11)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            java.lang.String r1 = ": Error inflating class "
            r2 = 1
            if (r0 != 0) goto L_0x0071
            android.content.Context r3 = r10.f2546c     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r4 = 0
            if (r12 == 0) goto L_0x005d
            int r5 = r12.length     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            if (r5 != 0) goto L_0x001a
            goto L_0x005d
        L_0x001a:
            r5 = 0
            int r6 = r12.length     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r7 = 0
        L_0x001d:
            if (r7 >= r6) goto L_0x003b
            r8 = r12[r7]     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            r9.<init>()     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            r9.append(r8)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            r9.append(r11)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            java.lang.String r9 = r9.toString()     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            java.lang.Class r6 = r3.loadClass(r9)     // Catch:{ ClassNotFoundException -> 0x0036, Exception -> 0x007c }
            r4 = r6
            goto L_0x003b
        L_0x0036:
            r9 = move-exception
            r5 = r9
            int r7 = r7 + 1
            goto L_0x001d
        L_0x003b:
            if (r4 != 0) goto L_0x0062
            if (r5 != 0) goto L_0x005b
            android.view.InflateException r2 = new android.view.InflateException     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r6.<init>()     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.String r7 = r13.getPositionDescription()     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r6.append(r7)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r6.append(r1)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r6.append(r11)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.String r6 = r6.toString()     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r2.<init>(r6)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            throw r2     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
        L_0x005b:
            throw r5     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
        L_0x005d:
            java.lang.Class r5 = r3.loadClass(r11)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r4 = r5
        L_0x0062:
            java.lang.Class<?>[] r5 = f2544a     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.reflect.Constructor r5 = r4.getConstructor(r5)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r0 = r5
            r0.setAccessible(r2)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor> r5 = f2545b     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r5.put(r11, r0)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
        L_0x0071:
            java.lang.Object[] r3 = r10.f2547d     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            r3[r2] = r13     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            java.lang.Object r2 = r0.newInstance(r3)     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            android.support.v7.preference.Preference r2 = (android.support.p001v7.preference.Preference) r2     // Catch:{ ClassNotFoundException -> 0x009d, Exception -> 0x007c }
            return r2
        L_0x007c:
            r2 = move-exception
            android.view.InflateException r3 = new android.view.InflateException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r13.getPositionDescription()
            r4.append(r5)
            r4.append(r1)
            r4.append(r11)
            java.lang.String r1 = r4.toString()
            r3.<init>(r1)
            r1 = r3
            r1.initCause(r2)
            throw r1
        L_0x009d:
            r1 = move-exception
            goto L_0x00a0
        L_0x009f:
            throw r1
        L_0x00a0:
            goto L_0x009f
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p001v7.preference.C0846x.m3974a(java.lang.String, java.lang.String[], android.util.AttributeSet):android.support.v7.preference.Preference");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Preference mo6502a(String name, AttributeSet attrs) throws ClassNotFoundException {
        return m3974a(name, this.f2549f, attrs);
    }

    /* renamed from: b */
    private Preference m3979b(String name, AttributeSet attrs) {
        try {
            if (-1 == name.indexOf(46)) {
                return mo6502a(name, attrs);
            }
            return m3974a(name, (String[]) null, attrs);
        } catch (InflateException e) {
            throw e;
        } catch (ClassNotFoundException e2) {
            StringBuilder sb = new StringBuilder();
            sb.append(attrs.getPositionDescription());
            sb.append(": Error inflating class (not found)");
            sb.append(name);
            InflateException ie = new InflateException(sb.toString());
            ie.initCause(e2);
            throw ie;
        } catch (Exception e3) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(attrs.getPositionDescription());
            sb2.append(": Error inflating class ");
            sb2.append(name);
            InflateException ie2 = new InflateException(sb2.toString());
            ie2.initCause(e3);
            throw ie2;
        }
    }

    /* renamed from: a */
    private void m3978a(XmlPullParser parser, Preference parent, AttributeSet attrs) throws XmlPullParserException, IOException {
        int depth = parser.getDepth();
        while (true) {
            int next = parser.next();
            int type = next;
            if ((next == 3 && parser.getDepth() <= depth) || type == 1) {
                return;
            }
            if (type == 2) {
                String name = parser.getName();
                String str = "Error parsing preference";
                if (Constants.INTENT_SCHEME.equals(name)) {
                    try {
                        parent.mo6343a(Intent.parseIntent(mo6500a().getResources(), parser, attrs));
                    } catch (IOException e) {
                        XmlPullParserException ex = new XmlPullParserException(str);
                        ex.initCause(e);
                        throw ex;
                    }
                } else {
                    String str2 = "extra";
                    if (str2.equals(name)) {
                        mo6500a().getResources().parseBundleExtra(str2, attrs, parent.mo6375g());
                        try {
                            m3977a(parser);
                        } catch (IOException e2) {
                            XmlPullParserException ex2 = new XmlPullParserException(str);
                            ex2.initCause(e2);
                            throw ex2;
                        }
                    } else {
                        Preference item = m3979b(name, attrs);
                        ((PreferenceGroup) parent).mo6396b(item);
                        m3978a(parser, item, attrs);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private static void m3977a(XmlPullParser parser) throws XmlPullParserException, IOException {
        int outerDepth = parser.getDepth();
        while (true) {
            int type = parser.next();
            if (type == 1) {
                return;
            }
            if (type == 3 && parser.getDepth() <= outerDepth) {
                return;
            }
        }
    }
}
