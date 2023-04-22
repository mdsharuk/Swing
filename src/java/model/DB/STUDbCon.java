
package model.DB;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class STUDbCon {

    public static DataSource getCon() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/con");
    }

 

    
    
    
}
