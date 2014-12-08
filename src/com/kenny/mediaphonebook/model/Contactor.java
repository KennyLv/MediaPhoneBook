package com.kenny.mediaphonebook.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.R.integer;

public class Contactor implements Serializable {

	private static final long serialVersionUID = 3522814835718150116L;

	private int contactorId;
	private String contactorName;
	private List<String> contactorNum = new ArrayList<String>();
	private String contactorPhotoAddress;
	private String contactorNameAudio;
	private int contactorCatorgray;

	public int getContactorId() {
		return contactorId;
	}

	public void setContactorId(int contactorId) {
		this.contactorId = contactorId;
	}

	public String getContactorName() {
		return contactorName;
	}

	public void setContactorName(String _contactorName) {
		this.contactorName = _contactorName;
	}

	public List<String> getContactorNum() {
		return contactorNum;
	}

	public void addContactorNum(String _contactorNum) {
		/*Boolean isExist = false;
		for(int index=0; index<contactorNum.size();index++){
			if(String.valueOf(contactorNum.indexOf(index)) == _contactorNum){
				isExist = true;
				break;
			}
		}*/
		//if(isExist){
			contactorNum.add(_contactorNum);
		//}
	}

	public String getContactorPhotoAddress() {
		return contactorPhotoAddress;
	}

	public void setContactorPhotoAddress(String contactorPhotoAddress) {
		this.contactorPhotoAddress = contactorPhotoAddress;
	}

	public String getContactorNameAudio() {
		return contactorNameAudio;
	}

	public void setContactorNameAudio(String contactorNameAudio) {
		this.contactorNameAudio = contactorNameAudio;
	}
	
}
