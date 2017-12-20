package com.tangtuongco.apppppp.ulty;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;
import com.tangtuongco.apppppp.R;
import com.tangtuongco.apppppp.model.phongban;
import com.tangtuongco.apppppp.model.sinhvien;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Administrator on 22/11/2017.
 */

public class svAdapter extends BaseAdapter{
    ArrayList<sinhvien> datasinhvien;

    Context context;

    public svAdapter(ArrayList<sinhvien> datasinhvien, Context context) {
        this.datasinhvien = datasinhvien;
        this.context = context;
    }

    @Override
    public int getCount() {
        return datasinhvien.size();
    }

    @Override
    public Object getItem(int i) {
        return datasinhvien.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder {
        TextView txtID,txtName,txtPB,txtPBBBB;
        ImageView imgAva;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view==null)
        {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_row,null);
            viewHolder.txtName= view.findViewById(R.id.txtName1);
            viewHolder.txtID=view.findViewById(R.id.txtCode1);
            viewHolder.txtPB=view.findViewById(R.id.txtNamePB);
            viewHolder.imgAva=view.findViewById(R.id.imgAva);

            view.setTag(viewHolder);
            sinhvien sinhvien1 = (sinhvien) getItem(i);
            viewHolder.txtName.setText(sinhvien1.getTensv());
            viewHolder.txtID.setText(sinhvien1.getMasv());
            Bitmap bmAva = BitmapFactory.decodeByteArray(sinhvien1.getAvatar(),0,sinhvien1.getAvatar().length);
            //viewHolder.imgAva.setImageBitmap(bmAva);
           viewHolder.imgAva.setImageBitmap(Bitmap.createScaledBitmap(bmAva,120,120,false));





        }
        else
        {
            viewHolder = (ViewHolder) view.getTag();
            sinhvien sinhvien1 = (sinhvien) getItem(i);
            viewHolder.txtName.setText(sinhvien1.getTensv());
            viewHolder.txtID.setText(sinhvien1.getMasv());
            Bitmap bmAva = BitmapFactory.decodeByteArray(sinhvien1.getAvatar(),0,sinhvien1.getAvatar().length);
          viewHolder.imgAva.setImageBitmap(bmAva);
            //viewHolder.imgAva.setImageBitmap(Bitmap.createScaledBitmap(bmAva, 160, 120, false));
            viewHolder.imgAva.setImageBitmap(Bitmap.createScaledBitmap(bmAva,120,120,false));


        }
        return view;
    }


    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
