package sematech.training.Drafts.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import sematech.training.Models.Book;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyImageView;
import sematech.training.custom_views.MyTextView;
import sematech.training.utils.Publics;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder> {
    List<Book> books;
    Context mContext;

    public RecyclerAdapter(Context mContext, List<Book> books) {
        this.books = books;
        this.mContext = mContext;
    }

    class Holder extends RecyclerView.ViewHolder {
        //bind widget and values
        MyImageView img;
        MyTextView name;
        MyButton remove;

        public Holder(View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img_recycler_items);
            name = itemView.findViewById(R.id.name_recycler_items);
            remove = itemView.findViewById(R.id.remove);

            remove.setOnClickListener(V->{
                removeItem(getAdapterPosition());
            });

            img.setOnClickListener(V->{
                Book selectedBook = books.get(getAdapterPosition());
                Publics.toast("img of : "+selectedBook.getName());
            });

            name.setOnClickListener(V->{
                Book selectedBook = books.get(getAdapterPosition());
                Publics.toast("name of :"+selectedBook.getName());
            });
        }
    }

    @Override
    public RecyclerAdapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //bind and inflate layout
        View v = LayoutInflater.from(mContext).inflate(R.layout.book_recycler_item, viewGroup, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.Holder holder, int position) {
        //set values
        holder.name.setText(books.get(position).getName());
        holder.img.load(books.get(position).getImageURL());
    }
    public void addItem(Book bk){
        books.add(bk);
        notifyDataSetChanged();
    }
    public void removeItem(int index){
        books.remove(index);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return books.size();
    }
}
