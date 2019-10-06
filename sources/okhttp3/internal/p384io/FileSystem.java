package okhttp3.internal.p384io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p362h.C14179A;
import p362h.C14180B;
import p362h.C14205t;

/* renamed from: okhttp3.internal.io.FileSystem */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() {
        public C14180B source(File file) throws FileNotFoundException {
            return C14205t.m45687c(file);
        }

        public C14179A sink(File file) throws FileNotFoundException {
            try {
                return C14205t.m45685b(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return C14205t.m45685b(file);
            }
        }

        public C14179A appendingSink(File file) throws FileNotFoundException {
            try {
                return C14205t.m45676a(file);
            } catch (FileNotFoundException e) {
                file.getParentFile().mkdirs();
                return C14205t.m45676a(file);
            }
        }

        public void delete(File file) throws IOException {
            if (!file.delete() && file.exists()) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to delete ");
                sb.append(file);
                throw new IOException(sb.toString());
            }
        }

        public boolean exists(File file) {
            return file.exists();
        }

        public long size(File file) {
            return file.length();
        }

        public void rename(File from, File to) throws IOException {
            delete(to);
            if (!from.renameTo(to)) {
                StringBuilder sb = new StringBuilder();
                sb.append("failed to rename ");
                sb.append(from);
                sb.append(" to ");
                sb.append(to);
                throw new IOException(sb.toString());
            }
        }

        public void deleteContents(File directory) throws IOException {
            File[] files = directory.listFiles();
            if (files != null) {
                int length = files.length;
                int i = 0;
                while (i < length) {
                    File file = files[i];
                    if (file.isDirectory()) {
                        deleteContents(file);
                    }
                    if (file.delete()) {
                        i++;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("failed to delete ");
                        sb.append(file);
                        throw new IOException(sb.toString());
                    }
                }
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("not a readable directory: ");
            sb2.append(directory);
            throw new IOException(sb2.toString());
        }
    };

    C14179A appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    C14179A sink(File file) throws FileNotFoundException;

    long size(File file);

    C14180B source(File file) throws FileNotFoundException;
}
