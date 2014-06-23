/**
 * 
 */
package sh.example.android.rssfead;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Son-Huy TRAN
 * 
 */
public class DetailFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_rssitem_detail, container,
				false);
	}

	public void setText(String value) {
		try {
			TextView textView = (TextView) this.getView().findViewById(
					R.id.frgRssItemDetails_txtDetails);
			textView.setText(value);
		} catch (Exception e) {
			Log.e("RSS Feed", "setTextException", e);
		}
	}
}
