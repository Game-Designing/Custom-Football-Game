package p024io.realm.internal;

import java.util.Date;
import p024io.realm.RealmFieldType;

/* renamed from: io.realm.internal.r */
/* compiled from: Row */
public interface C7347r {
    /* renamed from: a */
    void mo23699a(long j, double d);

    /* renamed from: a */
    void mo23700a(long j, float f);

    /* renamed from: a */
    void mo23701a(long j, long j2);

    /* renamed from: a */
    void mo23702a(long j, Date date);

    /* renamed from: a */
    void mo23703a(long j, boolean z);

    /* renamed from: a */
    void mo23704a(long j, byte[] bArr);

    /* renamed from: a */
    boolean mo23511a(long j);

    /* renamed from: b */
    void mo23512b(long j);

    /* renamed from: b */
    void mo23705b(long j, long j2);

    /* renamed from: c */
    byte[] mo23706c(long j);

    /* renamed from: d */
    double mo23707d(long j);

    /* renamed from: e */
    float mo23708e(long j);

    /* renamed from: e */
    boolean mo23709e();

    /* renamed from: f */
    LinkView mo23710f(long j);

    /* renamed from: f */
    Table mo23711f();

    /* renamed from: g */
    boolean mo23712g(long j);

    long getColumnCount();

    long getColumnIndex(String str);

    long getIndex();

    /* renamed from: h */
    long mo23716h(long j);

    /* renamed from: i */
    Date mo23717i(long j);

    /* renamed from: j */
    String mo23718j(long j);

    /* renamed from: k */
    void mo23719k(long j);

    /* renamed from: l */
    boolean mo23513l(long j);

    /* renamed from: m */
    String mo23720m(long j);

    /* renamed from: n */
    RealmFieldType mo23721n(long j);

    void setString(long j, String str);
}
