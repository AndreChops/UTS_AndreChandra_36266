package umn.ac.uts_00000036266;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class AdapterLibrary extends RecyclerView.Adapter<AdapterLibrary.ItemLibraryViewHolder> {

    private final Context mContext;
    private final LinkedList<Library> mListLibrary;
    private final ItemClickListener mListener;

    public AdapterLibrary(Context context, LinkedList<Library> listLibrary, ItemClickListener listener){
        this.mContext = context;
        this.mListLibrary = listLibrary;
        this.mListener = listener;
    }

    class ItemLibraryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title, category;
        ImageView sound, delete;
        AdapterLibrary adapter;
        public ItemLibraryViewHolder(@NonNull View itemView, AdapterLibrary adapter) {
            super(itemView);
            this.title = itemView.findViewById(R.id.SFXTitle);
            this.category = itemView.findViewById(R.id.SFXCategory);
            this.sound = itemView.findViewById(R.id.SFXSound);
            this.delete = itemView.findViewById(R.id.SFXDelete);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            listener.goToDetailLibrary(listLibrary.get(getAdapterPosition()));
            Intent intent = new Intent(adapter.mContext, SFXLibraryActivity.class);
            intent.putExtra("library", mListLibrary.get(getAdapterPosition()));
            adapter.mContext.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public ItemLibraryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_listitem, parent, false);
        return new ItemLibraryViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemLibraryViewHolder holder, int position) {
        holder.title.setText(mListLibrary.get(position).getTitle());
        holder.category.setText(mListLibrary.get(position).getCategory());
        holder.delete.setOnClickListener(v->{
            mListener.deleteLibrary(position);
        });
    }

    @Override
    public int getItemCount() {
        return mListLibrary.size();
    }

}

