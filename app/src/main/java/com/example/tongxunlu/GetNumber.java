package com.example.tongxunlu;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张晓红 on 2018/1/9.
 */
//获取通信录姓名和手机号的类
public class GetNumber {
    public static List<Phone> list=new ArrayList<>();
    public static String getNumber(Context context) {
        //判断是否打开读取权限
        if (ContextCompat.checkSelfPermission(context,android.Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{android.Manifest.permission.READ_CONTACTS},
                    1);
        }
           //获得resolver这个对象 进行查询Phone的URI
        Cursor query = context.getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        while (query.moveToNext()) {
            //字段:手机号
            String number = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Log.e("TAG", number);
            //字段:手机号姓名
            String name = query.getString(query.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            Log.e("TAG",name);
            Phone phone = new Phone(name,number);
            //添加到集合,为了显示在listview上使用
            list.add(phone);
        }
        //关闭流标,防止内存溢出
        query.close();
        return null;
    }


}
