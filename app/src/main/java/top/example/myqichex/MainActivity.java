package top.example.myqichex;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  boolean mIsExit = false;
    EditText lichengf;
    EditText shichangf;
    EditText yuantuf;
    EditText shijian;
    EditText licheng;
    EditText zongfy;
    EditText zuidixf;

    EditText youf;
    EditText baiglhy;

    TextView meiglchengbe;
    TextView zongchengbe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
		
        lichengf = (EditText)findViewById(R.id.lichengfedit);
        shichangf = (EditText)findViewById(R.id.shichangfedit);
        yuantuf = (EditText)findViewById(R.id.yuantufedit);
        shijian = (EditText)findViewById(R.id.shijianedit);
        licheng = (EditText)findViewById(R.id.lichengedit);
        zongfy = (EditText)findViewById(R.id.zongfyedit);
        zuidixf = (EditText)findViewById(R.id.zuidixfedit);
        youf = (EditText)findViewById(R.id.youfedit);
        baiglhy = (EditText)findViewById(R.id.baiglhyedit);
        meiglchengbe = (TextView)findViewById(R.id.meiglchengbetext);
        zongchengbe = (TextView)findViewById(R.id.zongchengbetext);

    }

    /*
     * 计算
     * */
    public void buttjisuan(View view)
    {
        double zhi=0;
        String strlichengf = lichengf.getText().toString();
        String strlicheng = licheng.getText().toString();
        String strshichangf = shichangf.getText().toString();
        String strshijian = shijian.getText().toString();
        String stryuantuf = yuantuf.getText().toString();
        String strzuidixf = zuidixf.getText().toString();
        //Toast toast;
        if(strlichengf.length()==0)
        {
            strlichengf="0";
            lichengf.append("0");
            Toast.makeText(getApplicationContext(), "里程费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();

        }
        if(strshichangf.length()==0)
        {
            strshichangf="0";
            shichangf.append("0");
            Toast.makeText(getApplicationContext(), "时长费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(stryuantuf.length()==0)
        {
            //System.out.println("我靠3");
            stryuantuf="0";
            yuantuf.append("0");
            Toast.makeText(getApplicationContext(), "远途费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(strshijian.length()==0)
        {
            strshijian="0";
            shijian.append("0");
            Toast.makeText(getApplicationContext(), "时间没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(strlicheng.length()==0)
        {
            strlicheng="0";
            licheng.append("0");
            Toast.makeText(getApplicationContext(), "里程没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(strzuidixf.length()==0)
        {
            strzuidixf="0";
            zuidixf.append("0");
            Toast.makeText(getApplicationContext(), "最低消费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }


        //System.out.println("我靠");
        double dlichengf = Double.parseDouble(strlichengf);
        double dlicheng = Double.parseDouble(strlicheng);
        double dshichangf = Double.parseDouble(strshichangf);
        double dshijian = Double.parseDouble(strshijian);
        double dyuantuf = Double.parseDouble(stryuantuf);
        double dzuidixf = Double.parseDouble(strzuidixf);
        zhi=dlichengf*dlicheng+dshichangf*dshijian;//里程费*里程+时长费*时间

        if(dlicheng>=7)//超7公里
            zhi+=dyuantuf*(dlicheng-7);//加远途费，远途费*里程
        if(zhi<dzuidixf)
            zhi=dzuidixf;//小于最低消费，用最低消费代替
        zongfy.setText(Double.toString(zhi));
    }
    public void buttchengbejisuan(View view)
    {
        double zhi=0,zhimeigl=0;

        String strlicheng = licheng.getText().toString();
        String strshichangf = shichangf.getText().toString();
        String strshijian = shijian.getText().toString();
        String stryuantuf = yuantuf.getText().toString();
        String stryouf = youf.getText().toString();
        String strbaiglhy = baiglhy.getText().toString();
        if(strshichangf.length()==0)
        {
            strshichangf="0";
            shichangf.append("0");
            Toast.makeText(getApplicationContext(), "时长费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(stryuantuf.length()==0)
        {
            //System.out.println("我靠3");
            stryuantuf="0";
            yuantuf.append("0");
            Toast.makeText(getApplicationContext(), "远途费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(strshijian.length()==0)
        {
            strshijian="0";
            shijian.append("0");
            Toast.makeText(getApplicationContext(), "时间没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }

        if(strlicheng.length()==0)
        {
            strlicheng="0";
            licheng.append("0");
            Toast.makeText(getApplicationContext(), "里程没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(stryouf.length()==0)
        {
            stryouf="0";
            youf.append("0");
            Toast.makeText(getApplicationContext(), "油费没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        if(strbaiglhy.length()==0)
        {
            strbaiglhy="0";
            baiglhy.append("0");
            Toast.makeText(getApplicationContext(), "百公里耗油没输入，自动填'0'了",
                    Toast.LENGTH_SHORT).show();
        }
        double dlicheng = Double.parseDouble(strlicheng);
        double dshichangf = Double.parseDouble(strshichangf);
        double dshijian = Double.parseDouble(strshijian);
        double dyuantuf = Double.parseDouble(stryuantuf);
        double dyouf = Double.parseDouble(stryouf);
        double dbaiglhy = Double.parseDouble(strbaiglhy);

        zhimeigl=dyouf*dbaiglhy/100;//平均每公里费用,油费*平均百公里耗油/100

        zhi = zhimeigl*dlicheng+dshichangf*dshijian;//平均每公里费用*里程+时长费*时间

        if(dlicheng>=7)
            zhi+=dyuantuf*(dlicheng-7);//加远途费，远途费*里程
        meiglchengbe.setText("大约每公里："+Double.toString(zhimeigl));
        zongchengbe.setText("大约总成本："+Double.toString(zhi));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id)
        {
            case R.id.action_moren:
                lichengf.setText("1.5");
                shichangf.setText("0.35");
                yuantuf.setText("0.7");
                shijian.setText("10");
                licheng.setText("2");
                zuidixf.setText("6");
                youf.setText("6.4");
                baiglhy.setText("8.8");
                break;
            case R.id.action_guanyu:
                Toast.makeText(this, "版本1.0.0\n保留所有权刘超群\nQQ1556792126", Toast.LENGTH_SHORT).show();
                break;
        }
//        if (id == R.id.action_guanyu) {
//        	return true;
//        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    /**
     * 双击返回键退出
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mIsExit) {
                this.finish();//退出Activity函数，资源没有被及时释放

            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                mIsExit = true;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mIsExit = false;
                    }
                }, 2000);
            }
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * 避免在转屏时重启Activity
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE) {
            //横向
            setContentView(R.layout.activity_main);
        } else {
            //竖向
            setContentView(R.layout.activity_main);
        }
    }
}
