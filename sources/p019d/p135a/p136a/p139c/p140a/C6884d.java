package p019d.p135a.p136a.p139c.p140a;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: d.a.a.c.a.d */
/* compiled from: PaymentDetails */
public class C6884d implements Serializable {

    /* renamed from: a */
    private Map<String, C6881c> f12624a = new HashMap();

    public C6884d(Collection<C6881c> inputDetails) {
        for (C6881c inputDetail : inputDetails) {
            this.f12624a.put(inputDetail.mo22311d(), inputDetail);
        }
    }

    /* renamed from: a */
    public boolean mo22320a(String key, String value) {
        C6881c inputDetail = (C6881c) this.f12624a.get(key);
        if (inputDetail == null) {
            return false;
        }
        return inputDetail.mo22307a(value);
    }

    /* renamed from: a */
    public boolean mo22321a(String key, boolean value) {
        C6881c inputDetail = (C6881c) this.f12624a.get(key);
        if (inputDetail == null) {
            return false;
        }
        return inputDetail.mo22308a(value);
    }

    /* renamed from: a */
    public Collection<C6881c> mo22319a() {
        return this.f12624a.values();
    }
}
