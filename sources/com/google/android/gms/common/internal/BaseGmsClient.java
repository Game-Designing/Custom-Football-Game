package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IGmsCallbacks.zza;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";

    /* renamed from: a */
    private static final Feature[] f20006a = new Feature[0];

    /* renamed from: A */
    private volatile zzb f20007A;
    @VisibleForTesting

    /* renamed from: B */
    protected AtomicInteger f20008B;

    /* renamed from: b */
    private int f20009b;

    /* renamed from: c */
    private long f20010c;

    /* renamed from: d */
    private long f20011d;

    /* renamed from: e */
    private int f20012e;

    /* renamed from: f */
    private long f20013f;
    @VisibleForTesting

    /* renamed from: g */
    private zzh f20014g;

    /* renamed from: h */
    private final Context f20015h;

    /* renamed from: i */
    private final Looper f20016i;

    /* renamed from: j */
    private final GmsClientSupervisor f20017j;

    /* renamed from: k */
    private final GoogleApiAvailabilityLight f20018k;

    /* renamed from: l */
    final Handler f20019l;

    /* renamed from: m */
    private final Object f20020m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public final Object f20021n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IGmsServiceBroker f20022o;
    @VisibleForTesting

    /* renamed from: p */
    protected ConnectionProgressReportCallbacks f20023p;

    /* renamed from: q */
    private T f20024q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public final ArrayList<zzc<?>> f20025r;

    /* renamed from: s */
    private zze f20026s;

    /* renamed from: t */
    private int f20027t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public final BaseConnectionCallbacks f20028u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public final BaseOnConnectionFailedListener f20029v;

    /* renamed from: w */
    private final int f20030w;

    /* renamed from: x */
    private final String f20031x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ConnectionResult f20032y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public boolean f20033z;

    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        void onConnected(Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult connectionResult);
    }

    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        /* renamed from: a */
        void mo27483a(ConnectionResult connectionResult);
    }

    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        /* renamed from: a */
        public void mo27483a(ConnectionResult connectionResult) {
            if (connectionResult.mo27281f()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.mo27717f());
                return;
            }
            if (BaseGmsClient.this.f20029v != null) {
                BaseGmsClient.this.f20029v.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        /* renamed from: a */
        void mo27462a();
    }

    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$a */
    private abstract class C8697a extends zzc<Boolean> {

        /* renamed from: d */
        private final int f20035d;

        /* renamed from: e */
        private final Bundle f20036e;

        protected C8697a(int i, Bundle bundle) {
            super(Boolean.valueOf(true));
            this.f20035d = i;
            this.f20036e = bundle;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo27739a(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public abstract boolean mo27742e();

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public final void mo27741c() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final /* synthetic */ void mo27740a(Object obj) {
            PendingIntent pendingIntent = null;
            if (((Boolean) obj) == null) {
                BaseGmsClient.this.m21732b(1, null);
                return;
            }
            int i = this.f20035d;
            if (i != 0) {
                if (i != 10) {
                    BaseGmsClient.this.m21732b(1, null);
                    Bundle bundle = this.f20036e;
                    if (bundle != null) {
                        pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                    }
                    mo27739a(new ConnectionResult(this.f20035d, pendingIntent));
                } else {
                    BaseGmsClient.this.m21732b(1, null);
                    throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", new Object[]{getClass().getSimpleName(), BaseGmsClient.this.mo27246h(), BaseGmsClient.this.mo27243g()}));
                }
            } else if (!mo27742e()) {
                BaseGmsClient.this.m21732b(1, null);
                mo27739a(new ConnectionResult(8, null));
            }
        }
    }

    /* renamed from: com.google.android.gms.common.internal.BaseGmsClient$b */
    final class C8698b extends com.google.android.gms.internal.common.zze {
        public C8698b(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.f20008B.get() != message.arg1) {
                if (m21766b(message)) {
                    m21765a(message);
                }
                return;
            }
            int i = message.what;
            if ((i == 1 || i == 7 || ((i == 4 && !BaseGmsClient.this.mo27710c()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                m21765a(message);
                return;
            }
            int i2 = message.what;
            PendingIntent pendingIntent = null;
            if (i2 == 4) {
                BaseGmsClient.this.f20032y = new ConnectionResult(message.arg2);
                if (!BaseGmsClient.this.m21741l() || BaseGmsClient.this.f20033z) {
                    if (BaseGmsClient.this.f20032y != null) {
                        connectionResult2 = BaseGmsClient.this.f20032y;
                    } else {
                        connectionResult2 = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.f20023p.mo27483a(connectionResult2);
                    BaseGmsClient.this.mo27707a(connectionResult2);
                    return;
                }
                BaseGmsClient.this.m21732b(3, null);
            } else if (i2 == 5) {
                if (BaseGmsClient.this.f20032y != null) {
                    connectionResult = BaseGmsClient.this.f20032y;
                } else {
                    connectionResult = new ConnectionResult(8);
                }
                BaseGmsClient.this.f20023p.mo27483a(connectionResult);
                BaseGmsClient.this.mo27707a(connectionResult);
            } else if (i2 == 3) {
                Object obj = message.obj;
                if (obj instanceof PendingIntent) {
                    pendingIntent = (PendingIntent) obj;
                }
                ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                BaseGmsClient.this.f20023p.mo27483a(connectionResult3);
                BaseGmsClient.this.mo27707a(connectionResult3);
            } else if (i2 == 6) {
                BaseGmsClient.this.m21732b(5, null);
                if (BaseGmsClient.this.f20028u != null) {
                    BaseGmsClient.this.f20028u.onConnectionSuspended(message.arg2);
                }
                BaseGmsClient.this.mo27702a(message.arg2);
                BaseGmsClient.this.m21729a(5, 1, null);
            } else if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                m21765a(message);
            } else if (m21766b(message)) {
                ((zzc) message.obj).mo27746d();
            } else {
                int i3 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i3);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }

        /* renamed from: a */
        private static void m21765a(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.mo27741c();
            zzc.mo27745b();
        }

        /* renamed from: b */
        private static boolean m21766b(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }
    }

    protected abstract class zzc<TListener> {

        /* renamed from: a */
        private TListener f20039a;

        /* renamed from: b */
        private boolean f20040b = false;

        public zzc(TListener tlistener) {
            this.f20039a = tlistener;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract void mo27740a(TListener tlistener);

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public abstract void mo27741c();

        /* renamed from: d */
        public final void mo27746d() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f20039a;
                if (this.f20040b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    mo27740a(tlistener);
                } catch (RuntimeException e) {
                    mo27741c();
                    throw e;
                }
            } else {
                mo27741c();
            }
            synchronized (this) {
                this.f20040b = true;
            }
            mo27745b();
        }

        /* renamed from: b */
        public final void mo27745b() {
            mo27744a();
            synchronized (BaseGmsClient.this.f20025r) {
                BaseGmsClient.this.f20025r.remove(this);
            }
        }

        /* renamed from: a */
        public final void mo27744a() {
            synchronized (this) {
                this.f20039a = null;
            }
        }
    }

    @VisibleForTesting
    public static final class zzd extends zza {

        /* renamed from: b */
        private BaseGmsClient f20042b;

        /* renamed from: c */
        private final int f20043c;

        public zzd(BaseGmsClient baseGmsClient, int i) {
            this.f20042b = baseGmsClient;
            this.f20043c = i;
        }

        /* renamed from: b */
        public final void mo27749b(int i, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        /* renamed from: a */
        public final void mo27747a(int i, IBinder iBinder, Bundle bundle) {
            Preconditions.m21858a(this.f20042b, (Object) "onPostInitComplete can be called only once per call to getRemoteService");
            this.f20042b.mo27704a(i, iBinder, bundle, this.f20043c);
            this.f20042b = null;
        }

        /* renamed from: a */
        public final void mo27748a(int i, IBinder iBinder, zzb zzb) {
            Preconditions.m21858a(this.f20042b, (Object) "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.m21857a(zzb);
            this.f20042b.m21728a(zzb);
            mo27747a(i, iBinder, zzb.f20173a);
        }
    }

    @VisibleForTesting
    public final class zze implements ServiceConnection {

        /* renamed from: a */
        private final int f20044a;

        public zze(int i) {
            this.f20044a = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.this.m21731b(16);
                return;
            }
            synchronized (BaseGmsClient.this.f20021n) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    iGmsServiceBroker = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                        iGmsServiceBroker = new C8699a(iBinder);
                    } else {
                        iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                    }
                }
                baseGmsClient.f20022o = iGmsServiceBroker;
            }
            BaseGmsClient.this.mo27703a(0, (Bundle) null, this.f20044a);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.f20021n) {
                BaseGmsClient.this.f20022o = null;
            }
            Handler handler = BaseGmsClient.this.f20019l;
            handler.sendMessage(handler.obtainMessage(6, this.f20044a, 1));
        }
    }

    protected final class zzf extends C8697a {

        /* renamed from: g */
        private final IBinder f20046g;

        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f20046g = iBinder;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo27739a(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.f20029v != null) {
                BaseGmsClient.this.f20029v.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.mo27707a(connectionResult);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public final boolean mo27742e() {
            String str = "GmsClient";
            try {
                String interfaceDescriptor = this.f20046g.getInterfaceDescriptor();
                if (!BaseGmsClient.this.mo27243g().equals(interfaceDescriptor)) {
                    String g = BaseGmsClient.this.mo27243g();
                    StringBuilder sb = new StringBuilder(String.valueOf(g).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(g);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e(str, sb.toString());
                    return false;
                }
                IInterface a = BaseGmsClient.this.mo27242a(this.f20046g);
                if (a == null || (!BaseGmsClient.this.m21729a(2, 4, a) && !BaseGmsClient.this.m21729a(3, 4, a))) {
                    return false;
                }
                BaseGmsClient.this.f20032y = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.f20028u != null) {
                    BaseGmsClient.this.f20028u.onConnected(connectionHint);
                }
                return true;
            } catch (RemoteException e) {
                Log.w(str, "service probably died");
                return false;
            }
        }
    }

    protected final class zzg extends C8697a {
        public zzg(int i, Bundle bundle) {
            super(i, null);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public final void mo27739a(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.mo27710c() || !BaseGmsClient.this.m21741l()) {
                BaseGmsClient.this.f20023p.mo27483a(connectionResult);
                BaseGmsClient.this.mo27707a(connectionResult);
                return;
            }
            BaseGmsClient.this.m21731b(16);
        }

        /* access modifiers changed from: protected */
        /* renamed from: e */
        public final boolean mo27742e() {
            BaseGmsClient.this.f20023p.mo27483a(ConnectionResult.f19510a);
            return true;
        }
    }

    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        GmsClientSupervisor a = GmsClientSupervisor.m21825a(context);
        GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
        Preconditions.m21857a(baseConnectionCallbacks);
        BaseConnectionCallbacks baseConnectionCallbacks2 = baseConnectionCallbacks;
        Preconditions.m21857a(baseOnConnectionFailedListener);
        this(context, looper, a, instance, i, baseConnectionCallbacks2, baseOnConnectionFailedListener, str);
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public abstract T mo27242a(IBinder iBinder);

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: g */
    public abstract String mo27243g();

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: h */
    public abstract String mo27246h();

    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.f20020m = new Object();
        this.f20021n = new Object();
        this.f20025r = new ArrayList<>();
        this.f20027t = 1;
        this.f20032y = null;
        this.f20033z = false;
        this.f20007A = null;
        this.f20008B = new AtomicInteger(0);
        Preconditions.m21858a(context, (Object) "Context must not be null");
        this.f20015h = context;
        Preconditions.m21858a(looper, (Object) "Looper must not be null");
        this.f20016i = looper;
        Preconditions.m21858a(gmsClientSupervisor, (Object) "Supervisor must not be null");
        this.f20017j = gmsClientSupervisor;
        Preconditions.m21858a(googleApiAvailabilityLight, (Object) "API availability must not be null");
        this.f20018k = googleApiAvailabilityLight;
        this.f20019l = new C8698b(looper);
        this.f20030w = i;
        this.f20028u = baseConnectionCallbacks;
        this.f20029v = baseOnConnectionFailedListener;
        this.f20031x = str;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: i */
    public String mo27728i() {
        return "com.google.android.gms";
    }

    /* renamed from: j */
    private final String mo27780j() {
        String str = this.f20031x;
        return str == null ? this.f20015h.getClass().getName() : str;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: e */
    public String mo27716e() {
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21728a(zzb zzb) {
        this.f20007A = zzb;
    }

    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzb zzb = this.f20007A;
        if (zzb == null) {
            return null;
        }
        return zzb.f20174b;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public void mo27706a(T t) {
        this.f20011d = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public void mo27702a(int i) {
        this.f20009b = i;
        this.f20010c = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public void mo27707a(ConnectionResult connectionResult) {
        this.f20012e = connectionResult.mo27275a();
        this.f20013f = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21732b(int i, T t) {
        zzh zzh;
        Preconditions.m21863a((i == 4) == (t != null));
        synchronized (this.f20020m) {
            this.f20027t = i;
            this.f20024q = t;
            mo27705a(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (!(this.f20026s == null || this.f20014g == null)) {
                        String c = this.f20014g.mo27866c();
                        String a = this.f20014g.mo27864a();
                        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 70 + String.valueOf(a).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(c);
                        sb.append(" on ");
                        sb.append(a);
                        Log.e("GmsClient", sb.toString());
                        this.f20017j.mo27790a(this.f20014g.mo27866c(), this.f20014g.mo27864a(), this.f20014g.mo27865b(), this.f20026s, mo27780j());
                        this.f20008B.incrementAndGet();
                    }
                    this.f20026s = new zze(this.f20008B.get());
                    if (this.f20027t != 3 || mo27716e() == null) {
                        zzh = new zzh(mo27728i(), mo27246h(), false, Opcodes.LOR);
                    } else {
                        zzh = new zzh(getContext().getPackageName(), mo27716e(), true, Opcodes.LOR);
                    }
                    this.f20014g = zzh;
                    if (!this.f20017j.mo27791a(new zza(this.f20014g.mo27866c(), this.f20014g.mo27864a(), this.f20014g.mo27865b()), this.f20026s, mo27780j())) {
                        String c2 = this.f20014g.mo27866c();
                        String a2 = this.f20014g.mo27864a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(c2).length() + 34 + String.valueOf(a2).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(c2);
                        sb2.append(" on ");
                        sb2.append(a2);
                        Log.e("GmsClient", sb2.toString());
                        mo27703a(16, (Bundle) null, this.f20008B.get());
                    }
                } else if (i == 4) {
                    mo27706a(t);
                }
            } else if (this.f20026s != null) {
                this.f20017j.mo27790a(this.f20014g.mo27866c(), this.f20014g.mo27864a(), this.f20014g.mo27865b(), this.f20026s, mo27780j());
                this.f20026s = null;
            }
        }
    }

    /* access modifiers changed from: 0000 */
    @KeepForSdk
    /* renamed from: a */
    public void mo27705a(int i, T t) {
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m21729a(int i, int i2, T t) {
        synchronized (this.f20020m) {
            if (this.f20027t != i) {
                return false;
            }
            m21732b(i2, t);
            return true;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int a = this.f20018k.mo27294a(this.f20015h, getMinApkVersion());
        if (a != 0) {
            m21732b(1, null);
            mo27708a((ConnectionProgressReportCallbacks) new LegacyClientCallbackAdapter(), a, (PendingIntent) null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    @KeepForSdk
    public void connect(ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        Preconditions.m21858a(connectionProgressReportCallbacks, (Object) "Connection progress callbacks cannot be null.");
        this.f20023p = connectionProgressReportCallbacks;
        m21732b(2, null);
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.f20020m) {
            z = this.f20027t == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.f20020m) {
            if (this.f20027t != 2) {
                if (this.f20027t != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    /* renamed from: k */
    private final boolean mo27247k() {
        boolean z;
        synchronized (this.f20020m) {
            z = this.f20027t == 3;
        }
        return z;
    }

    @KeepForSdk
    public void disconnect() {
        this.f20008B.incrementAndGet();
        synchronized (this.f20025r) {
            int size = this.f20025r.size();
            for (int i = 0; i < size; i++) {
                ((zzc) this.f20025r.get(i)).mo27744a();
            }
            this.f20025r.clear();
        }
        synchronized (this.f20021n) {
            this.f20022o = null;
        }
        m21732b(1, null);
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.f20019l;
        handler.sendMessage(handler.obtainMessage(6, this.f20008B.get(), i));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21731b(int i) {
        int i2;
        if (mo27247k()) {
            i2 = 5;
            this.f20033z = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.f20019l;
        handler.sendMessage(handler.obtainMessage(i2, this.f20008B.get(), 16));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @VisibleForTesting
    /* renamed from: a */
    public void mo27708a(ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, PendingIntent pendingIntent) {
        Preconditions.m21858a(connectionProgressReportCallbacks, (Object) "Connection progress callbacks cannot be null.");
        this.f20023p = connectionProgressReportCallbacks;
        Handler handler = this.f20019l;
        handler.sendMessage(handler.obtainMessage(3, this.f20008B.get(), i, pendingIntent));
    }

    @KeepForSdk
    public final Context getContext() {
        return this.f20015h;
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.f20016i;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return f20006a;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: d */
    public Bundle mo27713d() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: a */
    public void mo27704a(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.f20019l;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo27703a(int i, Bundle bundle, int i2) {
        Handler handler = this.f20019l;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: b */
    public final void mo27709b() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.f20020m) {
            if (this.f20027t != 5) {
                mo27709b();
                Preconditions.m21868b(this.f20024q != null, "Client is connected but service is null");
                t = this.f20024q;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle d = mo27713d();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.f20030w);
        getServiceRequest.f20081d = this.f20015h.getPackageName();
        getServiceRequest.f20084g = d;
        if (set != null) {
            getServiceRequest.f20083f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.f20085h = getAccount() != null ? getAccount() : new Account(DEFAULT_ACCOUNT, "com.google");
            if (iAccountAccessor != null) {
                getServiceRequest.f20082e = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.f20085h = getAccount();
        }
        getServiceRequest.f20086i = f20006a;
        getServiceRequest.f20087j = getApiFeatures();
        try {
            synchronized (this.f20021n) {
                if (this.f20022o != null) {
                    this.f20022o.mo27804a(new zzd(this, this.f20008B.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            mo27704a(8, (IBinder) null, (Bundle) null, this.f20008B.get());
        }
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: c */
    public boolean mo27710c() {
        return false;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void onUserSignOut(SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.mo27462a();
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    /* renamed from: f */
    public Set<Scope> mo27717f() {
        return Collections.EMPTY_SET;
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.f20020m) {
            i = this.f20027t;
            t = this.f20024q;
        }
        synchronized (this.f20021n) {
            iGmsServiceBroker = this.f20022o;
        }
        printWriter.append(str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append(mo27243g()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f20011d > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.f20011d;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.f20010c > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.f20009b;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 != 2) {
                printWriter.append(String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f20010c;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.f20013f > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.m21125a(this.f20012e));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f20013f;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.f20021n) {
            if (this.f20022o == null) {
                return null;
            }
            IBinder asBinder = this.f20022o.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public final boolean m21741l() {
        if (this.f20033z || TextUtils.isEmpty(mo27243g()) || TextUtils.isEmpty(mo27716e())) {
            return false;
        }
        try {
            Class.forName(mo27243g());
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        if (isConnected()) {
            zzh zzh = this.f20014g;
            if (zzh != null) {
                return zzh.mo27864a();
            }
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.f19526a;
    }
}
