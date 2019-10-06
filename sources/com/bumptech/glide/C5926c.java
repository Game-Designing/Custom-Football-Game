package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.support.p000v4.app.Fragment;
import android.util.Log;
import com.bumptech.glide.load.C6060b;
import com.bumptech.glide.load.C6229d;
import com.bumptech.glide.load.C6230e;
import com.bumptech.glide.load.C6350l;
import com.bumptech.glide.load.C6351m;
import com.bumptech.glide.load.engine.C6328s;
import com.bumptech.glide.load.engine.p120a.C6245b;
import com.bumptech.glide.load.engine.p120a.C6250e;
import com.bumptech.glide.load.engine.p121b.C6282i;
import com.bumptech.glide.load.engine.p123d.C6304a;
import com.bumptech.glide.load.p109a.C6044e.C6045a;
import com.bumptech.glide.load.p109a.C6055l.C6056a;
import com.bumptech.glide.load.p111b.C6061A;
import com.bumptech.glide.load.p111b.C6062B.C6063a;
import com.bumptech.glide.load.p111b.C6062B.C6064b;
import com.bumptech.glide.load.p111b.C6062B.C6065c;
import com.bumptech.glide.load.p111b.C6066C.C6067a;
import com.bumptech.glide.load.p111b.C6069D.C6070a;
import com.bumptech.glide.load.p111b.C6069D.C6071b;
import com.bumptech.glide.load.p111b.C6069D.C6073d;
import com.bumptech.glide.load.p111b.C6074E.C6075a;
import com.bumptech.glide.load.p111b.C6076a.C6078b;
import com.bumptech.glide.load.p111b.C6076a.C6079c;
import com.bumptech.glide.load.p111b.C6091c.C6092a;
import com.bumptech.glide.load.p111b.C6091c.C6095d;
import com.bumptech.glide.load.p111b.C6097e;
import com.bumptech.glide.load.p111b.C6098f.C6100b;
import com.bumptech.glide.load.p111b.C6101g.C6104c;
import com.bumptech.glide.load.p111b.C6106i.C6108b;
import com.bumptech.glide.load.p111b.C6106i.C6111e;
import com.bumptech.glide.load.p111b.C6114l;
import com.bumptech.glide.load.p111b.C6121q.C6122a;
import com.bumptech.glide.load.p111b.C6130v;
import com.bumptech.glide.load.p111b.C6140z.C6141a;
import com.bumptech.glide.load.p111b.C6140z.C6142b;
import com.bumptech.glide.load.p111b.C6140z.C6143c;
import com.bumptech.glide.load.p111b.C6140z.C6144d;
import com.bumptech.glide.load.p111b.p112a.C6080a.C6081a;
import com.bumptech.glide.load.p111b.p112a.C6082b.C6083a;
import com.bumptech.glide.load.p111b.p112a.C6084c.C6085a;
import com.bumptech.glide.load.p111b.p112a.C6086d.C6087a;
import com.bumptech.glide.load.p111b.p112a.C6088e.C6089a;
import com.bumptech.glide.load.p113c.p114a.C6147a;
import com.bumptech.glide.load.p113c.p114a.C6148b;
import com.bumptech.glide.load.p113c.p114a.C6149c;
import com.bumptech.glide.load.p113c.p114a.C6152f;
import com.bumptech.glide.load.p113c.p114a.C6155i;
import com.bumptech.glide.load.p113c.p114a.C6169l;
import com.bumptech.glide.load.p113c.p114a.C6179t;
import com.bumptech.glide.load.p113c.p114a.C6180u;
import com.bumptech.glide.load.p113c.p114a.C6184w;
import com.bumptech.glide.load.p113c.p114a.C6188z;
import com.bumptech.glide.load.p113c.p115b.C6194a.C6195a;
import com.bumptech.glide.load.p113c.p116c.C6200d;
import com.bumptech.glide.load.p113c.p116c.C6201e;
import com.bumptech.glide.load.p113c.p117d.C6202a;
import com.bumptech.glide.load.p113c.p118e.C6204a;
import com.bumptech.glide.load.p113c.p118e.C6208c;
import com.bumptech.glide.load.p113c.p118e.C6210d;
import com.bumptech.glide.load.p113c.p118e.C6218h;
import com.bumptech.glide.load.p113c.p118e.C6220j;
import com.bumptech.glide.load.p113c.p119f.C6221a;
import com.bumptech.glide.load.p113c.p119f.C6222b;
import com.bumptech.glide.load.p113c.p119f.C6223c;
import com.bumptech.glide.load.p113c.p119f.C6224d;
import com.bumptech.glide.load.p113c.p119f.C6225e;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.p099b.C5920a;
import com.bumptech.glide.p100c.C5931d;
import com.bumptech.glide.p100c.C5942n;
import com.bumptech.glide.p101d.C5952c;
import com.bumptech.glide.p101d.C5954e;
import com.bumptech.glide.p103f.C5991g;
import com.bumptech.glide.p103f.p104a.C5972e;
import com.bumptech.glide.p103f.p104a.C5976i;
import com.bumptech.glide.p107h.C6024i;
import com.bumptech.glide.p107h.C6026k;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.bumptech.glide.c */
/* compiled from: Glide */
public class C5926c implements ComponentCallbacks2 {

    /* renamed from: a */
    private static volatile C5926c f10430a;

    /* renamed from: b */
    private static volatile boolean f10431b;

    /* renamed from: c */
    private final C6328s f10432c;

    /* renamed from: d */
    private final C6250e f10433d;

    /* renamed from: e */
    private final C6282i f10434e;

    /* renamed from: f */
    private final C6304a f10435f;

    /* renamed from: g */
    private final C5956e f10436g;

    /* renamed from: h */
    private final Registry f10437h;

    /* renamed from: i */
    private final C6245b f10438i;

    /* renamed from: j */
    private final C5942n f10439j;

    /* renamed from: k */
    private final C5931d f10440k;

    /* renamed from: l */
    private final List<C6354n> f10441l = new ArrayList();

    /* renamed from: m */
    private C5966f f10442m = C5966f.NORMAL;

    /* renamed from: a */
    public static C5926c m10916a(Context context) {
        if (f10430a == null) {
            synchronized (C5926c.class) {
                if (f10430a == null) {
                    m10921c(context);
                }
            }
        }
        return f10430a;
    }

    /* renamed from: c */
    private static void m10921c(Context context) {
        if (!f10431b) {
            f10431b = true;
            m10923e(context);
            f10431b = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    /* renamed from: e */
    private static void m10923e(Context context) {
        m10918a(context, new C5949d());
    }

    /* renamed from: a */
    private static void m10918a(Context context, C5949d builder) {
        Context applicationContext = context.getApplicationContext();
        C5909a annotationGeneratedModule = m10924i();
        List<GlideModule> manifestModules = Collections.emptyList();
        if (annotationGeneratedModule == null || annotationGeneratedModule.mo18643a()) {
            manifestModules = new C5954e(applicationContext).mo18646a();
        }
        String str = "Glide";
        if (annotationGeneratedModule != null && !annotationGeneratedModule.mo18529b().isEmpty()) {
            Set<Class<?>> excludedModuleClasses = annotationGeneratedModule.mo18529b();
            Iterator<GlideModule> iterator = manifestModules.iterator();
            while (iterator.hasNext()) {
                C5952c current = (C5952c) iterator.next();
                if (excludedModuleClasses.contains(current.getClass())) {
                    if (Log.isLoggable(str, 3)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("AppGlideModule excludes manifest GlideModule: ");
                        sb.append(current);
                        Log.d(str, sb.toString());
                    }
                    iterator.remove();
                }
            }
        }
        if (Log.isLoggable(str, 3)) {
            Iterator it = manifestModules.iterator();
            while (it.hasNext()) {
                C5952c glideModule = (C5952c) it.next();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Discovered GlideModule from manifest: ");
                sb2.append(glideModule.getClass());
                Log.d(str, sb2.toString());
            }
        }
        builder.mo18642a(annotationGeneratedModule != null ? annotationGeneratedModule.mo18530c() : null);
        Iterator it2 = manifestModules.iterator();
        while (it2.hasNext()) {
            ((C5952c) it2.next()).applyOptions(applicationContext, builder);
        }
        if (annotationGeneratedModule != null) {
            annotationGeneratedModule.applyOptions(applicationContext, builder);
        }
        C5926c glide = builder.mo18638a(applicationContext);
        Iterator it3 = manifestModules.iterator();
        while (it3.hasNext()) {
            ((C5952c) it3.next()).registerComponents(applicationContext, glide, glide.f10437h);
        }
        if (annotationGeneratedModule != null) {
            annotationGeneratedModule.registerComponents(applicationContext, glide, glide.f10437h);
        }
        applicationContext.registerComponentCallbacks(glide);
        f10430a = glide;
    }

    /* renamed from: i */
    private static C5909a m10924i() {
        try {
            return (C5909a) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException e) {
            String str = "Glide";
            if (!Log.isLoggable(str, 5)) {
                return null;
            }
            Log.w(str, "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
            return null;
        } catch (InstantiationException e2) {
            m10919a((Exception) e2);
            throw null;
        } catch (IllegalAccessException e3) {
            m10919a((Exception) e3);
            throw null;
        } catch (NoSuchMethodException e4) {
            m10919a((Exception) e4);
            throw null;
        } catch (InvocationTargetException e5) {
            m10919a((Exception) e5);
            throw null;
        }
    }

    /* renamed from: a */
    private static void m10919a(Exception e) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e);
    }

    C5926c(Context context, C6328s engine, C6282i memoryCache, C6250e bitmapPool, C6245b arrayPool, C5942n requestManagerRetriever, C5931d connectivityMonitorFactory, int logLevel, C5991g defaultRequestOptions, Map<Class<?>, C6357o<?, ?>> defaultTransitionOptions) {
        Context context2 = context;
        C6282i iVar = memoryCache;
        C6250e eVar = bitmapPool;
        C6245b bVar = arrayPool;
        this.f10432c = engine;
        this.f10433d = eVar;
        this.f10438i = bVar;
        this.f10434e = iVar;
        this.f10439j = requestManagerRetriever;
        this.f10440k = connectivityMonitorFactory;
        C6060b decodeFormat = (C6060b) defaultRequestOptions.mo18764o().mo19310a(C6169l.f10877a);
        this.f10435f = new C6304a(iVar, eVar, decodeFormat);
        Resources resources = context.getResources();
        this.f10437h = new Registry();
        this.f10437h.mo18513a((C6230e) new C6155i());
        C6169l downsampler = new C6169l(this.f10437h.mo18523a(), resources.getDisplayMetrics(), eVar, bVar);
        C6204a byteBufferGifDecoder = new C6204a(context2, this.f10437h.mo18523a(), eVar, bVar);
        C6350l b = C6188z.m11752b(bitmapPool);
        C6152f byteBufferBitmapDecoder = new C6152f(downsampler);
        C6180u streamBitmapDecoder = new C6180u(downsampler, bVar);
        C6200d resourceDrawableDecoder = new C6200d(context2);
        C6169l lVar = downsampler;
        C6143c resourceLoaderStreamFactory = new C6143c(resources);
        C6060b bVar2 = decodeFormat;
        C6144d resourceLoaderUriFactory = new C6144d(resources);
        C6142b resourceLoaderFileDescriptorFactory = new C6142b(resources);
        C6141a resourceLoaderAssetFileDescriptorFactory = new C6141a(resources);
        C6149c bitmapEncoder = new C6149c(bVar);
        C6221a bitmapBytesTranscoder = new C6221a();
        C6224d gifDrawableBytesTranscoder = new C6224d();
        ContentResolver contentResolver = context.getContentResolver();
        Registry registry = this.f10437h;
        C6141a resourceLoaderAssetFileDescriptorFactory2 = resourceLoaderAssetFileDescriptorFactory;
        registry.mo18514a(ByteBuffer.class, (C6229d<Data>) new C6097e<Data>());
        registry.mo18514a(InputStream.class, (C6229d<Data>) new C6061A<Data>(bVar));
        C6144d resourceLoaderUriFactory2 = resourceLoaderUriFactory;
        String str = "Bitmap";
        registry.mo18519a(str, ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder);
        registry.mo18519a(str, InputStream.class, Bitmap.class, streamBitmapDecoder);
        registry.mo18519a(str, ParcelFileDescriptor.class, Bitmap.class, b);
        C6142b resourceLoaderFileDescriptorFactory2 = resourceLoaderFileDescriptorFactory;
        registry.mo18519a(str, AssetFileDescriptor.class, Bitmap.class, C6188z.m11750a(bitmapPool));
        registry.mo18516a(Bitmap.class, Bitmap.class, (C6130v<Model, Data>) C6067a.m11418a());
        registry.mo18519a(str, Bitmap.class, Bitmap.class, new C6184w());
        registry.mo18515a(Bitmap.class, (C6351m<TResource>) bitmapEncoder);
        C6147a aVar = new C6147a(resources, byteBufferBitmapDecoder);
        C6152f byteBufferBitmapDecoder2 = byteBufferBitmapDecoder;
        String str2 = "BitmapDrawable";
        registry.mo18519a(str2, ByteBuffer.class, BitmapDrawable.class, aVar);
        registry.mo18519a(str2, InputStream.class, BitmapDrawable.class, new C6147a(resources, streamBitmapDecoder));
        registry.mo18519a(str2, ParcelFileDescriptor.class, BitmapDrawable.class, new C6147a(resources, b));
        registry.mo18515a(BitmapDrawable.class, (C6351m<TResource>) new C6148b<TResource>(eVar, bitmapEncoder));
        String str3 = "Gif";
        registry.mo18519a(str3, InputStream.class, C6208c.class, new C6220j(this.f10437h.mo18523a(), byteBufferGifDecoder, bVar));
        registry.mo18519a(str3, ByteBuffer.class, C6208c.class, byteBufferGifDecoder);
        registry.mo18515a(C6208c.class, (C6351m<TResource>) new C6210d<TResource>());
        registry.mo18516a(C5920a.class, C5920a.class, (C6130v<Model, Data>) C6067a.m11418a());
        registry.mo18519a(str, C5920a.class, Bitmap.class, new C6218h(eVar));
        registry.mo18518a(Uri.class, Drawable.class, (C6350l<Data, TResource>) resourceDrawableDecoder);
        registry.mo18518a(Uri.class, Bitmap.class, (C6350l<Data, TResource>) new C6179t<Data,TResource>(resourceDrawableDecoder, eVar));
        registry.mo18512a((C6045a<?>) new C6195a<Object>());
        registry.mo18516a(File.class, ByteBuffer.class, (C6130v<Model, Data>) new C6100b<Model,Data>());
        registry.mo18516a(File.class, InputStream.class, (C6130v<Model, Data>) new C6111e<Model,Data>());
        registry.mo18518a(File.class, File.class, (C6350l<Data, TResource>) new C6202a<Data,TResource>());
        registry.mo18516a(File.class, ParcelFileDescriptor.class, (C6130v<Model, Data>) new C6108b<Model,Data>());
        registry.mo18516a(File.class, File.class, (C6130v<Model, Data>) C6067a.m11418a());
        registry.mo18512a((C6045a<?>) new C6056a<Object>(bVar));
        registry.mo18516a(Integer.TYPE, InputStream.class, (C6130v<Model, Data>) resourceLoaderStreamFactory);
        C6142b resourceLoaderFileDescriptorFactory3 = resourceLoaderFileDescriptorFactory2;
        registry.mo18516a(Integer.TYPE, ParcelFileDescriptor.class, (C6130v<Model, Data>) resourceLoaderFileDescriptorFactory3);
        registry.mo18516a(Integer.class, InputStream.class, (C6130v<Model, Data>) resourceLoaderStreamFactory);
        registry.mo18516a(Integer.class, ParcelFileDescriptor.class, (C6130v<Model, Data>) resourceLoaderFileDescriptorFactory3);
        C6144d resourceLoaderUriFactory3 = resourceLoaderUriFactory2;
        registry.mo18516a(Integer.class, Uri.class, (C6130v<Model, Data>) resourceLoaderUriFactory3);
        C6141a resourceLoaderAssetFileDescriptorFactory3 = resourceLoaderAssetFileDescriptorFactory2;
        registry.mo18516a(Integer.TYPE, AssetFileDescriptor.class, (C6130v<Model, Data>) resourceLoaderAssetFileDescriptorFactory3);
        registry.mo18516a(Integer.class, AssetFileDescriptor.class, (C6130v<Model, Data>) resourceLoaderAssetFileDescriptorFactory3);
        registry.mo18516a(Integer.TYPE, Uri.class, (C6130v<Model, Data>) resourceLoaderUriFactory3);
        C6180u streamBitmapDecoder2 = streamBitmapDecoder;
        registry.mo18516a(String.class, InputStream.class, (C6130v<Model, Data>) new C6104c<Model,Data>());
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6104c<Model,Data>());
        registry.mo18516a(String.class, InputStream.class, (C6130v<Model, Data>) new C6065c<Model,Data>());
        registry.mo18516a(String.class, ParcelFileDescriptor.class, (C6130v<Model, Data>) new C6064b<Model,Data>());
        registry.mo18516a(String.class, AssetFileDescriptor.class, (C6130v<Model, Data>) new C6063a<Model,Data>());
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6083a<Model,Data>());
        C6350l lVar2 = b;
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6079c<Model,Data>(context.getAssets()));
        registry.mo18516a(Uri.class, ParcelFileDescriptor.class, (C6130v<Model, Data>) new C6078b<Model,Data>(context.getAssets()));
        Context context3 = context;
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6085a<Model,Data>(context3));
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6087a<Model,Data>(context3));
        C6144d dVar = resourceLoaderUriFactory3;
        ContentResolver contentResolver2 = contentResolver;
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6073d<Model,Data>(contentResolver2));
        registry.mo18516a(Uri.class, ParcelFileDescriptor.class, (C6130v<Model, Data>) new C6071b<Model,Data>(contentResolver2));
        registry.mo18516a(Uri.class, AssetFileDescriptor.class, (C6130v<Model, Data>) new C6070a<Model,Data>(contentResolver2));
        registry.mo18516a(Uri.class, InputStream.class, (C6130v<Model, Data>) new C6075a<Model,Data>());
        registry.mo18516a(URL.class, InputStream.class, (C6130v<Model, Data>) new C6089a<Model,Data>());
        registry.mo18516a(Uri.class, File.class, (C6130v<Model, Data>) new C6122a<Model,Data>(context3));
        registry.mo18516a(C6114l.class, InputStream.class, (C6130v<Model, Data>) new C6081a<Model,Data>());
        registry.mo18516a(byte[].class, ByteBuffer.class, (C6130v<Model, Data>) new C6092a<Model,Data>());
        registry.mo18516a(byte[].class, InputStream.class, (C6130v<Model, Data>) new C6095d<Model,Data>());
        registry.mo18516a(Uri.class, Uri.class, (C6130v<Model, Data>) C6067a.m11418a());
        registry.mo18516a(Drawable.class, Drawable.class, (C6130v<Model, Data>) C6067a.m11418a());
        registry.mo18518a(Drawable.class, Drawable.class, (C6350l<Data, TResource>) new C6201e<Data,TResource>());
        registry.mo18517a(Bitmap.class, BitmapDrawable.class, (C6225e<TResource, Transcode>) new C6222b<TResource,Transcode>(resources));
        C6221a bitmapBytesTranscoder2 = bitmapBytesTranscoder;
        registry.mo18517a(Bitmap.class, byte[].class, (C6225e<TResource, Transcode>) bitmapBytesTranscoder2);
        C6204a aVar2 = byteBufferGifDecoder;
        ContentResolver contentResolver3 = contentResolver2;
        C6224d gifDrawableBytesTranscoder2 = gifDrawableBytesTranscoder;
        registry.mo18517a(Drawable.class, byte[].class, (C6225e<TResource, Transcode>) new C6223c<TResource,Transcode>(eVar, bitmapBytesTranscoder2, gifDrawableBytesTranscoder2));
        registry.mo18517a(C6208c.class, byte[].class, (C6225e<TResource, Transcode>) gifDrawableBytesTranscoder2);
        C6200d dVar2 = resourceDrawableDecoder;
        C5972e imageViewTargetFactory = new C5972e();
        C6180u uVar = streamBitmapDecoder2;
        C6152f fVar = byteBufferBitmapDecoder2;
        C6221a aVar3 = bitmapBytesTranscoder2;
        C6224d dVar3 = gifDrawableBytesTranscoder2;
        C5956e eVar2 = r1;
        Registry registry2 = this.f10437h;
        C6143c cVar = resourceLoaderStreamFactory;
        Resources resources2 = resources;
        C6142b bVar3 = resourceLoaderFileDescriptorFactory3;
        C5956e eVar3 = new C5956e(context, arrayPool, registry2, imageViewTargetFactory, defaultRequestOptions, defaultTransitionOptions, engine, logLevel);
        this.f10436g = eVar2;
    }

    /* renamed from: c */
    public C6250e mo18581c() {
        return this.f10433d;
    }

    /* renamed from: b */
    public C6245b mo18579b() {
        return this.f10438i;
    }

    /* renamed from: e */
    public Context mo18583e() {
        return this.f10436g.getBaseContext();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public C5931d mo18582d() {
        return this.f10440k;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: f */
    public C5956e mo18584f() {
        return this.f10436g;
    }

    /* renamed from: a */
    public void mo18575a() {
        C6026k.m11283b();
        this.f10434e.mo19191a();
        this.f10433d.mo19149a();
        this.f10438i.mo19128a();
    }

    /* renamed from: a */
    public void mo18576a(int level) {
        C6026k.m11283b();
        this.f10434e.mo19188a(level);
        this.f10433d.mo19150a(level);
        this.f10438i.mo19129a(level);
    }

    /* renamed from: h */
    public C5942n mo18586h() {
        return this.f10439j;
    }

    /* renamed from: d */
    private static C5942n m10922d(Context context) {
        C6024i.m11265a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return m10916a(context).mo18586h();
    }

    /* renamed from: b */
    public static C6354n m10920b(Context context) {
        return m10922d(context).mo18615a(context);
    }

    /* renamed from: a */
    public static C6354n m10917a(Fragment fragment) {
        return m10922d(fragment.getActivity()).mo18616a(fragment);
    }

    /* renamed from: g */
    public Registry mo18585g() {
        return this.f10437h;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public boolean mo18578a(C5976i<?> target) {
        synchronized (this.f10441l) {
            for (C6354n requestManager : this.f10441l) {
                if (requestManager.mo19325b(target)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo18577a(C6354n requestManager) {
        synchronized (this.f10441l) {
            if (!this.f10441l.contains(requestManager)) {
                this.f10441l.add(requestManager);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo18580b(C6354n requestManager) {
        synchronized (this.f10441l) {
            if (this.f10441l.contains(requestManager)) {
                this.f10441l.remove(requestManager);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public void onTrimMemory(int level) {
        mo18576a(level);
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onLowMemory() {
        mo18575a();
    }
}
