package baitsbait.heart2heart;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.content.Intent;

public class Data extends AppCompatActivity {
    //ListView data;
    CheckBox heart, sleep;
    public class MyActivity extends AppCompatActivity {
        public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        String[] displays = {"Heart Rate: ", "Sleep Hours: "};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_list,displays);
        heart = (CheckBox)findViewById(R.id.heart);
        //heart.setAdapter(adapter);
        sleep = (CheckBox)findViewById(R.id.sleep);
        //sleep.setAdapter(adapter);


        ArrayList<PhoneContact> contacts = new ArrayList<PhoneContact>();
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contacts.add(new PhoneContact(name, phoneNumber));
        }

        for(int i = 0; i < contacts.size(); i++)
        {
            Log.d("hi", contacts.get(i).getName() + " " + contacts.get(i).getNumber());
        }
        phones.close();

    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.heart:
                if (checked)
                // Put some meat on the sandwich
                break;
            case R.id.sleep:
                if (checked)
                // Cheese me
                break;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_data, menu);
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
