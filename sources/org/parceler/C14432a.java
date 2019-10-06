package org.parceler;

import java.util.ArrayList;
import java.util.List;

/* renamed from: org.parceler.a */
/* compiled from: IdentityCollection */
public final class C14432a {

    /* renamed from: a */
    private static final Object f43280a = new Object();

    /* renamed from: b */
    private final List<Object> f43281b = new ArrayList();

    public C14432a() {
        mo45531b((Object) null);
    }

    /* renamed from: a */
    public boolean mo45530a(int id) {
        return id < this.f43281b.size();
    }

    /* renamed from: a */
    public int mo45527a() {
        return mo45531b(f43280a);
    }

    /* renamed from: c */
    public boolean mo45533c(int id) {
        return this.f43281b.get(id) == f43280a;
    }

    /* renamed from: a */
    public void mo45529a(int id, Object input) {
        if (this.f43281b.size() > id) {
            this.f43281b.remove(id);
        }
        this.f43281b.add(id, input);
    }

    /* renamed from: b */
    public int mo45531b(Object input) {
        this.f43281b.add(input);
        return this.f43281b.size() - 1;
    }

    /* renamed from: b */
    public <T> T mo45532b(int id) {
        return this.f43281b.get(id);
    }

    /* renamed from: a */
    public int mo45528a(Object input) {
        for (int i = 0; i < this.f43281b.size(); i++) {
            if (this.f43281b.get(i) == input) {
                return i;
            }
        }
        return -1;
    }
}
