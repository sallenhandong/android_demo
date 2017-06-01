package com.sallen.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private ListView listView;
    //首先还是要声明一个SimpleAdapter适配器
    private SimpleAdapter simpleAdapter;
    //然后声明一个List数组，里面用Map数组作为填充数据源的方式
    private List<Map<String, Object>> dataList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = (ListView) findViewById(R.id.listView);
        dataList = new ArrayList<Map<String, Object>>();
        /*将数据源添加到适配器，这里有5个参数
        1. 第一个参数还是Context，这里填入this。
        2. 第二个参数是data(数据源)，这里我们将填充数据的步骤写成方法getData(),填入即可。
        3. 第三个参数是resource，也就是列表项的布局文件，这里我们就要自己新建一个layout文件了
        4. 第四个参数是frome，是Map中的键名
        5. 第五个参数是to，绑定数据视图中的ID，与frome形成对应关系*/
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.home, new String[]{"pic", "text"},
                new int[]{R.id.pic, R.id.text});
        //为listView绑定适配器即可
        listView.setAdapter(simpleAdapter);
    }

    //这里我们定义一个参数用来为dataList填充数据
    private List<Map<String, Object>> getData() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("pic", R.mipmap.dola);
            dataList.add(map);
        }
        return dataList;
    }
}
