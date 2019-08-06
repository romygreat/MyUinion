package myshop.comromygreat.uiautomation;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.OutputStream;

public class MainActivity extends Activity implements View.OnClickListener {
    Button button1, button2, button3;
    final String TAG = getClass().getSimpleName();
    String cmd = "am instrument -w -r   -e debug false -e class " +
            "'myshop.comromygreat.uiautomation.ExampleInstrumentedTest' " +
            "myshop.comromygreat.uiautomation.test/android.support.test.runner.AndroidJUnitRunner";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.test);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }
// am instrument -w -r   -e debug false -e class 'myshop.comromygreat.uiautomation.ExampleInstrumentedTest' myshop.comromygreat.uiautomation.test/android.support.test.runner.AndroidJUnitRunner

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                cmd = "";
                printtips("button1");
                break;
            case R.id.button2:
                printtips("button2");
                Log.i(TAG, "onClick: 222");
                break;
            case R.id.button3:
                printtips("button3");
                Log.i(TAG, "onClick:333 ");
                break;
            default:
                break;
        }
    }

    private void printtips(String str) {
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }

    public void execShell(String cmd) {
        try {
            //权限设置
            Process p = Runtime.getRuntime().exec(cmd);
            //获取输出流
            OutputStream outputStream = p.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            //将命令写入
            dataOutputStream.writeBytes(cmd);
            //提交命令
            dataOutputStream.flush();
            //关闭流操作
            dataOutputStream.close();
            outputStream.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
