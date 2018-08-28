package android.xrj.opengl.support.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.xrj.opengl.support.BaseGLRenderer;
import android.xrj.opengl.support.GLRenderable;

public class GLLinearLayout extends LinearLayout implements GLRenderable {
    private BaseGLRenderer mBaseGLRenderer;

    // default constructors

    public GLLinearLayout(Context context) {
        super(context);
    }

    public GLLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public GLLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    // drawing magic
    @Override
    public void draw(Canvas canvas) {
//        super.draw(canvas);
        Canvas glAttachedCanvas = mBaseGLRenderer.onDrawViewBegin();
        if (glAttachedCanvas != null) {
            //prescale canvas to make sure content fits
            float xScale = glAttachedCanvas.getWidth() / (float) canvas.getWidth();
            glAttachedCanvas.scale(xScale, xScale);
            //draw the view to provided canvas
            super.draw(glAttachedCanvas);
        }
        // notify the canvas is updated
        mBaseGLRenderer.onDrawViewEnd();

        invalidate();
    }

    public void setViewToGLRenderer(BaseGLRenderer baseGLRenderer) {
        mBaseGLRenderer = baseGLRenderer;
    }
}
