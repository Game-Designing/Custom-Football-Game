package p005cm.aptoide.p006pt.view.spannable;

import android.content.Context;
import android.text.ParcelableSpan;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.view.spannable.SpannableFactory */
public class SpannableFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8286695207507382254L, "cm/aptoide/pt/view/spannable/SpannableFactory", 43);
        $jacocoData = probes;
        return probes;
    }

    public SpannableFactory() {
        $jacocoInit()[0] = true;
    }

    public Spannable createStyleSpan(String text, int style, String... spanTexts) {
        boolean[] $jacocoInit = $jacocoInit();
        Spannable createSpan = createSpan(text, (ParcelableSpan) new StyleSpan(style), spanTexts);
        $jacocoInit[1] = true;
        return createSpan;
    }

    public Spannable createTextAppearanceSpan(Context context, int style, String text, String... spanTexts) {
        boolean[] $jacocoInit = $jacocoInit();
        Spannable createSpan = createSpan(text, (ParcelableSpan) new TextAppearanceSpan(context, style), spanTexts);
        $jacocoInit[2] = true;
        return createSpan;
    }

    public Spannable createColorSpan(String text, int color, String... spanTexts) {
        boolean[] $jacocoInit = $jacocoInit();
        Spannable createSpan = createSpan(text, (ParcelableSpan) new ForegroundColorSpan(color), spanTexts);
        $jacocoInit[3] = true;
        return createSpan;
    }

    private Spannable createSpan(String text, ParcelableSpan span, String[] spanTexts) {
        boolean[] $jacocoInit = $jacocoInit();
        Spannable result = new SpannableString(text);
        int length = spanTexts.length;
        $jacocoInit[4] = true;
        int i = 0;
        while (i < length) {
            String spanText = spanTexts[i];
            $jacocoInit[5] = true;
            int spanTextStart = text.indexOf(spanText);
            if (spanTextStart < 0) {
                $jacocoInit[6] = true;
            } else {
                $jacocoInit[7] = true;
                if (spanTextStart >= text.length()) {
                    $jacocoInit[8] = true;
                } else {
                    $jacocoInit[9] = true;
                    if (spanText.length() > text.length()) {
                        $jacocoInit[10] = true;
                    } else {
                        $jacocoInit[11] = true;
                        result.setSpan(span, spanTextStart, spanText.length() + spanTextStart, 33);
                        $jacocoInit[12] = true;
                    }
                }
            }
            i++;
            $jacocoInit[13] = true;
        }
        $jacocoInit[14] = true;
        return result;
    }

    public Spannable createSpan(String text, ParcelableSpan[] span, String... spanTexts) {
        boolean[] $jacocoInit = $jacocoInit();
        Spannable result = new SpannableString(text);
        if (span == null) {
            $jacocoInit[15] = true;
        } else if (spanTexts == null) {
            $jacocoInit[16] = true;
        } else if (span.length > spanTexts.length) {
            $jacocoInit[17] = true;
        } else {
            int i = 0;
            $jacocoInit[18] = true;
            while (i < span.length) {
                String spanText = spanTexts[i];
                $jacocoInit[20] = true;
                int spanTextStart = text.indexOf(spanText);
                if (spanTextStart < 0) {
                    $jacocoInit[21] = true;
                } else {
                    $jacocoInit[22] = true;
                    if (spanTextStart >= text.length()) {
                        $jacocoInit[23] = true;
                    } else {
                        $jacocoInit[24] = true;
                        if (spanText.length() > text.length()) {
                            $jacocoInit[25] = true;
                        } else {
                            $jacocoInit[26] = true;
                            result.setSpan(span[i], spanTextStart, spanText.length() + spanTextStart, 33);
                            $jacocoInit[27] = true;
                        }
                    }
                }
                i++;
                $jacocoInit[28] = true;
            }
            $jacocoInit[19] = true;
        }
        $jacocoInit[29] = true;
        return result;
    }

    public Spannable createMultiSpan(String text, ParcelableSpan[] span, String... spanTexts) {
        String str = text;
        ParcelableSpan[] parcelableSpanArr = span;
        String[] strArr = spanTexts;
        boolean[] $jacocoInit = $jacocoInit();
        Spannable result = new SpannableString(str);
        int length = parcelableSpanArr.length;
        $jacocoInit[30] = true;
        int i = 0;
        while (i < length) {
            ParcelableSpan parcelableSpan = parcelableSpanArr[i];
            int length2 = strArr.length;
            $jacocoInit[31] = true;
            int i2 = 0;
            while (i2 < length2) {
                String spanText = strArr[i2];
                $jacocoInit[32] = true;
                int spanTextStart = str.indexOf(spanText);
                if (spanTextStart < 0) {
                    $jacocoInit[33] = true;
                } else {
                    $jacocoInit[34] = true;
                    if (spanTextStart >= text.length()) {
                        $jacocoInit[35] = true;
                    } else {
                        $jacocoInit[36] = true;
                        if (spanText.length() > text.length()) {
                            $jacocoInit[37] = true;
                        } else {
                            $jacocoInit[38] = true;
                            result.setSpan(parcelableSpan, spanTextStart, spanText.length() + spanTextStart, 33);
                            $jacocoInit[39] = true;
                        }
                    }
                }
                i2++;
                $jacocoInit[40] = true;
            }
            i++;
            $jacocoInit[41] = true;
        }
        $jacocoInit[42] = true;
        return result;
    }
}
