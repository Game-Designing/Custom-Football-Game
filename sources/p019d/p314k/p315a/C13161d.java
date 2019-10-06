package p019d.p314k.p315a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tonyodev.fetch.listener.FetchListener;
import java.util.Iterator;
import p019d.p314k.p315a.p316a.C13155a;

/* renamed from: d.k.a.d */
/* compiled from: Fetch */
class C13161d extends BroadcastReceiver {

    /* renamed from: a */
    private long f40210a;

    /* renamed from: b */
    private int f40211b;

    /* renamed from: c */
    private int f40212c;

    /* renamed from: d */
    private long f40213d;

    /* renamed from: e */
    private long f40214e;

    /* renamed from: f */
    private int f40215f;

    /* renamed from: g */
    final /* synthetic */ C13163f f40216g;

    C13161d(C13163f this$0) {
        this.f40216g = this$0;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            this.f40210a = intent.getLongExtra("com.tonyodev.fetch.extra_id", -1);
            this.f40211b = intent.getIntExtra("com.tonyodev.fetch.extra_status", -1);
            this.f40212c = intent.getIntExtra("com.tonyodev.fetch.extra_progress", -1);
            this.f40213d = intent.getLongExtra("com.tonyodev.fetch.extra_downloaded_bytes", -1);
            this.f40214e = intent.getLongExtra("com.tonyodev.fetch.extra_file_size", -1);
            this.f40215f = intent.getIntExtra("com.tonyodev.fetch.extra_error", -1);
            try {
                Iterator<FetchListener> listenerIterator = this.f40216g.m42994e();
                while (listenerIterator.hasNext()) {
                    ((C13155a) listenerIterator.next()).onUpdate(this.f40210a, this.f40211b, this.f40212c, this.f40213d, this.f40214e, this.f40215f);
                }
            } catch (Exception e) {
                if (this.f40216g.m42995f()) {
                    e.printStackTrace();
                }
            }
        }
    }
}
