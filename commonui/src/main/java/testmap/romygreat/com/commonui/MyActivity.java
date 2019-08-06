package testmap.romygreat.com.commonui;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

public class MyActivity extends Activity {
    public static final String TAG="MyActivity";
    TextView giftView;
    Button shoppingCart;
    int cartHeightP2Y =0;
    int cartWidthP2X =0;
    int giftViewHeightP0Y =0;
    int giftViewWidthP0X =0;
    int zhidianP1X;
    int zhidianP1Y;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        giftView=findViewById(R.id.giftView);
        shoppingCart=findViewById(R.id.shoppingCart);

    }

    public void onClick(View view) {
        Log.d("TAG", "onClick: ");
        cartHeightP2Y =shoppingCart.getTop()+(shoppingCart.getBottom()-shoppingCart.getTop())/2;
        cartWidthP2X =shoppingCart.getLeft()+(shoppingCart.getRight()-shoppingCart.getLeft())/2;
        giftViewHeightP0Y =400;
        giftViewWidthP0X = 900;


        ValueAnimator valueAnimator=new ValueAnimator();
        valueAnimator.setDuration(3000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.setObjectValues(new PointF(100,100));
        valueAnimator.setEvaluator(new TypeEvaluator<PointF>() {
            //计算的时间，确实如此
            // fraction = t / duration
            @Override
            public PointF evaluate(float fraction, PointF startValue, PointF endValue) {
                zhidianP1Y = 300;
                zhidianP1X = 200;
                PointF pointF=new PointF(zhidianP1X,zhidianP1Y);
                startValue=new PointF(giftViewWidthP0X,giftViewHeightP0Y);
                endValue=new PointF(cartWidthP2X,cartHeightP2Y);
                return getBezierPoint(startValue,endValue,pointF,fraction);

            }
        });
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                PointF point = (PointF) animation.getAnimatedValue();
                giftView.setX(point.x);
                giftView.setY(point.y);
            }
        });

        valueAnimator.start();



    }

    private void pingyi() {
        final TranslateAnimation translateAnimation=new TranslateAnimation(0,300,0,600);
        translateAnimation.setDuration(3000);
        giftView.setAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "onAnimationEnd: ");

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                Log.d(TAG, "onAnimationRepeat: ");
            }
        });
        translateAnimation.setFillEnabled(true);
        translateAnimation.setFillAfter(true);
        giftView.startAnimation(translateAnimation);
    }
    public PointF getBezierPoint(PointF start, PointF end, PointF control, float t) {

        PointF mPointF = new PointF(200,300);
        Log.d(TAG, "getBezierPoint: "+mPointF.x+"startX="+start.x+"end="+end.x);
        mPointF.x = (1 - t) * (1 - t) * start.x + 2 * t * (1 - t) * control.x + t * t * end.x;
        mPointF.y = (1 - t) * (1 - t) * start.y + 2 * t * (1 - t) * control.y + t * t * end.y;
        return mPointF;
    }

}
