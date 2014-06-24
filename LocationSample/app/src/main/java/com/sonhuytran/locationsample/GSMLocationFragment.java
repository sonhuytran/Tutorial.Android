package com.sonhuytran.locationsample;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GSMLocationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GSMLocationFragment extends Fragment {

    private TextView txtCellId;
    private TextView txtLac;

    private Button btnRefreshOnce;
    private Button btnRefreshAuto;

    private View.OnClickListener btnRefreshOnceOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            displayGsmCellLocation(getGsmCellLocation());
            Activity activity = GSMLocationFragment.this.getActivity();
            Toast.makeText(activity, activity.getString(R.string.gsm_retrieved_succeed),
                    Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment GSMLocationFragment.
     */
    public static GSMLocationFragment newInstance() {
        GSMLocationFragment fragment = new GSMLocationFragment();
        Bundle args = new Bundle();
        // Add arguments here
        fragment.setArguments(args);

        return fragment;
    }

    public GSMLocationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            // Retrieve arguments here
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gsmlocation, container, false);

        // Setup place holders
        txtCellId = (TextView) view.findViewById(R.id.txt_gsm_cell_id);
        txtLac = (TextView) view.findViewById(R.id.txt_gsm_lac);

        btnRefreshOnce = (Button) view.findViewById(R.id.btn_refresh_once);
        btnRefreshOnce.setOnClickListener(btnRefreshOnceOnClickListener);
        btnRefreshAuto = (Button) view.findViewById(R.id.btn_refresh_auto);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        displayGsmCellLocation(getGsmCellLocation());
    }

    private GsmCellLocation getGsmCellLocation() {
        //retrieve a reference to an instance of TelephonyManager
        TelephonyManager telephonyManager =
                (TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE);
        return (GsmCellLocation) telephonyManager.getCellLocation();
    }

    private void displayGsmCellLocation(GsmCellLocation cellLocation) {
        int cid = cellLocation.getCid();
        int lac = cellLocation.getLac();

        // textGsmCellLocation.setText(cellLocation.toString());
        txtCellId.setText(String.valueOf(cid));
        txtLac.setText(String.valueOf(lac));
    }
}
