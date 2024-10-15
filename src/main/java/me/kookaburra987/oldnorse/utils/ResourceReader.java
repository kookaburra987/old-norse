package me.kookaburra987.oldnorse.utils;

import me.kookaburra987.oldnorse.utils.exceptions.FailedToReadResource;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

import static me.kookaburra987.oldnorse.utils.Assert.notBlank;

public class ResourceReader {

    public String readTextFile(String name){
        URL resource = this.getClass().getClassLoader().getResource(name);

        if (resource == null){
            throw new FailedToReadResource("Resource file not found: " + name);
        }

        try {
            return IOUtils.toString(resource, Charset.defaultCharset());
        } catch (IOException e) {
            throw new FailedToReadResource("Failed to read: " + name, e);
        }
    }

    public String[] readLinesOfTextFile(String name){
        notBlank(name, "name is null");

        String content = readTextFile(name);
        return content.split("\n");
    }
}
