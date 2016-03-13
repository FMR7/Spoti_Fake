/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.icons;

import javax.swing.ImageIcon;

/**
 *
 * @author Fernando
 * @since V 0.1
 */
public class img {
    
    /**
     * 
     * @param name
     * @return The image object.
     */
    public Object ini(String name){
        return(new ImageIcon(getClass().getResource(name)));
    }
    
}
