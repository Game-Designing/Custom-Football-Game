package p024io.realm.internal;

import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import p024io.realm.C13981A;
import p024io.realm.C14000K;
import p024io.realm.C14093z;
import p024io.realm.internal.C7336k.C7337a;
import p024io.realm.internal.C7336k.C7338b;

@Keep
/* renamed from: io.realm.internal.Collection */
public class Collection implements C7333h {
    public static final byte AGGREGATE_FUNCTION_AVERAGE = 3;
    public static final byte AGGREGATE_FUNCTION_MAXIMUM = 2;
    public static final byte AGGREGATE_FUNCTION_MINIMUM = 1;
    public static final byte AGGREGATE_FUNCTION_SUM = 4;
    private static final String CLOSED_REALM_MESSAGE = "This Realm instance has already been closed, making it unusable.";
    public static final byte MODE_EMPTY = 0;
    public static final byte MODE_LINKVIEW = 3;
    public static final byte MODE_QUERY = 2;
    public static final byte MODE_TABLE = 1;
    public static final byte MODE_TABLEVIEW = 4;
    private static final long nativeFinalizerPtr = nativeGetFinalizerPtr();
    private final C7332g context;
    /* access modifiers changed from: private */
    public boolean isSnapshot;
    private boolean loaded;
    private final long nativePtr;
    private final C7336k<C7300c> observerPairs;
    /* access modifiers changed from: private */
    public final SharedRealm sharedRealm;
    private final Table table;

    /* renamed from: io.realm.internal.Collection$a */
    public enum C7298a {
        MINIMUM(1),
        MAXIMUM(2),
        AVERAGE(3),
        SUM(4);
        

        /* renamed from: f */
        private final byte f14184f;

        private C7298a(byte value) {
            this.f14184f = value;
        }

        /* renamed from: e */
        public byte mo23565e() {
            return this.f14184f;
        }
    }

    /* renamed from: io.realm.internal.Collection$b */
    private static class C7299b implements C7337a<C7300c> {

        /* renamed from: a */
        private final C14093z f14185a;

        C7299b(C14093z changeSet) {
            this.f14185a = changeSet;
        }

        /* renamed from: a */
        public void mo23567a(C7300c pair, Object observer) {
            pair.mo23568a(observer, this.f14185a);
        }
    }

    /* renamed from: io.realm.internal.Collection$c */
    private static class C7300c<T> extends C7338b<T, Object> {
        public C7300c(T observer, Object listener) {
            super(observer, listener);
        }

        /* renamed from: a */
        public void mo23568a(T observer, C14093z changes) {
            S s = this.f14319b;
            if (s instanceof C13981A) {
                ((C13981A) s).mo23583a(observer, changes);
            } else if (s instanceof C14000K) {
                ((C14000K) s).mo43559a(observer);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported listener type: ");
                sb.append(this.f14319b);
                throw new RuntimeException(sb.toString());
            }
        }
    }

    /* renamed from: io.realm.internal.Collection$d */
    public static abstract class C7301d<T> implements Iterator<T> {

        /* renamed from: a */
        Collection f14186a;

        /* renamed from: b */
        protected int f14187b = -1;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract T mo23570a(UncheckedRow uncheckedRow);

        public C7301d(Collection collection) {
            if (!collection.sharedRealm.isClosed()) {
                this.f14186a = collection;
                if (!collection.isSnapshot) {
                    if (collection.sharedRealm.mo23636j()) {
                        mo23572b();
                    } else {
                        this.f14186a.sharedRealm.mo23618a(this);
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException(Collection.CLOSED_REALM_MESSAGE);
        }

        public boolean hasNext() {
            mo23571a();
            return ((long) (this.f14187b + 1)) < this.f14186a.size();
        }

        public T next() {
            mo23571a();
            this.f14187b++;
            if (((long) this.f14187b) < this.f14186a.size()) {
                return mo23569a(this.f14187b);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot access index ");
            sb.append(this.f14187b);
            sb.append(" when size is ");
            sb.append(this.f14186a.size());
            sb.append(". Remember to check hasNext() before using next().");
            throw new NoSuchElementException(sb.toString());
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: b */
        public void mo23572b() {
            this.f14186a = this.f14186a.createSnapshot();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo23573c() {
            this.f14186a = null;
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public void mo23571a() {
            if (this.f14186a == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: a */
        public T mo23569a(int pos) {
            return mo23570a(this.f14186a.getUncheckedRow(pos));
        }
    }

    /* renamed from: io.realm.internal.Collection$e */
    public static abstract class C7302e<T> extends C7301d<T> implements ListIterator<T> {
        public C7302e(Collection collection, int start) {
            super(collection);
            if (start < 0 || ((long) start) > this.f14186a.size()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Starting location must be a valid index: [0, ");
                sb.append(this.f14186a.size() - 1);
                sb.append("]. Yours was ");
                sb.append(start);
                throw new IndexOutOfBoundsException(sb.toString());
            }
            this.f14187b = start - 1;
        }

        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        public boolean hasPrevious() {
            mo23571a();
            return this.f14187b >= 0;
        }

        public int nextIndex() {
            mo23571a();
            return this.f14187b + 1;
        }

        public T previous() {
            mo23571a();
            try {
                T obj = mo23569a(this.f14187b);
                this.f14187b--;
                return obj;
            } catch (IndexOutOfBoundsException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot access index less than zero. This was ");
                sb.append(this.f14187b);
                sb.append(". Remember to check hasPrevious() before using previous().");
                throw new NoSuchElementException(sb.toString());
            }
        }

        public int previousIndex() {
            mo23571a();
            return this.f14187b;
        }

        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing and element is not supported.");
        }
    }

    /* renamed from: io.realm.internal.Collection$f */
    public enum C7303f {
        EMPTY,
        TABLE,
        QUERY,
        LINKVIEW,
        TABLEVIEW;

        /* renamed from: a */
        static C7303f m15890a(byte value) {
            if (value == 0) {
                return EMPTY;
            }
            if (value == 1) {
                return TABLE;
            }
            if (value == 2) {
                return QUERY;
            }
            if (value == 3) {
                return LINKVIEW;
            }
            if (value == 4) {
                return TABLEVIEW;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid value: ");
            sb.append(value);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    /* renamed from: io.realm.internal.Collection$g */
    private static class C7304g<T> implements C13981A<T> {

        /* renamed from: a */
        private final C14000K<T> f14194a;

        C7304g(C14000K<T> listener) {
            this.f14194a = listener;
        }

        /* renamed from: a */
        public void mo23583a(T collection, C14093z changes) {
            this.f14194a.mo43559a(collection);
        }

        public boolean equals(Object obj) {
            return (obj instanceof C7304g) && this.f14194a == ((C7304g) obj).f14194a;
        }

        public int hashCode() {
            return this.f14194a.hashCode();
        }
    }

    private static native Object nativeAggregate(long j, long j2, byte b);

    private static native void nativeClear(long j);

    private static native boolean nativeContains(long j, long j2);

    private static native long nativeCreateResults(long j, long j2, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2);

    private static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    private static native long nativeCreateResultsFromLinkView(long j, long j2, SortDescriptor sortDescriptor);

    private static native long nativeCreateSnapshot(long j);

    private static native void nativeDelete(long j, long j2);

    private static native boolean nativeDeleteFirst(long j);

    private static native boolean nativeDeleteLast(long j);

    private static native long nativeDistinct(long j, SortDescriptor sortDescriptor);

    private static native long nativeFirstRow(long j);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j);

    private static native long nativeGetRow(long j, int i);

    private static native long nativeIndexOf(long j, long j2);

    private static native long nativeIndexOfBySourceRowIndex(long j, long j2);

    private static native boolean nativeIsValid(long j);

    private static native long nativeLastRow(long j);

    private static native long nativeSize(long j);

    private static native long nativeSort(long j, SortDescriptor sortDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private static native long nativeWhere(long j);

    public static Collection createBacklinksCollection(SharedRealm realm, UncheckedRow row, Table srcTable, String srcFieldName) {
        Collection collection = new Collection(realm, srcTable, nativeCreateResultsFromBacklinks(realm.getNativePtr(), row.getNativePtr(), srcTable.getNativePtr(), srcTable.mo23656b(srcFieldName)), true);
        return collection;
    }

    public Collection(SharedRealm sharedRealm2, TableQuery query, SortDescriptor sortDescriptor, SortDescriptor distinctDescriptor) {
        this.isSnapshot = false;
        this.observerPairs = new C7336k<>();
        query.mo23698g();
        this.nativePtr = nativeCreateResults(sharedRealm2.getNativePtr(), query.getNativePtr(), sortDescriptor, distinctDescriptor);
        this.sharedRealm = sharedRealm2;
        this.context = sharedRealm2.f14234l;
        this.table = query.mo23695d();
        this.context.mo23771a(this);
        this.loaded = false;
    }

    public Collection(SharedRealm sharedRealm2, TableQuery query, SortDescriptor sortDescriptor) {
        this(sharedRealm2, query, sortDescriptor, (SortDescriptor) null);
    }

    public Collection(SharedRealm sharedRealm2, TableQuery query) {
        this(sharedRealm2, query, (SortDescriptor) null, (SortDescriptor) null);
    }

    public Collection(SharedRealm sharedRealm2, LinkView linkView, SortDescriptor sortDescriptor) {
        this.isSnapshot = false;
        this.observerPairs = new C7336k<>();
        this.nativePtr = nativeCreateResultsFromLinkView(sharedRealm2.getNativePtr(), linkView.getNativePtr(), sortDescriptor);
        this.sharedRealm = sharedRealm2;
        this.context = sharedRealm2.f14234l;
        this.table = linkView.mo23590b();
        this.context.mo23771a(this);
        this.loaded = true;
    }

    private Collection(SharedRealm sharedRealm2, Table table2, long nativePtr2) {
        this(sharedRealm2, table2, nativePtr2, false);
    }

    private Collection(SharedRealm sharedRealm2, Table table2, long nativePtr2, boolean loaded2) {
        this.isSnapshot = false;
        this.observerPairs = new C7336k<>();
        this.sharedRealm = sharedRealm2;
        this.context = sharedRealm2.f14234l;
        this.table = table2;
        this.nativePtr = nativePtr2;
        this.context.mo23771a(this);
        this.loaded = loaded2;
    }

    public Collection createSnapshot() {
        if (this.isSnapshot) {
            return this;
        }
        Collection collection = new Collection(this.sharedRealm, this.table, nativeCreateSnapshot(this.nativePtr));
        collection.isSnapshot = true;
        return collection;
    }

    public long getNativePtr() {
        return this.nativePtr;
    }

    public long getNativeFinalizerPtr() {
        return nativeFinalizerPtr;
    }

    public UncheckedRow getUncheckedRow(int index) {
        return this.table.mo23675j(nativeGetRow(this.nativePtr, index));
    }

    public UncheckedRow firstUncheckedRow() {
        long rowPtr = nativeFirstRow(this.nativePtr);
        if (rowPtr != 0) {
            return this.table.mo23675j(rowPtr);
        }
        return null;
    }

    public UncheckedRow lastUncheckedRow() {
        long rowPtr = nativeLastRow(this.nativePtr);
        if (rowPtr != 0) {
            return this.table.mo23675j(rowPtr);
        }
        return null;
    }

    public Table getTable() {
        return this.table;
    }

    public TableQuery where() {
        return new TableQuery(this.context, this.table, nativeWhere(this.nativePtr));
    }

    public Number aggregateNumber(C7298a aggregateMethod, long columnIndex) {
        return (Number) nativeAggregate(this.nativePtr, columnIndex, aggregateMethod.mo23565e());
    }

    public Date aggregateDate(C7298a aggregateMethod, long columnIndex) {
        return (Date) nativeAggregate(this.nativePtr, columnIndex, aggregateMethod.mo23565e());
    }

    public long size() {
        return nativeSize(this.nativePtr);
    }

    public void clear() {
        nativeClear(this.nativePtr);
    }

    public Collection sort(SortDescriptor sortDescriptor) {
        return new Collection(this.sharedRealm, this.table, nativeSort(this.nativePtr, sortDescriptor));
    }

    public Collection distinct(SortDescriptor distinctDescriptor) {
        return new Collection(this.sharedRealm, this.table, nativeDistinct(this.nativePtr, distinctDescriptor));
    }

    public boolean contains(UncheckedRow row) {
        return nativeContains(this.nativePtr, row.getNativePtr());
    }

    public int indexOf(UncheckedRow row) {
        long index = nativeIndexOf(this.nativePtr, row.getNativePtr());
        return index > 2147483647L ? MoPubClientPositioning.NO_REPEAT : (int) index;
    }

    public int indexOf(long sourceRowIndex) {
        long index = nativeIndexOfBySourceRowIndex(this.nativePtr, sourceRowIndex);
        return index > 2147483647L ? MoPubClientPositioning.NO_REPEAT : (int) index;
    }

    public void delete(long index) {
        nativeDelete(this.nativePtr, index);
    }

    public boolean deleteFirst() {
        return nativeDeleteFirst(this.nativePtr);
    }

    public boolean deleteLast() {
        return nativeDeleteLast(this.nativePtr);
    }

    public <T> void addListener(T observer, C13981A<T> listener) {
        if (this.observerPairs.mo23784b()) {
            nativeStartListening(this.nativePtr);
        }
        this.observerPairs.mo23781a(new C7300c<>(observer, listener));
    }

    public <T> void addListener(T observer, C14000K<T> listener) {
        addListener(observer, (C13981A<T>) new C7304g<T>(listener));
    }

    public <T> void removeListener(T observer, C13981A<T> listener) {
        this.observerPairs.mo23783a(observer, listener);
        if (this.observerPairs.mo23784b()) {
            nativeStopListening(this.nativePtr);
        }
    }

    public <T> void removeListener(T observer, C14000K<T> listener) {
        removeListener(observer, (C13981A<T>) new C7304g<T>(listener));
    }

    public void removeAllListeners() {
        this.observerPairs.mo23779a();
        nativeStopListening(this.nativePtr);
    }

    public boolean isValid() {
        return nativeIsValid(this.nativePtr);
    }

    private void notifyChangeListeners(long nativeChangeSetPtr) {
        if (nativeChangeSetPtr != 0 || !isLoaded()) {
            boolean wasLoaded = this.loaded;
            this.loaded = true;
            this.observerPairs.mo23780a((C7337a<T>) new C7299b<T>((nativeChangeSetPtr == 0 || !wasLoaded) ? null : new CollectionChangeSet(nativeChangeSetPtr)));
        }
    }

    public C7303f getMode() {
        return C7303f.m15890a(nativeGetMode(this.nativePtr));
    }

    public boolean isLoaded() {
        return this.loaded;
    }

    public void load() {
        if (!this.loaded) {
            notifyChangeListeners(0);
        }
    }
}
