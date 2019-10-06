package p005cm.aptoide.p006pt.store.view.p079my;

import android.content.Context;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.store.StoreContext;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;

/* renamed from: cm.aptoide.pt.store.view.my.StoreDisplayable */
public class StoreDisplayable extends Displayable {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private int firstStatsLabel;
    private long firstStatsNumber;
    private boolean isLongTime;
    private String message;
    private int secondStatsLabel;
    private long secondStatsNumber;
    private boolean statsClickable;
    private Store store;
    private StoreContext storeContext;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(8788964407160737857L, "cm/aptoide/pt/store/view/my/StoreDisplayable", 21);
        $jacocoData = probes;
        return probes;
    }

    public StoreDisplayable() {
        $jacocoInit()[0] = true;
    }

    public StoreDisplayable(Store store2, StoreContext storeContext2, long firstStatsNumber2, long secondStatsNumber2, int firstStatsLabelStringId, int secondStatsLabelStringId, boolean statsClickable2, String message2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.store = store2;
        this.storeContext = storeContext2;
        this.firstStatsNumber = firstStatsNumber2;
        this.secondStatsNumber = secondStatsNumber2;
        this.firstStatsLabel = firstStatsLabelStringId;
        this.secondStatsLabel = secondStatsLabelStringId;
        this.statsClickable = statsClickable2;
        this.message = message2;
        $jacocoInit[1] = true;
        Calendar aWeekBefore = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        $jacocoInit[2] = true;
        aWeekBefore.add(5, -7);
        $jacocoInit[3] = true;
        Date added = store2.getAdded();
        $jacocoInit[4] = true;
        this.isLongTime = added.before(aWeekBefore.getTime());
        $jacocoInit[5] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, true);
        $jacocoInit[6] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[7] = true;
        return C1375R.layout.store_displayable_layout;
    }

    public String getSuggestionMessage(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isLongTime) {
            $jacocoInit[8] = true;
            String storeDescription = getStoreDescription();
            $jacocoInit[9] = true;
            return storeDescription;
        }
        String string = context.getString(C1375R.string.create_store_displayable_explore_message);
        $jacocoInit[10] = true;
        return string;
    }

    private String getStoreDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.message;
        $jacocoInit[11] = true;
        return str;
    }

    public int getExploreButtonText() {
        boolean[] $jacocoInit = $jacocoInit();
        if (this.isLongTime) {
            $jacocoInit[12] = true;
            return C1375R.string.create_store_displayable_explore_long_term_button;
        }
        $jacocoInit[13] = true;
        return C1375R.string.create_store_displayable_explore_button;
    }

    /* access modifiers changed from: 0000 */
    public long getFirstStatsNumber() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.firstStatsNumber;
        $jacocoInit[14] = true;
        return j;
    }

    /* access modifiers changed from: 0000 */
    public long getSecondStatsNumber() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.secondStatsNumber;
        $jacocoInit[15] = true;
        return j;
    }

    /* access modifiers changed from: 0000 */
    public int getFirstStatsLabel() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.firstStatsLabel;
        $jacocoInit[16] = true;
        return i;
    }

    /* access modifiers changed from: 0000 */
    public int getSecondStatsLabel() {
        boolean[] $jacocoInit = $jacocoInit();
        int i = this.secondStatsLabel;
        $jacocoInit[17] = true;
        return i;
    }

    public StoreContext getStoreContext() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreContext storeContext2 = this.storeContext;
        $jacocoInit[18] = true;
        return storeContext2;
    }

    public Store getStore() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store2 = this.store;
        $jacocoInit[19] = true;
        return store2;
    }

    public boolean isStatsClickable() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.statsClickable;
        $jacocoInit[20] = true;
        return z;
    }
}
