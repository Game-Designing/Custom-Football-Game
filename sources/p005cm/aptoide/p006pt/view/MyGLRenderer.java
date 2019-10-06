package p005cm.aptoide.p006pt.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;
import p005cm.aptoide.p006pt.utils.p015q.QManager;

/* renamed from: cm.aptoide.pt.view.MyGLRenderer */
public class MyGLRenderer implements Renderer {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final QManager qManager;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-1092674285950634250L, "cm/aptoide/pt/view/MyGLRenderer", 8);
        $jacocoData = probes;
        return probes;
    }

    public MyGLRenderer(Context context2, QManager qManager2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        this.qManager = qManager2;
        $jacocoInit[0] = true;
    }

    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        boolean[] $jacocoInit = $jacocoInit();
        this.qManager.setSupportedOpenGLExtensions(GLES20.glGetString(7939));
        $jacocoInit[1] = true;
        Context context2 = this.context;
        ActivityProvider activityProvider = AptoideApplication.getActivityProvider();
        $jacocoInit[2] = true;
        Intent intent = new Intent(context2, activityProvider.getMainActivityFragmentClass());
        $jacocoInit[3] = true;
        ((Activity) this.context).finish();
        $jacocoInit[4] = true;
        this.context.startActivity(intent);
        $jacocoInit[5] = true;
    }

    public void onSurfaceChanged(GL10 gl, int width, int height) {
        $jacocoInit()[6] = true;
    }

    public void onDrawFrame(GL10 gl) {
        $jacocoInit()[7] = true;
    }
}
