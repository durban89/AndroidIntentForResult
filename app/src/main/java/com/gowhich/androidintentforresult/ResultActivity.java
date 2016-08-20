package com.gowhich.androidintentforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ResultActivity extends AppCompatActivity {

    private Button backButton;
    private EditText resultInput;
    private TextView msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        backButton = (Button) this.findViewById(R.id.backbutton);
        resultInput = (EditText) this.findViewById(R.id.resultinput);
        msg = (TextView) this.findViewById(R.id.msg);

        Intent intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);

        msg.setText(a+" + "+b+" = ?");

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int c = Integer.parseInt(resultInput.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("c", c);
                //通过Intent对象返回结果,setResult方法
                setResult(2, intent);
                finish();//结束当前的activity的生命周期
            }
        });

    }
}
