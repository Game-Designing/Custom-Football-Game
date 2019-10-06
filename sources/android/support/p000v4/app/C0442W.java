package android.support.p000v4.app;

import android.os.Bundle;
import android.support.p000v4.content.C0511c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.app.W */
/* compiled from: LoaderManager */
public abstract class C0442W {

    /* renamed from: android.support.v4.app.W$a */
    /* compiled from: LoaderManager */
    public interface C0443a<D> {
        /* renamed from: a */
        void mo5091a(C0511c<D> cVar);

        /* renamed from: a */
        void mo5092a(C0511c<D> cVar, D d);

        C0511c<D> onCreateLoader(int i, Bundle bundle);
    }

    /* renamed from: a */
    public abstract <D> C0511c<D> mo5050a(int i, Bundle bundle, C0443a<D> aVar);

    /* renamed from: a */
    public abstract void mo5052a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
