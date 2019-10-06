package p024io.realm.internal.p156a;

import java.util.List;
import java.util.Locale;
import java.util.Set;
import p024io.realm.RealmFieldType;
import p024io.realm.internal.Table;

/* renamed from: io.realm.internal.a.b */
/* compiled from: DynamicFieldDescriptor */
class C7316b extends C7317c {

    /* renamed from: m */
    private final Table f14268m;

    C7316b(Table table, String fieldDescription, Set<RealmFieldType> validInternalColumnTypes, Set<RealmFieldType> validFinalColumnTypes) {
        super(fieldDescription, validInternalColumnTypes, validFinalColumnTypes);
        this.f14268m = table;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo23729a(List<String> fields) {
        int nFields = fields.size();
        long[] columnIndices = new long[nFields];
        int i = 0;
        Table currentTable = this.f14268m;
        String tableName = null;
        String columnName = null;
        RealmFieldType columnType = null;
        while (i < nFields) {
            columnName = (String) fields.get(i);
            if (columnName == null || columnName.length() <= 0) {
                throw new IllegalArgumentException("Invalid query: Field descriptor contains an empty field.  A field description may not begin with or contain adjacent periods ('.').");
            }
            tableName = currentTable.mo23659c();
            long columnIndex = currentTable.mo23656b(columnName);
            if (columnIndex >= 0) {
                columnType = currentTable.mo23668g(columnIndex);
                if (i < nFields - 1) {
                    mo23730a(tableName, columnName, columnType);
                    currentTable = currentTable.mo23670h(columnIndex);
                }
                columnIndices[i] = columnIndex;
                i++;
            } else {
                throw new IllegalArgumentException(String.format(Locale.US, "Invalid query: field '%s' not found in table '%s'.", new Object[]{columnName, tableName}));
            }
        }
        mo23731a(tableName, columnName, columnType, columnIndices, new long[nFields]);
    }
}
