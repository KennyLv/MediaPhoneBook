package com.kenny.mediaphonebook.lib;

public class PhoneCalls {
	/*
	 * //其中Uri.parse("tel://13800138000")中的格式写成Uri.parse("tel:13800138000")
	 * //调用Android系统的拨号界面，但不发起呼叫，用户按下拨号键才会进行呼叫 Intent intent = new
	 * Intent(Intent.ACTION_DIAL, Uri.parse("tel://13800138000"));
	 * startActivity(intent);
	 * 
	 * //直接拨号发起呼叫 Intent intent = new Intent(Intent.ACTION_CALL,
	 * Uri.parse("tel://13800138000")); startActivity(intent);
	 * 
	 * //使用代码配置 import android.text.util.Linkify; Linkify.addLinks(textView,
	 * Linkify.WEB_URLS|Linkify.EMAIL_ADDRESSES|Linkify.PHONE_NUMBERS);
	 * <TextView ...... android:autoLink="web|phone|email" />
	 * 
	 * //为你的电话拨号程序添加拨号键意图过滤器配置 <activity android:name=".CallPhoneActivity"
	 * android:label="@string/app_name"> <intent-filter> <action
	 * android:name="android.intent.action.MAIN" /> <category
	 * android:name="android.intent.category.LAUNCHER" /> </intent-filter>
	 * <intent-filter> // 当用户按下拨号键时，Android系统会弹出选择菜单让用户选择使用那个拨号器 <action
	 * android:name="android.intent.action.CALL_BUTTON" /> <category
	 * android:name="android.intent.category.DEFAULT" /> </intent-filter>
	 * </activity>
	 * <intent-filter> // 功能跟上一个过滤器一样 <action
	 * android:name="android.intent.action.CALL_PRIVILEGED" /> <category
	 * android:name="android.intent.category.DEFAULT" /> <data
	 * android:scheme="tel" /> </intent-filter> 注：需要加上<category
	 * android:name="android.intent.category.BROWSABLE"
	 * />才能使调用的activity收到getIntent().getAction();
	 */

	/*
	 * if(smsContent.length()>70){ List<String> contents =
	 * smsManager.divideMessage(smsContent); for(String c:contents){
	 * smsManager.sendTextMessage(number, null, c, null, null); } }else{
	 * smsManager.sendTextMessage(number, null, smsContent, null, null); }
	 */
}
