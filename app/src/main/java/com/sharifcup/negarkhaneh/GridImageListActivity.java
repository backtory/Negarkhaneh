package com.sharifcup.negarkhaneh;

import ir.pegahtech.saas.client.NegarKhane.NegarKhaneConfiguration;
import ir.pegahtech.saas.client.shared.conf.SaaSDataProvider;

import java.util.ArrayList;
import java.util.List;

import com.sharifcup.negarkhaneh.factory.MyImagesFactory;
import com.sharifcup.negarkhaneh.factory.NewImagesFactory;
import com.sharifcup.negarkhaneh.factory.TopImagesFactory;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

public class GridImageListActivity extends ActionBarActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initBackTory();
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), getFragmentList()));
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
    }
    
    public void initBackTory(){
    	NegarKhaneConfiguration.initialize(getCacheDir(), new SaaSDataProvider() {
    		private Handler handler;
    		
    		@Override
    		public void save(String key, String value) {
    			SharedPreferences sp = getSharedPreferences("backtory-city-config", 0);
    			SharedPreferences.Editor editor = sp.edit();
    			editor.putString(key, value);
    			editor.commit();
    		}
    		
    		@Override
    		public void runOnMainThread(Runnable runnable) {
    			handler = new Handler(Looper.getMainLooper()){
    				@Override
    				public void handleMessage(Message msg) {
    					super.handleMessage(msg);
    				}
    			};
    			handler.post(runnable);
    		}
    		
    		@Override
    		public String load(String key) {
    			SharedPreferences sp = getSharedPreferences("backtory-config", 0);
    			return sp.getString(key, null);
    		}

    		@Override
    		public boolean keyExists(String key) {
    			SharedPreferences sp = getSharedPreferences("backtory-config", 0);
    			return sp.contains(key);
    		}

    		@Override
    		public void remove(String key) {
    			SharedPreferences sp = getSharedPreferences("backtory-config", 0);
    			SharedPreferences.Editor editor = sp.edit();
    			editor.remove(key);
    			editor.commit();
    		}
    	});
    }
    
    public List<FragmentItem> getFragmentList(){
    	List<FragmentItem> toReturn = new ArrayList<GridImageListActivity.FragmentItem>();
    	FragmentItem item1 =  new FragmentItem();
    	Fragment toSend1 = new GridListFragment();
    	Bundle extra1 = new Bundle();
    	extra1.putSerializable("factory", new NewImagesFactory(null));
    	toSend1.setArguments(extra1);
    	item1.setFragment(toSend1);
    	item1.setTitle(getResources().getString(R.string.news));
    	toReturn.add(item1);
    	
    	FragmentItem item2 =  new FragmentItem();
    	Fragment toSend2 = new GridListFragment();
    	Bundle extra2 = new Bundle();
    	extra2.putSerializable("factory", new TopImagesFactory(null));
    	toSend2.setArguments(extra2);
    	item2.setFragment(toSend2);
    	item2.setTitle(getResources().getString(R.string.top));
    	toReturn.add(item2);
    	
    	FragmentItem item3 =  new FragmentItem();
    	Fragment toSend3 = new GridListFragment();
    	Bundle extra3 = new Bundle();
    	extra3.putSerializable("factory", new MyImagesFactory(null));
    	toSend3.setArguments(extra3);
    	item3.setFragment(toSend3);
    	item3.setTitle(getResources().getString(R.string.liked));
    	toReturn.add(item3);
    	
    	return toReturn;
    }
    
    public class FragmentItem{
    	public FragmentItem(){
    		
    	}
    	private String title;
    	private Fragment fragment;
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public Fragment getFragment() {
			return fragment;
		}
		public void setFragment(Fragment fragment) {
			this.fragment = fragment;
		}
    }
    public class ViewPageAdapter extends FragmentPagerAdapter{
    	List<FragmentItem> fragments;
		public ViewPageAdapter(FragmentManager fm, List<FragmentItem> fragments) {
			super(fm);
			this.fragments = fragments;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return fragments.get(position).getTitle();
		}
		
		@Override
		public Fragment getItem(int arg0) {
			return this.fragments.get(arg0).fragment;
		}

		@Override
		public int getCount() {
			return this.fragments.size();
		}
    	
    }
}
