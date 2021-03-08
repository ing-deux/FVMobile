package uci.fvm.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import uci.fvm.MainActivity;
import uci.fvm.R;
import uci.fvm.adapter.BookItemAdapter;
import uci.fvm.model.Book;

/**
 * Created by Diosbel E. Lima on 08/04/2017.
 */

public class FragmentBook extends Fragment {
    private RecyclerView recyclerView;
    private BookItemAdapter adapter;

    public FragmentBook() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Book> bookList = MainActivity.getBooks();
        adapter = new BookItemAdapter(getContext(), bookList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_book, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_tab);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return rootView;
    }

}

