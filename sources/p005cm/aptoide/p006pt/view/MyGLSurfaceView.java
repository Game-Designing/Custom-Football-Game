package p005cm.aptoide.p006pt.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.AptoideApplication;

/* renamed from: cm.aptoide.pt.view.MyGLSurfaceView */
public class MyGLSurfaceView extends GLSurfaceView {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private MyGLRenderer myGLRenderer;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-978076470821221977L, "cm/aptoide/pt/view/MyGLSurfaceView", 10);
        $jacocoData = probes;
        return probes;
    }

    public MyGLSurfaceView(Context context, AttributeSet attrs) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context, attrs);
        $jacocoInit[0] = true;
        setTransparent(context);
        $jacocoInit[1] = true;
    }

    public MyGLSurfaceView(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        super(context);
        $jacocoInit[2] = true;
        setTransparent(context);
        $jacocoInit[3] = true;
    }

    private void setTransparent(Context context) {
        boolean[] $jacocoInit = $jacocoInit();
        setEGLContextClientVersion(2);
        $jacocoInit[4] = true;
        this.myGLRenderer = new MyGLRenderer(context, ((AptoideApplication) context.getApplicationContext()).getQManager());
        $jacocoInit[5] = true;
        setRenderer(this.myGLRenderer);
        $jacocoInit[6] = true;
        setZOrderOnTop(true);
        $jacocoInit[7] = true;
        SurfaceHolder surfaceHolder = getHolder();
        $jacocoInit[8] = true;
        surfaceHolder.setFormat(-2);
        $jacocoInit[9] = true;
    }
}
