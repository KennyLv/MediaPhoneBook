package com.kenny.mediaphonebook.lib;

import java.util.ArrayList;
import java.util.List;

import com.kenny.mediaphonebook.model.Contactor;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.provider.ContactsContract.PhoneLookup;
import android.util.Log;

public class SysContactors {
	/*
	 * ContentResolver cr // 得到contentresolver对象
	 */
	public List<Contactor> getSysContactorsList(ContentResolver cr){
		
		List<Contactor> contactors = new ArrayList<Contactor>();
		// 取得电话本中开始一项的光标，必须先moveToNext()
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
		while (cursor.moveToNext()) {
			Contactor newContactor = new Contactor();
			
			// 取得联系人的名字索引
			int nameIndex = cursor.getColumnIndex(PhoneLookup.DISPLAY_NAME);
			String contact = cursor.getString(nameIndex);
			newContactor.setContactorName(contact);

			// 取得联系人的ID索引值
			// 查询该位联系人的电话号码，类似的可以查询email，photo
			// 第一个参数是确定查询电话号，第三个参数是查询具体某个人的过滤值
			String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
			Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = " + contactId, null, null);
			// 一个人可能有几个号码
			while (phone.moveToNext()) {
				String strPhoneNumber = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				newContactor.addContactorNum(strPhoneNumber);
			}

			contactors.add(newContactor);
			phone.close();
		}
		cursor.close();
		return contactors;
	}	
}
