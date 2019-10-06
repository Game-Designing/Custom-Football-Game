package p005cm.aptoide.p006pt.editorial;

import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.editorial.ViewsFormatter */
public class ViewsFormatter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int NUMBER_OF_SUFFIXES = 2;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(957808057849658696L, "cm/aptoide/pt/editorial/ViewsFormatter", 18);
        $jacocoData = probes;
        return probes;
    }

    public ViewsFormatter() {
        $jacocoInit()[0] = true;
    }

    public static String formatNumberOfViews(String views) {
        boolean[] $jacocoInit = $jacocoInit();
        int length = views.length() / 4;
        if (length <= 2) {
            $jacocoInit[1] = true;
        } else {
            length = 2;
            $jacocoInit[2] = true;
        }
        double nViews = Double.parseDouble(views);
        $jacocoInit[3] = true;
        double dividedViews = get3DigitNumber(nViews, length);
        $jacocoInit[4] = true;
        String suffix = getSuffix(length);
        $jacocoInit[5] = true;
        DecimalFormat numberFormat = getDecimalFormat(dividedViews);
        $jacocoInit[6] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(numberFormat.format(dividedViews));
        sb.append(suffix);
        String sb2 = sb.toString();
        $jacocoInit[7] = true;
        return sb2;
    }

    private static DecimalFormat getDecimalFormat(double views) {
        DecimalFormat numberFormat;
        boolean[] $jacocoInit = $jacocoInit();
        if (views < 10.0d) {
            $jacocoInit[8] = true;
            numberFormat = new DecimalFormat("#.##");
            $jacocoInit[9] = true;
        } else if (views < 100.0d) {
            $jacocoInit[10] = true;
            numberFormat = new DecimalFormat("#.#");
            $jacocoInit[11] = true;
        } else {
            numberFormat = new DecimalFormat("#");
            $jacocoInit[12] = true;
        }
        $jacocoInit[13] = true;
        return numberFormat;
    }

    private static double get3DigitNumber(double views, int length) {
        double pow = views / Math.pow(1000.0d, (double) length);
        $jacocoInit()[14] = true;
        return pow;
    }

    private static String getSuffix(int length) {
        boolean[] $jacocoInit = $jacocoInit();
        String[] suffixes = {"", "k", "M"};
        String suffix = "";
        if (length >= suffixes.length) {
            $jacocoInit[15] = true;
        } else {
            suffix = suffixes[length];
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
        return suffix;
    }
}
