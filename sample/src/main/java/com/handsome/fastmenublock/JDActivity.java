package com.handsome.fastmenublock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.handsome.library.FastMenuAdapter;
import com.handsome.library.FastMenuBlock;

public class JDActivity extends AppCompatActivity {

    private String [] images = {"https://m.360buyimg.com/mobilecms/jfs/t5668/159/160398199/14046/acfe1fa3/591d9424N068a7ad0.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t13159/235/1663465595/16341/d2c180c3/5a266500N5169c7f9.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5656/351/153181074/12227/e35aa8d/591d9456Naa85e195.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5707/83/1407890143/14681/29321e2c/59263c71Nc7d16503.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t9511/185/243002105/6399/cfe6874b/59ca07dcN9b1c275e.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5647/156/156583179/12255/981e942a/591d94a1Nfde63a47.png"
            ,"https://m.360buyimg.com/mobilecms/s126x126_jfs/t2758/175/4146829331/10078/d6a3aa98/57aacab9N98edf989.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5872/340/146804759/11154/f4ae1409/591d94c4N79a488cc.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5824/248/156712927/7215/1ad6be5f/591d94c6Nc4711ad2.png"
            ,"https://m.360buyimg.com/mobilecms/jfs/t5842/205/151189300/13247/a6de2d/591d94edNc42fb94d.png"};
    private String[] title = {"京东超市", "全球购", "京东服饰", "京东生鲜", "排行榜",
            "充值缴费", "领金豆", "领费","赚钱","物流查询"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jd);

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
                Toast.makeText(JDActivity.this, "position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
