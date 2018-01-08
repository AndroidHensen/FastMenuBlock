package com.handsome.fastmenublock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.handsome.menublock.FastMenuAdapter;
import com.handsome.menublock.FastMenuBlock;

public class OfficeActivity extends AppCompatActivity {

    private int[] images = {R.drawable.icon_office1, R.drawable.icon_office2, R.drawable.icon_office3};
    private String[] title = {"人事申请", "电脑故障", "打卡补签"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        FastMenuBlock fmb = (FastMenuBlock) findViewById(R.id.fmb);
        fmb.setAdapter(new FastMenuAdapter() {
            @Override
            public Object getView(int position) {
                return images[position];
            }

            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public String getTitle(int position) {
                return title[position];
            }

            @Override
            public void onClick(int position) {
                Toast.makeText(OfficeActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public View getHeaderView() {
                return LayoutInflater.from(OfficeActivity.this).inflate(R.layout.view_office_header, null);
            }
        });
    }
}
