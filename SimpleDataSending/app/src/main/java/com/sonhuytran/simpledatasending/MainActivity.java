package com.sonhuytran.simpledatasending;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private EditText txtText;
    private Button btnSendText;
    private Button btnSend1Image;
    private Button btnSend2Images;

    private View.OnClickListener btnSendTextOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String textToSend = txtText.getText().toString();

            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, textToSend);
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent,
                    getString(R.string.send_to)));
        }
    };

    private View.OnClickListener btnSend1ImageOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String packageName = getApplicationContext().getPackageName();
            Uri uri = Uri.parse("android.resource://"
                    + packageName
                    + "/drawable/ic_launcher.png");

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
            shareIntent.setType("image/png");
            startActivity(Intent.createChooser(shareIntent,
                    getText(R.string.send_to)));
        }
    };

    private View.OnClickListener btnSend2ImagesOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String packageName = getApplicationContext().getPackageName();
            Uri uri = Uri.parse("android.resource://"
                    + packageName
                    + "/drawable/ic_launcher.png");

            ArrayList<Uri> imageUris = new ArrayList<Uri>();
            imageUris.add(uri); // Add your image URIs here
            imageUris.add(uri);

            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND_MULTIPLE);
            shareIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, imageUris);
            shareIntent.setType("image/*");
            startActivity(Intent.createChooser(shareIntent, "Share images to.."));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIElementHolders();
    }

    private void setupUIElementHolders() {
        // Setup txtText
        txtText = (EditText) findViewById(R.id.txt_text);

        // Setup btnSendText
        btnSendText = (Button) findViewById(R.id.btn_send_text);
        btnSendText.setOnClickListener(btnSendTextOnClickListener);

        // Setup btnSend1Image
        btnSend1Image = (Button) findViewById(R.id.btn_send_1_image);
        btnSend1Image.setOnClickListener(btnSend1ImageOnClickListener);

        // Setup btnSend2Images
        btnSend2Images = (Button) findViewById(R.id.btn_send_2_images);
        btnSend2Images.setOnClickListener(btnSend2ImagesOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
