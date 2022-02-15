import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        List<String> agents = Files.readAllLines(Path.of("./ressources/staff.txt"));

        String filesTemplate = Files.readString(Path.of("./template/fiche.txt"));

        String[] templateSplitted = filesTemplate.split("#");

        //GENERATION DES AGENTS
        for(String agent : agents){
            try {
                List<String> agentInfos = Files.readAllLines(Path.of("./ressources/" + agent + ".txt"));

                PrintWriter writerAgent = new PrintWriter( "./website/" + agent + ".html", "UTF-8");

                String fiche = "";

                fiche = fiche + templateSplitted[0];

                fiche = fiche + agentInfos.get(0) + " " + agentInfos.get(1);

                fiche = fiche + templateSplitted[1];

                fiche = fiche + agent;

                fiche = fiche + templateSplitted[2];

                int count = 0;
                for(String objet : agentInfos) {
                    if(count >= 5) {
                        fiche = fiche + templateSplitted[3];
                        fiche = fiche + objet;
                        fiche = fiche + templateSplitted[4];
                    }
                    count ++;
                }

                fiche = fiche + templateSplitted[5];

                writerAgent.println(fiche);

                writerAgent.close();

            }catch(Exception e) {
                System.out.println("Aucun fichier " + agent + " trouve");
            }

        }

        //GENERATION DE LA LISTE DES AGENTS
        String indexTemplate = Files.readString(Path.of("./template/index.txt"));
        String[] indexTemplateSplitted = indexTemplate.split("#");

        PrintWriter writerIndex = new PrintWriter( "./website/index.php", "UTF-8");

        String fiche = "";

        fiche = fiche + indexTemplateSplitted[0];

        for(String agent : agents) {
            fiche = fiche + indexTemplateSplitted[1];

            fiche = fiche + agent;

            fiche = fiche + indexTemplateSplitted[2];

            fiche = fiche + agent;

            fiche = fiche + indexTemplateSplitted[3];
        }

        fiche = fiche + indexTemplateSplitted[4];

        writerIndex.println(fiche);

        writerIndex.close();

    }
}