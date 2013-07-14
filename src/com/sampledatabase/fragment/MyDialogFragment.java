package com.sampledatabase.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.actionbarsherlock.view.Window;
import com.sampledatabase.DatabaseHandler;
import com.sampledatabase.MainActivity;
import com.sampledatabase.R;
import com.sampledatabase.adapter.ContactAdapter;

public class MyDialogFragment extends SherlockDialogFragment {
	static MyDialogFragment dialogFragment;
	private EditText mName;
	private EditText mContacts;
	private Button mAdd;
	String name, contacts;
	public DatabaseHandler dbHandler;
	Context context;
	ContactAdapter contact ;
	
	
	public static MyDialogFragment newInstance() {
		MyDialogFragment dialog = new MyDialogFragment();
		dialogFragment = dialog;
		return dialog;
	}
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		dbHandler = new DatabaseHandler(getSherlockActivity());
		contact = new ContactAdapter(getSherlockActivity(),dbHandler.getData());
	
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = null;
		dialogFragment.getDialog().requestWindowFeature((int) Window.FEATURE_NO_TITLE);
		dialogFragment.setCancelable(true);
		view = inflater.inflate(R.layout.add, container, false);
		mName = (EditText) view.findViewById(R.id.txtName);
		mContacts = (EditText) view.findViewById(R.id.txtContact);
		mAdd = (Button) view.findViewById(R.id.btnAdd);
		return view;
	}

	@Override
	public void onActivityCreated(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onActivityCreated(arg0);

		mAdd.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				name = mName.getText().toString();
				contacts = mContacts.getText().toString();
				dbHandler.addContact(name, contacts);
				Toast.makeText(getSherlockActivity(),
						"Contact has been added!", Toast.LENGTH_SHORT).show();
				dialogFragment.dismiss();
//				contact.notifyDataSetChanged();
				Intent i = new Intent(getSherlockActivity(), MainActivity.class);
				startActivity(i);
				contact.notifyDataSetChanged();
				
			}

		});

	}

}
