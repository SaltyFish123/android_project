package com.example.joey.lab4;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageClickListener (View view) {
        ImageView image = (ImageView)findViewById(R.id.sysu);
        final CharSequence[] items = {"拍摄", "从相册选择"};
        final AlertDialog.Builder alerdialog = new AlertDialog.Builder(this);
        alerdialog.setTitle("上传头像");
        alerdialog.setItems(items,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String str = "您选择了[" + items[which] + "]";
                        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
                    }
                });
        alerdialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), "您选择了[取消]", Toast.LENGTH_SHORT).show();
                    }
                });
        alerdialog.create();
        if (image != null) {
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    alerdialog.show();
                }
            });
        }
    }

    public void loginClickListener (View view) {
        Button button = (Button) findViewById(R.id.signIn);
        TextInputLayout input1 = (TextInputLayout) findViewById(R.id.input1);
        TextInputLayout input2 = (TextInputLayout) findViewById(R.id.input2);
        String id = input1.getEditText().getText().toString();
        String passwd = input2.getEditText().getText().toString();
        String idSuccessful = "123456";
        String passwdSuccessful = "6666";
        if (TextUtils.isEmpty(id)) {
            input1.setError("学号不能为空");
        }
        else if (TextUtils.isEmpty(passwd)) {
            input2.setError("密码不能为空");
        }
        else {
            input1.setErrorEnabled(false);
            input2.setErrorEnabled(false);
            if (id.equals("123456") && passwd.equals("6666")) {
                Snackbar.make(button, "登陆成功", Snackbar.LENGTH_SHORT).setAction("确定",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).setDuration(5000).show();

            }
            else {
                Snackbar.make(button, "学号或密码错误", Snackbar.LENGTH_SHORT).setAction("确定",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).setDuration(5000).show();
            }
        }
    }

    public void logupClickListener (View view) {
        Button button = (Button) findViewById(R.id.signUp);
        final RadioGroup rb = (RadioGroup) findViewById(R.id.radioGroup);
        int id = rb.getCheckedRadioButtonId();
        if (id != -1) {
            RadioButton temp = (RadioButton) findViewById(id);
            String str = temp.getText() + "注册功能尚未启用";
            Snackbar.make(button, str, Snackbar.LENGTH_SHORT).setAction("确定",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                        }
                    }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).setDuration(5000).show();
        }
    }

    public void radioClickListener (View view) {
        final RadioGroup button = (RadioGroup) findViewById(R.id.radioGroup);
        if (button != null) {
            button.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                    RadioButton rb = (RadioButton) group.findViewById(checkedId);
                    if (rb != null && checkedId > -1) {
                        String str = "您选择了" + rb.getText().toString();
                        Snackbar.make(rb, str, Snackbar.LENGTH_SHORT).setAction("确定",
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(getApplicationContext(), "Snackbar的确定按钮被点击了", Toast.LENGTH_SHORT).show();
                                    }
                                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).setDuration(5000).show();
                    }

                }
            });
        }
    }
}