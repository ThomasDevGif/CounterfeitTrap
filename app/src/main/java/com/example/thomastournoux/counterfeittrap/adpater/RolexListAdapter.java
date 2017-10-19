package com.example.thomastournoux.counterfeittrap.adpater;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.object.Rolex;

import java.util.List;


public class RolexListAdapter extends RecyclerView.Adapter<RolexListAdapter.ViewHolder>
        implements AdapterView.OnItemSelectedListener {

    // Variables
    private final static String TAG = "RolexListAdapter";
    private Context mContext;
    // User list data
    private List<Rolex> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public CardView mCard;
        public ImageView mRolexImage;
        public TextView mRolexId, mRolexSerialNumber;

        public ViewHolder(View v) {
            super(v);
            // Retrieve all field view instances
            mCard = (CardView)itemView.findViewById(R.id.card_rolex);
            mRolexImage = (ImageView)itemView.findViewById(R.id.iv_rolex_image) ;
            mRolexId = (TextView)itemView.findViewById(R.id.tv_rolex_id) ;
            mRolexSerialNumber = (TextView)itemView.findViewById(R.id.tv_rolex_serial_number);
            // Listener. Change fragment with event bus.
            mCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            return;
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param mContext Context
     */
    public RolexListAdapter(Context mContext, List<Rolex> rolexList) {
        this.mContext = mContext;
        mDataset = rolexList;
    }


    /**
     * Create new views (invoked by the layout manager)
     */
    @Override
    public RolexListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_rolex, parent, false);

        return new RolexListAdapter.ViewHolder(v);
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(final RolexListAdapter.ViewHolder holder, final int position) {
        holder.mRolexId.setText(mDataset.get(position).getRolexId());
        holder.mRolexSerialNumber.setText(mDataset.get(position).getSerialNumber());
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     * @return
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
//        typeName = parent.getItemAtPosition(pos).toString();
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
