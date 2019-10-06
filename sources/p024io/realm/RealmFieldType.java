package p024io.realm;

import java.nio.ByteBuffer;
import java.util.Date;
import p024io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.RealmFieldType */
public enum RealmFieldType {
    INTEGER(0),
    BOOLEAN(1),
    STRING(2),
    BINARY(4),
    UNSUPPORTED_TABLE(5),
    UNSUPPORTED_MIXED(6),
    UNSUPPORTED_DATE(7),
    DATE(8),
    FLOAT(9),
    DOUBLE(10),
    OBJECT(12),
    LIST(13),
    LINKING_OBJECTS(14);
    
    private static final RealmFieldType[] typeList = null;
    private final int nativeValue;

    static {
        typeList = new RealmFieldType[15];
        RealmFieldType[] columnTypes = values();
        for (int i = 0; i < columnTypes.length; i++) {
            typeList[columnTypes[i].nativeValue] = columnTypes[i];
        }
    }

    private RealmFieldType(int nativeValue2) {
        this.nativeValue = nativeValue2;
    }

    public int getNativeValue() {
        return this.nativeValue;
    }

    public boolean isValid(Object obj) {
        boolean z = true;
        switch (this.nativeValue) {
            case 0:
                if (!(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Short) && !(obj instanceof Byte)) {
                    z = false;
                }
                return z;
            case 1:
                return obj instanceof Boolean;
            case 2:
                return obj instanceof String;
            case 4:
                if (!(obj instanceof byte[]) && !(obj instanceof ByteBuffer)) {
                    z = false;
                }
                return z;
            case 5:
                if (obj != null && !(obj instanceof Object[][])) {
                    z = false;
                }
                return z;
            case 7:
                return obj instanceof Date;
            case 8:
                return obj instanceof Date;
            case 9:
                return obj instanceof Float;
            case 10:
                return obj instanceof Double;
            case 12:
                return false;
            case 13:
                return false;
            case 14:
                return false;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Unsupported Realm type:  ");
                sb.append(this);
                throw new RuntimeException(sb.toString());
        }
    }

    public static RealmFieldType fromNativeValue(int value) {
        if (value >= 0) {
            RealmFieldType[] realmFieldTypeArr = typeList;
            if (value < realmFieldTypeArr.length) {
                RealmFieldType e = realmFieldTypeArr[value];
                if (e != null) {
                    return e;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Invalid native Realm type: ");
        sb.append(value);
        throw new IllegalArgumentException(sb.toString());
    }
}
