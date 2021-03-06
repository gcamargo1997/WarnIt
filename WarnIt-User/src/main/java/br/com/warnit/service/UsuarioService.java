package br.com.warnit.service;

import br.com.warnit.model.domain.Logradouro;
import br.com.warnit.model.domain.Usuario;
import br.com.warnit.model.dto.LogradouroDTO;
import br.com.warnit.model.dto.UsuarioDTO;
import br.com.warnit.repository.UsuarioRepository;
import br.com.warnit.service.exceptions.AuthenticationFailedException;
import br.com.warnit.service.exceptions.DataIntegrityException;
import br.com.warnit.service.exceptions.ObjectNotFoundException;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author Guilherme Camargo
 * @since 01/02/2019
 * @version 1.0
 * */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private LogradouroService logradouroService;

    public Usuario authenticate(String email, String senha){
        Optional<Usuario> usuario = usuarioRepository.findByEmailAndSenha(email, senha);
        return usuario.orElseThrow(() -> new AuthenticationFailedException("Email ou senha incorretos."));
    }

    public Usuario findById(Long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: "+id+
                " Tipo: "+ Usuario.class.getSimpleName()));
    }

    public Usuario findByEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Email: "+email+
                " Tipo: "+ Usuario.class.getSimpleName()));
    }

    @Transactional
    public Usuario save(Usuario usuario){
        try{
            return usuarioRepository.save(usuario);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Email já cadastrado.");
        }
    }

    public void updatePassword(UsuarioDTO dto){
        Usuario usuario = findById(dto.getId());
        usuario.setSenha(dto.getSenha());
        save(usuario);
    }

    public void addLogradouro(LogradouroDTO logradouroDTO, Long usuarioId){
        Logradouro logradouro = logradouroService.findOrPopulate(logradouroDTO);
        Usuario usuario = findById(usuarioId);
        logradouro.setUsuario(usuario);
        logradouro = logradouroService.save(logradouro);
        usuario.setLogradouro(logradouro);
        save(usuario);
    }

     /** Convert a {@link UsuarioDTO} in a {@link Usuario}
     * @param dto
     * @return Usuario
     * */
    public Usuario fromDto(UsuarioDTO dto){
        Usuario usuario;
        if(dto.getId() != null){
            usuario = findById(dto.getId());
            usuario.setEmail(dto.getEmail());
            usuario.setNome(dto.getNome());
        }else{
            usuario = new Usuario(dto.getId(), dto.getNome(), dto.getEmail(), dto.getSenha(), null);
        }
        return usuario;
    }
}
