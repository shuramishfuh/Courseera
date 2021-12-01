package Implementations;

import CoreInterfaces.Downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class IMDownloader implements Downloader {

    /*
     * @param url : url to download content from
     *
     * @param file : file path to store downloaded content
     *
     * downloadHtmlToFile take a url and a file path downloads html page from url
     * and s
     */
    public void downloadHtmlToFile(String url, String file) {
        try {
            URL urL = new URL(url);
            ReadableByteChannel readableByteChannel = Channels.newChannel(urL.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            fileOutputStream.close();
        } catch (MalformedURLException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}