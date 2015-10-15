package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Pair;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.iktwo.joke.backend.jokeApi.JokeApi;
import com.iktwo.joke.backend.jokeApi.model.JokeBean;

import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static JokeApi jokeApiService = null;
    private Context context;
    private AsyncJokeResponse requester = null;

    public EndpointsAsyncTask(Context context, AsyncJokeResponse requester) {
        this.requester = requester;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (jokeApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1099.appspot.com/_ah/api/");

            jokeApiService = builder.build();
        }

        try {
            return jokeApiService.tellJoke(new JokeBean()).execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        // Toast.makeText(context, joke, Toast.LENGTH_LONG).show();
        requester.gotJoke(joke);
    }

    public interface AsyncJokeResponse {
        void gotJoke(String joke);
    }
}