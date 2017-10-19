package com.example.thomastournoux.counterfeittrap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thomastournoux.counterfeittrap.R;
import com.example.thomastournoux.counterfeittrap.application.UserApplication;
import com.example.thomastournoux.counterfeittrap.object.Rolex;
import com.example.thomastournoux.counterfeittrap.util.CircleTransform;
import com.squareup.picasso.Picasso;

public class RolexActivity extends AppCompatActivity {

    private Rolex mRolex;
    private ImageView mRolexImage;
    private TextView mRolexId;
    private TextView mRolexBrand;
    private TextView mRolexSerialNumber;
    private TextView mRolexWeight;
    private TextView mRolexWeightUnity;
    private TextView mRolexSecondHandSpecifications;
    private TextView mRolexMaterialsSpecifications;
    private TextView mRolexCyclopeanObjective;
    private TextView mRolexRemontoireChangeDateAtSixHour;
    private TextView mRolexBackTransparent;
    private TextView mRolexBraceletMaterial;
    private TextView mRolexSealing;
    private TextView mRolexProductDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rolex);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initialize();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Init variables
     */
    private void initialize() {
        // Get rolex
        mRolex = UserApplication.getSelectedRolex();
        getSupportActionBar().setTitle(mRolex.getRolexId());

        mRolexImage = (ImageView) findViewById(R.id.iv_rolex);
        Picasso.with(getApplicationContext())
                .load(mRolex.getVisual())
                .transform(new CircleTransform())
                .into(mRolexImage);

        // TextView
        mRolexId = (TextView) findViewById(R.id.tv_rolex_id);
        mRolexId.setText(mRolex.getRolexId());

        mRolexBrand = (TextView) findViewById(R.id.tv_rolex_brand);
        mRolexBrand.setText(mRolex.getBrand());

        mRolexSerialNumber = (TextView) findViewById(R.id.tv_rolex_serialNumber);
        mRolexSerialNumber.setText(mRolex.getSerialNumber());

        mRolexWeight = (TextView) findViewById(R.id.tv_rolex_weight);
        mRolexWeight.setText(mRolex.getWeight());

        mRolexWeightUnity = (TextView) findViewById(R.id.tv_rolex_weightUnity);
        mRolexWeightUnity.setText(mRolex.getWeightUnity());

        mRolexSecondHandSpecifications = (TextView) findViewById(R.id.tv_rolex_secondHandSpecifications);
        mRolexSecondHandSpecifications.setText(mRolex.getSecondHandSpecifications());


        mRolexMaterialsSpecifications = (TextView) findViewById(R.id.tv_rolex_materialsSpecifications);
        mRolexMaterialsSpecifications.setText(mRolex.getMaterialsSpecifications());

        mRolexCyclopeanObjective = (TextView) findViewById(R.id.tv_rolex_cyclopeanObjective);
        mRolexCyclopeanObjective.setText(mRolex.getCyclopeanObjective());

        mRolexRemontoireChangeDateAtSixHour = (TextView) findViewById(R.id.tv_rolex_remontoireChangeDateAtSixHour);
        mRolexRemontoireChangeDateAtSixHour.setText(mRolex.getRemontoireChangeDateAtSixHour());

        mRolexBackTransparent = (TextView) findViewById(R.id.tv_rolex_backTransparent);
        mRolexBackTransparent.setText(mRolex.getBackTransparent());

        mRolexBraceletMaterial = (TextView) findViewById(R.id.tv_rolex_braceletMaterial);
        mRolexBraceletMaterial.setText(mRolex.getBraceletMaterial());

        mRolexSealing = (TextView) findViewById(R.id.tv_rolex_sealing);
        mRolexSealing.setText(mRolex.getSealing());

        mRolexProductDate = (TextView) findViewById(R.id.tv_rolex_productDate);
        mRolexProductDate.setText(mRolex.getProductDate());
    }

}
