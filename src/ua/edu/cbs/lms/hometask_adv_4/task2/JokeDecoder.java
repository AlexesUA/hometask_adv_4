package ua.edu.cbs.lms.hometask_adv_4.task2;

import ua.edu.cbs.lms.hometask_adv_4.errorshandling.ErrorsHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;

public class JokeDecoder {
    private String prepositionRegex = "\\b(about|above|across|after|against|among|around|as|at" +
            "|before|behind|below|beneath|beside|between|beyond|but|by|despite|down|during" +
            "|except|for|from|in|inside|into|like|near|of|off|on|onto|out|outside|over|past" +
            "|since|through|throughout|till|to|toward|under|underneath|until|up|upon|with|within|without)\\b";

    private URL sourceFile = getClass().getResource("Source.txt");
    private URL destinationFile = getClass().getResource("Destination.txt");

    public JokeDecoder(){

    }

    public void replacePreposition(){
        try(BufferedReader reader = new BufferedReader(new FileReader(sourceFile.getPath()));
                FileWriter writer = new FileWriter(destinationFile.getPath(), true)){
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line.replaceAll(prepositionRegex, "Java"));
            }
            writer.flush();

        }catch (Exception error){
            ErrorsHandling.errorsHandling(error);
        }
    }

    private void printFile(URL file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file.getPath()))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception error){
            ErrorsHandling.errorsHandling(error);
        }
    }

    public void printSourceFile(){
        printFile(sourceFile);
    }

    public void printDestinationFile(){
        printFile(destinationFile);
    }

    public void clearDestinationFile(){

        try(FileWriter writer = new FileWriter(destinationFile.getPath(), false)){
            writer.write("");
            writer.flush();
        }catch (Exception error){
            ErrorsHandling.errorsHandling(error);
        }
    }

}