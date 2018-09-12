package corp.galvan.hlp.ticket.query;

import corp.galvan.hlp.ticket.enums.Estados;

public interface ConsultaSQL {

    String _LISTAR_HISTORIAL_TICKETS = "SELECT " +
            "htk.idhistorialticket, " +
            "htk.idticket, " +
            "htk.idaccion, " +
            "htk.idusuario, " +
            "htk.idinhibidor, " +
            "htk.observaciones, " +
            "htk.fecharegistro, " +
            "usr.id id_usrtk, " +
            "usr.usuario usuario_usrtk, usr.nombre nombre_usrtk, usr.apellido_paterno apaterno_usrtk, " +
            "usr.apellido_materno amaterno_usrtk, " +
            "usr.email email_usrtk, " +
            "usr.idsucursal idsucursal_usrtk, " +
            "usr.idgrupo idgrupo_usrtk, " +
            "ac.idaccion id_ac, " +
            "ac.nombre nombre_ac, " +
            "inh.idinhibidor id_inhibidor, " +
            "inh.codigo codigo_inh, " +
            "inh.nombre nombre_inh, " +
            "inh.idtipoinhibidor idtipoinhibidor_inh " +
            "FROM desarrollo.hlp_historialtickets htk " +
            "join desarrollo.usuarios usr on usr.id = htk.idusuario " +
            "left join desarrollo.hlp_acciones ac on ac.idaccion = htk.idaccion " +
            "left join desarrollo.hlp_inhibidores inh on inh.idinhibidor = htk.idinhibidor " +
            "ORDER BY htk.idhistorialticket, htk.fecharegistro DESC";

    String _LISTAR_HISTORIAL_TICKETS_BY_IDTICKET = "SELECT " +
            "htk.idhistorialticket, " +
            "htk.idticket, " +
            "htk.idaccion, " +
            "htk.idusuario, " +
            "htk.idinhibidor, " +
            "htk.observaciones, " +
            "htk.fecharegistro, " +
            "usr.id id_usrtk," +
            "usr.usuario usuario_usrtk, usr.nombre nombre_usrtk, usr.apellido_paterno apaterno_usrtk, " +
            "usr.apellido_materno amaterno_usrtk, " +
            "usr.email email_usrtk, " +
            "usr.oficina_id idsucursal_usrtk, " +
            "usr.grupo_id idgrupo_usrtk, " +
            "ac.idaccion id_ac, " +
            "ac.nombre nombre_ac, " +
            "inh.idinhibidor id_inhibidor, " +
            "inh.codigo codigo_inh, " +
            "inh.nombre nombre_inh, " +
            "inh.idtipoinhibidor idtipoinhibidor_inh " +
            "FROM desarrollo.hlp_historialtickets htk " +
            "join desarrollo.usuarios usr on usr.id = htk.idusuario " +
            "left join desarrollo.hlp_acciones ac on ac.idaccion = htk.idaccion " +
            "left join desarrollo.hlp_inhibidores inh on inh.idinhibidor = htk.idinhibidor " +
            "WHERE " +
            "htk.idticket = :p_idticket " +
            "ORDER BY htk.idhistorialticket, htk.fecharegistro DESC";

    String _BUSCAR_TICKETS_BY_IDUSUARIOSIS = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk, " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "INNER JOIN (SELECT usr.oficina_id FROM desarrollo.usuarios usr WHERE usr.id = :p_idusuario ) suc " +
            "ON tk.idsucursal = suc.oficina_id " +
            "WHERE tk.idestado = :p_idestatus ";

    String _BUSCAR_TICKETS_BY_IDUSUARIO = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk,  " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "WHERE tk.idusuario = :p_idusuario AND tk.idestado = :p_idestatus ";

    String _BUSCAR_TICKETS = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk,  " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "WHERE tk.idestado = :p_idestatus ";

    String _BUSCAR_TICKETS_CANCELADOS_Y_CERRADOS_BY_IDUSUARIOSIS = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk, " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "INNER JOIN (SELECT usr.oficina_id FROM desarrollo.usuarios usr WHERE usr.id = :p_idusuario ) suc " +
            "ON tk.idsucursal = suc.oficina_id " +
            "WHERE tk.idestado in (3, 4) ";

    String _BUSCAR_TICKETS_CANCELADOS_Y_CERRADOS_BY_IDUSUARIO = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk,  " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "WHERE tk.idusuario = :p_idusuario AND tk.idestado in (3, 4) ";

    String _BUSCAR_TICKETS_CANCELADOS_Y_CERRADOS = "SELECT " +
            "tk.idticket, " +
            "tk.descripcion, " +
            "tk.fechaapertura, " +
            "tk.fechaasignado, " +
            "tk.fechacierre, " +
            "tk.fechaevaluacion, " +
            "tk.fecharegistro, " +
            "tk.fechaatencion, " +
            "tk.idcategoriaserv, " +
            "tk.idestado, " +
            "tk.idprioridad, " +
            "tk.idsubcategoriaserv, " +
            "tk.idsucursal, " +
            "tk.idtiposervicio id_tiposervicioticket, " +
            "tk.idusuario, " +
            "tk.idusuariosis, " +
            "tk.indicevaloracion, " +
            "tk.referencia, " +
            "tk.titulo, " +
            "tps.idtiposervicio id_tiposervicio, tps.nombre nombre_tiposervicio, " +
            "ofctk.id id_oficina, ofctk.clave clave_oficina, ofctk.nombre nombre_oficina, " +
            "usrtk.id id_usrtk, usrtk.usuario usuario_usrtk, " +
            "usrtk.nombre nombre_usrtk, usrtk.apellido_paterno apaterno_usrtk, " +
            "usrtk.apellido_materno amaterno_usrtk, " +
            "usrtk.email email_usrtk, " +
            "usrtk.oficina_id idsucursal_usrtk,  " +
            "usrtk.grupo_id idgrupo_usrtk  " +
            "FROM " +
            "desarrollo.hlp_tickets tk " +
            "INNER JOIN desarrollo.hlp_tiposervicios tps on tk.idtiposervicio = tps.idtiposervicio " +
            "JOIN desarrollo.usuarios usrtk on tk.idusuario = usrtk.id " +
            "INNER JOIN desarrollo.oficinas ofctk on tk.idsucursal = ofctk.id " +
            "WHERE tk.idestado in (3, 4) ";

}
