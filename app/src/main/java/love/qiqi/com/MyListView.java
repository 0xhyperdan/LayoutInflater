package love.qiqi.com;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

/**
 * Created by iscod on 2016/4/21.
 */
public class MyListView extends ListView implements View.OnTouchListener,
        GestureDetector.OnGestureListener {

    private GestureDetector gestureDetector;

    private OnDeleteListener listener;

    private View deleteButton;

    private ViewGroup itemLayout;

    private int selectedItem;

    private boolean isDeleteShown;

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        gestureDetector = new GestureDetector(getContext(), this);
        setOnTouchListener(this);
    }

    public void setOnDeleteListener(OnDeleteListener l) {
        listener = l;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        if (!isDeleteShown) {
            selectedItem = pointToPosition((int) e.getX(), (int) e.getY());
        }
        return false;
    }


    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        if (!isDeleteShown && Math.abs(velocityX) > Math.abs(velocityY)) {
            deleteButton = LayoutInflater.from(getContext()).inflate(
                    R.layout.delete_button_layout, null);
            deleteButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemLayout.removeView(deleteButton);
                    deleteButton = null;
                    isDeleteShown = false;
                    listener.onDelete(selectedItem);
                }
            });
            itemLayout = (ViewGroup) getChildAt(selectedItem - getFirstVisiblePosition());
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                    LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            params.addRule(RelativeLayout.CENTER_VERTICAL);
            itemLayout.addView(deleteButton, params);
            isDeleteShown = true;
        }
        return false;
    }

    public interface OnDeleteListener {
        void onDelete(int index);
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (isDeleteShown && deleteButton != null) {
            itemLayout.removeView(deleteButton);
            deleteButton = null;
            isDeleteShown = false;
            return false;
        } else {
            return gestureDetector.onTouchEvent(event);
        }
    }
}
