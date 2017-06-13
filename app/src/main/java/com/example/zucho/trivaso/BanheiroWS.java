package com.example.zucho.trivaso;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * Created by zucho on 12/06/2017.
 */

public class BanheiroWS {

    public BanheiroWS(){

    }

    public int add(String usuario, String senha) throws IOException, XmlPullParserException{

        SoapObject soap = new SoapObject("http://177.44.248.141/trivaso/WebserviceAPI.php","add");

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.setOutputSoapObject(soap);

        HttpTransportSE httpTrans = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php?usuario="+usuario+"&senha="+senha+"&acao=listarBanheiros");

        httpTrans.call("add", envelope);

        Object resultado = envelope.getResponse();

        return Integer.parseInt(resultado.toString());


    }
}