package com.kenny.mediaphonebook;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.kenny.mediaphonebook.model.Contactor;

public class ContactorActivity extends Activity {
	Contactor currentContactor;
	TextView nameView;
	TextView numView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactor);
		
		Bundle extras = getIntent().getExtras().getBundle("selectedContactor"); 
		currentContactor = (Contactor)extras.getSerializable("contactorInfo");
		
		nameView =(TextView) this.findViewById(R.id.Contactor_Name_View);
		numView =(TextView) this.findViewById(R.id.Contactor_Num_View);
		nameView.setText(currentContactor.getContactorName());
		numView.setText(currentContactor.getContactorNum().get(0));
		
		numView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//.ACTION_DIAL
				Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel://" + numView.getText()));
				startActivityForResult(intent, 0);
			}
		});

		
	}

}
