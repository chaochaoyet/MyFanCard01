package com.chao.huadong;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import cn.w.song.widget.scroll.SlidePageView;
import cn.w.song.widget.scroll.SlidePageView.OnPageViewChangedListener;

/**
 * SlidePageView֧�ָ���ʾ��Ԫ�����ж��ƣ���������֧�ֵȿ����ʾ��Ԫ��ƣ�Ҳ֧�ֲ������ȵ���ʾ��Ԫ��ơ�
 * SlidePageView֧���ƶ�������˦�����ֻ�����ʽ��
 * �˽����鿴http://blog.csdn.net/swadair/article/details/7529159
 * ע��ȷ������Ŀ������w.song.android.widget-1.0.3.jar�����
 * w.song.android.widget-1.0.3.jar���ص�ַhttp://download.csdn.net/detail/swadair/4271503
 * @author w.song
 * @version 1.0.1
 * @date 2012-5-2
 */
public class SlidePageViewDemoActivity extends Activity {
	private String tag = "SlidePageViewDemoActivity";
    private ViewPager

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.slidepageviewdemo_ui);//��΢����ҳ
//		setContentView(R.layout.slidepageviewdemo_ui_b);//�Զ���ȿ���ʾ��Ԫdemo
//		setContentView(R.layout.slidepageviewdemo_ui_c);//�Զ��岻��������ʾ��Ԫdemo
		SlidePageView spv = (SlidePageView) findViewById(R.id.slidepageviewtest_ui_SlidePageView_test);
		//spv.setCurrPagePosition(0);//���õ�ǰҳλ��
		spv.setOnPageViewChangedListener(new OnPageViewChangedListener() {

			@Override
			public void OnPageViewChanged(int currPagePosition,
					View currPageView) {
				Log.v(tag, "currPagePosition=" + currPagePosition);
			}
		});
	}
}
