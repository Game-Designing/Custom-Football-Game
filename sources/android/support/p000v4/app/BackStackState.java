package android.support.p000v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
/* compiled from: BackStackRecord */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C0471g();

    /* renamed from: a */
    final int[] f1393a;

    /* renamed from: b */
    final int f1394b;

    /* renamed from: c */
    final int f1395c;

    /* renamed from: d */
    final String f1396d;

    /* renamed from: e */
    final int f1397e;

    /* renamed from: f */
    final int f1398f;

    /* renamed from: g */
    final CharSequence f1399g;

    /* renamed from: h */
    final int f1400h;

    /* renamed from: i */
    final CharSequence f1401i;

    /* renamed from: j */
    final ArrayList<String> f1402j;

    /* renamed from: k */
    final ArrayList<String> f1403k;

    /* renamed from: l */
    final boolean f1404l;

    public BackStackState(C0467f bse) {
        int numOps = bse.f1576b.size();
        this.f1393a = new int[(numOps * 6)];
        if (bse.f1583i) {
            int pos = 0;
            for (int opNum = 0; opNum < numOps; opNum++) {
                C0468a op = (C0468a) bse.f1576b.get(opNum);
                int[] iArr = this.f1393a;
                int pos2 = pos + 1;
                iArr[pos] = op.f1596a;
                int pos3 = pos2 + 1;
                Fragment fragment = op.f1597b;
                iArr[pos2] = fragment != null ? fragment.mIndex : -1;
                int[] iArr2 = this.f1393a;
                int pos4 = pos3 + 1;
                iArr2[pos3] = op.f1598c;
                int pos5 = pos4 + 1;
                iArr2[pos4] = op.f1599d;
                int pos6 = pos5 + 1;
                iArr2[pos5] = op.f1600e;
                pos = pos6 + 1;
                iArr2[pos6] = op.f1601f;
            }
            this.f1394b = bse.f1581g;
            this.f1395c = bse.f1582h;
            this.f1396d = bse.f1585k;
            this.f1397e = bse.f1587m;
            this.f1398f = bse.f1588n;
            this.f1399g = bse.f1589o;
            this.f1400h = bse.f1590p;
            this.f1401i = bse.f1591q;
            this.f1402j = bse.f1592r;
            this.f1403k = bse.f1593s;
            this.f1404l = bse.f1594t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel in) {
        this.f1393a = in.createIntArray();
        this.f1394b = in.readInt();
        this.f1395c = in.readInt();
        this.f1396d = in.readString();
        this.f1397e = in.readInt();
        this.f1398f = in.readInt();
        this.f1399g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1400h = in.readInt();
        this.f1401i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        this.f1402j = in.createStringArrayList();
        this.f1403k = in.createStringArrayList();
        this.f1404l = in.readInt() != 0;
    }

    /* renamed from: a */
    public C0467f mo5009a(C0409A fm) {
        C0467f bse = new C0467f(fm);
        int pos = 0;
        int num = 0;
        while (pos < this.f1393a.length) {
            C0468a op = new C0468a();
            int pos2 = pos + 1;
            op.f1596a = this.f1393a[pos];
            if (C0409A.f1337a) {
                StringBuilder sb = new StringBuilder();
                sb.append("Instantiate ");
                sb.append(bse);
                sb.append(" op #");
                sb.append(num);
                sb.append(" base fragment #");
                sb.append(this.f1393a[pos2]);
                Log.v("FragmentManager", sb.toString());
            }
            int pos3 = pos2 + 1;
            int findex = this.f1393a[pos2];
            if (findex >= 0) {
                op.f1597b = (Fragment) fm.f1357k.get(findex);
            } else {
                op.f1597b = null;
            }
            int[] iArr = this.f1393a;
            int pos4 = pos3 + 1;
            op.f1598c = iArr[pos3];
            int pos5 = pos4 + 1;
            op.f1599d = iArr[pos4];
            int pos6 = pos5 + 1;
            op.f1600e = iArr[pos5];
            int pos7 = pos6 + 1;
            op.f1601f = iArr[pos6];
            bse.f1577c = op.f1598c;
            bse.f1578d = op.f1599d;
            bse.f1579e = op.f1600e;
            bse.f1580f = op.f1601f;
            bse.mo5150a(op);
            num++;
            pos = pos7;
        }
        bse.f1581g = this.f1394b;
        bse.f1582h = this.f1395c;
        bse.f1585k = this.f1396d;
        bse.f1587m = this.f1397e;
        bse.f1583i = true;
        bse.f1588n = this.f1398f;
        bse.f1589o = this.f1399g;
        bse.f1590p = this.f1400h;
        bse.f1591q = this.f1401i;
        bse.f1592r = this.f1402j;
        bse.f1593s = this.f1403k;
        bse.f1594t = this.f1404l;
        bse.mo5148a(1);
        return bse;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(this.f1393a);
        dest.writeInt(this.f1394b);
        dest.writeInt(this.f1395c);
        dest.writeString(this.f1396d);
        dest.writeInt(this.f1397e);
        dest.writeInt(this.f1398f);
        TextUtils.writeToParcel(this.f1399g, dest, 0);
        dest.writeInt(this.f1400h);
        TextUtils.writeToParcel(this.f1401i, dest, 0);
        dest.writeStringList(this.f1402j);
        dest.writeStringList(this.f1403k);
        dest.writeInt(this.f1404l ? 1 : 0);
    }
}
