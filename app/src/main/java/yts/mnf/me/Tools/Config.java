package yts.mnf.me.Tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by muneef on 21/01/17.
 */

public class Config {

    //public static String ListUrl = "https://yts.ag/api/v2/list_movies.json";
    private static String TAG = "Config";
    public static int dpToPx(int dp, Context c) {

        Resources r = c.getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    public static void loadImage(final ImageView imageView, String url){
        Log.e(TAG,"loadImage = "+url);
        final Context c = imageView.getContext();

        Glide.with(imageView.getContext())
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView);

    /*  Picasso
                .with(imageView
                .getContext())
                .load(url+"")
                .placeholder(R.mipmap.star_off)
                .error(R.mipmap.imdb)
                .into(imageView, new Callback() {
            @Override
            public void onSuccess() {
               // holder.mMediaEvidencePb.setVisibility(View.GONE);
                Log.e(TAG,"succes loading image  ");

            }

            @Override
            public void onError() {
                Log.e(TAG,"error loading image  ");

            }
        });
*/



    /*    Picasso.Builder builder = new Picasso.Builder(imageView.getContext());
        builder.listener(new Picasso.Listener()
        {
            @Override
            public void onImageLoadFailed(Picasso picasso, Uri uri, Exception exception)
            {
                exception.printStackTrace();
                Log.e(TAG,"error loading image = "+exception.getMessage());
            }

        });
        builder.build().load(url)
                .placeholder(R.mipmap.star_off)
                .error(R.mipmap.imdb)
                .into(imageView);
*/


    }

    public static int manipulateColor(int color, float factor) {
        int a = Color.alpha(color);
        int r = Math.round(Color.red(color) * factor);
        int g = Math.round(Color.green(color) * factor);
        int b = Math.round(Color.blue(color) * factor);
        return Color.argb(a,
                Math.min(r,255),
                Math.min(g,255),
                Math.min(b,255));
    }
}