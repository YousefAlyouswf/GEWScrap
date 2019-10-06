package com.yousef.owner.scrapcalculator2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListView extends ArrayAdapter<String> {


    private String[] _type;
    private String[]  _price;
    private  String[] _weight;
    private  String[] _date;
    private Activity _context;

    public CustomListView(Activity context, String[] type, String[] price, String[] weight,String[] date) {

        super(context, R.layout.listview_layout, type);
        this._context=context;
        this._type=type;
        this._price=price;
        this._weight=weight;
        this._date=date;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View r=convertView;

        ViewHolder viewHolder=null;

        if(r==null){
            LayoutInflater inflater = _context.getLayoutInflater();
            r=inflater.inflate(R.layout.listview_layout,null,true);

            viewHolder=new ViewHolder(r);
            r.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)r.getTag();

        }

        viewHolder.textType.setText(_type[position]);
        viewHolder.textPrice.setText(_price[position]);
        viewHolder.textWeight.setText(_weight[position]);
        viewHolder.textdate.setText(_date[position]);

        return r;
    }

    class ViewHolder{
        TextView textType;
        TextView textPrice;
        TextView textWeight;
        TextView textdate;

        ViewHolder(View v){
            textType=(TextView)v.findViewById(R.id.texttype);
            textPrice=(TextView)v.findViewById(R.id.textprice);
            textWeight=(TextView)v.findViewById(R.id.textweight);
            textdate=(TextView)v.findViewById(R.id.date);
        }
    }
}
