package okhttp3.internal.cache;

import java.io.IOException;
import p362h.C14179A;
import p362h.C14191g;
import p362h.C14196k;

class FaultHidingSink extends C14196k {
    private boolean hasErrors;

    FaultHidingSink(C14179A delegate) {
        super(delegate);
    }

    public void write(C14191g source, long byteCount) throws IOException {
        if (this.hasErrors) {
            source.skip(byteCount);
            return;
        }
        try {
            super.write(source, byteCount);
        } catch (IOException e) {
            this.hasErrors = true;
            onException(e);
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onException(IOException e) {
    }
}
