/*    $(document).ready(function() {
        $('select').material_select();
    });

document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.fixed-action-btn');
    var instances = M.FloatingActionButton.init(elems, options);
  });  */

let categoria = document.querySelector("#categoria");
let participantes = document.querySelector("#add-participantes");
let idEvento = document.querySelector("#evt-id");

categoria.onchange = e => {
	
	if(e.target.value == "4") {
		participantes.innerHTML = "Convidar todos os participantes"
		participantes.href = "/gestao-eventos-web/evento/add-participante?operacao=SALVAR&id=0&evt-id=" + idEvento.value
	} else {
		participantes.innerHTML = "Adicionar participantes"
		participantes.href = "/gestao-eventos-web/evento/consultar-participantes?operacao=CONSULTAR"
	}
}