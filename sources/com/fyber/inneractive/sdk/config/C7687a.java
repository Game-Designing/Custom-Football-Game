package com.fyber.inneractive.sdk.config;

import android.content.Context;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.fyber.inneractive.sdk.config.a */
public final class C7687a implements C7707a {

    /* renamed from: a */
    Context f15265a;

    /* renamed from: b */
    public C7689b f15266b;

    /* renamed from: com.fyber.inneractive.sdk.config.a$a */
    private static class C7688a {

        /* renamed from: a */
        public static C7687a f15267a = new C7687a(0);
    }

    /* renamed from: com.fyber.inneractive.sdk.config.a$b */
    private static class C7689b implements Serializable {
        static final long serialVersionUID = 2;

        /* renamed from: a */
        public String f15268a;

        /* renamed from: b */
        public boolean f15269b;

        private C7689b() {
        }

        /* synthetic */ C7689b(byte b) {
            this();
        }
    }

    /* synthetic */ C7687a(byte b) {
        this();
    }

    private C7687a() {
    }

    /* renamed from: a */
    public final synchronized void mo24181a(String str, boolean z) {
        this.f15266b.f15268a = str;
        this.f15266b.f15269b = z;
        mo24182b();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final synchronized void mo24180a() {
        String str;
        ObjectInputStream objectInputStream = null;
        try {
            ObjectInputStream objectInputStream2 = new ObjectInputStream(this.f15265a.openFileInput("IAAndroidConfig.data"));
            try {
                this.f15266b = (C7689b) objectInputStream2.readObject();
                IAlog.m18021b("Android configuration. config cache read succesfully");
            } catch (Exception e) {
                objectInputStream = objectInputStream2;
                try {
                    IAlog.m18021b("Android configuration. could not read config from cache");
                    try {
                        objectInputStream.close();
                    } catch (Exception e2) {
                        str = "Android configuration. Failed closing cache file";
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        objectInputStream.close();
                    } catch (Exception e3) {
                        IAlog.m18021b("Android configuration. Failed closing cache file");
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                objectInputStream = objectInputStream2;
                objectInputStream.close();
                throw th;
            }
            try {
                objectInputStream2.close();
            } catch (Exception e4) {
                str = "Android configuration. Failed closing cache file";
                IAlog.m18021b(str);
            }
        } catch (Exception e5) {
            IAlog.m18021b("Android configuration. could not read config from cache");
            objectInputStream.close();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final synchronized void mo24182b() {
        String str;
        if (this.f15266b != null) {
            ObjectOutputStream objectOutputStream = null;
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(this.f15265a.openFileOutput("IAAndroidConfig.data", 0));
                try {
                    objectOutputStream2.writeObject(this.f15266b);
                } catch (Exception e) {
                    objectOutputStream = objectOutputStream2;
                    try {
                        IAlog.m18021b("Android configuration. failed writing android configuration to cache");
                        try {
                            objectOutputStream.close();
                        } catch (Exception e2) {
                            str = "Android configuration. failed closing android configuration cache file";
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            objectOutputStream.close();
                        } catch (Exception e3) {
                            IAlog.m18021b("Android configuration. failed closing android configuration cache file");
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    objectOutputStream = objectOutputStream2;
                    objectOutputStream.close();
                    throw th;
                }
                try {
                    objectOutputStream2.close();
                } catch (Exception e4) {
                    str = "Android configuration. failed closing android configuration cache file";
                    IAlog.m18021b(str);
                }
            } catch (Exception e5) {
                IAlog.m18021b("Android configuration. failed writing android configuration to cache");
                objectOutputStream.close();
            }
        }
    }
}
