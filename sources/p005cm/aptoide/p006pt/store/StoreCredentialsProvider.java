package p005cm.aptoide.p006pt.store;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.BaseRequestWithStore.StoreCredentials;

/* renamed from: cm.aptoide.pt.store.StoreCredentialsProvider */
public interface StoreCredentialsProvider {
    StoreCredentials fromUrl(String str);

    StoreCredentials get(long j);

    StoreCredentials get(String str);
}
