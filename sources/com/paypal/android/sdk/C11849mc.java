package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.paypal.android.sdk.mc */
public class C11849mc {

    /* renamed from: a */
    private static final List f37276a = Arrays.asList(new String[]{"android.permission.ACCESS_NETWORK_STATE", "android.permission.INTERNET"});

    /* renamed from: b */
    private final Context f37277b;

    static {
        C11849mc.class.getSimpleName();
    }

    public C11849mc(Context context) {
        this.f37277b = context;
    }

    /* renamed from: a */
    public final void mo38822a() {
        try {
            HashSet hashSet = new HashSet(f37276a);
            String[] strArr = this.f37277b.getPackageManager().getPackageInfo(this.f37277b.getPackageName(), Opcodes.ACC_SYNTHETIC).requestedPermissions;
            if (strArr != null) {
                for (String remove : strArr) {
                    hashSet.remove(remove);
                }
            }
            if (!hashSet.isEmpty()) {
                StringBuilder sb = new StringBuilder("Missing required permissions in manifest:");
                sb.append(hashSet);
                throw new RuntimeException(sb.toString());
            }
        } catch (NameNotFoundException e) {
            StringBuilder sb2 = new StringBuilder("Exception loading manifest");
            sb2.append(e.getMessage());
            throw new RuntimeException(sb2.toString());
        }
    }
}
