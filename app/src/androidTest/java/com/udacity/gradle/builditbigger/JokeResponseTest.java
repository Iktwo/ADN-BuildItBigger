package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

public class JokeResponseTest extends AndroidTestCase implements EndpointsAsyncTask.AsyncJokeResponse {
    private static final String TAG = JokeResponseTest.class.getSimpleName();

    @Override
    public void gotJoke(String joke) {

    }

    @SuppressWarnings("unchecked")
    public void test() {
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), this);
        endpointsAsyncTask.execute();
        try {
            result = endpointsAsyncTask.get();
            Log.d(TAG, "Got a joke: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNotNull(result);
    }
}
