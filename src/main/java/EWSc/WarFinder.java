package EWSc;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

public class WarFinder extends Thread{
    private int id;
    WarFinder(int id){this.id = id;}
    private void FindWar(int id) {
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("https://crest-tq.eveonline.com/wars/"+id+"/");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            JSONObject obj = new JSONObject(output);
            if(obj.toString().contains("99001134")&&!obj.toString().contains("timeFinished")){
            System.out.println(obj.getJSONObject("defender").getString("name"));
            App.list.add(obj);}

        } catch (Exception e) {

            e.printStackTrace();

        }
    }
    public void run(){
        FindWar(id);
    }
}
