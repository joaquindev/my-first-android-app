package com.example.omgandroid;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. Access the Textview defined in layout XML
        //and then set its text
        mainTextView = (TextView) findViewById(R.id.main_textview);
        mainTextView.setText("Set in JAVA code!");

        //2. Access the Button defined in layout XML
        // and listen for it here
        mainButton = (Button) findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);

        //3. Access the EditText defined in layout XML
        mainEditText = (EditText) findViewById(R.id.main_edittext);

        //4. Access the ListView
        mainListView = (ListView) findViewById(R.id.main_listview);
        //4.1 Create the ArrayAdapter for the ListView
        mArrayAdapter = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1,
                        mNameList);
        //4.2 Set the ListView to use the ArrayAdapter
        mainListView.setAdapter(mArrayAdapter);

        /*if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }*/
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

    @Override
    public void onClick(View view) {
        mainTextView.setText(mainEditText.getText().toString()
                + " is learning Android development from a tutorial!");

        //4.4 Also add that value to the list shown in the ListView
        mNameList.add(mainEditText.getText().toString());
        mArrayAdapter.notifyDataSetChanged();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    /*public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }*/

}
