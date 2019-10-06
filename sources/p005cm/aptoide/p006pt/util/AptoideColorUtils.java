package p005cm.aptoide.p006pt.util;

import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p002b.p003c.p053g.p054a.C1199a;

/* renamed from: cm.aptoide.pt.util.AptoideColorUtils */
public class AptoideColorUtils {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-4139475942590812015L, "cm/aptoide/pt/util/AptoideColorUtils", 7);
        $jacocoData = probes;
        return probes;
    }

    public AptoideColorUtils() {
        $jacocoInit()[0] = true;
    }

    public static int getChangedColorLightness(float[] hsl, float factor) {
        boolean[] $jacocoInit = $jacocoInit();
        float luminance = hsl[2] * factor;
        float f = 0.0f;
        if (luminance < 0.0f) {
            $jacocoInit[1] = true;
        } else {
            $jacocoInit[2] = true;
            f = luminance;
        }
        float luminance2 = f;
        float f2 = 1.0f;
        if (luminance2 > 1.0f) {
            $jacocoInit[3] = true;
        } else {
            $jacocoInit[4] = true;
            f2 = luminance2;
        }
        hsl[2] = f2;
        $jacocoInit[5] = true;
        int a = C1199a.m5721a(hsl);
        $jacocoInit[6] = true;
        return a;
    }
}
