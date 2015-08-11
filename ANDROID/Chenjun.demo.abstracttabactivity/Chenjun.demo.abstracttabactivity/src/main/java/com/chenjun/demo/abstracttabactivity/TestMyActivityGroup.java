package com.chenjun.demo.abstracttabactivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;

public class TestMyActivityGroup extends AbstractMyActivityGroup{
    //���ص�Activity�����֣�LocalActivityManager����ͨ����Щ���������Ҷ�Ӧ��Activity�ġ�
    private static final String CONTENT_ACTIVITY_NAME_0 = "contentActivity0";
    private static final String CONTENT_ACTIVITY_NAME_1 = "contentActivity1";
    private static final String CONTENT_ACTIVITY_NAME_2 = "contentActivity2";
    private static final String CONTENT_ACTIVITY_NAME_3 = "contentActivity3";
    private static final String CONTENT_ACTIVITY_NAME_4 = "contentActivity4";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        ((RadioButton)findViewById(R.id.radio_button0)).setChecked(true);
    }

    /**
     * �ҵ��Զ���id�ļ���Activity��View
     */
    @Override
    protected ViewGroup getContainer() {
        return (ViewGroup) findViewById(R.id.container);
    }

    /**
     * ��ʼ����ť
     */
    @Override
    protected void initRadioBtns() {
        initRadioBtn(R.id.radio_button0);
        initRadioBtn(R.id.radio_button1);
        initRadioBtn(R.id.radio_button2);
        initRadioBtn(R.id.radio_button3);
        initRadioBtn(R.id.radio_button4);
    }

    /**
     * ������ť�����ʱ�����巢���ı仯
     */
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            switch (buttonView.getId()) {

                case R.id.radio_button0:
                    setContainerView(CONTENT_ACTIVITY_NAME_0, ContentActivity0.class);
                    break;

                case R.id.radio_button1:
                    setContainerView(CONTENT_ACTIVITY_NAME_1, ContentActivity1.class);
                    break;

                case R.id.radio_button2:
                    setContainerView(CONTENT_ACTIVITY_NAME_2, ContentActivity2.class);
                    break;

                case R.id.radio_button3:
                    setContainerView(CONTENT_ACTIVITY_NAME_3, ContentActivity3.class);
                    break;

                case R.id.radio_button4:
                    setContainerView(CONTENT_ACTIVITY_NAME_4, ContentActivity4.class);
                    break;

                default:
                    break;
            }
        }
    }

}