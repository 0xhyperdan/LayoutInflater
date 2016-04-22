package love.qiqi.com;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout mLayout;
    private TitleView mTitle;
    private MyListView myListView;
    private MyAdapter myAdapter;
    private List<String> contentList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        LayoutInflater inflater = LayoutInflater.from(this);
        View button_view = inflater.inflate(R.layout.button_layout, null);
        mLayout = (RelativeLayout) findViewById(R.id.rl_layout);
        //mLayout.addView(button_view);
        //取到布局文件的父布局
        ViewParent viewParent = mLayout.getParent();
        Log.d("CONG", "父布局：" + viewParent);
        mTitle = (TitleView) findViewById(R.id.title_view);
        mTitle.setTitleText("自定义View");
        myListView = (MyListView) findViewById(R.id.my_list_view);

        myListView.setOnDeleteListener(new MyListView.OnDeleteListener() {
            @Override
            public void onDelete(int index) {
                contentList.remove(index);
                myAdapter.notifyDataSetChanged();
            }
        });
        myAdapter = new MyAdapter(this, 0, contentList);
        myListView.setAdapter(myAdapter);
    }

    private void initList() {
        contentList.add("Content Item 1");
        contentList.add("Content Item 2");
        contentList.add("Content Item 3");
        contentList.add("Content Item 4");
        contentList.add("Content Item 5");
        contentList.add("Content Item 6");
        contentList.add("Content Item 7");
        contentList.add("Content Item 8");
        contentList.add("Content Item 9");
        contentList.add("Content Item 10");
        contentList.add("Content Item 11");
        contentList.add("Content Item 12");
        contentList.add("Content Item 13");
        contentList.add("Content Item 14");
        contentList.add("Content Item 15");
        contentList.add("Content Item 16");
        contentList.add("Content Item 17");
        contentList.add("Content Item 18");
        contentList.add("Content Item 19");
        contentList.add("Content Item 20");
    }
}
