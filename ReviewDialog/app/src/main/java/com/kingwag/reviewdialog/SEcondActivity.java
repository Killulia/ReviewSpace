package com.kingwag.reviewdialog;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SEcondActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Context context = this;
         imageView = (ImageView) findViewById(R.id.iv_image);
        Intent intent = getIntent();
        int as = intent.getIntExtra("main", 0);
        Log.d("kingwag", String.valueOf(as));
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*loader = new ImageLoader(imageView,"http://imgsrc.baidu.com/forum/w%3D580%3Bcp%3Dtieba%2C10%2C791%3Bap%3D%BA%DA%BB%AF%C6%E6%A0%EB%B0%C9%2C90%2C799/sign=a59e12df13dfa9ecfd2e561f52eb9473/ed2468c27d1ed21b59b95e26af6eddc450da3f35.jpg"
                        );
                loader.execute();*/
                ImageLoader loader = new ImageLoader();
                loader.
                        setImageUrl("http://imgsrc.baidu.com/forum/w%3D580%3Bcp%3Dtieba%2C10%2C791%3Bap%3D%BA%DA%BB%AF%C6%E6%A0%EB%B0%C9%2C90%2C799/sign=a59e12df13dfa9ecfd2e561f52eb9473/ed2468c27d1ed21b59b95e26af6eddc450da3f35.jpg").
                        setIvPhoto(imageView).
                        execute();

               /* Intent intent1 = new Intent();
                intent1.putExtra("second", "from 2");
                setResult(200,intent1);
                finish();*/
            }
        });

    }
}
