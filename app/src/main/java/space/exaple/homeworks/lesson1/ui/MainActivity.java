package space.exaple.homeworks.lesson1.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import space.exaple.homeworks.R;
import space.exaple.homeworks.lesson1.domain.Content;
import space.exaple.homeworks.lesson1.ui.adapters.CustomContentAdapter;
import space.exaple.homeworks.lesson1.ui.adapters.EmojiAdapter;

public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener, CustomContentAdapter.Listener {
    private CustomContentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomContentGame contentGame = new CustomContentGame(this);
        adapter = new CustomContentAdapter(this, contentGame);
        RecyclerView recyclerView = findViewById(R.id.cards);
        recyclerView.setAdapter(adapter);

        Content content = new Content(1, "card1", 12);
        Content content1 = new Content(1, "card1", 12);
        Log.d("tag", String.valueOf(content.equals(content1)));
    }

    @Override
    public void onCardClick() {
        adapter.notifyDataSetChanged();
    }
}