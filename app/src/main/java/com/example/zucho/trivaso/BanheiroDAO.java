package com.example.zucho.trivaso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

//http://177.44.248.141/trivaso/WebserviceAPI.php?usuario=etore@teste.com.br&senha=123456&acao=listarBanheiros


public class BanheiroDAO {
    private static final String URL = "http://177.44.248.141/trivaso/WebserviceAPI.php";
    private static final String NAME_SPACE = "http://exemplows.videoaula.com.br";
    private static final String INSERIR = "inserirBanheiro";
    private static final String EXCLUIR = "excluirBanheiro";
    private static final String ATUALIZAR = "atualizarBanheiro";
    private static final String BUSCAR_TODOS = "buscarTodosBanheiro";
    private static final String BUSCAR_POR_ID = "buscarBanheiroPorID";

    public BanheiroDAO() {
    }

    public boolean inserirBanheiro(Banheiro banheiro) {
        SoapObject inserirBanheiro = new SoapObject("http://exemplows.videoaula.com.br", "inserirBanheiro");
        SoapObject usr = new SoapObject("http://exemplows.videoaula.com.br", "banheiro");
        usr.addProperty("id", Integer.valueOf(banheiro.getId_banheiro()));
        usr.addProperty("nome", banheiro.getNome());
        inserirBanheiro.addSoapObject(usr);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(inserirBanheiro);
        envelope.implicitTypes = true;
        HttpTransportSE http = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php");

        try {
            http.call("urn:inserirBanheiro", envelope);
            SoapPrimitive e = (SoapPrimitive)envelope.getResponse();
            return Boolean.parseBoolean(e.toString());
        } catch (Exception var7) {
            var7.printStackTrace();
            return false;
        }
    }

    public boolean atualizarBanheiro(Banheiro banheiro) {
        SoapObject atualizarBanheiro = new SoapObject("http://exemplows.videoaula.com.br", "atualizarBanheiro");
        SoapObject usr = new SoapObject("http://exemplows.videoaula.com.br", "banheiro");
        usr.addProperty("id", Integer.valueOf(banheiro.getId_banheiro()));
        usr.addProperty("nome", banheiro.getNome());
        atualizarBanheiro.addSoapObject(usr);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(atualizarBanheiro);
        envelope.implicitTypes = true;
        HttpTransportSE http = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php");

        try {
            http.call("urn:atualizarBanheiro", envelope);
            SoapPrimitive e = (SoapPrimitive)envelope.getResponse();
            return Boolean.parseBoolean(e.toString());
        } catch (Exception var7) {
            var7.printStackTrace();
            return false;
        }
    }

    public boolean excluirBanheiro(Banheiro banheiro) {
        SoapObject excluirBanheiro = new SoapObject("http://exemplows.videoaula.com.br", "excluirBanheiro");
        SoapObject usr = new SoapObject("http://exemplows.videoaula.com.br", "banheiro");
        usr.addProperty("id", Integer.valueOf(banheiro.getId_banheiro()));
        usr.addProperty("nome", banheiro.getNome());
        excluirBanheiro.addSoapObject(usr);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(excluirBanheiro);
        envelope.implicitTypes = true;
        HttpTransportSE http = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php");

        try {
            http.call("urn:excluirBanheiro", envelope);
            SoapPrimitive e = (SoapPrimitive)envelope.getResponse();
            return Boolean.parseBoolean(e.toString());
        } catch (Exception var7) {
            var7.printStackTrace();
            return false;
        }
    }

    public ArrayList<Banheiro> buscarTodosBanheiro() {
        ArrayList lista = new ArrayList();
        SoapObject buscarTodosBanheiro = new SoapObject("http://exemplows.videoaula.com.br", "buscarTodosBanheiro");
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(buscarTodosBanheiro);
        envelope.implicitTypes = true;
        HttpTransportSE http = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php");

        try {
            http.call("urn:buscarTodosBanheiro", envelope);
            Vector e = (Vector)envelope.getResponse();
            Iterator var7 = e.iterator();

            while(var7.hasNext()) {
                SoapObject soapObject = (SoapObject)var7.next();
                Banheiro usr = new Banheiro();
                usr.setId_banheiro(Integer.parseInt(soapObject.getProperty("id").toString()));
                usr.setNome(soapObject.getProperty("nome").toString());
                lista.add(usr);
            }

            return lista;
        } catch (Exception var9) {
            var9.printStackTrace();
            return null;
        }
    }

    public Banheiro buscarBanheiroPorID(int id) {
        Banheiro usr = null;
        SoapObject buscarBanheiroID = new SoapObject("http://exemplows.videoaula.com.br", "buscarBanheiroPorID");
        buscarBanheiroID.addProperty("id", Integer.valueOf(id));
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(110);
        envelope.setOutputSoapObject(buscarBanheiroID);
        envelope.implicitTypes = true;
        HttpTransportSE http = new HttpTransportSE("http://177.44.248.141/trivaso/WebserviceAPI.php");

        try {
            http.call("urn:buscarBanheiroPorID", envelope);
            SoapObject e = (SoapObject)envelope.getResponse();
            usr = new Banheiro(id, "", 0);
            usr.setId_banheiro(Integer.parseInt(e.getProperty("id").toString()));
            usr.setNome(e.getProperty("nome").toString());
            return usr;
        } catch (Exception var7) {
            var7.printStackTrace();
            return null;
        }
    }

    public boolean excluirBanheiro(int id) {
        return this.excluirBanheiro(new Banheiro(id, "", 0));
    }
}