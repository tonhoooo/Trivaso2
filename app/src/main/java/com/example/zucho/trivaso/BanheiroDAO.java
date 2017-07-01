package com.example.zucho.trivaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import org.json.*;

/**
 *
 * @author eduardo
 */
public class BanheiroDAO {

    private static String serverURL = "http://177.44.248.141/trivaso/WebserviceAPI.php?acao=";

    public static ArrayList<Banheiro> getBanheiros() throws IOException {
        String aux = getResponse(serverURL + "listarBanheiros");
        //System.out.println(aux);
        //aux = aux.replaceAll("[\\[\\]]", "");
        aux = aux.substring(1, aux.length()-2);
        //System.out.println(aux);
        String[] strArray = new String[100];
        strArray = aux.split("},");
        ArrayList<Banheiro> banheiros = new ArrayList<Banheiro>();
        for(String s:strArray) {
            //System.out.println(s + "}");
            banheiros.add(JSONtoBanheiro(s + "}"));
        }
        return banheiros;
    }

    public static Banheiro getBanheiroByID(int id) throws IOException {
        String resp = getResponse(serverURL + "listarBanheirosId&bid=" + id);
        return JSONtoBanheiro(resp);
    }

    //incluirBanheiro&bnome="Univates prédio 6"&bdescricao="Banheiro muito bom com suporte a deficientes."&blat=37.323455&blong=89.344334
    public static Banheiro adicionaBanheiro(Banheiro banheiro) throws IOException{
        String targetURL = serverURL + "incluirBanheiro"
                + "&bnome=" + banheiro.getNome()
                + "&bdescricao=" + banheiro.getDescricao()
                + "&blat=" + Float.toString(banheiro.getLat())
                + "&blon=" + Float.toString(banheiro.getLon());
        targetURL = targetURL.replaceAll(" ", "%20");
        return JSONtoBanheiro(getResponse(targetURL));
    }

    private static Banheiro JSONtoBanheiro(String strJSON){
        String strBanheiro = strJSON.replaceAll("[\\[\\]]", "");
        JSONObject banheiroJSON = null;
        try {
            banheiroJSON = new JSONObject(strBanheiro);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Banheiro banheiro = new Banheiro();
        try {
            banheiro.setId_banheiro(banheiroJSON.getInt("id_banheiro"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            banheiro.setNome(banheiroJSON.getString("nome"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            banheiro.setDescricao(banheiroJSON.getString("descricao"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //banheiro.setMedia(banheiroJSON.getDouble("media"));
        //banheiro.setLat(banheiroJSON.getFloat("lat"));
        //banheiro.setLon(banheiroJSON.getFloat("lon"));
        return banheiro;
    }

    private static String getResponse(String targetURL) throws IOException {
        String resp = "";
        URL url = new URL(targetURL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = null;
        while ((line = rd.readLine()) != null){
            resp += line;
        }
        resp = resp.replaceFirst("  ", "");
        return resp;
    }
}