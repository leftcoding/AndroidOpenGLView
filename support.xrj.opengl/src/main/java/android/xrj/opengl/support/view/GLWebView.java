package android.xrj.opengl.support.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.xrj.opengl.support.BaseGLRenderer;
import android.xrj.opengl.support.GLRenderable;

public class GLWebView extends WebView implements GLRenderable {

    private BaseGLRenderer mBaseGLRenderer;

    // default constructors

    public GLWebView(Context context) {
        super(context);
    }

    public GLWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GLWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    // draw magic
    @Override
    public void draw(Canvas canvas) {
        //returns canvas attached to gl texture to draw on
        Canvas glAttachedCanvas = mBaseGLRenderer.onDrawViewBegin();
        if (glAttachedCanvas != null) {
            //translate canvas to reflect view scrolling
            float xScale = glAttachedCanvas.getWidth() / (float) canvas.getWidth();
            glAttachedCanvas.scale(xScale, xScale);
            glAttachedCanvas.translate(-getScrollX(), -getScrollY());
            //draw the view to provided canvas
            super.draw(glAttachedCanvas);
        }
        // notify the canvas is updated
        mBaseGLRenderer.onDrawViewEnd();
    }

    public void setViewToGLRenderer(BaseGLRenderer viewTOGLRenderer) {
        mBaseGLRenderer = viewTOGLRenderer;
    }
}
