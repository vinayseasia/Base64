package com.vinay.convert.images;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView1, imageView2;
	Button button;
	private boolean isSet = false;
	String imageString;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.button1);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		imageView2 = (ImageView) findViewById(R.id.imageView2);

		button.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (isSet) {
					imageView2.setImageResource(R.drawable.ic_launcher);
					isSet = false;
				} else {

					convertImageIntoString();

					convertStringIntoImage();

					//imageView2.setImageDrawable(imageView1.getBackground());
					isSet = true;
				}

			}

			private void convertImageIntoString() {
				Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
						R.drawable.stub);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.PNG, 90, baos);
				byte[] b_array = baos.toByteArray();
				imageString = Base64.encodeBytes(b_array);
				Log.i("imageIntoString~~~~~", imageString);

			}
		});
	}

	protected void convertStringIntoImage() {
		try {
			byte [] b_array = Base64.decode(imageString.getBytes());
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			imageView2.setImageBitmap(BitmapFactory.decodeByteArray(b_array, 0, b_array.length));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}