import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        List<String> test = []
        List<String> agents = Files.readAllLines(Path.of("./ressources/staff.txt"));

        String filesTemplate = Files.readString(Path.of("./template/fiche.txt"));

        String[] templateSplitted = filesTemplate.split("#");

        //GENERATION DES AGENTS + API
        for(String agent : agents){
            try {
                List<String> agentInfos = Files.readAllLines(Path.of("./ressources/" + agent + ".txt"));

                PrintWriter writerAgent = new PrintWriter( "./website/" + agent + ".html", "UTF-8");
                PrintWriter writerAgentApi = new PrintWriter( "./api/get" + agent + ".txt", "UTF-8");

                String AgentJson = "{\"prenom\": \"";
                String fiche = "";
                
                fiche = fiche + templateSplitted[0];

                AgentJson += agentInfos.get(0);
                AgentJson += "\",\"nom\": \"";
                AgentJson += agentInfos.get(1);
                AgentJson += "\",\"role\": \"";
                AgentJson += agentInfos.get(2);
                AgentJson += "\",\"mdp\": \"";
                AgentJson += agentInfos.get(3);
                AgentJson += "\",\"objets\": [";



                fiche = fiche + agentInfos.get(0) + " " + agentInfos.get(1);

                fiche = fiche + templateSplitted[1];

                fiche = fiche + agent;

                fiche = fiche + templateSplitted[2];

                int count = 0;
                for(String objet : agentInfos) {
                    if(count >= 5) {
                        AgentJson += "\"" + objet;
                        AgentJson += "\", ";

                        fiche = fiche + templateSplitted[3];
                        fiche = fiche + objet;
                        fiche = fiche + templateSplitted[4];
                    }
                    count ++;
                }

                AgentJson = AgentJson.substring(0, AgentJson.length() -2);

                AgentJson += "]}";

                fiche = fiche + templateSplitted[5];

                writerAgent.println(fiche);
                writerAgentApi.println(AgentJson);

                writerAgent.close();
                writerAgentApi.close();

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


    public class Agent {
        public String Nom;

        public String Prenom;

        public List<String> Objets;
    }
}