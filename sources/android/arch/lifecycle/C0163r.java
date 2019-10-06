package android.arch.lifecycle;

/* renamed from: android.arch.lifecycle.r */
/* compiled from: ViewModelProvider */
public class C0163r {

    /* renamed from: a */
    private final C0164a f227a;

    /* renamed from: b */
    private final C0165s f228b;

    /* renamed from: android.arch.lifecycle.r$a */
    /* compiled from: ViewModelProvider */
    public interface C0164a {
        /* renamed from: a */
        <T extends C0162q> T mo3771a(Class<T> cls);
    }

    public C0163r(C0165s store, C0164a factory) {
        this.f227a = factory;
        this.f228b = store;
    }

    /* renamed from: a */
    public <T extends C0162q> T mo3769a(Class<T> modelClass) {
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("android.arch.lifecycle.ViewModelProvider.DefaultKey:");
            sb.append(canonicalName);
            return mo3770a(sb.toString(), modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    /* renamed from: a */
    public <T extends C0162q> T mo3770a(String key, Class<T> modelClass) {
        C0162q viewModel = this.f228b.mo3772a(key);
        if (modelClass.isInstance(viewModel)) {
            return viewModel;
        }
        C0162q viewModel2 = this.f227a.mo3771a(modelClass);
        this.f228b.mo3774a(key, viewModel2);
        return viewModel2;
    }
}
