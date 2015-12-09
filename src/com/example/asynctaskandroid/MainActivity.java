package com.example.asynctaskandroid;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends Activity {
	final Context context = this;

	/** Called when the activity is first created. */

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

	}
	
	private class LoadWebPageASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... urls) {

			WebView webView = (WebView) findViewById(R.id.webView);
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl(urls[0]);

			return null;
		}

		protected void onPostExecute(String result) {

		}
	}

	public void dummyFunc(View view){
		Toast.makeText(MainActivity.this, "Button Clicked", Toast.LENGTH_SHORT).show();

	}

	public void readWebpage(View view) {
		LoadWebPageASYNC task = new LoadWebPageASYNC();
		task.execute(new String[] { "http://www.javacodegeeks.com" });

	}
}