$(document).ready(function() {
	
	$("#mensagem").hide();
	$("#dados_patente").hide();
	
	var patenteComponent = new PatenteComponent();

	function carregarPatente() {
		
		if (patenteComponent.carregar($("#numero_patente").val())) {
			
			// carrega a patente na tela
			var patente = patenteComponent.getPatente();
			var requerentes = "";
			var titulos = "";
			var dataPublicacao = new Date(patente.data_publicacao);
			
			$("#nro_pub").text(patente.nro_pub);
			$("#nro_pedido_internacional").text(patente.nro_pedido_internacional);
			$("#data_publicacao").text(dataPublicacao.getDate()+"/"+((dataPublicacao.getMonth() < 8) ? "0" : "")+(dataPublicacao.getMonth() + 1)+"/"+dataPublicacao.getFullYear());

			$("#requerentes").text("");
			$("#titulo").text("");
			
			$.each(patente.requerentes, function(index, value) {
				$("#requerentes").append("<li class=\"list-group-item\">"+value.nome+"</li>");
			}); 
			
			$.each(patente.titulo, function(index, value) {
				$("#titulo").append("<li class=\"list-group-item\">"+value.nome+"</li>");
			}); 
			
			$("#mensagem").hide("slow");
			$("#dados_patente").show("slow");
			
		} else {
			$("#mensagem").show("slow");
			$("#texto").text("Patente não encontrada");
		}
		
	}
	
	function salvarPatente() {
		if (patenteComponent.salvar()) {
			$("#mensagem").show("slow");
			$("#texto").text("Patente cadastrada com sucesso.");
		} else {
			$("#mensagem").show("slow");
			$("#texto").text("Erro ao cadastradar a patente.");
		}
	}
	
	$("#buscar_patente").click(function() {
		$("#texto").text("Buscando dados da patente");
		$("#dados_patente").hide("slow", function() {
			$("#mensagem").show("slow", function(){
				carregarPatente();
			});
		});
	});
	
	$("#salvar").click(function() {
		$("#texto").text("Salvando patente");
		$("#dados_patente").hide("slow", function() {
			$("#mensagem").show("slow", function(){
				salvarPatente();
			});
		});
	});
	
	
});