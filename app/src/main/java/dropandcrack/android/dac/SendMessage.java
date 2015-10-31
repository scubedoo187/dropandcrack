package dropandcrack.android.dac;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SendMessage extends Activity {

    EditText et;
    Button sendBtn;
    Button exitBtn;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmassage);

        et = (EditText)findViewById(R.id.editText);
        sendBtn = (Button)findViewById(R.id.sendbtn);
        exitBtn = (Button)findViewById(R.id.exitbtn);
    }

    public void mOnClick(View v){
        switch(v.getId()){
            case R.id.sendbtn:

            case R.id.exitbtn:
                finish();
            default:
        }
    }
}
