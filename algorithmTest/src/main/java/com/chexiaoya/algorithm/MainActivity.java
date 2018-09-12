package com.chexiaoya.algorithm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Arrays;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_mao_pao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_mao_pao = (Button) findViewById(R.id.bt_mao_pao);
        bt_mao_pao.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_mao_pao:
                int[] arrays = new int[]{43, 13, 4341, 434, 11, 454, 13003, 13, 0, 5531, 134343};
                Log.d("sort", Arrays.toString(arrays));
                arrays = Sort.selectionSort(arrays);
                Log.d("sort", Arrays.toString(arrays));

                String[] arrays1 = new String[]{"a", "b", "v", "v", "a"};
                filterSurveillanceType(arrays1);
                break;
        }
    }

    private String filterSurveillanceType(String[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return null;
        }
        HashMap<String, Integer> hm = new HashMap<>();

        for (String array : arrays) {
            if (!hm.containsKey(array)) {
                hm.put(array, 1);
            } else {
                hm.put(array, hm.get(array) + 1);
            }
        }
        for (String s : hm.keySet()) {
            Log.d("sort", s + "___" + hm.get(s));
        }
        return null;
    }
}
