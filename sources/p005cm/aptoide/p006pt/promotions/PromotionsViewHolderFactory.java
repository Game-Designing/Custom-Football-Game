package p005cm.aptoide.p006pt.promotions;

import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.text.DecimalFormat;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p026rx.p028h.C14963c;

/* renamed from: cm.aptoide.pt.promotions.PromotionsViewHolderFactory */
public class PromotionsViewHolderFactory {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final DecimalFormat decimalFormat;
    private final C14963c<PromotionAppClick> promotionAppClick;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6572768395877603336L, "cm/aptoide/pt/promotions/PromotionsViewHolderFactory", 18);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsViewHolderFactory(C14963c<PromotionAppClick> promotionAppClick2, DecimalFormat decimalFormat2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.promotionAppClick = promotionAppClick2;
        this.decimalFormat = decimalFormat2;
        $jacocoInit[0] = true;
    }

    public C1000w createViewHolder(ViewGroup parent, int viewType) {
        C1000w promotionAppViewHolder;
        boolean[] $jacocoInit = $jacocoInit();
        switch (viewType) {
            case 0:
                LayoutInflater from = LayoutInflater.from(parent.getContext());
                $jacocoInit[3] = true;
                promotionAppViewHolder = new PromotionAppViewHolder(from.inflate(C1375R.layout.promotion_app_inactive, parent, false), 0, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[4] = true;
                break;
            case 1:
                LayoutInflater from2 = LayoutInflater.from(parent.getContext());
                $jacocoInit[5] = true;
                C1000w promotionAppViewHolder2 = new PromotionAppViewHolder(from2.inflate(C1375R.layout.promotion_app_inactive, parent, false), 1, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[6] = true;
                promotionAppViewHolder = promotionAppViewHolder2;
                break;
            case 2:
                $jacocoInit[13] = true;
                LayoutInflater from3 = LayoutInflater.from(parent.getContext());
                $jacocoInit[14] = true;
                promotionAppViewHolder = new PromotionAppDownloadingViewHolder(from3.inflate(C1375R.layout.promotion_app_active_download, parent, false), this.promotionAppClick, this.decimalFormat);
                $jacocoInit[15] = true;
                break;
            case 3:
                LayoutInflater from4 = LayoutInflater.from(parent.getContext());
                $jacocoInit[7] = true;
                promotionAppViewHolder = new PromotionAppViewHolder(from4.inflate(C1375R.layout.promotion_app_inactive, parent, false), 3, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[8] = true;
                break;
            case 4:
                LayoutInflater from5 = LayoutInflater.from(parent.getContext());
                $jacocoInit[9] = true;
                promotionAppViewHolder = new PromotionAppViewHolder(from5.inflate(C1375R.layout.promotion_app_inactive, parent, false), 4, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[10] = true;
                break;
            case 5:
                LayoutInflater from6 = LayoutInflater.from(parent.getContext());
                $jacocoInit[11] = true;
                promotionAppViewHolder = new PromotionAppViewHolder(from6.inflate(C1375R.layout.promotion_app_inactive, parent, false), 5, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[12] = true;
                break;
            case 6:
                LayoutInflater from7 = LayoutInflater.from(parent.getContext());
                $jacocoInit[1] = true;
                promotionAppViewHolder = new PromotionAppViewHolder(from7.inflate(C1375R.layout.promotion_app_inactive, parent, false), 6, this.promotionAppClick, this.decimalFormat);
                $jacocoInit[2] = true;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Wrong view type of promotion app");
                $jacocoInit[16] = true;
                throw illegalArgumentException;
        }
        $jacocoInit[17] = true;
        return promotionAppViewHolder;
    }
}
