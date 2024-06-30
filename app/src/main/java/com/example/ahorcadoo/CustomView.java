package com.example.ahorcadoo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomView extends View {

    private int parts = 0;
    private Paint paint;

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(0xFFFF0000);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(10f);
        Log.d("CustomView", "Paint initialized with color: " + paint.getColor());

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawMan(canvas);
    }

    private void drawMan(Canvas canvas) {
        Log.d("CustomView", "Drawing parts: " + parts);
        float centerX = getWidth() / 2;
        float centerY = getHeight() / 4;
        float headRadius = 50f;
        float bodyLength = 150f;

        if (parts > 0) { // Draw head
            canvas.drawCircle(centerX, centerY, headRadius, paint);
            Log.d("CustomView", "Drawing head");
        }
        if (parts > 1) { // Draw body
            canvas.drawLine(centerX, centerY + headRadius, centerX, centerY + headRadius + bodyLength, paint);
            Log.d("CustomView", "Drawing body");
        }
        if (parts > 2) { // Draw left arm
            canvas.drawLine(centerX, centerY + headRadius + bodyLength / 3, centerX - headRadius, centerY + headRadius + bodyLength / 3, paint);
            Log.d("CustomView", "Drawing left arm");
        }
        if (parts > 3) { // Draw right arm
            canvas.drawLine(centerX, centerY + headRadius + bodyLength / 3, centerX + headRadius, centerY + headRadius + bodyLength / 3, paint);
            Log.d("CustomView", "Drawing right arm");
        }
        if (parts > 4) { // Draw left leg
            canvas.drawLine(centerX, centerY + headRadius + bodyLength, centerX - headRadius / 2, centerY + headRadius + bodyLength + bodyLength / 2, paint);
            Log.d("CustomView", "Drawing left leg");
        }
        if (parts > 5) { // Draw right leg
            canvas.drawLine(centerX, centerY + headRadius + bodyLength, centerX + headRadius / 2, centerY + headRadius + bodyLength + bodyLength / 2, paint);
            Log.d("CustomView", "Drawing right leg");
        }
    }
    public void addPart() {
        if (parts < 6) {
            parts++;
            invalidate();
        }
    }
    public void resetParts() {
        parts = 0;
        invalidate();
    }
}