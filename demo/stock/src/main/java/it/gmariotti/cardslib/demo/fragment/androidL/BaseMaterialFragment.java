/*
 * ******************************************************************************
 *   Copyright (c) 2013-2014 Gabriele Mariotti.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  *****************************************************************************
 */

package it.gmariotti.cardslib.demo.fragment.androidL;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import it.gmariotti.cardslib.demo.R;
import it.gmariotti.cardslib.demo.fragment.BaseFragment;
import it.gmariotti.cardslib.demo.utils.LPreviewUtils;
import it.gmariotti.cardslib.demo.utils.LPreviewUtilsBase;

/**
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public abstract class BaseMaterialFragment extends BaseFragment {

    private View mHeaderBox;
    private View mHeaderContentBox;
    private View mHeaderBackgroundBox;
    private View mHeaderShadow;

    TextView mTitleHeader;
    TextView mSubTitleHeader;
    
    @Override
    public int getTitleResourceId() {
        return R.string.app_name;
    }


    protected void setupBarHeader(View rootView){
        mHeaderBox = rootView.findViewById(R.id.header_recap);
        mHeaderContentBox = rootView.findViewById(R.id.header_contents);
        mHeaderBackgroundBox = rootView.findViewById(R.id.header_background);
        mHeaderShadow = rootView.findViewById(R.id.header_shadow);
        
        mTitleHeader = (TextView) rootView.findViewById(R.id.header_title);
        mSubTitleHeader = (TextView) rootView.findViewById(R.id.header_subtitle);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LPreviewUtilsBase lpu = LPreviewUtils.getInstance(getActivity());

        float mMaxHeaderElevation = getResources().getDimensionPixelSize(
                R.dimen.carddemo_barheader_elevation);

        mHeaderShadow.setVisibility(lpu.hasLPreviewAPIs() ? View.GONE : View.VISIBLE);
        lpu.setViewElevation(mHeaderBackgroundBox,  mMaxHeaderElevation);
        lpu.setViewElevation(mHeaderContentBox,  mMaxHeaderElevation + 0.1f);
    
        mTitleHeader.setText(getString(getTitleHeaderResourceId()));
        mSubTitleHeader.setText(getString(getSubTitleHeaderResourceId()));

    }

    protected abstract int getSubTitleHeaderResourceId();

    protected abstract int getTitleHeaderResourceId();  
}