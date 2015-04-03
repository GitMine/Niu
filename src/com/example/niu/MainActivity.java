package com.example.niu;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static String TAG = "MainActivity";

	private EditText editText_1 = null;
	private EditText editText_2 = null;
	private TextView textView = null;
	private Button button = null;

	private List<Cow> cowList = new ArrayList<Cow>();// 牛的列表，装牛（Cow对象)用的，相当于牛圈

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.editText_1 = (EditText) findViewById(R.id.edit_1);
		this.editText_2 = (EditText) findViewById(R.id.edit_2);
		this.textView = (TextView) findViewById(R.id.txt);
		this.button = (Button) findViewById(R.id.btn);

		this.button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String niu = editText_1.getText().toString().trim();
				String year = editText_2.getText().toString().trim();
				if (niu.isEmpty() || year.isEmpty()) {
					Toast.makeText(MainActivity.this, "初始牛数和年数不能为空，请输入",
							Toast.LENGTH_SHORT).show();
				} else {
					int n = Integer.valueOf(niu);
					int y = Integer.valueOf(year);
					textView.setText(countCow(n, y) + "");
				}

			}
		});

	}

	private int countCow(int niu, int year) {

		this.cowList.clear();

		for (int i = 0; i < niu; i++) {
			Cow cow = new Cow();// 造出一头牛
			cow.setAge(3);// 设置牛为3岁
			cowList.add(cow);// 将牛加入牛圈
		}

		int yearCount = year;
		// 就这样一年年过
		for (int i = 1; i <= yearCount; i++) {
			int rowNum = cowList.size();
			for (int j = 0; j < rowNum; j++) {
				Cow o = cowList.get(j);
				// 过年了
				o.addYear();
				// 能生小牛吗？
				if (o.getAge() >= 3) {
					cowList.add(new Cow());
				}
			}
		}
		Log.d(TAG, yearCount + "年后将有【" + cowList.size() + "】头牛。");
		return cowList.size();// 返回现在牛圈还有多少牛
	}

}
