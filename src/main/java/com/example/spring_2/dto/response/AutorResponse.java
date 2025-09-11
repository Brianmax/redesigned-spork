package com.example.spring_2.dto.response;

public class AutorResponse {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private int numLibros;
    private String nacionalidad;

    public AutorResponse(String nombre, String apellidoPaterno, String apellidoMaterno, int numLibros, String nacionalidad) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numLibros = numLibros;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public int getNumLibros() {
        return numLibros;
    }

    public void setNumLibros(int numLibros) {
        this.numLibros = numLibros;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}

// todo: implementar el metodo findById y retornar un autorResponse en vez de un autorEntity
// TODO: implementar metodos getter y setter