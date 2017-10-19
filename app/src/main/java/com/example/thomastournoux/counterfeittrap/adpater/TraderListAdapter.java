package com.example.thomastournoux.counterfeittrap.adpater;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.fragment.TraderFragment;
import com.example.thomastournoux.counterfeittrap.object.Trader;

import java.util.List;

public class TraderListAdapter extends RecyclerView.Adapter<TraderListAdapter.ViewHolder>
        implements AdapterView.OnItemSelectedListener {

    // Variables
    private final static String TAG = "TraderListAdapter";
    private Context mContext;
    private TraderFragment mTraderFragment;
    // User list data
    private List<Trader> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Trader mTrader;
        public CardView mCard;
        public RelativeLayout mRelativeLayout;
        public TextView mTraderName, mTraderId;

        public ViewHolder(View v) {
            super(v);
            // Retrieve all field view instances
            mCard = (CardView)itemView.findViewById(R.id.card_rolex);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_layout_trader);
            mTraderName = (TextView)itemView.findViewById(R.id.tv_trader_name);
            mTraderId = (TextView)itemView.findViewById(R.id.tv_trader_id);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param mContext Context
     */
    public TraderListAdapter(Context mContext, TraderFragment traderFragment, List<Trader> traders) {
        this.mContext = mContext;
        this.mTraderFragment = traderFragment;
        mDataset = traders;
    }

    /**
     * Create new views (invoked by the layout manager)
     */
    @Override
    public TraderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_trader, parent, false);

        return new TraderListAdapter.ViewHolder(v);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder Holder
     * @param position Position
     */
    @Override
    public void onBindViewHolder(final TraderListAdapter.ViewHolder holder, final int position) {
        holder.mTrader = mDataset.get(position);

        String name = holder.mTrader.getFirstName()
                + " " + holder.mTrader.getLastName().toUpperCase();
        holder.mTraderName.setText(name);
        holder.mTraderId.setText(mDataset.get(position).getTradeId());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do nothing
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
