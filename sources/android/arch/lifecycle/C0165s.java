package android.arch.lifecycle;

import java.util.HashMap;

/* renamed from: android.arch.lifecycle.s */
/* compiled from: ViewModelStore */
public class C0165s {

    /* renamed from: a */
    private final HashMap<String, C0162q> f229a = new HashMap<>();

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo3774a(String key, C0162q viewModel) {
        C0162q oldViewModel = (C0162q) this.f229a.get(key);
        if (oldViewModel != null) {
            oldViewModel.mo3768a();
        }
        this.f229a.put(key, viewModel);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C0162q mo3772a(String key) {
        return (C0162q) this.f229a.get(key);
    }

    /* renamed from: a */
    public final void mo3773a() {
        for (C0162q vm : this.f229a.values()) {
            vm.mo3768a();
        }
        this.f229a.clear();
    }
}
