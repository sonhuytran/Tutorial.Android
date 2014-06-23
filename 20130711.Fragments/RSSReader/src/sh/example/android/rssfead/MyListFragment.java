/**
 * 
 */
package sh.example.android.rssfead;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author Son-Huy TRAN
 * 
 */
public class MyListFragment extends Fragment implements OnClickListener {

	public interface OnItemSelectedListener {
		public void OnRssItemSelected(String link);
	}

	private OnItemSelectedListener listener = null;
	private Button btnPressToUpdate = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rsslist_overview,
				container, false);
		this.btnPressToUpdate = (Button) view
				.findViewById(R.id.frgRsslistOverview_btnUpdate);
		this.btnPressToUpdate.setOnClickListener(this);

		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		if (activity instanceof OnItemSelectedListener) {
			this.listener = (OnItemSelectedListener) activity;
		} else {
			throw new ClassCastException(activity + " must implement "
					+ OnItemSelectedListener.class);
		}
	}

	@Override
	public void onClick(View view) {
		if (view == this.btnPressToUpdate) {
			this.btnPressToUpdateOnClicked();
		}
	}

	private void btnPressToUpdateOnClicked() {
		this.updateDetail();
	}

	public void updateDetail() {
		String newTime = String.valueOf(System.currentTimeMillis());
		this.listener.OnRssItemSelected(newTime);
	}
}