package com.kenny.mediaphonebook.lib;

import java.io.IOException;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.util.Log;

public class PlayName {
	private static final String LOG_TAG = "AudioRecordTest";
	// 语音操作对象
	private MediaPlayer mPlayer = null;
	
	public void startPlay(String _FileName) {
		mPlayer = new MediaPlayer();
		try {
			mPlayer.setDataSource(_FileName);
			mPlayer.setOnCompletionListener(new onPlayFinished());
			mPlayer.setOnErrorListener(new onPlayError());
			
			mPlayer.prepare();
			mPlayer.start();
		} catch (IOException e) {
			Log.e(LOG_TAG, "播放失败");
		}
	}

	public void stopPlay() {
		mPlayer.stop();
		mPlayer.release();
		mPlayer = null;
	}

	public class onPlayFinished implements OnCompletionListener{
		@Override
		public void onCompletion(MediaPlayer mPlayer) {
			
		}
	}

	public class onPlayError implements OnErrorListener{
		@Override
		public boolean onError(MediaPlayer mp, int what, int extra) {
			return false;
		}
	}
	
	

}
