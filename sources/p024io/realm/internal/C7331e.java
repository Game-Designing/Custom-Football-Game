package p024io.realm.internal;

import java.util.Date;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.e */
/* compiled from: InvalidRow */
public enum C7331e implements C7347r {
    INSTANCE;

    public long getColumnCount() {
        throw m16123g();
    }

    /* renamed from: j */
    public String mo23718j(long columnIndex) {
        throw m16123g();
    }

    public long getColumnIndex(String columnName) {
        throw m16123g();
    }

    /* renamed from: n */
    public RealmFieldType mo23721n(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: f */
    public Table mo23711f() {
        throw m16123g();
    }

    public long getIndex() {
        throw m16123g();
    }

    /* renamed from: h */
    public long mo23716h(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: g */
    public boolean mo23712g(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: e */
    public float mo23708e(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: d */
    public double mo23707d(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: i */
    public Date mo23717i(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: m */
    public String mo23720m(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: c */
    public byte[] mo23706c(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: l */
    public boolean mo23513l(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: f */
    public LinkView mo23710f(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: b */
    public void mo23705b(long columnIndex, long value) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23703a(long columnIndex, boolean value) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23700a(long columnIndex, float value) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23699a(long columnIndex, double value) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23702a(long columnIndex, Date date) {
        throw m16123g();
    }

    public void setString(long columnIndex, String value) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23704a(long columnIndex, byte[] data) {
        throw m16123g();
    }

    /* renamed from: a */
    public void mo23701a(long columnIndex, long value) {
        throw m16123g();
    }

    /* renamed from: k */
    public void mo23719k(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: a */
    public boolean mo23511a(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: b */
    public void mo23512b(long columnIndex) {
        throw m16123g();
    }

    /* renamed from: e */
    public boolean mo23709e() {
        return false;
    }

    /* renamed from: g */
    private RuntimeException m16123g() {
        return new IllegalStateException("Object is no longer managed by Realm. Has it been deleted?");
    }
}
