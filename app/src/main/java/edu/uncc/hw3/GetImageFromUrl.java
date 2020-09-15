package edu.uncc.hw3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class GetImageFromUrl {

    public static ArrayList<String> getImgUrls(){
        ArrayList<String> list = new ArrayList<>();
        list.add("https://picsum.photos/id/0/5616/3744");
        list.add("https://picsum.photos/id/1/5616/3744");
        list.add("https://picsum.photos/id/10/2500/1667");
        list.add("https://picsum.photos/id/100/2500/1656");
        list.add("https://picsum.photos/id/1000/5626/3635");
        list.add("https://picsum.photos/id/1001/5616/3744");
        list.add("https://picsum.photos/id/1002/4312/2868");
        list.add("https://picsum.photos/id/1003/1181/1772");
        list.add("https://picsum.photos/id/1004/5616/3744");
        list.add("https://picsum.photos/id/1005/5760/3840");
        list.add("https://picsum.photos/id/1006/3000/2000");
        list.add("https://picsum.photos/id/1008/5616/3744");
        list.add("https://picsum.photos/id/1009/5000/7502");
        list.add("https://picsum.photos/id/101/2621/1747");
        list.add("https://picsum.photos/id/1010/5184/3456");
        list.add("https://picsum.photos/id/1011/5472/3648");
        list.add("https://picsum.photos/id/1012/3973/2639");
        list.add("https://picsum.photos/id/1013/4256/2832");
        list.add("https://picsum.photos/id/1014/6016/4000");
        list.add("https://picsum.photos/id/1015/6000/4000");
        list.add("https://picsum.photos/id/1016/3844/2563");
        list.add("https://picsum.photos/id/1018/3914/2935");
        list.add("https://picsum.photos/id/1019/5472/3648");
        list.add("https://picsum.photos/id/102/4320/3240");
        list.add("https://picsum.photos/id/1020/4288/2848");
        list.add("https://picsum.photos/id/1021/2048/1206");
        list.add("https://picsum.photos/id/1022/6000/3376");
        list.add("https://picsum.photos/id/1023/3955/2094");
        list.add("https://picsum.photos/id/1024/1920/1280");
        list.add("https://picsum.photos/id/1025/4951/3301");
        return list;
    }

    public static Bitmap getImageFromUrl(String urlStr){
        Bitmap bitmap = null;
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection)url.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            int width = 1000;
            float factor = width / (float) bitmap.getWidth();
            bitmap = Bitmap.createScaledBitmap(bitmap, width, (int) (bitmap.getHeight() * factor), true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                connection.disconnect();
            }
        }
        return bitmap;
    }



}
