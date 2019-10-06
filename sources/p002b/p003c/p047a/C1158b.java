package p002b.p003c.p047a;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: b.c.a.b */
/* compiled from: R */
public final class C1158b {
    public static final int[] FontFamily = {C1375R.attr.fontProviderAuthority, C1375R.attr.fontProviderCerts, C1375R.attr.fontProviderFetchStrategy, C1375R.attr.fontProviderFetchTimeout, C1375R.attr.fontProviderPackage, C1375R.attr.fontProviderQuery};
    public static final int[] FontFamilyFont = {16844082, 16844083, 16844095, C1375R.attr.font, C1375R.attr.fontStyle, C1375R.attr.fontWeight};
    public static final int FontFamilyFont_android_font = 0;
    public static final int FontFamilyFont_android_fontStyle = 2;
    public static final int FontFamilyFont_android_fontWeight = 1;
    public static final int FontFamilyFont_font = 3;
    public static final int FontFamilyFont_fontStyle = 4;
    public static final int FontFamilyFont_fontWeight = 5;
    public static final int FontFamily_fontProviderAuthority = 0;
    public static final int FontFamily_fontProviderCerts = 1;
    public static final int FontFamily_fontProviderFetchStrategy = 2;
    public static final int FontFamily_fontProviderFetchTimeout = 3;
    public static final int FontFamily_fontProviderPackage = 4;
    public static final int FontFamily_fontProviderQuery = 5;

    /* renamed from: a */
    private static transient /* synthetic */ boolean[] f3814a;

    /* renamed from: a */
    private static /* synthetic */ boolean[] m5631a() {
        boolean[] zArr = f3814a;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-2921565739953886628L, "android/support/compat/R$styleable", 2);
        f3814a = probes;
        return probes;
    }

    static {
        boolean[] a = m5631a();
        a[1] = true;
    }
}
