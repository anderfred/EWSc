package EWSc;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;

class MaxWars {
     static void MaxWarsCount(){
        try {

            Client client = Client.create();

            WebResource webResource = client
                    .resource("https://crest-tq.eveonline.com/wars/");

            ClientResponse response = webResource.accept("application/json")
                    .get(ClientResponse.class);

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            String output = response.getEntity(String.class);

            JSONObject obj = new JSONObject(output);
            App.totalWarsCount = obj.getInt("totalCount_str");
        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
