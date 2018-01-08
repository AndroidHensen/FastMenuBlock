# FastMenuBlock

A simple, practical FastMenuBlock for Android.

<img src="/preview/preview1.png" height="400px"></img>
<img src="/preview/preview2.png" height="400px"></img>
<img src="/preview/preview3.png" height="400px"></img>

# Feature

* 支持添加头部内容
* 支持一行或两行的菜单
* 支持三种不同数目的菜单
* 支持本地资源或网络资源

# Usage

You can directly copy the layout file style using the sample project.

### Step1

Add it in your root build.gradle at the end of repositories

```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```

### Step2

Add the dependency

```
dependencies {
	compile 'com.github.AndroidHensen:FastMenuBlock:1.0.1'
}
```

### Step3

Add FastMenuBlock in your layout

```
<com.handsome.library.FastMenuBlock
	android:id="@+id/fmb"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	app:fmb_gap="2dp"                     // default 2dp
	app:fmb_icon_size="42dp"              // default 42dp
	app:fmb_title_size="14sp"             // default 14sp
	app:fmb_type="type_three" />          // default type_three
```

### Step4

Add Local parameters

```
private int[] images = {R.drawable.icon_office1, R.drawable.icon_office2, R.drawable.icon_office3,
            R.drawable.icon_office4, R.drawable.icon_office5, R.drawable.icon_office6};
private String[] title = {"人事申请", "电脑故障", "打卡补签", "付款申请", "交通报销", "借款申请"};
```

Or Network parameters

```
private String[] images = {"https://fuss10.elemecdn.com/b/7e/d1890cf73ae6f2adb97caa39de7fcjpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/9/21/60ac33f023d9074e13cd78f9b5964jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/c/3c/0184f5b3fa72f295fc01864734218jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/c/db/d20d49e5029281b9b73db1c5ec6f9jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/a/fa/d41b04d520d445dc5de42dae9a384jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/6/74/785eafaf358fa6b18df37c64c3510jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/9/a6/e8422e3dc7f1bd3b4b99b0b2890f9jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",
            "https://fuss10.elemecdn.com/2/35/696aa5cf9820adada9b11a3d14bf5jpeg.jpeg?imageMogr/format/webp/thumbnail/!90x90r/gravity/Center/crop/90x90/",};
private String[] title = {"美食", "夜宵", "商超便利", "果蔬生鲜", "新店特惠", "大牌5折", "港粤美食", "甜品饮品"};
```

### Step5

Add FastMenuAdapter for FastMenuBlock

```
FastMenuBlock fmb = (FastMenuBlock) findViewById(R.id.fmb);
fmb.setAdapter(new FastMenuAdapter() {

	/**
	 * Parameters can be resource files or url
	 */
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
	
	/**
	 * Options:return your HeaderView
	 */
	@Override
	public View getHeaderView() {
		return LayoutInflater.from(OfficeActivity.this).inflate(R.layout.view_office_header, null);
	}
});
```

# Changelog

* 1.0.2
    * Add attribute for fmb_line
    * Add options method for FastMenuAdapter
* 1.0.1
    * Change the package name
    * Modify the minSdkVersion 14
* 1.0
	* Initial release
	
# License

```
Copyright 2017 AndroidHensen

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
