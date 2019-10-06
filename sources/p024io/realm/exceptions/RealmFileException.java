package p024io.realm.exceptions;

import java.util.Locale;
import p024io.realm.internal.Keep;

@Keep
/* renamed from: io.realm.exceptions.RealmFileException */
public class RealmFileException extends RuntimeException {
    private final Kind kind;

    @Keep
    /* renamed from: io.realm.exceptions.RealmFileException$Kind */
    public enum Kind {
        ACCESS_ERROR,
        BAD_HISTORY,
        PERMISSION_DENIED,
        EXISTS,
        NOT_FOUND,
        INCOMPATIBLE_LOCK_FILE,
        FORMAT_UPGRADE_REQUIRED;

        static Kind getKind(byte value) {
            switch (value) {
                case 0:
                    return ACCESS_ERROR;
                case 1:
                    return BAD_HISTORY;
                case 2:
                    return PERMISSION_DENIED;
                case 3:
                    return EXISTS;
                case 4:
                    return NOT_FOUND;
                case 5:
                    return INCOMPATIBLE_LOCK_FILE;
                case 6:
                    return FORMAT_UPGRADE_REQUIRED;
                default:
                    throw new RuntimeException("Unknown value for RealmFileException kind.");
            }
        }
    }

    public RealmFileException(byte value, String message) {
        super(message);
        this.kind = Kind.getKind(value);
    }

    public RealmFileException(Kind kind2, String message) {
        super(message);
        this.kind = kind2;
    }

    public RealmFileException(Kind kind2, Throwable cause) {
        super(cause);
        this.kind = kind2;
    }

    public RealmFileException(Kind kind2, String message, Throwable cause) {
        super(message, cause);
        this.kind = kind2;
    }

    public Kind getKind() {
        return this.kind;
    }

    public String toString() {
        return String.format(Locale.US, "%s Kind: %s.", new Object[]{super.toString(), this.kind});
    }
}
