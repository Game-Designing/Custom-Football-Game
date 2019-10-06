package p363i.p364a.p366b;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* renamed from: i.a.b.b */
public final class C14224b {

    /* renamed from: a */
    final int f43133a;

    /* renamed from: b */
    private final C14224b f43134b;

    /* renamed from: c */
    final Map<Character, C14224b> f43135c;

    /* renamed from: d */
    C14224b f43136d;

    /* renamed from: e */
    private Set<String> f43137e;

    public C14224b() {
        this(0);
    }

    private C14224b(int i) {
        this.f43135c = new HashMap();
        this.f43133a = i;
        this.f43134b = i == 0 ? this : null;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final C14224b mo44332a(Character ch, boolean z) {
        C14224b bVar = (C14224b) this.f43135c.get(ch);
        if (z || bVar != null) {
            return bVar;
        }
        C14224b bVar2 = this.f43134b;
        if (bVar2 != null) {
            return bVar2;
        }
        return bVar;
    }

    /* renamed from: a */
    public final C14224b mo44333a(String str) {
        C14224b bVar = this;
        for (char valueOf : str.toCharArray()) {
            Character valueOf2 = Character.valueOf(valueOf);
            C14224b a = bVar.mo44332a(valueOf2, true);
            if (a == null) {
                a = new C14224b(bVar.f43133a + 1);
                bVar.f43135c.put(valueOf2, a);
            }
            bVar = a;
        }
        return bVar;
    }

    /* renamed from: b */
    public final void mo44336b(String str) {
        if (this.f43137e == null) {
            this.f43137e = new TreeSet();
        }
        this.f43137e.add(str);
    }

    /* renamed from: a */
    public final void mo44335a(Collection<String> collection) {
        for (String b : collection) {
            mo44336b(b);
        }
    }

    /* renamed from: a */
    public final Collection<String> mo44334a() {
        Set<String> set = this.f43137e;
        return set == null ? Collections.emptyList() : set;
    }
}
