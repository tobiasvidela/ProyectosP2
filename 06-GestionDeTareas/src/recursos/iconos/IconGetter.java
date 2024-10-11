package recursos.iconos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import logica.Util;

public class IconGetter {
    public static Icon db_JOP_icon = null;
    public static Icon login_JOP_icon = null;
    public static Icon logout_JOP_icon = null;
    public static Icon exit_JOP_icon = null;
    public static Icon register_user_JOP_icon = null;
    public static Icon modify_user_JOP_icon = null;
    public static Icon delete_account_JOP_icon = null;
    public static Icon delete_task_JOP_icon = null;
    public static Icon nuevo_JOP_icon = null;
    public static Icon pendiente_JOP_icon = null;
    public static Icon finalizado_JOP_icon = null;
    
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
    static {
        try {
            register_user_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/register_user_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono register_user_JOP.png");
        }
    }
    static {
        try {
            modify_user_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/modify_user_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono modify_user_JOP.png");
        }
    }
    static {
        try {
            delete_account_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/delete_account_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono delete_account_JOP.png");
        }
    }
    static {
        try {
            delete_task_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/delete_task_JOP.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono delete_task_JOP.png");
        }
    }
    static {
        try {
            nuevo_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/started_task.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono pendiente_JOP.png");
        }
    }
    static {
        try {
            pendiente_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/pending_task.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono pending_task.png");
        }
    }
    static {
        try {
            finalizado_JOP_icon = new ImageIcon(Util.class.getResource("/recursos/iconos/completed_task.png"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError("No se pudo cargar el ícono completed_task.png");
        }
    }
}
