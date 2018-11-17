package sematech.training.Drafts.recycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import sematech.training.Models.Book;
import sematech.training.R;
import sematech.training.custom_views.MyButton;
import sematech.training.custom_views.MyEditText;
import sematech.training.utils.BaseActivity;
import sematech.training.utils.BaseApplication;

public class RecyclerActivity extends BaseActivity {
    RecyclerView recycler;
    MyEditText word;
    String TAG = "filter_";
    List<Book> books;
    MyButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        bind();
        books = new ArrayList<>();

        books.add(new Book("Java", "https://findicons.com/files/icons/1008/quiet/128/java.png"));
        books.add(new Book("Android", "https://findicons.com/files/icons/2796/metro_uinvert_dock/128/os_android.png"));
        books.add(new Book("Php", "https://findicons.com/files/icons/1620/crystal_project/128/php.png"));

        books.add(new Book("Java", "https://findicons.com/files/icons/1008/quiet/128/java.png"));
        books.add(new Book("Android", "https://findicons.com/files/icons/2796/metro_uinvert_dock/128/os_android.png"));
        books.add(new Book("Php", "https://findicons.com/files/icons/1620/crystal_project/128/php.png"));

        books.add(new Book("Java", "https://findicons.com/files/icons/1008/quiet/128/java.png"));
        books.add(new Book("Android", "https://findicons.com/files/icons/2796/metro_uinvert_dock/128/os_android.png"));
        books.add(new Book("Php", "https://findicons.com/files/icons/1620/crystal_project/128/php.png"));

        books.add(new Book("Java", "https://findicons.com/files/icons/1008/quiet/128/java.png"));
        books.add(new Book("Android", "https://findicons.com/files/icons/2796/metro_uinvert_dock/128/os_android.png"));
        books.add(new Book("Php", "https://findicons.com/files/icons/1620/crystal_project/128/php.png"));

        RecyclerAdapter adapter = new RecyclerAdapter(mContext, books);
        recycler.setAdapter(adapter);

        add.setOnClickListener(V -> {
            adapter.addItem(new Book("Windows","https://findicons.com/files/icons/734/phuzion/128/windows.png"));
        });

        word.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence input, int start, int before, int count) {
                Log.d(TAG, "onTextChanged: " + input);
                filterRecycler(input.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    void filterRecycler(String word) {
        List<Book> tempListBooks = new ArrayList<>();
        for (Book bk : books)
            if (bk.getName().toLowerCase().contains(word.toLowerCase()))
                tempListBooks.add(bk);

        if (tempListBooks.size() > 0) {
            RecyclerAdapter adapter = new RecyclerAdapter(mContext, tempListBooks);
            recycler.setAdapter(adapter);
        }
    }

    private void bind() {
        recycler = findViewById(R.id.recycler);
        word = findViewById(R.id.word);
        add = findViewById(R.id.add);

    }
}
