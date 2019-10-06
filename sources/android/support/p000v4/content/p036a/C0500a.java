package android.support.p000v4.content.p036a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Base64;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p002b.p003c.p047a.C1158b;
import p002b.p003c.p053g.p059d.C1227a;

/* renamed from: android.support.v4.content.a.a */
/* compiled from: FontResourcesParserCompat */
public class C0500a {

    /* renamed from: android.support.v4.content.a.a$a */
    /* compiled from: FontResourcesParserCompat */
    public interface C0501a {
    }

    /* renamed from: android.support.v4.content.a.a$b */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0502b implements C0501a {

        /* renamed from: a */
        private final C0503c[] f1648a;

        public C0502b(C0503c[] entries) {
            this.f1648a = entries;
        }

        /* renamed from: a */
        public C0503c[] mo5276a() {
            return this.f1648a;
        }
    }

    /* renamed from: android.support.v4.content.a.a$c */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0503c {

        /* renamed from: a */
        private final String f1649a;

        /* renamed from: b */
        private int f1650b;

        /* renamed from: c */
        private boolean f1651c;

        /* renamed from: d */
        private int f1652d;

        public C0503c(String fileName, int weight, boolean italic, int resourceId) {
            this.f1649a = fileName;
            this.f1650b = weight;
            this.f1651c = italic;
            this.f1652d = resourceId;
        }

        /* renamed from: a */
        public String mo5277a() {
            return this.f1649a;
        }

        /* renamed from: c */
        public int mo5279c() {
            return this.f1650b;
        }

        /* renamed from: d */
        public boolean mo5280d() {
            return this.f1651c;
        }

        /* renamed from: b */
        public int mo5278b() {
            return this.f1652d;
        }
    }

    /* renamed from: android.support.v4.content.a.a$d */
    /* compiled from: FontResourcesParserCompat */
    public static final class C0504d implements C0501a {

        /* renamed from: a */
        private final C1227a f1653a;

        /* renamed from: b */
        private final int f1654b;

        /* renamed from: c */
        private final int f1655c;

        public C0504d(C1227a request, int strategy, int timeoutMs) {
            this.f1653a = request;
            this.f1655c = strategy;
            this.f1654b = timeoutMs;
        }

        /* renamed from: b */
        public C1227a mo5282b() {
            return this.f1653a;
        }

        /* renamed from: a */
        public int mo5281a() {
            return this.f1655c;
        }

        /* renamed from: c */
        public int mo5283c() {
            return this.f1654b;
        }
    }

    /* renamed from: a */
    public static C0501a m2524a(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        int type;
        do {
            int next = parser.next();
            type = next;
            if (next == 2) {
                break;
            }
        } while (type != 1);
        if (type == 2) {
            return m2528b(parser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    /* renamed from: b */
    private static C0501a m2528b(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        String str = "font-family";
        parser.require(2, null, str);
        if (parser.getName().equals(str)) {
            return m2529c(parser, resources);
        }
        m2527a(parser);
        return null;
    }

    /* renamed from: c */
    private static C0501a m2529c(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray array = resources.obtainAttributes(Xml.asAttributeSet(parser), C1158b.FontFamily);
        String authority = array.getString(C1158b.FontFamily_fontProviderAuthority);
        String providerPackage = array.getString(C1158b.FontFamily_fontProviderPackage);
        String query = array.getString(C1158b.FontFamily_fontProviderQuery);
        int certsId = array.getResourceId(C1158b.FontFamily_fontProviderCerts, 0);
        int strategy = array.getInteger(C1158b.FontFamily_fontProviderFetchStrategy, 1);
        int timeoutMs = array.getInteger(C1158b.FontFamily_fontProviderFetchTimeout, 500);
        array.recycle();
        if (authority == null || providerPackage == null || query == null) {
            List<FontFileResourceEntry> fonts = new ArrayList<>();
            while (parser.next() != 3) {
                if (parser.getEventType() == 2) {
                    if (parser.getName().equals("font")) {
                        fonts.add(m2530d(parser, resources));
                    } else {
                        m2527a(parser);
                    }
                }
            }
            if (fonts.isEmpty()) {
                return null;
            }
            return new C0502b((C0503c[]) fonts.toArray(new C0503c[fonts.size()]));
        }
        while (parser.next() != 3) {
            m2527a(parser);
        }
        return new C0504d(new C1227a(authority, providerPackage, query, m2525a(resources, certsId)), strategy, timeoutMs);
    }

    /* renamed from: a */
    public static List<List<byte[]>> m2525a(Resources resources, int certsId) {
        List<List<byte[]>> certs = null;
        if (certsId != 0) {
            TypedArray typedArray = resources.obtainTypedArray(certsId);
            if (typedArray.length() > 0) {
                certs = new ArrayList<>();
                if (typedArray.getResourceId(0, 0) != 0) {
                    for (int i = 0; i < typedArray.length(); i++) {
                        certs.add(m2526a(resources.getStringArray(typedArray.getResourceId(i, 0))));
                    }
                } else {
                    certs.add(m2526a(resources.getStringArray(certsId)));
                }
            }
            typedArray.recycle();
        }
        return certs != null ? certs : Collections.emptyList();
    }

    /* renamed from: a */
    private static List<byte[]> m2526a(String[] stringArray) {
        List<byte[]> result = new ArrayList<>();
        for (String item : stringArray) {
            result.add(Base64.decode(item, 0));
        }
        return result;
    }

    /* renamed from: d */
    private static C0503c m2530d(XmlPullParser parser, Resources resources) throws XmlPullParserException, IOException {
        TypedArray array = resources.obtainAttributes(Xml.asAttributeSet(parser), C1158b.FontFamilyFont);
        int weight = array.getInt(array.hasValue(C1158b.FontFamilyFont_fontWeight) ? C1158b.FontFamilyFont_fontWeight : C1158b.FontFamilyFont_android_fontWeight, 400);
        boolean z = true;
        if (1 != array.getInt(array.hasValue(C1158b.FontFamilyFont_fontStyle) ? C1158b.FontFamilyFont_fontStyle : C1158b.FontFamilyFont_android_fontStyle, 0)) {
            z = false;
        }
        boolean isItalic = z;
        int resourceAttr = array.hasValue(C1158b.FontFamilyFont_font) ? C1158b.FontFamilyFont_font : C1158b.FontFamilyFont_android_font;
        int resourceId = array.getResourceId(resourceAttr, 0);
        String filename = array.getString(resourceAttr);
        array.recycle();
        while (parser.next() != 3) {
            m2527a(parser);
        }
        return new C0503c(filename, weight, isItalic, resourceId);
    }

    /* renamed from: a */
    private static void m2527a(XmlPullParser parser) throws XmlPullParserException, IOException {
        int depth = 1;
        while (depth > 0) {
            int next = parser.next();
            if (next == 2) {
                depth++;
            } else if (next == 3) {
                depth--;
            }
        }
    }
}
