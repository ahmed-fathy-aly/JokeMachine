package enterprises.wayne.jokeshower;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowJokeActivity extends AppCompatActivity {

    /* constants */
    public static final String EXTRA_JOKE = "extra joke";

    /**
     * @return the intent to launch this activity with a joke displayed
     */
    public static Intent getIntent(Context context, String joke) {
        Intent intent = new Intent(context, ShowJokeActivity.class);
        intent.putExtra(EXTRA_JOKE, joke);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_joke);

        // show the joke from the intent in the text view
        String joke = getIntent().getStringExtra(EXTRA_JOKE);
        TextView textView = (TextView) findViewById(R.id.text_view);
        textView.setText(joke);
    }
}
