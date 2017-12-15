package com.tangtuongco.apppppp.ulty;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;

import java.util.ArrayList;

/**
 * Created by Administrator on 24/11/2017.
 */

public class pbAdapter extends BaseAdapter {
    ArrayList<phongban> dataphongban;
    Context context;

    public pbAdapter(ArrayList<phongban> dataphongban, Context context) {
        this.dataphongban = dataphongban;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataphongban.size();
    }

    @Override
    public Object getItem(int i) {
        return dataphongban.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder {
        TextView txtID,txtName;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_row_pb,null);
            viewHolder.txtName= view.findViewById(R.id.txtNamePB);
            viewHolder.txtID=view.findViewById(R.id.txtCODEPB);
            view.setTag(viewHolder);
            phongban phongban1 = (phongban) getItem(i);
            viewHolder.txtName.setText(phongban1.getTenpb());
            viewHolder.txtID.setText(phongban1.getMapb());

        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
            phongban phongban1 = (phongban) getItem(i);
            viewHolder.txtName.setText(phongban1.getTenpb());
            viewHolder.txtID.setText(phongban1.getMapb());
        }
        return view;
    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
