package com.dalong.slidingball;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.dalong.francyconverflow.FancyCoverFlow;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FancyCoverFlow mfancyCoverFlow;
    private MyFancyCoverFlowAdapter mMyFancyCoverFlowAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        List<Item> mFancyCoverFlows=new ArrayList<>();
        for(int i=0;i<365;i++){
            Item item=new Item();
            item.setName((i+1)+"天");
            item.setSelected(false);
            mFancyCoverFlows.add(item);
        }
        mfancyCoverFlow = (FancyCoverFlow) findViewById(R.id.fancyCoverFlow);
        mMyFancyCoverFlowAdapter = new MyFancyCoverFlowAdapter(this, mFancyCoverFlows);
        mfancyCoverFlow.setAdapter(mMyFancyCoverFlowAdapter);
        mMyFancyCoverFlowAdapter.notifyDataSetChanged();
        mfancyCoverFlow.setUnselectedAlpha(0.5f);//通明度
        mfancyCoverFlow.setUnselectedSaturation(0.5f);//设置选中的饱和度
        mfancyCoverFlow.setUnselectedScale(0.3f);//设置选中的规模
        mfancyCoverFlow.setSpacing(0);//设置间距
        mfancyCoverFlow.setMaxRotation(0);//设置最大旋转
        mfancyCoverFlow.setScaleDownGravity(0.5f);
        mfancyCoverFlow.setActionDistance(FancyCoverFlow.ACTION_DISTANCE_AUTO);
        int num = Integer.MAX_VALUE / 2 % mFancyCoverFlows.size();
        int selectPosition = Integer.MAX_VALUE / 2 - num;
        mfancyCoverFlow.setSelection(selectPosition);
        mfancyCoverFlow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Item homeFancyCoverFlow = (Item) mfancyCoverFlow.getSelectedItem();
                if (homeFancyCoverFlow != null) {
                    Toast.makeText(MainActivity.this,homeFancyCoverFlow.getName(),Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


}
