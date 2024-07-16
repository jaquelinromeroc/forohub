package com.alura.forohub.domian.usuario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuarios")
@Entity(name = "Usuario")
@EqualsAndHashCode(of = "id")

public class Usuario implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

   @Enumerated(EnumType.STRING)
   private Role role;
   private String nombre;
   private String apellido;
   private String email;
   private Boolean enabled;

   public Usuario(CrearUsuario crearUsuario, String hashedPassword){
       this.username = crearUsuario.username();
       this.password = hashedPassword;
       this.role = Role.USUARIO;
       this.nombre = capitalizado(crearUsuario.nombre());
       this.apellido = capitalizado(crearUsuario.apellido());
       this.email = crearUsuario.email();
       this.enabled = true;
   }

   public void actualizarUsuarioConPassword(ActualizarUsuario actualizarUsuario, String hashedPassword){
       if (actualizarUsuario.password() != null){
           this.password = hashedPassword;
       }
       if (actualizarUsuario.role() != null){
           this.role = actualizarUsuario.role();
       }
       if(actualizarUsuario.nombre() != null){
           this.nombre = capitalizado(actualizarUsuario.nombre());
       }
       if(actualizarUsuario.apellido() != null){
           this.apellido = capitalizado(actualizarUsuario.apellido());
       }
       if (actualizarUsuario.email() != null){
           this.email = actualizarUsuario.email();
       }
       if (actualizarUsuario.enabled() != null){
           this.enabled = actualizarUsuario.enabled();
       }
   }

   public void actualizarUsuario(ActualizarUsuario actualizarUsuario){
       if (actualizarUsuario.role() != null){
           this.role = actualizarUsuario.role();
       }
       if (actualizarUsuario.nombre() != null){
           this.nombre = capitalizado(actualizarUsuario.nombre());
       }
       if (actualizarUsuario.apellido() != null){
           this.apellido = capitalizado(actualizarUsuario.apellido());
       }
       if(actualizarUsuario.email() != null){
           this.email = actualizarUsuario.email();
       }
       if (actualizarUsuario.enabled() != null){
           this.enabled = actualizarUsuario.enabled();
       }
   }

   public void eliminarUsuario(){
       this.enabled = false;
   }

   private String capitalizado(String string){
       return string.substring(0,1).toUpperCase()+string.substring(1).toLowerCase();
   }

   @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
       return List.of(new SimpleGrantedAuthority("ROLE_USER"));
   }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired(){
       return true;
   }

   @Override
    public boolean isAccountNonLocked(){
       return true;
   }

   @Override
    public boolean isCredentialsNonExpired(){
       return true;
   }

   @Override
    public boolean isEnabled(){
       return enabled;
   }
}

