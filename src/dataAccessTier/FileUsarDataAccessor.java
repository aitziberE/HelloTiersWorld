/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessTier;

import model.User;

/**
 *
 * @author Aitziber
 */
public class FileUsarDataAccessor implements DataAccessible{

    @Override
    public User getUserData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//    getBundle()
//    getString()
//    estos dos tienen los dos exceptiones de runtime así que como no son checkeadas el throws exception te sirve para todo
//    te miras la documentación, buscas el método dentro de la clase y miras si produce excepciones no checkeadas, aka que no extienden de runtimeException. esas hay que illarlas.
}
