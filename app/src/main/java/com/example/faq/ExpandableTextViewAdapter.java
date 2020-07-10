package com.example.faq;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableTextViewAdapter extends BaseExpandableListAdapter {

    Context context;

    String[] faq_ques = {
            "What should I do when I am not able to receive my OTP?",
            "Why I cannot scan documents properly?",
            "Who can upload files in any particular Criminal Record?"
    };

    String[][] faq_ans = {
            {"Check your registered mobile number to that particular ID. Check your internet connection. For further queries kindly contact System Administrator."},
            {"Make sure your document is at optimum distance. Keep your brightness level at 50% . Try to keep your scan as straight as possible."},
            {"System Administrator does the assignation of investigating officer for a particular case . Only that investigating officer can upload files  regarding that particular Criminal Record."}
    };

    public ExpandableTextViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return faq_ques.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return faq_ans[groupPosition].length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return faq_ques[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return faq_ans[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String question = (String)getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_questions, null);
        }

        TextView ques = convertView.findViewById(R.id.faq_Ques);
        ques.setTypeface(null, Typeface.BOLD);
        ques.setText(question);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String answer = (String)getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faq_answer, null);
        }
        TextView ans = convertView.findViewById(R.id.faq_Ans);
        ans.setText(answer);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
