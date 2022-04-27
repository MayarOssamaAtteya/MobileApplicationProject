package com.example.afinal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class WordListAdapter extends RecyclerView.Adapter<WordViewHolder> {

    private ArrayList<String> mWordList;
    private WordListAdapter mAdapter;

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used by RecyclerView.
     */
    public WordListAdapter(ArrayList<String> dataSet) {
        mWordList = dataSet;
        mAdapter = this;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.layout, viewGroup, false);

        return new WordViewHolder(view);
    }

    //Provide a reference to the type of views that you are using (custom ViewHolder).
    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        String mCurrent = mWordList.get(position);
        holder.wordItemView.setText(mCurrent);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mWordList.size();
    }
}
