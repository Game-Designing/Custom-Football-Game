package p019d.p273h.p276c;

import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;
import p019d.p273h.p276c.p281e.C12826q;

/* renamed from: d.h.c.ea */
/* compiled from: ProgUtils */
public class C12830ea {

    /* renamed from: a */
    private static final Object f39530a = new Object();

    /* renamed from: a */
    public static C12775b m41759a(C12826q config) {
        synchronized (f39530a) {
            String name = config.mo41556m() ? config.mo41552i() : config.mo41551h();
            try {
                C12775b providerAdapter = m41760a(name, config.mo41552i());
                if (providerAdapter == null) {
                    return null;
                }
                providerAdapter.setLogListener(C12802d.m41613c());
                return providerAdapter;
            } catch (Throwable e) {
                StringBuilder sb = new StringBuilder();
                sb.append("loadAdapter(");
                sb.append(name);
                sb.append(") ");
                sb.append(e.getMessage());
                m41761a(sb.toString());
                return null;
            }
        }
    }

    /* renamed from: a */
    private static C12775b m41760a(String name, String reflectionName) {
        try {
            C12775b providerAdapter = C12747I.m41186g().mo41216b(name);
            if (providerAdapter != null) {
                return providerAdapter;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("com.ironsource.adapters.");
            sb.append(reflectionName.toLowerCase());
            sb.append(".");
            sb.append(reflectionName);
            sb.append("Adapter");
            Class<?> mAdapterClass = Class.forName(sb.toString());
            return (C12775b) mAdapterClass.getMethod("startAdapter", new Class[]{String.class}).invoke(mAdapterClass, new Object[]{name});
        } catch (Exception ex) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getLoadedAdapterOrFetchByReflection ");
            sb2.append(ex.getMessage());
            m41761a(sb2.toString());
            return null;
        }
    }

    /* renamed from: a */
    private static void m41761a(String text) {
        C12802d.m41613c().mo41427b(C12801a.INTERNAL, text, 3);
    }
}
