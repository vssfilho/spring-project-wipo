var PatenteComponent = function() {

	var patente = null;
	var listaPatentes = null;

	this.getPatente = function() {
		return patente;
	}

	this.getListaPatentes = function() {
		return listaPatentes;
	}

	this.carregar = function(numero) {
		patente = null;
		$.ajax({
			type : "GET",
			dataType : "json",
			async : false,
			url : "http://localhost:8080/wipo/rest/patente/carregar/" + numero,
			success : function(retorno) {
				if (retorno.status == "OK") {
					patente = retorno.data;
				}
			}
		});
		return (patente != null);
	};

	this.salvar = function() {
		var sucesso = false;
		$.ajax({
			type : "POST",
			dataType : "json",
			headers : {
				'Accept' : 'application/json',
				'Content-Type' : 'application/json'
			},
			async : false,
			data : JSON.stringify(patente),
			url : "http://localhost:8080/wipo/rest/patente/salvar/",
			success : function(retorno) {
				sucesso = (retorno.status == "OK");
			}
		});
		return sucesso;
	};

	this.buscar = function(numero, requerente) {
		listaPatentes = null;
		$.ajax({
			type : "GET",
			dataType : "json",
			async : false,
			url : "http://localhost:8080/wipo/rest/patente/buscar",
			data : {
				nro_publicacao : numero,
				no_requerente : requerente
			},
			success : function(retorno) {
				if (retorno.status == "OK") {
					listaPatentes = retorno.data;
				}
			}
		});
		return (listaPatentes != null);
	};

}