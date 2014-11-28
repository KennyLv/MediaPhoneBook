package com.kenny.mediaphonebook.lib;

import java.io.File;
import java.io.FilenameFilter;

import android.os.Environment;

public class Utils {
	/*
	public void checkSd(){
		if (Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED))
		{
			//得到SD卡得路径
			File mRecAudioPath = Environment.getExternalStorageDirectory();
		}
		
	}*/
	
	
	class MusicFilter implements FilenameFilter
	{
		public boolean accept(File dir, String name)
		{
			return (name.endsWith(".amr"));
		}
	} 
 
	
}
