package corp.galvan.hlp.ticket.service;

import corp.galvan.hlp.ticket.model.Usuario;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @PersistenceContext
    private EntityManager _entityManager;

    @Override
    public Usuario getById(Long p__idusuario) {


        List<Usuario> _listUsuarios = new ArrayList<>();
        Usuario _usuarioAux = new Usuario();

        List<Usuario> _listAux = _entityManager
                .createNamedQuery("funcGetUsuarioById")
                .setParameter( "p_idusuario", p__idusuario )
                .getResultList();


        if (!_listAux.isEmpty()) {
            /*
            for (Object[] _resultObject : _listAux) {
                Usuario _UsuarioAux = (Usuario)_resultObject[0];
                _listUsuarios.add(_UsuarioAux);
            }
            */
            _usuarioAux = _listAux.get(0);
        }

        return _usuarioAux;
    }
}
