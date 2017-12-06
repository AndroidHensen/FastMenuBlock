package com.handsome.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * =====作者=====
 * 许英俊
 * =====时间=====
 * 2017/12/6.
 */

public class FastMenuBlock extends RelativeLayout implements View.OnClickListener {

    private SparseArray<View> views;
    private View fmb_view;
    private LayoutInflater inflater;

    private FastMenuAdapter mFastMenuAdapter;
    private ExecutorService mCachedThreadPool;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap) msg.obj;
            int position = msg.arg1;

            fmb_list_icon.get(position).setImageBitmap(bitmap);
        }
    };

    private int[] fmb_layout = {R.id.fmb_ly_1, R.id.fmb_ly_2, R.id.fmb_ly_3,
            R.id.fmb_ly_4, R.id.fmb_ly_5, R.id.fmb_ly_6,
            R.id.fmb_ly_7, R.id.fmb_ly_8, R.id.fmb_ly_9, R.id.fmb_ly_10};
    private int[] fmb_icon = {R.id.fmb_iv_1, R.id.fmb_iv_2, R.id.fmb_iv_3,
            R.id.fmb_iv_4, R.id.fmb_iv_5, R.id.fmb_iv_6,
            R.id.fmb_iv_7, R.id.fmb_iv_8, R.id.fmb_iv_9, R.id.fmb_iv_10};
    private int[] fmb_title = {R.id.fmb_tv_1, R.id.fmb_tv_2, R.id.fmb_tv_3,
            R.id.fmb_tv_4, R.id.fmb_tv_5, R.id.fmb_tv_6,
            R.id.fmb_tv_7, R.id.fmb_tv_8, R.id.fmb_tv_9, R.id.fmb_tv_10};

    private List<LinearLayout> fmb_list_ly;
    private List<ImageView> fmb_list_icon;
    private List<TextView> fmb_list_title;

    private int fmb_type;
    private int fmb_title_size = 12;
    private int fmb_icon_size = 42;
    private int fmb_gap = 2;

    interface TYPE {
        int TYPE_THREE = 6;
        int TYPE_FOUR = 8;
        int TYPE_FIVE = 10;
    }

    public FastMenuBlock(Context context) {
        this(context, null);
    }

    public FastMenuBlock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FastMenuBlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mCachedThreadPool = Executors.newCachedThreadPool();

        fmb_list_ly = new ArrayList<>();
        fmb_list_icon = new ArrayList<>();
        fmb_list_title = new ArrayList<>();

        initAttrs(context, attrs, defStyleAttr);
        initRootViews(context);
        initViews();
    }

    private void initAttrs(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FastMenuBlock, defStyleAttr, 0);
        fmb_type = ta.getInt(R.styleable.FastMenuBlock_fmb_type, TYPE.TYPE_THREE);
        fmb_title_size = (int) ta.getDimension(R.styleable.FastMenuBlock_fmb_title_size, dp2px(fmb_title_size));
        fmb_icon_size = (int) ta.getDimension(R.styleable.FastMenuBlock_fmb_icon_size, dp2px(fmb_icon_size));
        fmb_gap = (int) ta.getDimension(R.styleable.FastMenuBlock_fmb_gap, dp2px(fmb_gap));
        ta.recycle();
    }

    private void initRootViews(Context context) {
        views = new SparseArray<>();
        inflater = LayoutInflater.from(context);
        if (fmb_type == TYPE.TYPE_THREE) {
            fmb_view = inflater.inflate(R.layout.fast_menu_block3, null);
        } else if (fmb_type == TYPE.TYPE_FOUR) {
            fmb_view = inflater.inflate(R.layout.fast_menu_block4, null);
        } else if (fmb_type == TYPE.TYPE_FIVE) {
            fmb_view = inflater.inflate(R.layout.fast_menu_block5, null);
        }
        addView(fmb_view);
    }

    private void initViews() {
        for (int i = 0; i < fmb_type; i++) {
            fmb_list_ly.add((LinearLayout) getView(fmb_layout[i]));
            fmb_list_icon.add((ImageView) getView(fmb_icon[i]));
            fmb_list_title.add((TextView) getView(fmb_title[i]));
        }
    }

    /**
     * Set adapter for FastMenuBlock
     *
     * @param adapter
     */
    public void setAdapter(FastMenuAdapter adapter) {
        this.mFastMenuAdapter = adapter;

        setFastMenuBlockView();
    }

    private void setFastMenuBlockView() {
        for (int i = 0; i < fmb_type; i++) {
            if (i + 1 <= mFastMenuAdapter.getCount()) {
                Object object = mFastMenuAdapter.getView(i);

                fmb_list_icon.get(i).getLayoutParams().width =
                        fmb_list_icon.get(i).getLayoutParams().height = fmb_icon_size;

                if (object instanceof String) {
                    mCachedThreadPool.execute(new UrlImageRunnable((String) object, i));
                } else if (object instanceof Integer) {
                    fmb_list_icon.get(i).setImageResource((Integer) object);
                }

                fmb_list_title.get(i).setText(mFastMenuAdapter.getTitle(i));
                fmb_list_title.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX,fmb_title_size);
                fmb_list_title.get(i).setPadding(0, fmb_gap, 0, 0);
                fmb_list_ly.get(i).setTag(i);
                fmb_list_ly.get(i).setOnClickListener(this);
            }
        }
    }

    /**
     * FindViewById
     *
     * @param viewId
     * @param <T>
     * @return
     */
    private <T> T getView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = fmb_view.findViewById(viewId);
            if (view != null) {
                views.put(viewId, view);
            }
        }
        return (T) view;
    }


    /**
     * Load NetWorkImage
     */
    private class UrlImageRunnable implements Runnable {

        private String url;
        private int position;

        public UrlImageRunnable(String url, int position) {
            this.url = url;
            this.position = position;
        }

        @Override
        public void run() {
            try {
                URL imageUrl = new URL(url);
                Bitmap bitmap = BitmapFactory.decodeStream(imageUrl.openStream());

                Message message = Message.obtain();
                message.obj = bitmap;
                message.arg1 = position;
                mHandler.sendMessage(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Click Event
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        mFastMenuAdapter.onClick((Integer) v.getTag());
    }

    /**
     * dp2px
     *
     * @param pxValue
     * @return
     */
    private int dp2px(float pxValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (pxValue * scale + 0.5f);
    }


}
