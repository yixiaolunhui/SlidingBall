package com.dalong.slidingball;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.dalong.francyconverflow.FancyCoverFlow;
import com.dalong.francyconverflow.FancyCoverFlowAdapter;

import java.util.List;


public class MyFancyCoverFlowAdapter extends FancyCoverFlowAdapter {
    private Context mContext;

    public List<Item> list;

    public MyFancyCoverFlowAdapter(Context context, List<Item> list) {
        mContext = context;
        this.list = list;
    }

    @Override
    public View getCoverFlowItem(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_fancycoverflow, null);
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
            int width = wm.getDefaultDisplay().getWidth();
            convertView.setLayoutParams(new FancyCoverFlow.LayoutParams(width / 3, FancyCoverFlow.LayoutParams.WRAP_CONTENT));
            holder = new ViewHolder();
            holder.product_name = (TextView) convertView.findViewById(R.id.name);
            holder.product_btn = (Button) convertView.findViewById(R.id.item_btn);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Item item = getItem(position);
        holder.product_name.setText(item.getName());
        holder.product_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    public void setSelected(int position) {
        position = position % list.size();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                if (i == position) {
                    list.get(i).setSelected(true);
                } else {
                    list.get(i).setSelected(false);
                }
            }
        }
        notifyDataSetChanged();

    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public Item getItem(int i) {
        return list.get(i % list.size());
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    static class ViewHolder {
        TextView product_name;
        Button product_btn;
    }
}
