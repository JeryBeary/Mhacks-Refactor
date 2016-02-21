package baitsbait.heart2heart;

/**
 * Created by JeryBeary on 2/21/16.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class CustomAdapter extends BaseAdapter {
    String[] result, numbers;
    Context context;
    int[] imageId;
    private static LayoutInflater inflater = null;

    public CustomAdapter(ContactActivity mainActivity, String[] prgmNameList, String[] numberList) {
        // TODO Auto-generated constructor stub
        result = prgmNameList;
        context = mainActivity;
        numbers = numberList;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder {
        TextView label;
        TextView label2;
        CheckBox phoneCheck;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.activity_list, null);
        holder.label = (TextView) rowView.findViewById(R.id.label);
        holder.label2 = (TextView) rowView.findViewById(R.id.label2);
        holder.phoneCheck = (CheckBox) rowView.findViewById(R.id.number_check);
        holder.label.setText(result[position]);
        holder.label2.setText(numbers[position]);
        holder.phoneCheck.setChecked(false);
        return rowView;
    }
}

