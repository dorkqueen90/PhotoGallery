package edu.uncc.hw3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    TextView pageNum;
    ImageButton previous;
    ImageButton next;
    int pageCounter;
    int length;
    String newPage;
    ArrayList<String> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Photo Gallery");

        images = GetImageFromUrl.getImgUrls();
        image = findViewById(R.id.imageView);
        pageNum = findViewById(R.id.pageNumber);
        previous = findViewById(R.id.previousButton);
        next = findViewById(R.id.nextButton);
        length = images.size();
        pageCounter = 1;

        new getImage().execute(images.get(pageCounter - 1));
        newPage = pageCounter + " out of " + length;
        pageNum.setText(newPage);

        next.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pageCounter++;
                if(pageCounter > length){
                    pageCounter = 1;
                    new getImage().execute(images.get(pageCounter - 1));
                    newPage = pageCounter + " out of " + length;
                    pageNum.setText(newPage);
                }
                else {
                    new getImage().execute(images.get(pageCounter - 1));
                    newPage = pageCounter + " out of " + length;
                    pageNum.setText(newPage);
                }
            }
        });
        previous.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                pageCounter--;
                if(pageCounter <= 0){
                    pageCounter = length;
                    new getImage().execute(images.get(pageCounter - 1));
                    newPage = pageCounter + " out of " + length;
                    pageNum.setText(newPage);
                }
                else {
                    new getImage().execute(images.get(pageCounter - 1));
                    newPage = pageCounter + " out of " + length;
                    pageNum.setText(newPage);
                }
            }
        });
    }
    public class getImage extends AsyncTask<String, Void, Bitmap>{
        @Override
        protected void onPreExecute() {
            next.setVisibility(View.INVISIBLE);
            previous.setVisibility(View.INVISIBLE);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            image.setImageBitmap(bitmap);
            next.setVisibility(View.VISIBLE);
            previous.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            String url = strings[0];
            Bitmap bitmap = GetImageFromUrl.getImageFromUrl(url);
            return bitmap;
        }
    }
}