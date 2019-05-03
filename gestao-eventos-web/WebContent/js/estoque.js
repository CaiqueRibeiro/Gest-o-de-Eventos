let botoesEstoque = document.querySelectorAll(".btn-add-estoque")
let enviar = document.querySelector("#add-estoque")
let ids = "ids="
let qtds = "quantidades="
	
botoesEstoque.forEach(e => {
	e.onclick = e => {
		if(e.target.readOnly != "true") {
			ids += e.target.value + ","
			e.target.readOnly = "true"
			e.target.style.backgroundColor = "gray";
			e.target.style.borderColor = "gray"
			e.target.innerHTML = "Selecionado"
		
			let idBotao = e.target.value
			let ipt = document.querySelector(`#number-${idBotao}`)
			qtds += ipt.value + ","
			
		}
	}
})

enviar.onclick = e => {
	e.preventDefault()
	
	ids = ids.substr(0,(ids.length - 1))
	qtds = qtds.substr(0,(qtds.length - 1))
	
	let url = enviar.href + ids + "&" + qtds
		
	window.location.assign(url)
}
