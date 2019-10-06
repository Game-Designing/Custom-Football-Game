package com.mopub.common.util;

import com.mopub.common.Preconditions;
import java.util.Collection;
import java.util.Collections;

public class MoPubCollections {
    public static <T> void addAllNonNull(Collection<? super T> c, T... a) {
        Collections.addAll(c, a);
        c.removeAll(Collections.singleton(null));
    }

    public static <T> void addAllNonNull(Collection<? super T> collection, Collection<T> elementsToAdd) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(elementsToAdd);
        collection.addAll(elementsToAdd);
        collection.removeAll(Collections.singleton(null));
    }
}
