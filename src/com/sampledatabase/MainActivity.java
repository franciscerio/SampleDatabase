package com.sampledatabase;

import java.util.ArrayList;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.sampledatabase.adapter.ContactAdapter;
import com.sampledatabase.fragment.MyDialogFragment;

public class MainActivity extends SherlockFragmentActivity {

	public ArrayList<String> list = new ArrayList<String>();
	public DatabaseHandler db;
	private ListView listview;
	private ContactAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		db = new DatabaseHandler(this);
		getDataList();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		getDataList();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		getDataList();
	}

	public void getDataList() {
		
		listview = (ListView) findViewById(R.id.list);
		adapter = new ContactAdapter(this, db.getData());
		listview.setAdapter(adapter);
		adapter.notifyDataSetChanged();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater menuInflater = getSupportMenuInflater();
		menuInflater.inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(
			com.actionbarsherlock.view.MenuItem item) {
		switch (item.getItemId()) {
		case R.id.search:

			return true;
		case R.id.add:
			showDialog();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	public void showDialog() {
		MyDialogFragment dialog = MyDialogFragment.newInstance();
		dialog.show(getSupportFragmentManager(), "dialog");
	}

}
