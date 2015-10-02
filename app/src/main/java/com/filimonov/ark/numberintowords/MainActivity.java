package com.filimonov.ark.numberintowords;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private EditText inputNumber;
    private TextView outWord;
    private TranslateNum translateNum;
    private String numForResult;
    private Long numForConvert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        translateNum = new TranslateNum();

        inputNumber = (EditText) findViewById(R.id.inputText);
        outWord = (TextView) findViewById(R.id.outText);
        final Button btnTranslate = (Button) findViewById(R.id.btnTranslate);

        btnTranslate.setOnClickListener(new View.OnClickListener(){
                @Override
        public void onClick(View v){
                    if (outWord.getText().toString().equals("")){
                        String input = inputNumber.getText().toString();//получаю номер в тексте из строки текста
                        String result = input.replaceAll("\\D", "");//фильтр ввода
                        try {
                            numForConvert = Long.parseLong(result); //перевод с роки в лонг
                        }catch (NumberFormatException e){System.err.println("Wrong Type Of String");
                        }

                        numForResult = translateNum.convert(numForConvert); //обращение к второму классу

                        outWord.setText(numForResult);

                    }else {outWord.setText("");}
                }
        });

}


}


