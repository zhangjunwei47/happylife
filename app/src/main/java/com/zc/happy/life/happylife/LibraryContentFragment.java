package com.zc.happy.life.happylife;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dinuscxj.itemdecoration.GridOffsetsItemDecoration;
import com.zc.happy.life.happylife.base.KaolaBaseFragment;

/**
 * 节目库内容区
 */
public class LibraryContentFragment extends KaolaBaseFragment {

    private RecyclerView mRecyclerView;

    private LibraryContentAdapter contentAdapter;

    private String categoryId;

    private static final String PARAMS_CATEGORY_ID = "category_id";

    public static LibraryContentFragment create(String categoryId) {
        LibraryContentFragment libraryContentFragment = new LibraryContentFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAMS_CATEGORY_ID, categoryId);
        libraryContentFragment.setArguments(bundle);
        return libraryContentFragment;
    }

    public LibraryContentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library_content, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        GridOffsetsItemDecoration offsetsItemDecoration = new GridOffsetsItemDecoration(
                GridOffsetsItemDecoration.GRID_OFFSETS_VERTICAL);
        offsetsItemDecoration.setVerticalItemOffsets(20);
        offsetsItemDecoration.setHorizontalItemOffsets(20);
        mRecyclerView.addItemDecoration(offsetsItemDecoration);

        Bundle arguments = getArguments();
        if (arguments != null) {
            // TODO: 16-12-15 get content by category id
        }

        contentAdapter = new LibraryContentAdapter(getContext());

        mRecyclerView.setAdapter(contentAdapter);

    }
}
