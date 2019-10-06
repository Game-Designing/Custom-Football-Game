package p005cm.aptoide.p006pt.timeline.view.displayable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.p000v4.app.Fragment;
import android.text.TextUtils;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.GetFollowers.TimelineUser;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.TimelineStats.StatusData;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.Appearance;
import p005cm.aptoide.p006pt.navigator.FragmentNavigator;
import p005cm.aptoide.p006pt.store.StoreTheme;
import p005cm.aptoide.p006pt.store.view.StoreFragment.OpenType;
import p005cm.aptoide.p006pt.view.FragmentProvider;
import p005cm.aptoide.p006pt.view.recycler.displayable.Displayable.Configs;
import p005cm.aptoide.p006pt.view.recycler.displayable.DisplayablePojo;

/* renamed from: cm.aptoide.pt.timeline.view.displayable.FollowUserDisplayable */
public class FollowUserDisplayable extends DisplayablePojo<TimelineUser> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private String defaultTheme;
    private boolean isLike;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-197080856480313735L, "cm/aptoide/pt/timeline/view/displayable/FollowUserDisplayable", 81);
        $jacocoData = probes;
        return probes;
    }

    public FollowUserDisplayable() {
        $jacocoInit()[0] = true;
    }

    public FollowUserDisplayable(TimelineUser pojo, boolean isLike2, String defaultTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        super(pojo);
        this.isLike = isLike2;
        this.defaultTheme = defaultTheme2;
        $jacocoInit[1] = true;
    }

    /* access modifiers changed from: protected */
    public Configs getConfig() {
        boolean[] $jacocoInit = $jacocoInit();
        Configs configs = new Configs(this, 1, false);
        $jacocoInit[2] = true;
        return configs;
    }

    public int getViewLayout() {
        $jacocoInit()[3] = true;
        return C1375R.layout.timeline_follow_user;
    }

    public String getUserName() {
        boolean[] $jacocoInit = $jacocoInit();
        String name = ((TimelineUser) getPojo()).getName();
        $jacocoInit[4] = true;
        return name;
    }

    public String storeName() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = ((TimelineUser) getPojo()).getStore();
        $jacocoInit[5] = true;
        String name = store.getName();
        $jacocoInit[6] = true;
        return name;
    }

    public String getFollowing() {
        long number;
        boolean[] $jacocoInit = $jacocoInit();
        if (((TimelineUser) getPojo()).getStats() != null) {
            $jacocoInit[7] = true;
            StatusData stats = ((TimelineUser) getPojo()).getStats();
            $jacocoInit[8] = true;
            number = stats.getFollowing();
            $jacocoInit[9] = true;
        } else {
            number = 0;
            $jacocoInit[10] = true;
        }
        String valueOf = String.valueOf(number);
        $jacocoInit[11] = true;
        return valueOf;
    }

    public String getFollowers() {
        long number;
        boolean[] $jacocoInit = $jacocoInit();
        if (((TimelineUser) getPojo()).getStats() != null) {
            $jacocoInit[12] = true;
            StatusData stats = ((TimelineUser) getPojo()).getStats();
            $jacocoInit[13] = true;
            number = stats.getFollowers();
            $jacocoInit[14] = true;
        } else {
            number = 0;
            $jacocoInit[15] = true;
        }
        String valueOf = String.valueOf(number);
        $jacocoInit[16] = true;
        return valueOf;
    }

    public String getStoreName() {
        String str;
        boolean[] $jacocoInit = $jacocoInit();
        if (((TimelineUser) getPojo()).getStore() == null) {
            str = null;
            $jacocoInit[17] = true;
        } else {
            Store store = ((TimelineUser) getPojo()).getStore();
            $jacocoInit[18] = true;
            str = store.getName();
            $jacocoInit[19] = true;
        }
        $jacocoInit[20] = true;
        return str;
    }

    public String getStoreAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = ((TimelineUser) getPojo()).getStore();
        $jacocoInit[21] = true;
        String avatar = store.getAvatar();
        $jacocoInit[22] = true;
        return avatar;
    }

    public String getUserAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        String avatar = ((TimelineUser) getPojo()).getAvatar();
        $jacocoInit[23] = true;
        return avatar;
    }

    public boolean hasStoreAndUser() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!hasStore()) {
            $jacocoInit[24] = true;
        } else if (!hasUser()) {
            $jacocoInit[25] = true;
        } else {
            $jacocoInit[26] = true;
            z = true;
            $jacocoInit[28] = true;
            return z;
        }
        z = false;
        $jacocoInit[27] = true;
        $jacocoInit[28] = true;
        return z;
    }

    public boolean hasStore() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (((TimelineUser) getPojo()).getStore() == null) {
            $jacocoInit[29] = true;
        } else {
            Store store = ((TimelineUser) getPojo()).getStore();
            $jacocoInit[30] = true;
            String name = store.getName();
            $jacocoInit[31] = true;
            if (!TextUtils.isEmpty(name)) {
                $jacocoInit[32] = true;
            } else {
                $jacocoInit[33] = true;
                Store store2 = ((TimelineUser) getPojo()).getStore();
                $jacocoInit[34] = true;
                String avatar = store2.getAvatar();
                $jacocoInit[35] = true;
                if (TextUtils.isEmpty(avatar)) {
                    $jacocoInit[36] = true;
                } else {
                    $jacocoInit[37] = true;
                }
            }
            $jacocoInit[38] = true;
            z = true;
            $jacocoInit[40] = true;
            return z;
        }
        z = false;
        $jacocoInit[39] = true;
        $jacocoInit[40] = true;
        return z;
    }

    public boolean hasUser() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(((TimelineUser) getPojo()).getName())) {
            $jacocoInit[41] = true;
        } else if (!TextUtils.isEmpty(((TimelineUser) getPojo()).getAvatar())) {
            $jacocoInit[42] = true;
        } else {
            z = false;
            $jacocoInit[44] = true;
            $jacocoInit[45] = true;
            return z;
        }
        $jacocoInit[43] = true;
        z = true;
        $jacocoInit[45] = true;
        return z;
    }

    public int getStoreColor(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = ((TimelineUser) getPojo()).getStore();
        $jacocoInit[46] = true;
        if (store == null) {
            $jacocoInit[47] = true;
        } else if (store.getAppearance() == null) {
            $jacocoInit[48] = true;
        } else {
            $jacocoInit[49] = true;
            Appearance appearance = store.getAppearance();
            $jacocoInit[50] = true;
            String theme = appearance.getTheme();
            $jacocoInit[51] = true;
            StoreTheme storeTheme = StoreTheme.get(theme);
            $jacocoInit[52] = true;
            int storeHeaderColorResource = storeTheme.getStoreHeaderColorResource(context.getResources(), context.getTheme());
            $jacocoInit[53] = true;
            return storeHeaderColorResource;
        }
        StoreTheme storeTheme2 = StoreTheme.get(this.defaultTheme);
        $jacocoInit[54] = true;
        int storeHeaderColorResource2 = storeTheme2.getStoreHeaderColorResource(context.getResources(), context.getTheme());
        $jacocoInit[55] = true;
        return storeHeaderColorResource2;
    }

    public Drawable getButtonBackgroundStoreThemeColor(Context context) {
        StoreTheme storeTheme;
        boolean[] $jacocoInit = $jacocoInit();
        Store store = ((TimelineUser) getPojo()).getStore();
        $jacocoInit[56] = true;
        if (store.getAppearance() != null) {
            $jacocoInit[57] = true;
            storeTheme = StoreTheme.get(store);
            $jacocoInit[58] = true;
        } else {
            storeTheme = StoreTheme.ORANGE;
            $jacocoInit[59] = true;
        }
        Drawable buttonLayoutDrawable = storeTheme.getButtonLayoutDrawable(context.getResources(), context.getTheme());
        $jacocoInit[60] = true;
        return buttonLayoutDrawable;
    }

    public void viewClicked(FragmentNavigator navigator) {
        boolean[] $jacocoInit = $jacocoInit();
        Store store = ((TimelineUser) getPojo()).getStore();
        $jacocoInit[61] = true;
        String theme = getStoreTheme(store);
        if (store != null) {
            $jacocoInit[62] = true;
            FragmentProvider fragmentProvider = AptoideApplication.getFragmentProvider();
            $jacocoInit[63] = true;
            Fragment newStoreFragment = fragmentProvider.newStoreFragment(store.getName(), theme, OpenType.GetHome);
            $jacocoInit[64] = true;
            navigator.navigateTo(newStoreFragment, true);
            $jacocoInit[65] = true;
        } else {
            FragmentProvider fragmentProvider2 = AptoideApplication.getFragmentProvider();
            $jacocoInit[66] = true;
            Fragment newStoreFragment2 = fragmentProvider2.newStoreFragment(((TimelineUser) getPojo()).getId(), theme, OpenType.GetHome);
            $jacocoInit[67] = true;
            navigator.navigateTo(newStoreFragment2, true);
            $jacocoInit[68] = true;
        }
        $jacocoInit[69] = true;
    }

    private String getStoreTheme(Store store) {
        String theme;
        boolean[] $jacocoInit = $jacocoInit();
        if (store == null) {
            $jacocoInit[70] = true;
        } else if (store.getAppearance() == null) {
            $jacocoInit[71] = true;
        } else {
            $jacocoInit[72] = true;
            Appearance appearance = store.getAppearance();
            $jacocoInit[73] = true;
            if (appearance.getTheme() == null) {
                theme = this.defaultTheme;
                $jacocoInit[74] = true;
            } else {
                Appearance appearance2 = store.getAppearance();
                $jacocoInit[75] = true;
                theme = appearance2.getTheme();
                $jacocoInit[76] = true;
            }
            $jacocoInit[77] = true;
            $jacocoInit[79] = true;
            return theme;
        }
        theme = this.defaultTheme;
        $jacocoInit[78] = true;
        $jacocoInit[79] = true;
        return theme;
    }

    public boolean isLike() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.isLike;
        $jacocoInit[80] = true;
        return z;
    }
}
