
package com.example.afinal;


import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class WordViewHolder extends RecyclerView.ViewHolder {
    public final TextView wordItemView;
    public WordViewHolder(View view) {
        super(view);
        wordItemView = (TextView) view.findViewById(R.id.haircaretxt);
    }
}
