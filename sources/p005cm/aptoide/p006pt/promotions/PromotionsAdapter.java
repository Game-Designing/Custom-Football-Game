package p005cm.aptoide.p006pt.promotions;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.view.ViewGroup;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.app.DownloadModel;
import p005cm.aptoide.p006pt.app.DownloadModel.Action;

/* renamed from: cm.aptoide.pt.promotions.PromotionsAdapter */
public class PromotionsAdapter extends C0970a<C1000w> {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    static final int CLAIM = 4;
    static final int CLAIMED = 5;
    static final int DOWNGRADE = 6;
    static final int DOWNLOAD = 1;
    static final int DOWNLOADING = 2;
    static final int INSTALL = 3;
    static final int UPDATE = 0;
    private List<PromotionViewApp> appsList;
    private boolean isWalletInstalled;
    private PromotionsViewHolderFactory viewHolderFactory;

    /* renamed from: cm.aptoide.pt.promotions.PromotionsAdapter$1 */
    static /* synthetic */ class C44731 {
        static final /* synthetic */ int[] $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action = new int[Action.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(6369787196219144901L, "cm/aptoide/pt/promotions/PromotionsAdapter$1", 10);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.DOWNGRADE.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            $jacocoInit[8] = true;
                        }
                    }
                }
            }
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.INSTALL.ordinal()] = 2;
            $jacocoInit[3] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.OPEN.ordinal()] = 3;
            $jacocoInit[5] = true;
            $SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[Action.UPDATE.ordinal()] = 4;
            $jacocoInit[7] = true;
            $jacocoInit[9] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(6767624298809452538L, "cm/aptoide/pt/promotions/PromotionsAdapter", 36);
        $jacocoData = probes;
        return probes;
    }

    public PromotionsAdapter(List<PromotionViewApp> appsList2, PromotionsViewHolderFactory viewHolderFactory2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.appsList = appsList2;
        this.viewHolderFactory = viewHolderFactory2;
        $jacocoInit[0] = true;
    }

    public C1000w onCreateViewHolder(ViewGroup parent, int viewType) {
        boolean[] $jacocoInit = $jacocoInit();
        C1000w createViewHolder = this.viewHolderFactory.createViewHolder(parent, viewType);
        $jacocoInit[1] = true;
        return createViewHolder;
    }

    public void onBindViewHolder(C1000w holder, int position) {
        boolean[] $jacocoInit = $jacocoInit();
        if (holder instanceof PromotionAppDownloadingViewHolder) {
            $jacocoInit[2] = true;
            ((PromotionAppDownloadingViewHolder) holder).setApp((PromotionViewApp) this.appsList.get(position));
            $jacocoInit[3] = true;
        } else if (holder instanceof PromotionAppViewHolder) {
            $jacocoInit[4] = true;
            ((PromotionAppViewHolder) holder).setApp((PromotionViewApp) this.appsList.get(position), this.isWalletInstalled);
            $jacocoInit[5] = true;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Invalid type of ViewHolder");
            $jacocoInit[6] = true;
            throw illegalStateException;
        }
        $jacocoInit[7] = true;
    }

    public int getItemViewType(int position) {
        int state;
        boolean[] $jacocoInit = $jacocoInit();
        PromotionViewApp app = (PromotionViewApp) this.appsList.get(position);
        $jacocoInit[8] = true;
        if (app.isClaimed()) {
            $jacocoInit[9] = true;
            return 5;
        }
        DownloadModel downloadModel = app.getDownloadModel();
        $jacocoInit[10] = true;
        if (downloadModel.isDownloading()) {
            $jacocoInit[11] = true;
            return 2;
        }
        int i = C44731.$SwitchMap$cm$aptoide$pt$app$DownloadModel$Action[downloadModel.getAction().ordinal()];
        if (i == 1) {
            state = 6;
            $jacocoInit[12] = true;
        } else if (i == 2) {
            state = 3;
            $jacocoInit[13] = true;
        } else if (i == 3) {
            state = 4;
            $jacocoInit[14] = true;
        } else if (i == 4) {
            state = 0;
            $jacocoInit[15] = true;
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid type of download action");
            $jacocoInit[16] = true;
            throw illegalArgumentException;
        }
        $jacocoInit[17] = true;
        return state;
    }

    public int getItemCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.appsList.size();
        $jacocoInit[18] = true;
        return size;
    }

    public void setPromotionApp(PromotionViewApp promotionViewApp) {
        boolean[] $jacocoInit = $jacocoInit();
        int index = this.appsList.indexOf(promotionViewApp);
        if (index != -1) {
            $jacocoInit[19] = true;
            this.appsList.set(index, promotionViewApp);
            $jacocoInit[20] = true;
            notifyItemChanged(index);
            $jacocoInit[21] = true;
        } else {
            this.appsList.add(promotionViewApp);
            $jacocoInit[22] = true;
            notifyDataSetChanged();
            $jacocoInit[23] = true;
        }
        $jacocoInit[24] = true;
    }

    public void isWalletInstalled(boolean isWalletInstalled2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.isWalletInstalled = isWalletInstalled2;
        $jacocoInit[25] = true;
        notifyDataSetChanged();
        $jacocoInit[26] = true;
    }

    public void updateClaimStatus(String packageName) {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[27] = true;
        for (PromotionViewApp promotionViewApp : this.appsList) {
            $jacocoInit[28] = true;
            String packageName2 = promotionViewApp.getPackageName();
            $jacocoInit[29] = true;
            if (!packageName2.equals(packageName)) {
                $jacocoInit[30] = true;
            } else {
                $jacocoInit[31] = true;
                promotionViewApp.setClaimed();
                $jacocoInit[32] = true;
                notifyDataSetChanged();
                $jacocoInit[33] = true;
            }
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
    }
}
