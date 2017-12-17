package com.handsome.fastmenublock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.handsome.menublock.FastMenuAdapter;
import com.handsome.menublock.FastMenuBlock;

public class ELemeActivity extends AppCompatActivity {

    private String[] images = {"https://fuss10.elemecdn.com/b/7e/d1890cf73ae6f2adb97caa39de7fcjpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/9/21/60ac33f023d9074e13cd78f9b5964jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/c/3c/0184f5b3fa72f295fc01864734218jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/c/db/d20d49e5029281b9b73db1c5ec6f9jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/a/fa/d41b04d520d445dc5de42dae9a384jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/6/74/785eafaf358fa6b18df37c64c3510jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/9/a6/e8422e3dc7f1bd3b4b99b0b2890f9jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/2/35/696aa5cf9820adada9b11a3d14bf5jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",};

    private String[] title = {"美食", "夜宵", "商超便利", "果蔬生鲜", "新店特惠", "大牌5折", "港粤美食", "甜品饮品"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleme);

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
                Toast.makeText(ELemeActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
