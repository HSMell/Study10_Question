package com.example.study10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    EditText editText2;
    Button setButton;
    Button closeButton;
    RadioButton radioButton;
    RadioButton radioButton2;

    //@SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView)findViewById(R.id.imageView);
        imageView2 = (ImageView)findViewById(R.id.imageView2);


        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

        setButton = (Button)findViewById(R.id.set);
        closeButton = (Button)findViewById(R.id.close);

        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioButton = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);




        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Singer aeYong = new Singer();
                aeYong.name = editText.getText().toString();
                aeYong.age = editText2.getText().toString();


                Singer takeALook = new Singer();
                takeALook.name = editText.getText().toString();
                takeALook.age = editText2.getText().toString();

        if(isNumber(aeYong.name) == true)
        {
            Toast.makeText(MainActivity.this," 문자를 입력해주세요",Toast.LENGTH_SHORT).show();
        }

        else if(isNumber(aeYong.age) == false){
            Toast.makeText(MainActivity.this,"숫자를 입력해주세요",Toast.LENGTH_SHORT).show();
        }
        
                switch (radioGroup.getCheckedRadioButtonId()) {
                    case R.id.radioButton1:
                        imageView1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, aeYong.name +" " + aeYong.age,Toast.LENGTH_SHORT).show();
                            }
                        });
                        Toast.makeText(MainActivity.this," 첫번째 이미지에 설정", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.radioButton2:
                        imageView2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, takeALook.name +" " + takeALook.age,Toast.LENGTH_SHORT).show();
                            }
                        });
                        Toast.makeText(MainActivity.this," 두번째 이미지에 설정", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });


        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // 예    외처리 : 문자가 입력되었을때에 관한 예외처리
    public static boolean isNumber(String s){
        try{
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    class Singer {


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
        String name;
        String age;
    }
}