package p019d.p314k.p315a;

import android.os.Bundle;

/* renamed from: d.k.a.k */
/* compiled from: FetchService */
class C13169k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Bundle f40247a;

    /* renamed from: b */
    final /* synthetic */ C13177s f40248b;

    C13169k(C13177s this$0, Bundle bundle) {
        this.f40248b = this$0;
        this.f40247a = bundle;
    }

    public void run() {
        this.f40248b.f40263c.mo42170a();
        long id = this.f40247a.getLong("com.tonyodev.fetch.extra_id", -1);
        String str = "com.tonyodev.fetch.extra_priority";
        String str2 = "com.tonyodev.fetch.extra_url";
        switch (this.f40247a.getInt("com.tonyodev.fetch.action_type", -1)) {
            case 310:
                this.f40248b.m43039a(this.f40247a.getString(str2), this.f40247a.getString("com.tonyodev.fetch.extra_file_path"), this.f40247a.getParcelableArrayList("com.tonyodev.fetch.extra_headers"), this.f40247a.getInt(str, 600));
                return;
            case 311:
                this.f40248b.m43043b(id);
                return;
            case 312:
                this.f40248b.m43074h(id);
                return;
            case 313:
                this.f40248b.m43059d(id);
                return;
            case 314:
                this.f40248b.m43025a(this.f40247a.getInt("com.tonyodev.fetch.extra_network_id", 200));
                return;
            case 315:
                this.f40248b.m43084l();
                return;
            case 316:
                long queryId = this.f40247a.getLong("com.tonyodev.fetch.extra_query_id", -1);
                this.f40248b.m43026a(this.f40247a.getInt("com.tonyodev.fetch.extra_query_type", 481), queryId, id, this.f40247a.getInt("com.tonyodev.fetch.extra_status", -1));
                return;
            case 317:
                this.f40248b.m43028a(id, this.f40247a.getInt(str, 600));
                return;
            case 318:
                this.f40248b.m43078i(id);
                return;
            case 319:
                this.f40248b.m43073h();
                return;
            case 320:
                this.f40248b.m43040a(this.f40247a.getBoolean("com.tonyodev.fetch.extra_logging_id", true));
                return;
            case 321:
                this.f40248b.m43042b(this.f40247a.getInt("com.tonyodev.fetch.extra_concurrent_download_limit", 1));
                return;
            case 322:
                this.f40248b.m43029a(id, this.f40247a.getString(str2));
                return;
            case 323:
                this.f40248b.m43082j(this.f40247a.getLong("com.tonyodev.fetch.extra_on_update_interval", 2000));
                return;
            case 324:
                this.f40248b.m43067f(id);
                return;
            case 325:
                this.f40248b.m43081j();
                return;
            default:
                this.f40248b.m43084l();
                return;
        }
    }
}
