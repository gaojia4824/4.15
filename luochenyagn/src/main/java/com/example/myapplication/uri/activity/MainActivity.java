package com.example.myapplication.uri.activity;

import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.myapplication.presenter.Mainpresenter;
import com.example.myapplication.R;
import com.example.myapplication.View.MianView;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.uri.fragment.BFragment;
import com.example.myapplication.uri.adapter.setAAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends BaseActivity<Mainpresenter> implements MianView {


    private NavigationView mNa;
    private DrawerLayout mDr;
    private Toolbar mToo;
    private ArrayList<Fragment> mList;

    private setAAdapter mAdapter;
    private FrameLayout mFr;
    private BottomNavigationView mBott;

    @Override
    protected Mainpresenter initPresenter() {
        return new Mainpresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void into() {
        mPresenter.kk();
         initView();
    }


    @Override
    public void setDate(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_SHORT).show();
    }


    public void initView() {
        mFr = findViewById(R.id.fr);
        mBott = findViewById(R.id.bott);
        mNa = (NavigationView) findViewById(R.id.na);
        mDr = findViewById(R.id.dr);
        mToo = findViewById(R.id.too);
        //三条杠
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDr, mToo, R.string.app_name, R.string.app_name);
        mDr.addDrawerListener(toggle);
        toggle.syncState();
               mList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
//           AFragment fragment = new AFragment();
            BFragment fragment = new BFragment();
            mList.add(fragment);
            fragment.da(i);
        }
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fr,mList.get(0)).commit();

//        ArrayList<String> item = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            item.add("A"+i);
//        }
//
//        mAdapter = new setAAdapter(getSupportFragmentManager(), item, mList);
//        mViewp.setAdapter(mAdapter);
//        mTab.setupWithViewPager(mViewp);

    mBott.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            int i = menuItem.getItemId();
           switch (menuItem.getItemId()){
               case R.id.a:
                   transaction.replace(R.id.fr,mList.get(0)).commit();
                   break;
               case R.id.b:
                   transaction.replace(R.id.fr,mList.get(1)).commit();
                   break;
           }

            return false;
        }
    });
    }
}
