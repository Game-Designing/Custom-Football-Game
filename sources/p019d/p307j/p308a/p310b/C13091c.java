package p019d.p307j.p308a.p310b;

/* renamed from: d.j.a.b.c */
/* compiled from: DownloadServiceConnectChangedEvent */
public class C13091c extends C13093d {

    /* renamed from: c */
    private final C13092a f40085c;

    /* renamed from: d */
    private final Class<?> f40086d;

    /* renamed from: d.j.a.b.c$a */
    /* compiled from: DownloadServiceConnectChangedEvent */
    public enum C13092a {
        connected,
        disconnected,
        lost
    }

    public C13091c(C13092a status, Class<?> serviceClass) {
        super("event.service.connect.changed");
        this.f40085c = status;
        this.f40086d = serviceClass;
    }

    /* renamed from: b */
    public C13092a mo42067b() {
        return this.f40085c;
    }
}
