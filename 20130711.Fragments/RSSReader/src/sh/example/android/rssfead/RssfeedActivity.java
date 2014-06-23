package sh.example.android.rssfead;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class RssfeedActivity extends Activity implements
		MyListFragment.OnItemSelectedListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rssfeed);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_rssfeed, menu);
		return true;
	}

	@Override
	public void OnRssItemSelected(String link) {		
		DetailFragment detailFragment = (DetailFragment) this
				.getFragmentManager().findFragmentById(
						R.id.actRssFeed_frgDetail);
		if (null != detailFragment && detailFragment.isInLayout()) {
			detailFragment.setText(link);
		} else {
			Intent intent = new Intent(this.getApplicationContext(),
					DetailActivity.class);
			intent.putExtra(DetailActivity.EXTRA_URL, link);
			this.startActivity(intent);
		}
	}
}
