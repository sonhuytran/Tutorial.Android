package com.sonhuytran.gesturessample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GesturesActivity extends Activity {

    private RelativeLayout viewGestures;
    private TextView txtGesturesHistory;

    private View.OnTouchListener viewGesturesOnTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent event) {

            int action = MotionEventCompat.getActionMasked(event);
            String actionName;

            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    actionName = "Down";
                    break;

                case MotionEvent.ACTION_UP:
                    actionName = "Up";
                    break;

                case MotionEvent.ACTION_CANCEL:
                    actionName = "Cancel";
                    break;

                case MotionEvent.ACTION_MOVE:
                    actionName = "Move";
                    break;

                case MotionEvent.ACTION_MASK:
                    actionName = "Mask";
                    break;

                case MotionEvent.ACTION_HOVER_ENTER:
                    actionName = "Hover Enter";
                    break;

                case MotionEvent.ACTION_HOVER_EXIT:
                    actionName = "Hover Exit";
                    break;

                case MotionEvent.ACTION_HOVER_MOVE:
                    actionName = "Hover Move";
                    break;

                case MotionEvent.ACTION_OUTSIDE:
                    actionName = "Outside";
                    break;

                case MotionEvent.ACTION_SCROLL: // == MotionEvent.ACTION_POINTER_INDEX_SHIFT:
                    actionName = "Scroll";
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    actionName = "Pointer Down";
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    actionName = "Pointer Up";
                    break;

                case MotionEvent.ACTION_POINTER_INDEX_MASK:
                    actionName = "Pointer Index Mask";
                    break;

                default:
                    actionName = "Unknown";
                    break;
            }

            txtGesturesHistory.setText(actionName + "\r\n" + txtGesturesHistory.getText());
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures);

        viewGestures = (RelativeLayout) findViewById(R.id.view_gestures);
        viewGestures.setOnTouchListener(viewGesturesOnTouchListener);
        txtGesturesHistory = (TextView) findViewById(R.id.txt_gestures_history);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.gestures, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
