package recursos.iconos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import logica.Util;

public class IconGetter {
    public static Icon db_JOP_icon = null;
    public static Icon login_JOP_icon = null;
    public static Icon logout_JOP_icon = null;
    public static Icon exit_JOP_icon = null;
    
    static {
        try {
            db_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/database_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono database_JOP.png");
        }
    }
    static {
        try {
            login_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/login_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono login_JOP.png");
        }
    }
    static {
        try {
            logout_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/logout_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono logout_JOP.png");
        }
    }
    static {
        try {
            exit_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/exit_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono exit_JOP.png");
        }
    }
}
