package bolts;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

public class AggregateException extends Exception {

    /* renamed from: a */
    private List<Throwable> f4195a;

    public void printStackTrace(PrintStream err) {
        super.printStackTrace(err);
        int currentIndex = -1;
        for (Throwable throwable : this.f4195a) {
            String str = "\n";
            err.append(str);
            err.append("  Inner throwable #");
            currentIndex++;
            err.append(Integer.toString(currentIndex));
            err.append(": ");
            throwable.printStackTrace(err);
            err.append(str);
        }
    }

    public void printStackTrace(PrintWriter err) {
        super.printStackTrace(err);
        int currentIndex = -1;
        for (Throwable throwable : this.f4195a) {
            String str = "\n";
            err.append(str);
            err.append("  Inner throwable #");
            currentIndex++;
            err.append(Integer.toString(currentIndex));
            err.append(": ");
            throwable.printStackTrace(err);
            err.append(str);
        }
    }
}
