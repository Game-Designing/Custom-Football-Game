package p005cm.aptoide.accountmanager;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p009v7.store.Store.SocialChannelType;
import p026rx.C0117M;

/* renamed from: cm.aptoide.accountmanager.StoreManager */
public interface StoreManager {
    C0117M createOrUpdate(String str, String str2, String str3, boolean z, String str4, boolean z2, List<SocialLink> list, List<SocialChannelType> list2);
}
