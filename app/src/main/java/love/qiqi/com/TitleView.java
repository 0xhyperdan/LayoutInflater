package love.qiqi.com;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by iscod on 2016/4/21.
 */
public class TitleView extends FrameLayout {
    private Button leftButton;
    private TextView titleText;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        titleText = (TextView) findViewById(R.id.title_text);
        leftButton = (Button) findViewById(R.id.button_left);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }

    public void setTitleText(String s) {
        titleText.setText(s);
    }

    public void setLeftButtonText(String s) {
        leftButton.setText(s);
    }

    public void setLeftButtonClickListener(OnClickListener l) {
        leftButton.setOnClickListener(l);
    }
}
