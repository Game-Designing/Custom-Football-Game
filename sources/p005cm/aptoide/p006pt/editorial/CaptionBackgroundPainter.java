package p005cm.aptoide.p006pt.editorial;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.p001v7.widget.CardView;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;

/* renamed from: cm.aptoide.pt.editorial.CaptionBackgroundPainter */
public class CaptionBackgroundPainter {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Resources resources;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-6612624774344042073L, "cm/aptoide/pt/editorial/CaptionBackgroundPainter", 10);
        $jacocoData = probes;
        return probes;
    }

    public CaptionBackgroundPainter(Resources resources2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.resources = resources2;
        $jacocoInit[0] = true;
    }

    public void addColorBackgroundToCaption(CardView captionView, String captionColor) {
        boolean[] $jacocoInit = $jacocoInit();
        if (captionColor == null) {
            $jacocoInit[1] = true;
        } else if (captionColor.isEmpty()) {
            $jacocoInit[2] = true;
        } else {
            try {
                $jacocoInit[3] = true;
                captionView.setCardBackgroundColor(Color.parseColor(captionColor));
                $jacocoInit[4] = true;
            } catch (IllegalArgumentException e) {
                $jacocoInit[5] = true;
                setDefaultBackgroundColor(captionView);
                $jacocoInit[6] = true;
            }
            $jacocoInit[8] = true;
        }
        setDefaultBackgroundColor(captionView);
        $jacocoInit[7] = true;
        $jacocoInit[8] = true;
    }

    private void setDefaultBackgroundColor(CardView captionView) {
        boolean[] $jacocoInit = $jacocoInit();
        captionView.setCardBackgroundColor(this.resources.getColor(C1375R.color.curation_default));
        $jacocoInit[9] = true;
    }
}
