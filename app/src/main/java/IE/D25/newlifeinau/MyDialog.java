package IE.D25.newlifeinau;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MyDialog {
    public static class MyDialog1 extends Dialog implements View.OnClickListener{

        private Context context;
        private int layoutResID;
        private int[] listenedItem;
        public MyDialog1(Context context,int layoutResID,int[] listenedItem){
            super(context,R.style.MyDialog);
            this.context = context;
            this.layoutResID = layoutResID;
            this.listenedItem = listenedItem;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            Window dialogWindow = getWindow();
            dialogWindow.setGravity(Gravity.CENTER);

            setContentView(layoutResID);


            WindowManager windowManager = ((Activity)context).getWindowManager();
            Display display = windowManager.getDefaultDisplay();
            WindowManager.LayoutParams lp = getWindow().getAttributes();
            lp.width = display.getWidth()*4/5;
            getWindow().setAttributes(lp);
            setCanceledOnTouchOutside(true);

            for(int id:listenedItem){
                findViewById(id).setOnClickListener(this);
            }
        }
        private OnCenterItemClickListener listener;
        public interface OnCenterItemClickListener {
            void OnCenterItemClick(MyDialog1 dialog, View view);
        }

        public void setOnCenterItemClickListener(OnCenterItemClickListener listener) {
            this.listener = listener;
        }


        @Override
        public void onClick(View v) {
            dismiss();
            listener.OnCenterItemClick(this,v);
        }
    }
}
