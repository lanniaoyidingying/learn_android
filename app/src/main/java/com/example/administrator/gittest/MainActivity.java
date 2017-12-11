package com.example.administrator.gittest;

import android.graphics.BlurMaskFilter;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuggestionSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * helloworld program to learn how an android program running and it's configrations
 * TextView通常用来显示普通文本，但是有时候需要对其中某些文本进行样式、事件方面的设置。Android系统通过SpannableString类来对指定文本进行相关处理，具体有以下功能：

 1、BackgroundColorSpan 背景色
 2、ClickableSpan 文本可点击，有点击事件
 3、ForegroundColorSpan 文本颜色（前景色）
 4、MaskFilterSpan 修饰效果，如模糊(BlurMaskFilter)、浮雕(EmbossMaskFilter)
 5、MetricAffectingSpan 父类，一般不用
 6、RasterizerSpan 光栅效果
 7、StrikethroughSpan 删除线（中划线）
 8、SuggestionSpan 相当于占位符
 9、UnderlineSpan 下划线
 10、AbsoluteSizeSpan 绝对大小（文本字体）
 11、DynamicDrawableSpan 设置图片，基于文本基线或底部对齐。
 12、ImageSpan 图片
 13、RelativeSizeSpan 相对大小（文本字体）
 14、ReplacementSpan 父类，一般不用
 15、ScaleXSpan 基于x轴缩放
 16、StyleSpan 字体样式：粗体、斜体等
 17、SubscriptSpan 下标（数学公式会用到）
 18、SuperscriptSpan 上标（数学公式会用到）
 19、TextAppearanceSpan 文本外貌（包括字体、大小、样式和颜色）
 20、TypefaceSpan 文本字体
 21、URLSpan 文本超链接
 设置Span
 SpannableStringBuilder.setSpan(Object what, int start, int end, int flags)

 这里的Flag表示：start和end是开区间还是闭区间。

 Flag:

 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE —— (a,b)

 Spanned.SPAN_EXCLUSIVE_INCLUSIVE —— (a,b]

 Spanned.SPAN_INCLUSIVE_EXCLUSIVE —— [a,b)

 Spanned.SPAN_INCLUSIVE_INCLUSIVE —— [a,b]


 */
public class MainActivity extends AppCompatActivity {
/*
* 设置span的步骤
* 首先创建需要设置span的文本对象
* 接着创建需要设置的span类型
* 给span文本设置span
* 把设置好span的文本与TextView进行绑定
* */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        backgroundSpan();
        clickbleSpan();
        forGroundColorSpan();
        maskFilterSpan();
        strikethroughSpan();
        suggestionSpan();
        underlineSpan();
        absoluteSizeSpan();
        dynamicDrawableSpan();
        imageSpan();
        relativeSizeSpan();
        styleSpan();
        sbuscriptSpan();
        superscriptSpan();
        textApperanceSpan();
        typeFaceSpan();
        urlSpan();
    }
    //1. backgroundspan 背景
    public void backgroundSpan(){
        SpannableString spannableString = new SpannableString("闯的博客" +"www.chuang.com");
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.GREEN);
        spannableString.setSpan(backgroundColorSpan,0,spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        TextView textView_bgSpan = (TextView)findViewById(R.id.background_span);
        textView_bgSpan.append("\n");
        textView_bgSpan.append(spannableString);
    }
    //2、ClickableSpan 文本可点击，有点击事件
    public void clickbleSpan(){
        TextView clickabletext = (TextView)findViewById(R.id.clickableSpan);
        SpannableString spannableString = new SpannableString(clickabletext.getText().toString());
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"this span is cliabled",Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan,0,spannableString.length(),Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        clickabletext.append("\n");
        clickabletext.append("后面的是可以点击的span： ");
        clickabletext.append(spannableString);
        clickabletext.setMovementMethod(LinkMovementMethod.getInstance());//该方法如果不进行调用文字进行点击的时候没有任何的效果
        clickabletext.setHighlightColor(Color.CYAN);//设置的高亮的颜色是当文本被点击之后高亮显示背景色
    }
//3、ForegroundColorSpan 文本颜色（前景色）
    public void forGroundColorSpan(){
        TextView forGroundColorTextView = (TextView)findViewById(R.id.forgroundColorSpan);
        SpannableString spannableString = new SpannableString(forGroundColorTextView.getText().toString());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.YELLOW);
        spannableString.setSpan(foregroundColorSpan,0,spannableString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        forGroundColorTextView.append("\n");
        forGroundColorTextView.append(spannableString);//前景色实际上是设置文本的颜色
    }
    //4、MaskFilterSpan 修饰效果，如模糊(BlurMaskFilter)、浮雕(EmbossMaskFilter)
    public void maskFilterSpan() {
        TextView maskfilterTv = (TextView) findViewById(R.id.maskfilterSpan);
        SpannableString spannableString = new SpannableString(maskfilterTv.getText().toString());
        //模糊效果
        MaskFilterSpan maskFilterSpan = new MaskFilterSpan(new BlurMaskFilter(20, BlurMaskFilter.Blur.OUTER));
        spannableString.setSpan(maskFilterSpan,spannableString.length()-10,spannableString.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        maskfilterTv.setText(spannableString);
        //浮雕效果
        SpannableString spannableString1 = new SpannableString("这个是浮雕效果");
        MaskFilterSpan maskFilterSpan1 = new MaskFilterSpan(new EmbossMaskFilter(new float[]{1,2,3},2,3,5));
        spannableString1.setSpan(maskFilterSpan1,spannableString1.length()-7,spannableString1.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        maskfilterTv.append(spannableString1);
    }

    //5、MetricAffectingSpan 父类，一般不用
    public void metricAffectingSpan(){

    }
    //6、RasterizerSpan 光栅效果
    public void rasterizerSpan(){
        TextView textView = (TextView)findViewById(R.id.rasterizer_span);
        SpannableString spannableString = new SpannableString(textView.getText().toString());
        //RasterizerSpan
    }
    //7、StrikethroughSpan 删除线（中划线）
    public void strikethroughSpan(){
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        SpannableString spannableString = getSpannableString(R.id.strikethrough_span,strikethroughSpan);
        TextView textView = getTextView(R.id.strikethrough_span);
        textView.setText(spannableString);
    }
    //8、SuggestionSpan 相当于占位符
    public void suggestionSpan(){
        SuggestionSpan suggestionSpan = new SuggestionSpan(MainActivity.this,new String[]{"hahaha"},SuggestionSpan.SUGGESTIONS_MAX_SIZE);
        SpannableString spannableString = getSpannableString(R.id.suggestionSpan,suggestionSpan);
        TextView textView = getTextView(R.id.suggestionSpan);
        textView.setText(spannableString);
        scaleXSpan();
    }
    //9、UnderlineSpan 下划
     public void underlineSpan(){
         UnderlineSpan underlineSpan = new UnderlineSpan();
         SpannableString spannableString = getSpannableString(R.id.underlineSpan,underlineSpan);
         TextView textView = getTextView(R.id.underlineSpan);
         textView.setText(spannableString);
     }
    //10、AbsoluteSizeSpan 绝对大小（文本字体）
     public void absoluteSizeSpan(){
         AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(20,true);
         SpannableString spannableString = getSpannableString(R.id.absoluteSizeSpan,absoluteSizeSpan);
         TextView textView = getTextView(R.id.absoluteSizeSpan);
         textView.setText(spannableString);
     }
    //11、DynamicDrawableSpan 设置图片，基于文本基线或底部对齐。
    public void dynamicDrawableSpan(){
        TextView textView = getTextView(R.id.dynamicDrawableSpan);
        DynamicDrawableSpan dynamicDrawableSpan = new DynamicDrawableSpan(DynamicDrawableSpan.ALIGN_BASELINE){

            @Override
            public Drawable getDrawable() {
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                drawable.setBounds(0,0,50,50);
                return drawable;
            }
        };
        DynamicDrawableSpan dynamicDrawableSpan1 = new DynamicDrawableSpan(DynamicDrawableSpan.ALIGN_BOTTOM){

            @Override
            public Drawable getDrawable() {
                Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
                drawable.setBounds(0,0,50,50);
                return drawable;
            }
        };
        SpannableString spannableString = new SpannableString(textView.getText().toString());
        spannableString.setSpan(dynamicDrawableSpan,2,4,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(dynamicDrawableSpan1,7,9,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(spannableString);
    }
    //12、ImageSpan 图片
    public void imageSpan(){
        Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher);
        drawable.setBounds(0,0,50,50);
        ImageSpan imageSpan = new ImageSpan(drawable);
        SpannableString spannableString = getSpannableString(R.id.imageSpan,imageSpan);
        TextView textView = getTextView(R.id.imageSpan);
        textView.setText("adsgb");
        textView.append(spannableString);
        textView.append("adsgb");//后边继续添加文字无效
    }
    //13、RelativeSizeSpan 相对大小（文本字体）
    public void relativeSizeSpan(){
        RelativeSizeSpan relativeSizeSpan = new RelativeSizeSpan(0.5f);
        SpannableString spannableString = getSpannableString(R.id.relativeSizeSpan,relativeSizeSpan);
        TextView textView = getTextView(R.id.relativeSizeSpan);
        textView.setText(spannableString);
    }
    //14、ReplacementSpan 父类，一般不用
    public void replacementSpan(){
        //ReplacementSpan replacementSpan = new ReplacementSpan();
        //SpannableString spannableString = getSpannableString(R.id.strikethrough_span);
    }
    //15、ScaleXSpan 基于x轴缩放
    public void scaleXSpan(){
        ScaleXSpan scaleXSpan = new ScaleXSpan(0.5f);
        SpannableString spannableString = getSpannableString(R.id.scaleXSpan,scaleXSpan);
        TextView textView = getTextView(R.id.scaleXSpan);
        textView.setText(spannableString);
    }
    //16、StyleSpan 字体样式：粗体、斜体等
    public void styleSpan(){
        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD_ITALIC);
        SpannableString spannableString = getSpannableString(R.id.strikethrough_span,styleSpan);
        TextView textView = getTextView(R.id.styleSpan);
        textView.setText(spannableString);
    }
    //17、SubscriptSpan 下标（数学公式会用到）
    public void sbuscriptSpan(){
        SubscriptSpan subscriptSpan = new SubscriptSpan();
        SpannableString spannableString = getSpannableString(R.id.subscriptSpan,subscriptSpan);
        TextView textView = getTextView(R.id.subscriptSpan);
        textView.setText("subscriptSpan");
        textView.append(spannableString);
    }
    //18、SuperscriptSpan 上标（数学公式会用到）
    public void superscriptSpan(){
        SuperscriptSpan superscriptSpan = new SuperscriptSpan();
        SpannableString spannableString = getSpannableString(R.id.superscriptSpan,superscriptSpan);
        TextView textView = getTextView(R.id.styleSpan);
        textView.setText("superscriptSpan");
        textView.append(spannableString);
    }
    //19、TextAppearanceSpan 文本外貌（包括字体、大小、样式和颜色）
    public void textApperanceSpan(){
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(this,R.style.span_style);
        SpannableString spannableString = getSpannableString(R.id.textAppearanceSpan,textAppearanceSpan);
        TextView textView = getTextView(R.id.textAppearanceSpan);
        textView.setText(spannableString);
    }
    //20、TypefaceSpan 文本字体
    public void typeFaceSpan(){
        TypefaceSpan typefaceSpan = new TypefaceSpan("monospace");
        SpannableString spannableString = getSpannableString(R.id.typeface,typefaceSpan);
        TextView textView = getTextView(R.id.typeface);
        textView.setText(spannableString);
    }
    //21、URLSpan 文本超链接
    public void urlSpan(){
        URLSpan urlSpan = new URLSpan("http://orgcent.com");
        SpannableString spannableString = getSpannableString(R.id.url,urlSpan);
        TextView textView = getTextView(R.id.url);
        textView.setText(spannableString);
    }/**/
    public SpannableString getSpannableString(int id,Object span){
        TextView textView = (TextView)findViewById(id);
        SpannableString spannableString = new SpannableString(textView.getText().toString());
        spannableString.setSpan(span,0,spannableString.length(),Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
        return spannableString;
    }
    public TextView getTextView(int id ){
        TextView textView = (TextView)findViewById(id);
        return textView;
    }
}
