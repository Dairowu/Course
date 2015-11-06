package com.suwan.course.TestThree;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.suwan.course.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private TextView info_detail;
    private Button submit, getInfo;
    private String fileName = Environment.getExternalStorageDirectory()+"/CourseDesign", storageFile = "conf.ini";
    private File rootPath;
    private static String TAG = "MainActivity";
    private boolean isFileExist = false;
    private Properties cnfPp;
    private FileInputStream in;
    private OutputStream out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*初始化相关控件*/
        doPre();

        /*获取储存卡的数据，并且检查是否已经存在文件夹<strong>CourseDesign</strong>,如果
        * 不存在则新建一个用于储存.ini文件
        * */
        isFileExist = initFile();
        if (isFileExist) {
            createFile(fileName +"/"+ storageFile);
        }
        //初始化相关的文件
        initConfigure(fileName +"/"+ storageFile);
        submit.setOnClickListener(this);
        getInfo.setOnClickListener(this);


    }


    /**
     *
     * 用于创建一个ini文件
     * @param s 文件的路径
     * @return boolean 如果创建ini文件成功则返回真
     */
    private boolean createFile(String s) {
        File dir = new File(s);
        if (!dir.exists()) {
            try {
                dir.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        return true;
    }

    /**
     * 检查储存卡是否存在，并且初始化.ini文件
     *
     * @return boolean如果初始化成功则返回真，否则返回假
     */
    private boolean initFile() {
        boolean sdcardExist = Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
        if (sdcardExist) {
            File path = new File(fileName);
            if (!path.exists()) {
                path.mkdirs();
                return true;
            }
        } else {
            Toast.makeText(getApplicationContext(), "未找到储存卡，请检查储存卡状态！！"
                    , Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    /**
     * 初始化相关控件
     */
    private void doPre() {
        editText = (EditText) findViewById(R.id.edittext1);
        info_detail = (TextView) findViewById(R.id.info_detail);
        submit = (Button) findViewById(R.id.submit);
        getInfo = (Button) findViewById(R.id.get_info);
    }


    @Override
    public void onClick(View v) {
        if(isFileExist) {
            switch (v.getId()) {
                case R.id.submit:
                    String s = editText.getText().toString();
                    if (editText.getText().toString().length()!=0) {
                        try {
                            out = new FileOutputStream(fileName +"/"+ storageFile);
                            cnfPp.setProperty("default", s);
                            cnfPp.store(out, null);
                            out.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "阿噢，出现了点小故障，请重试",
                                    Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "阿噢，出现了点小故障，请重试",
                                    Toast.LENGTH_LONG).show();
                        }

                    }else Toast.makeText(getApplicationContext(), "输入的内容为空，请重新输入！！！",
                            Toast.LENGTH_LONG).show();
                    break;
                case R.id.get_info:
                    if (cnfPp != null) {
                        String tmp = cnfPp.getProperty("default", "No content!!");
                        info_detail.setText(tmp);
                    }
                    break;
            }
        }

    }


    /**
     * 初始化并加载配置文件
     *
     * @param fileName 配置文件所在路径
     */
    private void initConfigure(String fileName) {
        if (isFileExist) {
            cnfPp = new Properties();
            try {
                in = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                cnfPp.load(in);
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
