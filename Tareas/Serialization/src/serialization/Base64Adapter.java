/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author Felipe
 */
public class Base64Adapter extends XmlAdapter<String, byte[]> {

    @Override
    public String marshal(byte[] v) throws Exception {
        return javax.xml.bind.DatatypeConverter.printBase64Binary(v);
    }

    @Override
    public byte[] unmarshal(String v) throws Exception {
        return javax.xml.bind.DatatypeConverter.parseBase64Binary(v);
    }
}
