package p024io.realm.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import p024io.realm.C14064ia;
import p024io.realm.RealmFieldType;
import p024io.realm.internal.p156a.C7317c;
import p024io.realm.internal.p156a.C7317c.C7318a;

@KeepMember
/* renamed from: io.realm.internal.SortDescriptor */
public class SortDescriptor {

    /* renamed from: a */
    static final Set<RealmFieldType> f14246a = Collections.unmodifiableSet(new HashSet(Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.FLOAT, RealmFieldType.DOUBLE, RealmFieldType.STRING, RealmFieldType.DATE})));

    /* renamed from: b */
    static final Set<RealmFieldType> f14247b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new RealmFieldType[]{RealmFieldType.BOOLEAN, RealmFieldType.INTEGER, RealmFieldType.STRING, RealmFieldType.DATE})));

    /* renamed from: c */
    private final Table f14248c;

    /* renamed from: d */
    private final long[][] f14249d;

    /* renamed from: e */
    private final boolean[] f14250e;

    /* renamed from: a */
    public static SortDescriptor m15954a(C7318a proxy, Table table, String fieldDescription, C14064ia sortOrder) {
        return m15955a(proxy, table, new String[]{fieldDescription}, new C14064ia[]{sortOrder});
    }

    /* renamed from: a */
    public static SortDescriptor m15955a(C7318a proxy, Table table, String[] fieldDescriptions, C14064ia[] sortOrders) {
        if (sortOrders == null || sortOrders.length == 0) {
            throw new IllegalArgumentException("You must provide at least one sort order.");
        } else if (fieldDescriptions.length == sortOrders.length) {
            return m15956a(proxy, table, fieldDescriptions, sortOrders, C7317c.f14272d, f14246a, "Sort is not supported");
        } else {
            throw new IllegalArgumentException("Number of fields and sort orders do not match.");
        }
    }

    /* renamed from: a */
    private static SortDescriptor m15956a(C7318a proxy, Table table, String[] fieldDescriptions, C14064ia[] sortOrders, Set<RealmFieldType> legalInternalTypes, Set<RealmFieldType> legalTerminalTypes, String message) {
        if (fieldDescriptions == null || fieldDescriptions.length == 0) {
            throw new IllegalArgumentException("You must provide at least one field name.");
        }
        long[][] columnIndices = new long[fieldDescriptions.length][];
        for (int i = 0; i < fieldDescriptions.length; i++) {
            C7317c descriptor = C7317c.m16059a(proxy, table, fieldDescriptions[i], legalInternalTypes, null);
            m15957a(descriptor, legalTerminalTypes, message, fieldDescriptions[i]);
            columnIndices[i] = descriptor.mo23732a();
        }
        return new SortDescriptor(table, columnIndices, sortOrders);
    }

    /* renamed from: a */
    private static void m15957a(C7317c descriptor, Set<RealmFieldType> legalTerminalTypes, String message, String fieldDescriptions) {
        if (!legalTerminalTypes.contains(descriptor.mo23734c())) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s on '%s' field '%s' in '%s'.", new Object[]{message, descriptor.mo23734c(), descriptor.mo23733b(), fieldDescriptions}));
        }
    }

    private SortDescriptor(Table table, long[][] columnIndices, C14064ia[] sortOrders) {
        this.f14248c = table;
        this.f14249d = columnIndices;
        if (sortOrders != null) {
            this.f14250e = new boolean[sortOrders.length];
            for (int i = 0; i < sortOrders.length; i++) {
                this.f14250e[i] = sortOrders[i].mo43737e();
            }
            return;
        }
        this.f14250e = null;
    }

    /* access modifiers changed from: 0000 */
    @KeepMember
    public long[][] getColumnIndices() {
        return this.f14249d;
    }

    /* access modifiers changed from: 0000 */
    @KeepMember
    public boolean[] getAscendings() {
        return this.f14250e;
    }

    @KeepMember
    private long getTablePtr() {
        return this.f14248c.getNativePtr();
    }
}
