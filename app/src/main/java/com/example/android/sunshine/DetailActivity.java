package com.example.android.sunshine;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("onCreate", "1");
        setContentView(R.layout.activity_detail);
        Log.v("onCreate", "2");
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.v("onCreateView", "1");
            Intent intent = getActivity().getIntent();
            Log.v("onCreateView", "2");
            View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
            Log.v("onCreateView", "3");

            if(intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
                Log.v("onCreateView", "4");
                String forecast = intent.getStringExtra(Intent.EXTRA_TEXT);
                Log.v("onCreateView", "5");
             //   ((TextView)( rootView.findViewById(R.id.detail_text))).setText(forecast);

                ((TextView) rootView.findViewById(R.id.detail_text))
                        .setText(forecast);

                Log.v("onCreateView", "6");
            }
            Log.v("onCreateView", "7");

            return rootView;
        }
    }
}