package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

@KeepForSdk
public final class ListenerHolder<L> {

    /* renamed from: a */
    private final C8647a f19697a;

    /* renamed from: b */
    private volatile L f19698b;

    /* renamed from: c */
    private final ListenerKey<L> f19699c;

    @KeepForSdk
    public static final class ListenerKey<L> {

        /* renamed from: a */
        private final L f19700a;

        /* renamed from: b */
        private final String f19701b;

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListenerKey)) {
                return false;
            }
            ListenerKey listenerKey = (ListenerKey) obj;
            if (this.f19700a != listenerKey.f19700a || !this.f19701b.equals(listenerKey.f19701b)) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f19700a) * 31) + this.f19701b.hashCode();
        }
    }

    @KeepForSdk
    public interface Notifier<L> {
    }

    /* renamed from: com.google.android.gms.common.api.internal.ListenerHolder$a */
    private final class C8647a extends zap {
    }

    @KeepForSdk
    /* renamed from: a */
    public final void mo27527a(Notifier<? super L> notifier) {
        Preconditions.m21858a(notifier, (Object) "Notifier must not be null");
        this.f19697a.sendMessage(this.f19697a.obtainMessage(1, notifier));
    }

    @KeepForSdk
    /* renamed from: a */
    public final void mo27526a() {
        this.f19698b = null;
    }

    @KeepForSdk
    /* renamed from: b */
    public final ListenerKey<L> mo27528b() {
        return this.f19699c;
    }
}
