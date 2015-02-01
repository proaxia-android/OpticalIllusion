package kz.opticalillusion;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


    public class MainActivity extends Activity {
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main);
//	}
//
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

	// 操作UI
	Button mBtnStart;
	Button mBtnStop;

	// アニメーションさせるビュー
	LinearLayout mLayoutAnim;
	ImageView    mImageAnim ;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        mBtnStart = (Button) findViewById( R.id.buttonStart );
        mBtnStop = (Button) findViewById( R.id.buttonStop );
        mLayoutAnim = (LinearLayout) findViewById( R.id.layout_anim_field );
        mImageAnim  = (ImageView   ) findViewById( R.id.image_anim_image  );

        mBtnStart.setOnClickListener(mClickListener);
        mBtnStop.setOnClickListener(mClickListener);
    }

    // OnClickListener
    View.OnClickListener mClickListener = new View.OnClickListener() {
		public void onClick(View v) {
			if( v == mBtnStart )
			{
				animationStart(mImageAnim);
			}
			else if( v == mBtnStop  )
			{
				animationStop(mImageAnim);
			}
		}
	};

	// アニメーションスタート
	void animationStart(View v){

		// 画面をスリープ状態にさせない
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		resourceAnimationStart(MainActivity.this, v);
	}

	// アニメーションストップ
	void animationStop(View v){

		v.clearAnimation();

		// 画面をスリープ状態にさせない状態を解除
		getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}

	// XML リソースからのアニメーション読み込み
	void resourceAnimationStart(Context con, View v){
		// リソースからのアニメーション読み込み
		Animation anim = AnimationUtils.loadAnimation( con, R.anim.animation );

		// アニメーション開始
		v.startAnimation(anim);

	}

}
