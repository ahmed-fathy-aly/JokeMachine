/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.ahmed.myapplication.backend;

import com.example.JokeGenerator;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.ahmed.example.com",
                ownerName = "backend.myapplication.ahmed.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that makes a joke from the joke generator
     */
    @ApiMethod(name = "joke")
    public MyBean sayHi() {
        MyBean response = new MyBean();
        String joke = JokeGenerator.getJoke();
        response.setData(joke);
        return response;
    }

}
