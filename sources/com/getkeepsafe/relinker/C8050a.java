package com.getkeepsafe.relinker;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.getkeepsafe.relinker.C8065b.C8066a;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: com.getkeepsafe.relinker.a */
/* compiled from: ApkLibraryInstaller */
public class C8050a implements C8066a {
    /* renamed from: a */
    public void mo24878a(Context context, String[] abis, String mappedLibraryName, File destination, C8072e instance) {
        int i;
        String[] strArr = abis;
        String str = mappedLibraryName;
        File file = destination;
        C8072e eVar = instance;
        ZipFile zipFile = null;
        try {
            ApplicationInfo appInfo = context.getApplicationInfo();
            int tries = 0;
            while (true) {
                int tries2 = tries + 1;
                i = 5;
                if (tries >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(appInfo.sourceDir), 1);
                    break;
                } catch (IOException e) {
                    tries = tries2;
                }
            }
            if (zipFile == null) {
                eVar.mo24905a("FATAL! Couldn't find application APK!");
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                    }
                }
                return;
            }
            int tries3 = 0;
            while (true) {
                int tries4 = tries3 + 1;
                if (tries3 < i) {
                    int length = strArr.length;
                    ZipEntry libraryEntry = null;
                    String jniNameInApk = null;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            break;
                        }
                        String abi = strArr[i2];
                        StringBuilder sb = new StringBuilder();
                        sb.append("lib");
                        sb.append(File.separatorChar);
                        sb.append(abi);
                        sb.append(File.separatorChar);
                        sb.append(str);
                        jniNameInApk = sb.toString();
                        libraryEntry = zipFile.getEntry(jniNameInApk);
                        if (libraryEntry != null) {
                            break;
                        }
                        i2++;
                    }
                    if (jniNameInApk != null) {
                        eVar.mo24906a("Looking for %s in APK...", jniNameInApk);
                    }
                    if (libraryEntry != null) {
                        eVar.mo24906a("Found %s! Extracting...", jniNameInApk);
                        try {
                            if (destination.exists() || destination.createNewFile()) {
                                InputStream inputStream = zipFile.getInputStream(libraryEntry);
                                FileOutputStream fileOut = new FileOutputStream(file);
                                long written = m18147a(inputStream, fileOut);
                                fileOut.getFD().sync();
                                if (written != destination.length()) {
                                    m18148a(inputStream);
                                    m18148a(fileOut);
                                    tries3 = tries4;
                                    i = 5;
                                } else {
                                    m18148a(inputStream);
                                    m18148a(fileOut);
                                    file.setReadable(true, false);
                                    file.setExecutable(true, false);
                                    file.setWritable(true);
                                    if (zipFile != null) {
                                        try {
                                            zipFile.close();
                                        } catch (IOException e3) {
                                        }
                                    }
                                    return;
                                }
                            } else {
                                tries3 = tries4;
                                i = 5;
                            }
                        } catch (IOException e4) {
                        }
                    } else if (jniNameInApk != null) {
                        throw new MissingLibraryException(jniNameInApk);
                    } else {
                        throw new MissingLibraryException(str);
                    }
                } else {
                    eVar.mo24905a("FATAL! Couldn't extract the library from the APK!");
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException e5) {
                        }
                    }
                    return;
                }
            }
        } catch (FileNotFoundException e6) {
            m18148a(null);
            m18148a(null);
        } catch (IOException e7) {
            m18148a(null);
            m18148a(null);
        } catch (Throwable th) {
            ZipFile zipFile2 = zipFile;
            Throwable th2 = th;
            if (zipFile2 != null) {
                try {
                    zipFile2.close();
                } catch (IOException e8) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: a */
    private long m18147a(InputStream in, OutputStream out) throws IOException {
        long copied = 0;
        byte[] buf = new byte[Opcodes.ACC_SYNTHETIC];
        while (true) {
            int read = in.read(buf);
            if (read == -1) {
                out.flush();
                return copied;
            }
            out.write(buf, 0, read);
            copied += (long) read;
        }
    }

    /* renamed from: a */
    private void m18148a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }
}
