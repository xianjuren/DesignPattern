package com.design.designpattern.mvp.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.design.designpattern.R;

import java.util.List;

/**
 * Created by Jone on 17/4/12.
 */
public class StudentNameAdapter extends BaseAdapter {

    List<String> mStringList;


    public void setAdapter(List<String> list) {
        mStringList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (null == mStringList) {
            return 0;
        }
        return mStringList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_name, null);
            mViewHolder = new ViewHolder();
            mViewHolder.mNumber = (TextView) convertView.findViewById(R.id.tv_number);
            mViewHolder.mName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        String name = mStringList.get(position);
        if (!TextUtils.isEmpty(name)) {
            mViewHolder.mNumber.setText(position + "");
            mViewHolder.mName.setText(name);
        }
        return convertView;
    }

    class ViewHolder {
        TextView mNumber;
        TextView mName;
    }
}
