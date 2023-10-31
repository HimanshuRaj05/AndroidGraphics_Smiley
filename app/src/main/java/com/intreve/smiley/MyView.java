package com.intreve.smiley;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int radius=200;
        Paint paint=new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);


        canvas.save();
        canvas.drawCircle(350, 400, radius, paint);
        Paint paintBlk = new Paint();
        paint.setColor(Color.BLACK);

        drawTriangle(canvas,paintBlk, 270 , 320, 100);


        drawTriangle(canvas,paintBlk, 430 , 320, 100);

        canvas.drawRect(230, 450, 460, 490, paintBlk);

        canvas.restore();
    }

    public void drawTriangle(Canvas canvas, Paint paint, int x, int y, int width) {
        int halfWidth = width / 2;

        Path path = new Path();
        path.moveTo(x, y - halfWidth); // Top
        path.lineTo(x - halfWidth, y + halfWidth); // Bottom left
        path.lineTo(x + halfWidth, y + halfWidth); // Bottom right
        path.lineTo(x, y - halfWidth); // Back to Top
        path.close();

        canvas.drawPath(path, paint);
    }
}
