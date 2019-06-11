package com.rittamann.oview.popup;

import android.content.Context;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;

import com.rittamann.oview.R;

public class OPopup {

    public static void deleteOrUpdate(Context context, View view, final OptionSelected optionSelected) {
        final PopupMenu popup = new PopupMenu(context, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.update_delete_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.update) {
                    optionSelected.update();
                    return true;
                } else if (item.getItemId() == R.id.delete) {
                    optionSelected.delete();
                    return true;
                }
                return false;
            }
        });
        popup.show();
    }

    public interface OptionSelected {
        void update();

        void delete();
    }
}
