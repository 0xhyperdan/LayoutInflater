package love.qiqi.com;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by iscod on 2016/4/22.
 */
public class MyAdapter extends ArrayAdapter<String> {
    private Context mContext;

    public MyAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.my_listview_itemlayout, null);
        } else {
            view = convertView;
        }
        TextView textView = (TextView) view.findViewById(R.id.text_view);
        textView.setText(getItem(position));
        return view;
    }

}
