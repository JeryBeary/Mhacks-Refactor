package baitsbait.heart2heart;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactActivity extends AppCompatActivity {

    ListView people;
    TextView label;
    CheckBox phoneCheck;
    String[] contactNames, contactNumbers;
    Context context;
    private static LayoutInflater inflater = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        people=(ListView) findViewById(R.id.listView);
        ArrayList<PhoneContact> contacts = new ArrayList<PhoneContact>();
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(new PhoneContact(name, phoneNumber));
        }
        ArrayList<String> names = new ArrayList<String>();
        for(int x = 0; x< contacts.size(); x++) {
            names.add(contacts.get(x).getName());
        }
        ArrayList<String> numbers = new ArrayList<String>();
        for(int x = 0; x< contacts.size(); x++)
        {
            numbers.add(contacts.get(x).getNumber());
        }

        contactNames = names.toArray(new String[names.size()]);
        contactNumbers = numbers.toArray(new String[names.size()]);
        people.setAdapter(new CustomAdapter(this, contactNames, contactNumbers));
        phones.close();
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View rowView;
        rowView = inflater.inflate(R.layout.activity_list, null);
        label = (TextView) rowView.findViewById(R.id.label);
        phoneCheck = (CheckBox) rowView.findViewById(R.id.number_check);
        label.setText(contactNames[position]);
        phoneCheck.setChecked(false);
        return rowView;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
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
}
