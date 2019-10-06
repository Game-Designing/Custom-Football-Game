package p005cm.aptoide.p006pt.account.view.store;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.accountmanager.SocialLink;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannel;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p005cm.aptoide.p006pt.store.StoreTheme;

/* renamed from: cm.aptoide.pt.account.view.store.ManageStoreViewModel */
public class ManageStoreViewModel {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String FACEBOOK_BASE_URL = "https://www.facebook.com/";
    public static final String TWITCH_BASE_URL = "https://go.twitch.tv/";
    public static final String TWITTER_BASE_URL = "https://twitter.com/";
    public static final String YOUTUBE_BASE_URL = "https://www.youtube.com/";
    boolean newAvatar;
    String pictureUri;
    List<SocialChannelType> socialDelLinks;
    List<SocialLink> socialLinks;
    String storeDescription;
    long storeId;
    String storeName;
    StoreTheme storeTheme;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-813103867447279191L, "cm/aptoide/pt/account/view/store/ManageStoreViewModel", 40);
        $jacocoData = probes;
        return probes;
    }

    public ManageStoreViewModel() {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = -1;
        String str = "";
        this.storeName = str;
        this.storeDescription = str;
        this.pictureUri = str;
        this.storeTheme = StoreTheme.DEFAULT;
        this.newAvatar = false;
        $jacocoInit[0] = true;
        this.socialLinks = Collections.emptyList();
        $jacocoInit[1] = true;
        this.socialDelLinks = Collections.emptyList();
        $jacocoInit[2] = true;
    }

    public ManageStoreViewModel(long storeId2, StoreTheme storeTheme2, String storeName2, String storeDescription2, String pictureUri2, List<SocialChannel> storeLinks) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = storeId2;
        this.storeName = storeName2;
        this.storeDescription = storeDescription2;
        this.pictureUri = pictureUri2;
        this.storeTheme = storeTheme2;
        this.newAvatar = false;
        $jacocoInit[3] = true;
        this.socialLinks = buildSocialLinksList(storeLinks);
        $jacocoInit[4] = true;
        this.socialDelLinks = new ArrayList();
        $jacocoInit[5] = true;
    }

    public static ManageStoreViewModel update(ManageStoreViewModel model, String storeName2, String storeDescription2) {
        boolean[] $jacocoInit = $jacocoInit();
        if (TextUtils.isEmpty(storeName2)) {
            $jacocoInit[6] = true;
        } else {
            $jacocoInit[7] = true;
            model.setStoreName(storeName2);
            $jacocoInit[8] = true;
        }
        if (TextUtils.isEmpty(storeDescription2)) {
            $jacocoInit[9] = true;
        } else {
            $jacocoInit[10] = true;
            model.setStoreDescription(storeDescription2);
            $jacocoInit[11] = true;
        }
        $jacocoInit[12] = true;
        return model;
    }

    private List<SocialLink> buildSocialLinksList(List<SocialChannel> socialChannels) {
        boolean[] $jacocoInit = $jacocoInit();
        List<SocialLink> storeLinks = new ArrayList<>();
        $jacocoInit[13] = true;
        $jacocoInit[14] = true;
        for (SocialChannel socialChannel : socialChannels) {
            $jacocoInit[15] = true;
            storeLinks.add(new SocialLink(socialChannel.getType(), socialChannel.getUrl()));
            $jacocoInit[16] = true;
        }
        $jacocoInit[17] = true;
        return storeLinks;
    }

    public void setNewAvatar(boolean newAvatar2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.newAvatar = newAvatar2;
        $jacocoInit[18] = true;
    }

    public String getStoreName() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeName;
        $jacocoInit[19] = true;
        return str;
    }

    public void setStoreName(String storeName2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeName = storeName2;
        $jacocoInit[20] = true;
    }

    public String getStoreDescription() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.storeDescription;
        $jacocoInit[21] = true;
        return str;
    }

    public void setStoreDescription(String storeDescription2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeDescription = storeDescription2;
        $jacocoInit[22] = true;
    }

    public String getPictureUri() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.pictureUri;
        $jacocoInit[23] = true;
        return str;
    }

    public void setPictureUri(String pictureUri2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.pictureUri = pictureUri2;
        $jacocoInit[24] = true;
    }

    public boolean hasNewAvatar() {
        boolean[] $jacocoInit = $jacocoInit();
        boolean z = this.newAvatar;
        $jacocoInit[25] = true;
        return z;
    }

    public boolean hasPicture() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (!TextUtils.isEmpty(this.pictureUri)) {
            $jacocoInit[26] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[27] = true;
        }
        $jacocoInit[28] = true;
        return z;
    }

    public long getStoreId() {
        boolean[] $jacocoInit = $jacocoInit();
        long j = this.storeId;
        $jacocoInit[29] = true;
        return j;
    }

    public void setStoreId(long storeId2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeId = storeId2;
        $jacocoInit[30] = true;
    }

    public StoreTheme getStoreTheme() {
        boolean[] $jacocoInit = $jacocoInit();
        StoreTheme storeTheme2 = this.storeTheme;
        $jacocoInit[31] = true;
        return storeTheme2;
    }

    public void setStoreTheme(StoreTheme storeTheme2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.storeTheme = storeTheme2;
        $jacocoInit[32] = true;
    }

    public boolean storeExists() {
        boolean z;
        boolean[] $jacocoInit = $jacocoInit();
        if (this.storeId >= 0) {
            $jacocoInit[33] = true;
            z = true;
        } else {
            z = false;
            $jacocoInit[34] = true;
        }
        $jacocoInit[35] = true;
        return z;
    }

    public List<SocialLink> getSocialLinks() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SocialLink> list = this.socialLinks;
        $jacocoInit[36] = true;
        return list;
    }

    public void setSocialLinks(List<SocialLink> socialLinks2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.socialLinks = socialLinks2;
        $jacocoInit[37] = true;
    }

    public List<SocialChannelType> getSocialDeleteLinks() {
        boolean[] $jacocoInit = $jacocoInit();
        List<SocialChannelType> list = this.socialDelLinks;
        $jacocoInit[38] = true;
        return list;
    }

    public void setSocialDelLinks(List<SocialChannelType> socialDelLinks2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.socialDelLinks = socialDelLinks2;
        $jacocoInit[39] = true;
    }
}
