package com.kenny.mediaphonebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kenny.mediaphonebook.lib.SysContactors;
import com.kenny.mediaphonebook.model.Contactor;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ContactorListActivity extends Activity {
	ListView list;
	List<Contactor> contactors;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_contactor_list);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.activity_contactor_list_titlebar);

		contactors = new SysContactors().getSysContactorsList(getContentResolver());
		
		// 生成动态数组，并且转载数据
		ArrayList<HashMap<String, Object>> mylist = new ArrayList<HashMap<String, Object>>();
		for (int i = 0; i < contactors.size(); i++) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("ItemTitle", contactors.get(i).getContactorName());
			//map.put("ItemText", contactors.get(i).getContactorNum());
			map.put("ItemImg", R.drawable.profile);

			mylist.add(map);
		}
		// 生成适配器，数组===》ListItem
		SimpleAdapter mSchedule = new SimpleAdapter(this, // 没什么解释
				mylist,// 数据来源
				R.layout.activity_contactor_list_item,// ListItem的XML实现
				// 动态数组与ListItem对应的子项
				new String[] { "ItemTitle", /*"ItemText", */ "ItemImg" },
				// ListItem的XML文件里面的两个TextView ID
				new int[] { R.id.ItemTitle, /*R.id.ItemText,*/ R.id.ItemImg });
		
		// 添加并且显示
		list = (ListView) findViewById(R.id.MyListView);
		list.setAdapter(mSchedule);
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int index, long arg3) {
				//获得选中项的HashMap对象   
				Contactor selected = contactors.get(index);
				
				Bundle selectedContactor = new Bundle();
				selectedContactor.putSerializable("contactorInfo", selected);
				
				Intent intent = new Intent(ContactorListActivity.this, ContactorActivity.class);
				intent.putExtra("selectedContactor", selectedContactor);
				
				startActivity(intent);
			}
		});
		
	}
}
