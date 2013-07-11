package sh.example.android.rssfead;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {

	public static final String EXTRA_URL = "url";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
			this.finish();
			return;
		}

		this.setContentView(R.layout.activity_detail);
		Bundle extras = this.getIntent().getExtras();

		if (null != extras) {
			String string = extras.getString(EXTRA_URL);
			TextView textView = (TextView) this
					.findViewById(R.id.frgRssItemDetails_txtDetails);
			textView.setText(string);
		}
	}
}
