package com.tatang.pcit1.kalbe.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tatang.pcit1.kalbe.Library.Hellper.Hellper_Kalbe;
import com.tatang.pcit1.kalbe.Library.Model.M_Interface;
import com.tatang.pcit1.kalbe.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Adapter_Kalbe extends ArrayAdapter<M_Interface> {

    private Context context;
    private List<M_Interface> dataSet = null;
    private ArrayList<M_Interface> originDataSet = null;
    LayoutInflater inflater;

    Hellper_Kalbe hellper_kalbe;

    public Adapter_Kalbe(List<M_Interface> data, Context context) {
        super(context, R.layout.activity_main_item, data);
        this.dataSet = data;
        this.context = context;
        inflater = LayoutInflater.from(getContext());
        this.originDataSet = new ArrayList<>();
        this.originDataSet.addAll(data);
    }

    private static class ViewHolder {

        TextView IdSalesOrder;
        TextView IdCostumerID;
        TextView IdProductID;
        TextView IdQTy;


    }

    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public M_Interface getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final M_Interface dataModel = getItem(position);
        final ViewHolder viewHolder;
        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_main_item, parent, false);

            viewHolder.IdSalesOrder = convertView.findViewById(R.id.IdSalesOrder);
            viewHolder.IdCostumerID = convertView.findViewById(R.id.IdCostumerID);
            viewHolder.IdProductID = convertView.findViewById(R.id.IdProductID);
            viewHolder.IdQTy = convertView.findViewById(R.id.IdQTy);

            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        assert dataModel != null;

        viewHolder.IdSalesOrder.setText(dataModel.getIntSalesOrderID());
        viewHolder.IdCostumerID.setText(dataModel.getIntCustomerID());
        viewHolder.IdProductID.setText(dataModel.getIntProductID());
        viewHolder.IdQTy.setText(dataModel.getIntQty());


        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        dataSet.clear();
        if (charText.length() == 0) {
            dataSet.addAll(originDataSet);
        } else {
            for (M_Interface wp : originDataSet) {
                if (wp.getIntProductID().toLowerCase(Locale.getDefault()).contains(charText) || wp.getIntCustomerID().toLowerCase(Locale.getDefault()).contains(charText)) {
                    dataSet.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
