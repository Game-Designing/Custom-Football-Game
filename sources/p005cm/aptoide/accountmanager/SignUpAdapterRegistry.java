package p005cm.aptoide.accountmanager;

import java.util.Map;
import p026rx.C0117M;
import p026rx.C0120S;
import p026rx.Single;
import p026rx.p027b.C0132p;

/* renamed from: cm.aptoide.accountmanager.SignUpAdapterRegistry */
public class SignUpAdapterRegistry {
    private final AccountService accountService;
    private final Map<String, SignUpAdapter> adapters;

    public SignUpAdapterRegistry(Map<String, SignUpAdapter> adapters2, AccountService accountService2) {
        this.adapters = adapters2;
        this.accountService = accountService2;
    }

    public void register(String type, SignUpAdapter adapter) {
        this.adapters.put(type, adapter);
    }

    public <T> Single<Account> signUp(String type, T data) {
        return ((SignUpAdapter) this.adapters.get(type)).signUp(data, this.accountService);
    }

    public C0117M logoutAll() {
        return C0120S.m629a((Iterable<? extends T>) this.adapters.values()).mo3653d((C0132p<? super T, Boolean>) C1339v.f4236a).mo3669j(C1340w.f4237a).mo3663g((C0132p<? super T, ? extends C0117M>) C1338u.f4235a).mo3673l();
    }

    /* renamed from: a */
    static /* synthetic */ C0117M m6128a(C0117M logout) {
        return logout;
    }

    public boolean isEnabled(String type) {
        return ((SignUpAdapter) this.adapters.get(type)).isEnabled();
    }
}
