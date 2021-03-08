package uci.fvm.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uci.fvm.BookActivity;
import uci.fvm.R;
import uci.fvm.model.Book;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class BookItemAdapter extends RecyclerView.Adapter<BookItemAdapter.MyViewHolder>{
    private List<Book> bookList;
    private Context mContext;

    public BookItemAdapter(Context mContext, List<Book> bookList){
        this.bookList=bookList;
        this.mContext=mContext;
    }

    @Override
    public BookItemAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.general_card, parent, false);

        return new BookItemAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BookItemAdapter.MyViewHolder holder, int position) {
        final Book book=bookList.get(position);
        holder.book_title.setText(book.getName());
        holder.book_description.setText(book.getDescription());
        holder.book_cover.setImageResource(book.getThumbnail());
        holder.book_gender.setText(book.getGender());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(mContext, BookActivity.class);
                i.putExtra("name", book.getName());
                i.putExtra("desc", book.getDescription());
                i.putExtra("gender", book.getGender());
                i.putExtra("img", book.getThumbnail());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(bookList.isEmpty()){
            return 0;
        }
        else{
            return bookList.size();
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView book_title;
        public TextView book_description;
        public TextView book_gender;
        public ImageView book_cover;


        public MyViewHolder(final View itemView) {
            super(itemView);
            book_title=(TextView)itemView.findViewById(R.id.text_principal);
            book_description=(TextView)itemView.findViewById(R.id.text_description);
            book_gender=(TextView)itemView.findViewById(R.id.text_secondary);
            book_cover=(ImageView)itemView.findViewById(R.id.image_background);
        }
    }
}
