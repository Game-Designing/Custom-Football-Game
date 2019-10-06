package com.smaato.soma.p261j;

import android.annotation.SuppressLint;
import com.smaato.soma.p239c.p242c.C12202o;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.smaato.soma.j.O */
/* compiled from: VideoAdDispatcherCache */
public class C12447O {
    @SuppressLint({"UseSparseArrays"})

    /* renamed from: a */
    private static final Map<Long, C12202o> f38863a = Collections.synchronizedMap(new HashMap());

    /* renamed from: a */
    public static void m40922a(Long videoAdDispatcherCacheId, C12202o videoAdDispatcher) {
        f38863a.put(videoAdDispatcherCacheId, videoAdDispatcher);
    }

    /* renamed from: a */
    public static C12202o m40921a(Long videoAdDispatcherCacheId) {
        return (C12202o) f38863a.get(videoAdDispatcherCacheId);
    }

    /* renamed from: b */
    public static C12202o m40923b(Long videoAdDispatcherCacheId) {
        return (C12202o) f38863a.remove(videoAdDispatcherCacheId);
    }
}
