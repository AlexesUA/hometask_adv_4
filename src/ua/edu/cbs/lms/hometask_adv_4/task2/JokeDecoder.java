package ua.edu.cbs.lms.hometask_adv_4.task2;

import ua.edu.cbs.lms.hometask_adv_4.errorshandling.ErrorsHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JokeDecoder {
    private String prepositionRegex = "\\b(about|above|across|after|against|among|around|as|at" +
            "|before|behind|below|beneath|beside|between|beyond|but|by|despite|down|during" +
            "|except|for|from|in|inside|into|like|near|of|off|on|onto|out|outside|over|past" +
            "|since|through|throughout|till|to|toward|under|underneath|until|up|upon|with|within|without)\\b";

    private URL sourceFile = getClass().getResource("Source.txt");
    private Path pSourceFile; //Це я зробив, щоб подивитись, може десь в шляхах проблема для запису файла
    private URL destinationFile = getClass().getResource("Destination.txt");
    private Path pDestinationFile; //Це я зробив, щоб подивитись, може десь в шляхах проблема для запису файла

    public JokeDecoder() {
        try {
            if (!Files.exists(pSourceFile = Paths.get(sourceFile.toURI()))) {

                Files.createFile(pSourceFile);
            }
        }catch(Exception error){
            ErrorsHandling.errorsHandling(error);
        }

        try {
            if (!Files.exists(pDestinationFile = Paths.get(destinationFile.toURI()))) {

                Files.createFile(pDestinationFile);
            }
        }catch (Exception error) {
            ErrorsHandling.errorsHandling(error);
        }
    }

    public void replacePreposition(){
        //System.out.println(pSourceFile);
        //System.out.println(pSourceFile.toFile());
        //System.out.println(pDestinationFile);
        //System.out.println(pDestinationFile.toFile());

        try(BufferedReader reader = new BufferedReader(new FileReader(pSourceFile.toFile()));
                FileWriter writer = new FileWriter(pDestinationFile.toFile(), true)){
            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line.replaceAll(prepositionRegex, "Java") + "\n");
                writer.flush();
            }


        }catch (Exception error){
            ErrorsHandling.errorsHandling(error);
        }
    }

    private void printFile(Path file){
        try(BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception error){
            ErrorsHandling.errorsHandling(error);
        }
    }

    public void printSourceFile(){
        printFile(pSourceFile);
    }

    public void printDestinationFile(){
        printFile(pDestinationFile);
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
