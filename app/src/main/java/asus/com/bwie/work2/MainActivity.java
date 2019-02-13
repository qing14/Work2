package asus.com.bwie.work2;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 圆角
     */
    private Button mYuanjiaoButton;
    /**
     * 圆形
     */
    private Button mYuanxingButton;
    /**
     * 比例1：2
     */
    private Button mBiliButton;
    /**
     * 动画
     */
    private Button mDonghuaButton;
    private SimpleDraweeView mYuanjiao;
    private SimpleDraweeView mYuanxing;
    private SimpleDraweeView mBili;
    private SimpleDraweeView mDonghua;
    /**
     * 获取注解的值
     */
    private Button mHuoqu;
    /**
     * 反射添加集合
     */
    private Button mFanshe;
    Uri uri = Uri.parse("http://www.zhaoapi.cn/images/quarter/ad1.png");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        mYuanjiaoButton = (Button) findViewById(R.id.yuanjiaoButton);
        mYuanjiaoButton.setOnClickListener(this);
        mYuanxingButton = (Button) findViewById(R.id.yuanxingButton);
        mYuanxingButton.setOnClickListener(this);
        mBiliButton = (Button) findViewById(R.id.biliButton);
        mBiliButton.setOnClickListener(this);
        mDonghuaButton = (Button) findViewById(R.id.donghuaButton);
        mDonghuaButton.setOnClickListener(this);
        mYuanjiao = (SimpleDraweeView) findViewById(R.id.yuanjiao);
        mYuanxing = (SimpleDraweeView) findViewById(R.id.yuanxing);
        mBili = (SimpleDraweeView) findViewById(R.id.bili);
        mDonghua = (SimpleDraweeView) findViewById(R.id.donghua);
        mHuoqu = (Button) findViewById(R.id.huoqu);
        mHuoqu.setOnClickListener(this);
        mFanshe = (Button) findViewById(R.id.fanshe);
        mFanshe.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.yuanjiaoButton:
                mYuanjiao.setVisibility(View.VISIBLE);
                mYuanxing.setVisibility(View.GONE);
                mBili.setVisibility(View.GONE);
                mDonghua.setVisibility(View.GONE);
                mYuanjiao.setImageURI(uri);
                break;
            case R.id.yuanxingButton:
                mYuanjiao.setVisibility(View.GONE);
                mYuanxing.setVisibility(View.VISIBLE);
                mBili.setVisibility(View.GONE);
                mDonghua.setVisibility(View.GONE);
                mYuanxing.setImageURI(uri);
                break;
            case R.id.biliButton:
                mYuanjiao.setVisibility(View.GONE);
                mYuanxing.setVisibility(View.GONE);
                mBili.setVisibility(View.VISIBLE);
                mDonghua.setVisibility(View.GONE);
                mBili.setImageURI(uri);
                break;
            case R.id.donghuaButton:
                mYuanjiao.setVisibility(View.GONE);
                mYuanxing.setVisibility(View.GONE);
                mBili.setVisibility(View.GONE);
                mDonghua.setVisibility(View.VISIBLE);
                Uri parse = Uri.parse("http://www.zhaoapi.cn/images/girl.gif");
                ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
                    @Override
                    public void onFinalImageSet(
                            String id,
                            @Nullable ImageInfo imageInfo,
                            @Nullable Animatable anim) {
                        if (anim != null) {
                            // 其他控制逻辑
                            anim.start();
                        }
                    }
                };

                DraweeController controller1 = Fresco.newDraweeControllerBuilder()
                        .setUri(parse)
                        .setControllerListener(controllerListener)
                        .build();
                mDonghua.setController(controller1);

                break;
            case R.id.huoqu:
                Method[] methods = DrawweeViewAnnotation.class.getMethods();
                Field[] fields = DrawweeViewAnnotation.class.getDeclaredFields();
                for (Field field : fields) {
                    MyAnno myAnno = field.getAnnotation(MyAnno.class);
                    if (myAnno != null) {
                        Toast.makeText(MainActivity.this, "sayHello：  " + myAnno.name(), Toast.LENGTH_SHORT).show();
                    }
                }
                for (Method method : methods) {
                    MyAnno annotation = method.getAnnotation(MyAnno.class);
                    if (annotation != null) {
                        Toast.makeText(MainActivity.this, "sayHello：  " + annotation.name(), Toast.LENGTH_SHORT).show();
                    }
                }


                break;
            case R.id.fanshe:




                break;
        }
    }
}
