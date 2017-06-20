package com.example.zucho.trivaso;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Created by zucho on 19/06/2017.
 */

public class BanheiroDAO {
    private static final String NAMESPACE = "http://localhost/WebServer/index.php";
    private static final String URL = "http://localhost/WebServer/index.php";
    private static final String METHOD_NAME_LOGIN = "hello";
    private static final String SOAP_ACTION_LOGIN = "http://localhost/WebServer/index.php#hello";



    private String getWebServiceResponse(String parametro) {
        String resp = "";
        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME_LOGIN);
        request.addProperty("name", parametro);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(request);
        HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
        try {
            androidHttpTransport.call(SOAP_ACTION_LOGIN, envelope);
            resp = (String) envelope.getResponse();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }
}