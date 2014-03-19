package com.example.pdsdlab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class PaintView extends View implements android.view.View.OnTouchListener/*, Runnable */ {
	private static final String TAG = "PaintView";
 
	List<Point> points = new ArrayList<Point>();
	Paint paint = new Paint();
 
	public PaintView(Context context) {
		super(context);
		setFocusable(true);
		setFocusableInTouchMode(true);
		this.setOnTouchListener((OnTouchListener) this);
		paint.setColor(Color.RED);
		paint.setAntiAlias(true);
		//new Thread(this).start();  // nu este fezabilă
	}
 
	@SuppressLint("DrawAllocation") @Override
	public void onDraw(Canvas canvas) {
		Random r = new Random();
		canvas.drawColor(r.nextInt());
 
	for (Point point : points) {
		canvas.drawCircle(point.x, point.y, 12, paint);
	  } 
	  //invalidate();  // produce încărcare mare  
	  Log.d(TAG, "OnDraw " + points.size());
	}
 
	public boolean onTouch(View view, MotionEvent event) {
		Point point = new Point();
		point.x = (int) event.getX();
		point.y = (int) event.getY();
		points.add(point);
		invalidate();
		Log.d(TAG, "point: " + point.x + " " + point.y);
	        return true;
	 }
	}
