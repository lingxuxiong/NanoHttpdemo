package com.neil.nanohttpdemo.server;

import android.util.Log;

import org.nanohttpd.protocols.http.IHTTPSession;
import org.nanohttpd.protocols.http.response.Response;
import org.nanohttpd.router.RouterNanoHTTPD;

import java.io.IOException;

/**
 * Created by neil on 12/02/2018.
 */

public class MyServer extends RouterNanoHTTPD {

    private static final String LOG_TAG = "MyServer";

    public final static int PORT = 9090;

    public  MyServer() throws IOException {
        super(PORT);
        start();
        Log.d(LOG_TAG, "Running! Point your browers to http://localhost:" + PORT);
    }

    public MyServer(int port) throws IOException {
        super(port);
        start();
        Log.d(LOG_TAG, "Running! Point your browers to http://localhost:" + port);
    }

    public MyServer(String hostname, int port) throws IOException {
        super(hostname, port);
        start();
        Log.d(LOG_TAG, "Running! Point your browers to http://" + hostname + ":" + PORT);
    }

    @Override
    public Response serve(IHTTPSession session) {
        String msg = "<html><body><h1>Hello server</h1>\n";
        msg += "<p>We serve " + session.getUri() + " !</p>";
        return Response.newFixedLengthResponse( msg + "</body></html>\n" );
    }

}
