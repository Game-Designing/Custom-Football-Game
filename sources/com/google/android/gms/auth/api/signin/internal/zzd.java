package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusPendingResult;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public final class zzd implements Runnable {

    /* renamed from: a */
    private static final Logger f19484a = new Logger("RevokeAccessOperation", new String[0]);

    /* renamed from: b */
    private final String f19485b;

    /* renamed from: c */
    private final StatusPendingResult f19486c = new StatusPendingResult(null);

    private zzd(String str) {
        Preconditions.m21866b(str);
        this.f19485b = str;
    }

    public final void run() {
        Status status = Status.f19599c;
        try {
            String valueOf = String.valueOf("https://accounts.google.com/o/oauth2/revoke?token=");
            String valueOf2 = String.valueOf(this.f19485b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.f19597a;
            } else {
                f19484a.mo27872b("Unable to revoke access!", new Object[0]);
            }
            Logger logger = f19484a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            logger.mo27870a(sb.toString(), new Object[0]);
        } catch (IOException e) {
            Logger logger2 = f19484a;
            String str = "IOException when revoking access: ";
            String valueOf3 = String.valueOf(e.toString());
            logger2.mo27872b(valueOf3.length() != 0 ? str.concat(valueOf3) : new String(str), new Object[0]);
        } catch (Exception e2) {
            Logger logger3 = f19484a;
            String str2 = "Exception when revoking access: ";
            String valueOf4 = String.valueOf(e2.toString());
            logger3.mo27872b(valueOf4.length() != 0 ? str2.concat(valueOf4) : new String(str2), new Object[0]);
        }
        this.f19486c.mo27451a(status);
    }

    /* renamed from: a */
    public static PendingResult<Status> m21013a(String str) {
        if (str == null) {
            return PendingResults.m21174a(new Status(4), (GoogleApiClient) null);
        }
        zzd zzd = new zzd(str);
        new Thread(zzd).start();
        return zzd.f19486c;
    }
}
