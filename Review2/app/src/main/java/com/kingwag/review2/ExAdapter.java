package com.kingwag.review2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kingwag on 2016/11/20.
 */

public class ExAdapter extends BaseExpandableListAdapter {
    Context context;
    List<MyGroup> groupList;
    LayoutInflater inflater;

    public ExAdapter(Context context, List<MyGroup> groupList) {
        this.context = context;
        this.groupList = groupList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        MyGroup group = groupList.get(i);

        return group.getChildList().size();
    }

    @Override
    public Object getGroup(int i) {
        return i;
    }

    @Override
    public Object getChild(int i, int i1) {
        return groupList.get(i).getChildList().get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,View convertView,  ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_group, parent, false);
        TextView tvGroup = (TextView) convertView.findViewById(R.id.tv_group);
        ImageView ivindicatior = (ImageView) convertView.findViewById(R.id.iv_indicator);
        if (isExpanded){
            ivindicatior.setImageResource(R.drawable.service_arrow_up);

        }else {
            ivindicatior.setImageResource(R.drawable.service_arrow_down);
        }
        MyGroup group = groupList.get(groupPosition);
        tvGroup.setText(group.getName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,  boolean isLastChild,  View convertView, ViewGroup parent) {

        convertView = inflater.inflate(R.layout.item_child, parent, false);
        TextView tvChild = (TextView) convertView.findViewById(R.id.tv_child);
        MyChild myChild = groupList.get(groupPosition).getChildList().get(childPosition);
        tvChild.setText(myChild.getName());
        return convertView;

    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
