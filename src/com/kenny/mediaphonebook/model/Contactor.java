package com.kenny.mediaphonebook.model;

import java.io.Serializable;

public class Contactor implements Serializable {

	private static final long serialVersionUID = 3522814835718150116L;

	private int contactorId;
	private String contactorName;
	private int contactorNum;
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

	public int getContactorNum() {
		return contactorNum;
	}

	public void setContactorNum(int contactorNum) {
		this.contactorNum = contactorNum;
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
