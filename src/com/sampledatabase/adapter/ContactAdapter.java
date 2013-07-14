package com.sampledatabase.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sampledatabase.R;
import com.sampledatabase.holder.ContactHolder;

public class ContactAdapter extends BaseAdapter {

	public Context context;
	public ArrayList<ContactHolder> contact;

	public ContactAdapter(Context context, ArrayList<ContactHolder> contact) {
		this.context = context;
		this.contact = contact;
	}
	public ContactAdapter (Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return contact.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return contact.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		// Recycle ViewHolder's items
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.list,
					parent, false);
			holder = new ViewHolder();
			holder.mTextViewName = (TextView) convertView
					.findViewById(R.id.txtListName);
			holder.mTextViewContact = (TextView) convertView
					.findViewById(R.id.txtListContact);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.mTextViewName.setText(contact.get(position).getName());
//		holder.mTextViewContact.setText(contact.get(position).getContacts());
		return convertView;
	}

	class ViewHolder {
		public TextView mTextViewName;
		public TextView mTextViewContact;
	}

}
