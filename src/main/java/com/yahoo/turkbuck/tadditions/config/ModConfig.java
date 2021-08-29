package com.yahoo.turkbuck.tadditions.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;

public class ModConfig {

    private static final File folder = new File("config");
    private static File configFile;
    private static final Gson config = new GsonBuilder().setPrettyPrinting().create();
    public static ConfigInstance INSTANCE;

    public static void init() {
        loadDefaults();
        generateFoldersAndFiles();
        readJson();
        writeJson();
    }

    public static void loadDefaults() {
        INSTANCE = new ConfigInstance();
    }

    public static void generateFoldersAndFiles() {
        if (!folder.exists()) {
            folder.mkdir();
        }

        if (folder.isDirectory()) {
            configFile = new File(folder, "tadditions.json");
            if (!configFile.exists()) {
                System.out.println("Creating config file");

                try {
                    configFile.createNewFile();
                    loadDefaults();
                    String json = config.toJson(INSTANCE);
                    FileWriter writer = new FileWriter(configFile);
                    writer.write(json);
                    writer.close();
                } catch (IOException var2) {
                    throw new IllegalStateException("Can't create config file", var2);
                }
            } else if (configFile.isDirectory()) {
                throw new IllegalStateException("'tadditions.json' must be a file!");
            }

        } else {
            throw new IllegalStateException("'config' must be a folder!");
        }
    }

    public static void readJson() {
        try {
            INSTANCE = (ConfigInstance)config.fromJson(new FileReader(configFile), ConfigInstance.class);
            if (INSTANCE == null) {
                throw new IllegalStateException("Null configuration");
            }
        } catch (JsonSyntaxException var1) {
            System.err.println("Invalid configuration!");
            var1.printStackTrace();
        } catch (JsonIOException var2) {
            var2.printStackTrace();
        } catch (FileNotFoundException var3) {
        }

    }

    public static void writeJson() {
        try {
            String json = config.toJson(INSTANCE);
            FileWriter writer = new FileWriter(configFile, false);
            writer.write(json);
            writer.close();
        } catch (IOException var2) {
            throw new IllegalStateException("Can't update config file", var2);
        }
    }

}
