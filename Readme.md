# HeadShadowView
实现头像底部展示模糊渐变阴影, 不包含头像控件。

## 引入依赖

* 根目录build.gradle
```
allprojects {
repositories {
    google()
    jcenter()

    maven {url 'https://jitpack.io'}
}
}
```

* 工程build.gradle
```
 implementation 'com.github.dongxingrong:HeadShadowView:1.1'
 ```

## 使用方法
```
<com.example.headshadowview.ShadowView
android:id="@+id/iv_shadow"
android:layout_width="match_parent"
android:layout_height="88dp"
app:shadow_size="67dp"
app:shadow_color="@color/color_6C62F5x"
app:shadow_bg_color="@color/color_6C62F5"/>
```

* shadow_size: 头像大小
* shadow_color: 阴影颜色
* shadow_bg_color:头像占位颜色

## 效果

![效果图](https://github.com/dongxingrong/img_folder/blob/master/S81228-141050.jpg)
