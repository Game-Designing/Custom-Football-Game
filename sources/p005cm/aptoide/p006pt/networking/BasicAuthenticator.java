package p005cm.aptoide.p006pt.networking;

import java.io.IOException;
import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.networking.BasicAuthenticator */
public class BasicAuthenticator implements Authenticator {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String password;
    private final String username;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(5633562283705435347L, "cm/aptoide/pt/networking/BasicAuthenticator", 5);
        $jacocoData = probes;
        return probes;
    }

    public BasicAuthenticator(String username2, String password2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.username = username2;
        this.password = password2;
        $jacocoInit[0] = true;
    }

    public Request authenticate(Route route, Response response) throws IOException {
        boolean[] $jacocoInit = $jacocoInit();
        Request request = response.request();
        $jacocoInit[1] = true;
        Builder newBuilder = request.newBuilder();
        String str = this.username;
        String str2 = this.password;
        $jacocoInit[2] = true;
        Builder header = newBuilder.header("Authorization", Credentials.basic(str, str2));
        $jacocoInit[3] = true;
        Request build = header.build();
        $jacocoInit[4] = true;
        return build;
    }
}
