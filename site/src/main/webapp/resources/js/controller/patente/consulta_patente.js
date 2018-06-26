$(document).ready(function() {
	
	$("#mensagem").hide();
	$("#resultado_consulta").hide();
	
	var patenteComponent = new PatenteComponent();

	function buscarPatente() {
		
		if (patenteComponent.buscar($("#numero_patente").val(), $("#requerente_patente").val())) {
			
			// carrega as patentes na tela
			var listaPatentes = patenteComponent.getListaPatentes();
			$("#grid_patentes").text("");
			$.each(listaPatentes, function(index, value) {
				var dataPublicacao = new Date(value.data_publicacao);
				var listaRequerentes = "<ul>";
				var listaTitulo = "<ul>";
				// Carrega os requerentes
				$.each(value.requerentes, function(index, value) {
					listaRequerentes += "<li>"+value.nome+"</li>";
				});
				// Carrega titulos
				$.each(value.titulo, function(index, value) {
					listaTitulo += "<li>"+value.nome+"</li>";
				});
				listaRequerentes += "</ul>";
				listaTitulo += "</ul>";
				
				$("#grid_patentes").append("<tr>");
				$("#grid_patentes").append("<th scope=\"row\">"+value.id+"</th>");
				$("#grid_patentes").append("<td>"+value.nro_pub+"</td>");
				$("#grid_patentes").append("<td>"+value.nro_pedido_internacional+"</td>");
				$("#grid_patentes").append("<td>"+dataPublicacao.getDate()+"/"+((dataPublicacao.getMonth() < 8) ? "0" : "")+(dataPublicacao.getMonth() + 1)+"/"+dataPublicacao.getFullYear()+"</td>");
				$("#grid_patentes").append("<td>"+listaRequerentes+"</td>");
				$("#grid_patentes").append("<td>"+listaTitulo+"</td>");
				$("#grid_patentes").append("</tr>");
			}); 
		
			$("#mensagem").hide("slow");
			$("#resultado_consulta").show("slow");
			
		} else {
			$("#mensagem").show("slow");
			$("#texto").text("Nenhuma patente encontrada");
		}
		
	}

	$("#buscar_patente").click(function() {
		$("#texto").text("Buscando patente");
		$("#resultado_consulta").hide("slow", function() {
			$("#mensagem").show("slow", function(){
				buscarPatente();
			});
		});
	});
	
});