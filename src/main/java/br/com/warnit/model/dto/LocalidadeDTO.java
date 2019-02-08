package br.com.warnit.model.dto;

import java.io.Serializable;

/**
 * @author Guilherme Camargo
 * @since 07/02/2019
 * @version 1.0
 * */
public class LocalidadeDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Localidade*/
    private Long idLocalidade;
    private String nomeLocalidade;
    private String cep;
    /*Bairro*/
    private Long idBairro;
    private String nomeBairro;
    /*Cidade*/
    private Long idCidade;
    private String nomeCidade;
    /*Estado*/
    private Long idEstado;
    private String nomeEstado;
    private String uf;

    public LocalidadeDTO(Long idLocalidade, String nomeLocalidade, String cep, Long idBairro, String nomeBairro, Long idCidade, String nomeCidade, Long idEstado, String nomeEstado, String uf) {
        this.idLocalidade = idLocalidade;
        this.nomeLocalidade = nomeLocalidade;
        this.cep = cep;
        this.idBairro = idBairro;
        this.nomeBairro = nomeBairro;
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.idEstado = idEstado;
        this.nomeEstado = nomeEstado;
        this.uf = uf;
    }

    public Long getIdLocalidade() {
        return idLocalidade;
    }

    public void setIdLocalidade(Long idLocalidade) {
        this.idLocalidade = idLocalidade;
    }

    public String getNomeLocalidade() {
        return nomeLocalidade;
    }

    public void setNomeLocalidade(String nomeLocalidade) {
        this.nomeLocalidade = nomeLocalidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Long getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(Long idBairro) {
        this.idBairro = idBairro;
    }

    public String getNomeBairro() {
        return nomeBairro;
    }

    public void setNomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}