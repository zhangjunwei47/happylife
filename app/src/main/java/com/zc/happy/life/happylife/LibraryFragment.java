package com.zc.happy.life.happylife;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.zc.happy.life.happylife.base.KaolaBaseFragment;

import java.util.List;

/**
 * 节目库
 */
public class LibraryFragment extends KaolaBaseFragment implements ILibraryView, AdapterView.OnItemClickListener, TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ListView mCategoryListView;
    private TabLayout mTabLayout;
    private ViewPager mContentViewPager;

    private LibraryPresenter mPresenter;
    private CategoryAdapter mCategoryAdapter;
    private LibraryContentPagerAdapter contentAdapter;

    public LibraryFragment() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mPresenter = new LibraryPresenter();
        mPresenter.attachView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mCategoryListView = (ListView) view.findViewById(R.id.category_list);
        mTabLayout = (TabLayout) view.findViewById(R.id.tab);
        mContentViewPager = (ViewPager) view.findViewById(R.id.content_pager);

        mCategoryAdapter = new CategoryAdapter(getContext(), null);
        mCategoryListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        mCategoryListView.setAdapter(mCategoryAdapter);
        mCategoryListView.setOnItemClickListener(this);

        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.addOnTabSelectedListener(this);

        contentAdapter = new LibraryContentPagerAdapter(getChildFragmentManager(), null);
        mContentViewPager.setAdapter(contentAdapter);
        mContentViewPager.addOnPageChangeListener(this);
        mTabLayout.setupWithViewPager(mContentViewPager, true);

        mPresenter.getCategory();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mPresenter.detachView();
    }

    @Override
    public void refreshCategoryList(List<String> categoryList) {
        mCategoryAdapter.setDataList(categoryList);
        mCategoryListView.setSelection(0);
        mCategoryListView.performClick();
        hideLoading();
    }

    @Override
    public void refreshTab(List<String> tabList) {
        mTabLayout.removeAllTabs();
        contentAdapter.setCategoryIds(tabList);
        int size = mTabLayout.getTabCount();
        for (int i = 0; i < size; i++) {
            TabLayout.Tab tab = mTabLayout.getTabAt(i);
            tab.setCustomView(R.layout.layout_library_tab);
            ((TextView) tab.getCustomView()).setText(tabList.get(i));
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String str = (String) mCategoryAdapter.getItem(position);
        mPresenter.getCategory(str);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
