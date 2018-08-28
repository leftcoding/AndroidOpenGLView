package android.xrj.opengl;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.xrj.opengl.support.BaseGLRenderer;
import android.xrj.opengl.support.FooRenderer;
import android.xrj.opengl.support.view.GLWebView;
import android.xrj.opengl.util.DisplayUtil;
import android.xrj.opengl.util.StatusUtil;

/**
 * Create by LingYan on 2018-08-27
 */

public class GLLinearLayoutActivity extends Activity {
    private static final String TAG = "GLLinearLayoutActivity";

    private FrameLayout root;
    private GLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl_line);
        root = findViewById(R.id.root);
        glSurfaceView = findViewById(R.id.gl_surface_view);

        GLWebView webView = new GLWebView(this);

        int width = DisplayUtil.getWidth(this);
        int height = DisplayUtil.getHeight(this) - StatusUtil.getStatusHeight(this);

        final BaseGLRenderer baseGlRenderer = new FooRenderer(this, width, height);

        glSurfaceView.setEGLContextClientVersion(2);
        glSurfaceView.setRenderer(baseGlRenderer);
        webView.setViewToGLRenderer(baseGlRenderer);

        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("https://www.baidu.com");

        root.addView(webView);
    }
}
