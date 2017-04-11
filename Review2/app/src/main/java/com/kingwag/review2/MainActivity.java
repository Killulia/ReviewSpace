package com.kingwag.review2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AbsListView.OnScrollListener.SCROLL_STATE_FLING;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView listView;
    private List<String> list;
    private String[] strings = {"sfd", "Sdfw", "werdwe", "Werw", "yhrt", "Sdf", "werwe", "dfsd",
            "Wer", "hrth", "sdfs", "dfbd", "Er", "Er", "Er", "Er", "Er", "Er", "Er", "Er", "Er", "Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er","Er",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ExpandableListView) findViewById(R.id.expanded_menu);
//        list = new ArrayList<>();
//       for (int i=0;i<strings.length;i++){
//           list.add(strings[i]);
//       }
//        ListAdapter adapter = new ListAdapter(this,list);
//        listView.setAdapter(adapter);
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(AbsListView absListView, int i) {
//               if (i==2){
//                   Toast.makeText(MainActivity.this,"fling",Toast.LENGTH_SHORT).show();
//               }
//            }
//
//            @Override
//            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
//
//            }
//        });
//
//    }
        List<MyGroup> groupList = new ArrayList<>();
        MyChild child11 = new MyChild("11");
        MyChild child12 = new MyChild("12");
        MyChild child13 = new MyChild("13");
        List<MyChild> childList1 = new ArrayList<>();
        childList1.add(child11);
        childList1.add(child12);
        childList1.add(child13);
        MyGroup group1 = new MyGroup(childList1,"一组");

        List<MyChild> childList2 = new ArrayList<>();
        MyChild child21 = new MyChild("21");
        MyChild child22 = new MyChild("22");
        MyChild child23 = new MyChild("23");
        childList2.add(child21);
        childList2.add(child22);
        childList2.add(child23);
        MyGroup group2 = new MyGroup(childList2,"二组");

        groupList.add(group1);
        groupList.add(group2);

        ExAdapter adapter = new ExAdapter(this, groupList);
        listView.setAdapter(adapter);

    }
}
