package com.sallen.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.text.Selection;

public class MainActivity extends AppCompatActivity {
    Button loginButton;
    EditText userNameText;
    EditText passwordText;
    private final int maxInputNumer = 11;
    private CharSequence temp;//监听前的文本
    private int editStart;//光标开始位置
    private int editEnd;//光标结束位置

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = (Button) findViewById(R.id.loginButton);
        userNameText = (EditText) findViewById(R.id.userNameText);
        passwordText = (EditText) findViewById(R.id.passwordText);

        //限制密码输入20位
        passwordText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});


        //监听用户名输入
        userNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                Editable editable = userNameText.getText();
                int len = editable.length();

                if(len > maxInputNumer)
                {
                    int selEndIndex = Selection.getSelectionEnd(editable);
                    String str = editable.toString();
                    //截取新字符串
                    String newStr = str.substring(0,maxInputNumer);
                    userNameText.setText(newStr);
                    editable = userNameText.getText();

                    //新字符串的长度
                    int newLen = editable.length();
                    //旧光标位置超过字符串长度
                    if(selEndIndex > newLen)
                    {
                        selEndIndex = editable.length();
                    }
                    //设置新光标所在的位置
                    Selection.setSelection(editable, selEndIndex);

                }

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userNameText.getText().length() == 0) {

                    Toast.makeText(MainActivity.this, "请输入账号", Toast.LENGTH_SHORT).show();

                } else if (passwordText.getText().length() == 0) {

                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();

                } else {

                    //类名跳转activity
                    Intent ac = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(ac);


                }
            }
        });




    }

}
