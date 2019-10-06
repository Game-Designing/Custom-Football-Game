package p005cm.aptoide.accountmanager;

import p026rx.C0117M;
import p026rx.p027b.C0131o;

/* renamed from: cm.aptoide.accountmanager.CredentialsValidator */
public class CredentialsValidator {
    public C0117M validate(AptoideCredentials credentials, boolean validatePassword) {
        return C0117M.m586a((C0131o<? extends C0117M>) new C1337t<Object>(this, credentials, validatePassword));
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9331a(AptoideCredentials credentials, boolean validatePassword) {
        int x = validateFields(credentials, validatePassword);
        if (x != -1) {
            return C0117M.m591b((Throwable) new AccountValidationException(x));
        }
        return C0117M.m590b();
    }

    /* access modifiers changed from: protected */
    public int validateFields(AptoideCredentials credentials, boolean validatePassword) {
        if (isEmpty(credentials.getEmail()) && isEmpty(credentials.getPassword())) {
            return 3;
        }
        if (isEmpty(credentials.getPassword())) {
            return 2;
        }
        if (isEmpty(credentials.getEmail())) {
            return 1;
        }
        if (!validatePassword || (credentials.getPassword().length() >= 8 && has1number1letter(credentials.getPassword()))) {
            return -1;
        }
        return 4;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r10.contains("*") == false) goto L_0x005b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean has1number1letter(java.lang.String r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            char[] r2 = r10.toCharArray()
            int r3 = r2.length
            r4 = 0
            r5 = r1
            r1 = r0
            r0 = 0
        L_0x000b:
            r6 = 1
            if (r0 >= r3) goto L_0x002c
            char r7 = r2[r0]
            if (r1 != 0) goto L_0x001d
            boolean r8 = java.lang.Character.isLetter(r7)
            if (r8 == 0) goto L_0x001d
            if (r5 == 0) goto L_0x001b
            return r6
        L_0x001b:
            r1 = 1
            goto L_0x0029
        L_0x001d:
            if (r5 != 0) goto L_0x0029
            boolean r8 = java.lang.Character.isDigit(r7)
            if (r8 == 0) goto L_0x0029
            if (r1 == 0) goto L_0x0028
            return r6
        L_0x0028:
            r5 = 1
        L_0x0029:
            int r0 = r0 + 1
            goto L_0x000b
        L_0x002c:
            java.lang.String r0 = "!"
            boolean r0 = r10.contains(r0)
            if (r0 != 0) goto L_0x005a
            java.lang.String r0 = "@"
            boolean r0 = r10.contains(r0)
            if (r0 != 0) goto L_0x005a
            java.lang.String r0 = "#"
            boolean r2 = r10.contains(r0)
            if (r2 != 0) goto L_0x005a
            java.lang.String r2 = "$"
            boolean r2 = r10.contains(r2)
            if (r2 != 0) goto L_0x005a
            boolean r0 = r10.contains(r0)
            if (r0 != 0) goto L_0x005a
            java.lang.String r0 = "*"
            boolean r0 = r10.contains(r0)
            if (r0 == 0) goto L_0x005b
        L_0x005a:
            r5 = 1
        L_0x005b:
            if (r5 == 0) goto L_0x0060
            if (r1 == 0) goto L_0x0060
            r4 = 1
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.accountmanager.CredentialsValidator.has1number1letter(java.lang.String):boolean");
    }

    private boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}
