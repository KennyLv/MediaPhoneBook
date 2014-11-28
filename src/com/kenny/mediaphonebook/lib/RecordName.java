package com.kenny.mediaphonebook.lib;

import java.io.IOException;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;
import android.media.MediaRecorder.OnInfoListener;
import android.util.Log;

public class RecordName {
	private static final String LOG_TAG = "AudioRecordTest";
	// 语音文件保存路径
	private String FileName = null;
	// 语音操作对象
	private MediaRecorder mRecorder = null;

	public void recordStart() {
		mRecorder = new MediaRecorder();

		// 注册一个回调被调用发生错误时，同时录制
		// mRecorder.setOnErrorListener(new onRecodeError());
		// 注册要同时记录一个信息事件发生时调用的回调。
		// mRecorder.setOnInfoListener(new onRecodeInfo());

		// 第1步：设置音频来源（MIC表示麦克风）
		mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);

		// 第2步：设置音频输出格式（默认的输出格式）
		// mRecorder.setOutputFormat(MediaRecorder.OutputFormat.DEFAULT);
		// mRecorder.setOutputFormat(MediaRecorder.OutputFormat.RAW_AMR);
		mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

		// 第3步：设置音频编码方式（默认的编码方式）
		// mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
		mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB); // 录制音频的编码为amr.

		// 第4步：指定音频输出文件
		// audioFile = File.createTempFile("record_", ".amr"); //创建一个临时的音频输出文件
		// mRecorder.setOutputFile(audioFile.getAbsolutePath());
		mRecorder.setOutputFile(FileName);
		try {
			// 第5步：调用prepare方法
			mRecorder.prepare();
		} catch (IOException e) {
			Log.e(LOG_TAG, "prepare() failed");
		}
		// 第6步：调用start方法开始录音
		mRecorder.start();
	}

	public void recordStop() {
		mRecorder.stop();
		// 录音的硬件资源被申请了，但是没有释放，再次申请资源，会导致初始化失败。
		// 这里需要注意的是不仅仅需要调用Release()方法，还需要把AudioRecord对象置为null，否则还是释放失败。
		mRecorder.release();
		mRecorder = null;
	}

	public class onRecodeError implements OnErrorListener {
		@Override
		public void onError(MediaRecorder mr, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}
	}

	public class onRecodeInfo implements OnInfoListener {
		@Override
		public void onInfo(MediaRecorder mr, int what, int extra) {
			// TODO Auto-generated method stub

		}
	}

	/*
	 * //获取音频信号源的最高值。 final static int getAudioSourceMax()
	 * 
	 * //最后调用这个方法采样的时候返回最大振幅的绝对值 int getMaxAmplitude()
	 * 
	 * //准备recorder 开始捕获和编码数据 void prepare()
	 * 
	 * //发布与此MediaRecorder对象关联的资源 void release()
	 * 
	 * //重新启动mediarecorder到空闲状态 void reset()
	 * 
	 * //设置录制的音频通道数。 void setAudioChannels(int numChannels)
	 * 
	 * //设置audio的编码格式 void setAudioEncoder(int audio_encoder)
	 * 
	 * //设置录制的音频编码比特率 void setAudioEncodingBitRate(int bitRate)
	 * 
	 * //设置录制的音频采样率。 void setAudioSamplingRate(int samplingRate)
	 * 
	 * //设置用于录制的音源。 void setAudioSource(int audio_source)
	 * 
	 * //辅助时间的推移视频文件的路径传递。 void setAuxiliaryOutputFile(String path)
	 * 
	 * void setAuxiliaryOutputFile(FileDescriptor fd) //在文件描述符传递的辅助时间的推移视频
	 * 
	 * //设置一个recording的摄像头 void setCamera(Camera c)
	 * 
	 * //设置视频帧的捕获率 void setCaptureRate(double fps)
	 * 
	 * //设置记录会话的最大持续时间（毫秒） void setMaxDuration(int max_duration_ms)
	 * 
	 * //设置记录会话的最大大小（以字节为单位） void setMaxFileSize(long max_filesize_bytes)
	 * 
	 * //注册一个回调被调用发生错误时，同时录制 void
	 * setOnErrorListener(MediaRecorder.OnErrorListener l)
	 * 
	 * //注册要同时记录一个信息事件发生时调用的回调。 void
	 * setOnInfoListener(MediaRecorder.OnInfoListener listener)
	 * 
	 * //设置输出的视频播放的方向提示 void setOrientationHint(int degrees)
	 * 
	 * //传递要写入的文件的文件描述符 void setOutputFile(FileDescriptor fd)
	 * 
	 * //设置输出文件的路径 void setOutputFile(String path)
	 * 
	 * //设置在录制过程中产生的输出文件的格式 void setOutputFormat(int output_format)
	 * 
	 * //表面设置显示记录媒体（视频）的预览 void setPreviewDisplay(Surface sv)
	 * 
	 * //从一个记录CamcorderProfile对象的使用设置 void setProfile(CamcorderProfile profile)
	 * 
	 * //设置视频编码器，用于录制 void setVideoEncoder(int video_encoder)
	 * 
	 * //设置录制的视频编码比特率 void setVideoEncodingBitRate(int bitRate)
	 * 
	 * //设置要捕获的视频帧速率 void setVideoFrameRate(int rate)
	 * 
	 * //设置要捕获的视频的宽度和高度 void setVideoSize(int width, int height)
	 * 
	 * //开始捕捉和编码数据到setOutputFile（指定的文件） void setVideoSource(int video_source)
	 * 
	 * //开始录音 void start()
	 * 
	 * //停止recording void stop()
	 */

}
