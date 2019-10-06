package p024io.realm;

import java.util.Collection;
import p024io.realm.C0105Y;
import p024io.realm.internal.C0107f;

/* renamed from: io.realm.RealmCollection */
public interface RealmCollection<E extends C0105Y> extends Collection<E>, C0107f {
    boolean isLoaded();
}
