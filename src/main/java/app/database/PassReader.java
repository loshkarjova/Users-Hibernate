package app.database;

import app.utils.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PassReader {

    public static String readPass(){
        String fileName = "user_pass.txt";
        try{
            return Files.readString(Path.of(Constants.PATH_CREDS + fileName)).replace("\n","");
        }catch (IOException e){
            return e.getMessage();
        }
    }
}
