package p019d.p271g.p272a;

/* renamed from: d.g.a.a */
public enum C12720a {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    

    /* renamed from: f */
    private final String f39035f;

    private C12720a(String str) {
        this.f39035f = str;
    }

    public final String toString() {
        return this.f39035f;
    }
}
