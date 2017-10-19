package com.example.thomastournoux.counterfeittrap.adpater;

import android.content.Context;
import android.content.Intent;
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
import com.example.thomastournoux.counterfeittrap.activity.RolexActivity;
import com.example.thomastournoux.counterfeittrap.application.UserApplication;
import com.example.thomastournoux.counterfeittrap.fragment.RolexFragment;
import com.example.thomastournoux.counterfeittrap.object.Rolex;
import com.example.thomastournoux.counterfeittrap.util.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.List;


public class RolexListAdapter extends RecyclerView.Adapter<RolexListAdapter.ViewHolder>
        implements AdapterView.OnItemSelectedListener {

    // Variables
    private final static String TAG = "RolexListAdapter";
    private Context mContext;
    private RolexFragment mRolexFragment;
    // User list data
    private List<Rolex> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Rolex mRolex;
        public CardView mCard;
        public RelativeLayout mRelativeLayout;
        public ImageView mRolexImage;
        public TextView mRolexId, mRolexSerialNumber;

        public ViewHolder(View v) {
            super(v);
            // Retrieve all field view instances
            mCard = (CardView)itemView.findViewById(R.id.card_rolex);
            mRelativeLayout = (RelativeLayout)itemView.findViewById(R.id.relative_layout_rolex);
            mRolexImage = (ImageView)itemView.findViewById(R.id.iv_rolex_image);
            mRolexId = (TextView)itemView.findViewById(R.id.tv_rolex_id);
            mRolexSerialNumber = (TextView)itemView.findViewById(R.id.tv_rolex_serial_number);
        }
    }

    /**
     * Provide a suitable constructor (depends on the kind of dataset)
     * @param mContext Context
     */
    public RolexListAdapter(Context mContext, RolexFragment rolexFragment, List<Rolex> rolexList) {
        this.mContext = mContext;
        this.mRolexFragment = rolexFragment;
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
     * @param holder Holder
     * @param position Position
     */
    @Override
    public void onBindViewHolder(final RolexListAdapter.ViewHolder holder, final int position) {
        holder.mRolex = mDataset.get(position);

        Picasso.with(mContext)
                .load(holder.mRolex.getVisual())
                .transform(new CircleTransform())
                .into(holder.mRolexImage);

        holder.mRolexId.setText(mDataset.get(position).getRolexId());
        holder.mRolexSerialNumber.setText(mDataset.get(position).getSerialNumber());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserApplication.setSelectedRolex(holder.mRolex);
                Intent intent = new Intent(mContext, RolexActivity.class);
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
