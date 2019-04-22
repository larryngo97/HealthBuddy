package cs478.larryngo.healthbuddy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ExercisesInfoFragment extends ExercisesViewFragment {

    private final String TAG = "Exercises Info";
    private ImageView iv_exercise;
    private TextView tv_header;
    private TextView tv_difficulty;
    private TextView tv_instructions;
    private Button button_website;

    private String text_header;
    private String text_difficulty;
    private String text_instructions;
    private String text_website;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_exercises_info, container, false);
        iv_exercise = (ImageView) view.findViewById(R.id.exercises_info_image);
        tv_header = (TextView) view.findViewById(R.id.exercises_info_header);
        tv_difficulty = (TextView) view.findViewById(R.id.exercises_info_difficulty);
        tv_instructions = (TextView) view.findViewById(R.id.exercises_info_instructions);
        button_website = (Button) view.findViewById(R.id.exercises_info_learnmore);

        iv_exercise.setImageResource(ExercisesViewFragment.EXTRA_EXERCISE_INFO_IMAGE);
        text_header = ExercisesViewFragment.EXTRA_EXERCISE_INFO_HEADER;
        text_difficulty = ExercisesViewFragment.EXTRA_EXERCISE_INFO_DIFFICULTY;
        text_instructions = ExercisesViewFragment.EXTRA_EXERCISE_INFO_INSTRUCTIONS;
        text_website = ExercisesViewFragment.EXTRA_EXERCISE_INFO_WEBSITE;

        tv_header.setText(text_header);
        tv_difficulty.setText(text_difficulty);
        tv_instructions.setText(text_instructions);
        //button_website.setText(text_website);

        button_website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse(text_website));
                startActivity(browser);
            }
        });
        return view;
    }

    @Override
    public void onStart() {
        Log.i(TAG, "++ ON START ++");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "++ ON RESUME ++");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "++ ON PAUSE ++");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "++ ON STOP ++");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "++ ON DESTROY ++");
        super.onDestroy();
    }
}
