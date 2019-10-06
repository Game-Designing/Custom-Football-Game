package p019d.p143b.p144a.p147c;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: d.b.a.c.uc */
public class C7217uc {

    /* renamed from: a */
    public static final C7217uc f13987a = new C7217uc();

    /* renamed from: b */
    private final C7217uc f13988b;

    /* renamed from: c */
    private final String f13989c;

    /* renamed from: d */
    private final Map<String, String> f13990d;

    /* renamed from: e */
    protected String f13991e;

    /* renamed from: f */
    protected final List<C7217uc> f13992f;

    private C7217uc() {
        this.f13988b = null;
        String str = "";
        this.f13989c = str;
        this.f13990d = Collections.emptyMap();
        this.f13991e = str;
        this.f13992f = Collections.emptyList();
    }

    public C7217uc(String str, Map<String, String> map, C7217uc ucVar) {
        this.f13988b = ucVar;
        this.f13989c = str;
        this.f13990d = Collections.unmodifiableMap(map);
        this.f13992f = new ArrayList();
    }

    /* renamed from: a */
    public String mo23347a() {
        return this.f13989c;
    }

    /* renamed from: a */
    public List<C7217uc> mo23348a(String str) {
        if (str != null) {
            ArrayList arrayList = new ArrayList(this.f13992f.size());
            for (C7217uc ucVar : this.f13992f) {
                if (str.equalsIgnoreCase(ucVar.mo23347a())) {
                    arrayList.add(ucVar);
                }
            }
            return arrayList;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public C7217uc mo23349b(String str) {
        if (str != null) {
            for (C7217uc ucVar : this.f13992f) {
                if (str.equalsIgnoreCase(ucVar.mo23347a())) {
                    return ucVar;
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: b */
    public Map<String, String> mo23350b() {
        return this.f13990d;
    }

    /* renamed from: c */
    public C7217uc mo23351c(String str) {
        if (str != null) {
            if (this.f13992f.size() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this);
                while (!arrayList.isEmpty()) {
                    C7217uc ucVar = (C7217uc) arrayList.get(0);
                    arrayList.remove(0);
                    if (str.equalsIgnoreCase(ucVar.mo23347a())) {
                        return ucVar;
                    }
                    arrayList.addAll(ucVar.mo23353d());
                }
            }
            return null;
        }
        throw new IllegalArgumentException("No name specified.");
    }

    /* renamed from: c */
    public String mo23352c() {
        return this.f13991e;
    }

    /* renamed from: d */
    public List<C7217uc> mo23353d() {
        return Collections.unmodifiableList(this.f13992f);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("XmlNode{, elementName='");
        sb.append(this.f13989c);
        sb.append('\'');
        sb.append(", text='");
        sb.append(this.f13991e);
        sb.append('\'');
        sb.append(", attributes=");
        sb.append(this.f13990d);
        sb.append('}');
        return sb.toString();
    }
}
