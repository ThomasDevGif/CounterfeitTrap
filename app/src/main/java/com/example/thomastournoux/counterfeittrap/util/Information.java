package com.example.thomastournoux.counterfeittrap.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Toast;

import com.example.thomastournoux.counterfeittrap.R;

public class Information {

    private static final SparseIntArray COLORS = new SparseIntArray();
    public static final int ALERT = 1;
    public static final int INFO = 2;
    public static final int SUCCESS = 3;

    static {
        COLORS.put(ALERT, R.color.snackBar_error);
        COLORS.put(INFO, R.color.snackBar_info);
        COLORS.put(SUCCESS, R.color.snackBar_sucess);
    }

    public static void showToast(Context context, String text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * Create snackbar.
     *
     * @param activity  activity to display snackbar
     * @param message the message of the snack
     * @param typeInformation color of the snackbar
     * @param duration  duration of the snackbar
     * @param actionTitle  action title in snackbar
     * @param listener  listener for action in snackbar
     */
    public static void createSnackBar(Activity activity,
                                      String message,
                                      int typeInformation,
                                      int duration,
                                      String actionTitle,
                                      View.OnClickListener listener) {
        Snackbar snack
                = Snackbar.make(activity.findViewById(android.R.id.content), message, duration);
        snack.getView().setBackgroundResource(COLORS.get(typeInformation));
        snack.setActionTextColor(Color.WHITE);
        snack.setAction(actionTitle, listener);
        snack.show();
    }
}
