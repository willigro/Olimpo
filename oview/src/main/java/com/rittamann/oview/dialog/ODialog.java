package com.rittamann.oview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.design.widget.BottomSheetDialog;
import android.view.View;

public class ODialog {

    public static Dialog createBootomSheet(View view) {
        if (view == null)
            throw new NullPointerException("Não é possível criar um Bottom Sheet Dialog com uma view null, passe uma view válida para continuar.");
        if (view.getContext() == null)
            throw new NullPointerException("Não é possível criar um Bottom Sheet Dialog com um context null, passe uma view com context válido para continuar.");

        Dialog dialog = new BottomSheetDialog(view.getContext());
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.show();
        return dialog;
    }

    public static Dialog createBootomSheet(Context context, int layout) {
        if (context == null)
            throw new NullPointerException("Não é possível criar um Bottom Sheet Dialog com um context null, passe uma view com context válido para continuar.");

        Dialog dialog = new BottomSheetDialog(context);
        dialog.setContentView(layout);
        dialog.setCancelable(true);
        dialog.show();
        return dialog;
    }
}
