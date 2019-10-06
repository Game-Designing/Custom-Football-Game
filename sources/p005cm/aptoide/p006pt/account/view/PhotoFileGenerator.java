package p005cm.aptoide.p006pt.account.view;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.p000v4.content.FileProvider;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.Callable;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p026rx.Single;

/* renamed from: cm.aptoide.pt.account.view.PhotoFileGenerator */
public class PhotoFileGenerator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
    private final Context context;
    private final String fileProviderAuthority;
    private final File storageDirectory;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8004672235627805281L, "cm/aptoide/pt/account/view/PhotoFileGenerator", 11);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[9] = true;
        $jacocoInit[10] = true;
    }

    public PhotoFileGenerator(Context context2, File storageDirectory2, String fileProviderAuthority2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.storageDirectory = storageDirectory2;
        this.fileProviderAuthority = fileProviderAuthority2;
        $jacocoInit[0] = true;
    }

    public Single<String> generateNewImageFileUriAsString() {
        boolean[] $jacocoInit = $jacocoInit();
        Single<String> b = Single.m742b((Callable<? extends T>) new C1498ha<Object>(this));
        $jacocoInit[1] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ String mo9768a() throws Exception {
        boolean[] $jacocoInit = $jacocoInit();
        String timeStamp = DATE_FORMATTER.format(new Date());
        $jacocoInit[2] = true;
        String imageFileName = String.format("aptoide_image_%s", new Object[]{timeStamp});
        String str = ".jpg";
        if (VERSION.SDK_INT >= 21) {
            Context context2 = this.context;
            String str2 = this.fileProviderAuthority;
            File file = this.storageDirectory;
            $jacocoInit[3] = true;
            File createTempFile = File.createTempFile(imageFileName, str, file);
            $jacocoInit[4] = true;
            Uri a = FileProvider.m2499a(context2, str2, createTempFile);
            $jacocoInit[5] = true;
            String uri = a.toString();
            $jacocoInit[6] = true;
            return uri;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.storageDirectory);
        sb.append(File.separator);
        sb.append(imageFileName);
        sb.append(str);
        Uri fromFile = Uri.fromFile(new File(sb.toString()));
        $jacocoInit[7] = true;
        String uri2 = fromFile.toString();
        $jacocoInit[8] = true;
        return uri2;
    }
}
