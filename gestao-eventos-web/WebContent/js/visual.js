/*    $(document).ready(function() {
        $('select').material_select();
    });

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.fixed-action-btn');
    var instances = M.FloatingActionButton.init(elems, options);
  });  */

let categoria = document.querySelector("#categoria");
let participantes = document.querySelector("#add-participantes");

categoria.onchange = e => {
	
	if(e.target.value == "4") {
		participantes.innerHTML = "Convidar todos os participantes"
		participantes.href = "/gestao-eventos-web/evento/consultar?operacao=CONSULTAR&editar=false"
	} else {
		participantes.innerHTML = "Selecionar participantes"
		participantes.href = "/gestao-eventos-web/participantes/seleciona-participantes.jsp"
	}
}