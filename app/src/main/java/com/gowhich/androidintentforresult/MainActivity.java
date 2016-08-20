package com.gowhich.androidintentforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText input1;
    private EditText input2;
    private EditText result;

    public static final int REQUESTCODE = 1;//返回的结果码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) this.findViewById(R.id.button);
        input1 = (EditText) this.findViewById(R.id.input1);
        input2 = (EditText) this.findViewById(R.id.input2);
        result = (EditText) this.findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(input1.getText().toString());
                int b = Integer.parseInt(input2.getText().toString());
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("a", a);
                intent.putExtra("b", b);

                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 2){
            if(requestCode == REQUESTCODE){
                int c = data.getIntExtra("c", 0);
                result.setText(String.valueOf(c));
            }
        }

    }
}
