package com.example.thomastournoux.counterfeittrap.adpater;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.activity.TradeActivity;
import com.example.thomastournoux.counterfeittrap.application.UserApplication;
import com.example.thomastournoux.counterfeittrap.fragment.TradeFragment;
import com.example.thomastournoux.counterfeittrap.object.Trade;
import com.example.thomastournoux.counterfeittrap.util.Information;

import java.util.List;

public class TradeListAdapter extends RecyclerView.Adapter<TradeListAdapter.ViewHolder>
        implements AdapterView.OnItemSelectedListener {

    // Variables
    private final static String TAG = "TradeListAdapter";
    private Context mContext;
    private TradeFragment mTradeFragment;
    // User list data
    private List<Trade> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Trade mTrade;
        public CardView mCard;
        public RelativeLayout mRelativeLayout;
        public TextView mTradeId, mTradeDate;

        public ViewHolder(View v) {
            super(v);
            // Retrieve all field view instances
            mCard = (CardView)itemView.findViewById(R.id.card_trade);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_layout_trade);
            mTradeId = (TextView)itemView.findViewById(R.id.tv_trade_id);
            mTradeDate = (TextView)itemView.findViewById(R.id.tv_trade_date);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param mContext Context
     */
    public TradeListAdapter(Context mContext, TradeFragment tradeFragment, List<Trade> trades) {
        this.mContext = mContext;
        this.mTradeFragment = tradeFragment;
        mDataset = trades;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @Override
    public TradeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_trade, parent, false);

        return new TradeListAdapter.ViewHolder(v);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder Holder
     * @param position Position
     */
    @Override
    public void onBindViewHolder(final TradeListAdapter.ViewHolder holder, final int position) {
        holder.mTrade = mDataset.get(position);
        holder.mTradeId.setText("Transaction");
        holder.mTradeDate.setText(mDataset.get(position).getTimestamp());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApplication.setSelectedTrade(holder.mTrade);
                Intent intent = new Intent(mContext, TradeActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return Number of items
     */
    @Override
    public int getItemCount() {
        if(mDataset != null) {
            return mDataset.size();
        }
        return 0;
    }

    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    /**
     * Clear devices list
     */
    public void clear(){
        if(mDataset != null){
            mDataset.clear();
        }
    }
}
