package p024io.realm.internal.p156a;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import p024io.realm.RealmFieldType;
import p024io.realm.internal.C7327c;
import p024io.realm.internal.p156a.C7317c.C7318a;

/* renamed from: io.realm.internal.a.a */
/* compiled from: CachedFieldDescriptor */
class C7315a extends C7317c {

    /* renamed from: m */
    private final C7318a f14266m;

    /* renamed from: n */
    private final String f14267n;

    C7315a(C7318a schema, String className, String fieldDescription, Set<RealmFieldType> validInternalColumnTypes, Set<RealmFieldType> validFinalColumnTypes) {
        super(fieldDescription, validInternalColumnTypes, validFinalColumnTypes);
        this.f14267n = className;
        this.f14266m = schema;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23729a(List<String> fields) {
        int nFields = fields.size();
        long[] columnIndices = new long[nFields];
        long[] tableNativePointers = new long[nFields];
        int i = 0;
        String currentTable = this.f14267n;
        String columnName = null;
        RealmFieldType columnType = null;
        while (i < nFields) {
            columnName = (String) fields.get(i);
            if (columnName == null || columnName.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            C7327c tableInfo = this.f14266m.mo23737a(currentTable);
            if (tableInfo != null) {
                long columnIndex = tableInfo.mo23758a(columnName);
                long j = 0;
                if (columnIndex >= 0) {
                    columnType = tableInfo.mo23763b(columnName);
                    if (i < nFields - 1) {
                        mo23730a(currentTable, columnName, columnType);
                    }
                    currentTable = tableInfo.mo23764c(columnName);
                    columnIndices[i] = columnIndex;
                    if (columnType == RealmFieldType.LINKING_OBJECTS) {
                        j = this.f14266m.mo23739b(currentTable);
                    }
                    tableNativePointers[i] = j;
                    i++;
                } else {
                    throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{columnName, currentTable}));
                }
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: table '%s' not found in this schema.", new Object[]{currentTable}));
            }
        }
        List<String> list = fields;
        mo23731a(this.f14267n, columnName, columnType, columnIndices, tableNativePointers);
    }
}
