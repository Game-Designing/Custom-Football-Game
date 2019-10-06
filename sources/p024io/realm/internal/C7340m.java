package p024io.realm.internal;

import java.lang.ref.WeakReference;
import java.util.Date;
import p024io.realm.C14000K;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.m */
/* compiled from: PendingRow */
public class C7340m implements C7347r {

    /* renamed from: a */
    private SharedRealm f14321a;

    /* renamed from: b */
    private Collection f14322b;

    /* renamed from: c */
    private C14000K<C7340m> f14323c;

    /* renamed from: d */
    private WeakReference<C7341a> f14324d;

    /* renamed from: e */
    private boolean f14325e;

    /* renamed from: io.realm.internal.m$a */
    /* compiled from: PendingRow */
    public interface C7341a {
        /* renamed from: a */
        void mo23789a(C7347r rVar);
    }

    public long getColumnCount() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: j */
    public String mo23718j(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public long getColumnIndex(String columnName) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: n */
    public RealmFieldType mo23721n(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: f */
    public Table mo23711f() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public long getIndex() {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: h */
    public long mo23716h(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: g */
    public boolean mo23712g(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: e */
    public float mo23708e(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: d */
    public double mo23707d(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: i */
    public Date mo23717i(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: m */
    public String mo23720m(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: c */
    public byte[] mo23706c(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: l */
    public boolean mo23513l(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: f */
    public LinkView mo23710f(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: b */
    public void mo23705b(long columnIndex, long value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23703a(long columnIndex, boolean value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23700a(long columnIndex, float value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23699a(long columnIndex, double value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23702a(long columnIndex, Date date) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    public void setString(long columnIndex, String value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23704a(long columnIndex, byte[] data) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public void mo23701a(long columnIndex, long value) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: k */
    public void mo23719k(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: a */
    public boolean mo23511a(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: b */
    public void mo23512b(long columnIndex) {
        throw new IllegalStateException("The pending query has not been executed.");
    }

    /* renamed from: e */
    public boolean mo23709e() {
        return false;
    }

    /* renamed from: b */
    private void m16165b() {
        this.f14322b.removeListener(this, this.f14323c);
        this.f14322b = null;
        this.f14323c = null;
        this.f14321a.mo23620a(this);
    }

    /* renamed from: c */
    private void m16166c() {
        WeakReference<C7341a> weakReference = this.f14324d;
        if (weakReference != null) {
            C7341a frontEnd = (C7341a) weakReference.get();
            if (frontEnd == null) {
                m16165b();
                return;
            }
            if (this.f14322b.isValid()) {
                UncheckedRow uncheckedRow = this.f14322b.firstUncheckedRow();
                m16165b();
                if (uncheckedRow != null) {
                    frontEnd.mo23789a(this.f14325e ? CheckedRow.m15876a(uncheckedRow) : uncheckedRow);
                } else {
                    frontEnd.mo23789a(C7331e.INSTANCE);
                }
            } else {
                m16165b();
            }
            return;
        }
        throw new IllegalStateException("The 'frontEnd' has not been set.");
    }

    /* renamed from: a */
    public void mo23788a() {
        if (this.f14322b != null) {
            m16166c();
            return;
        }
        throw new IllegalStateException("The query has been executed. This 'PendingRow' is not valid anymore.");
    }
}
