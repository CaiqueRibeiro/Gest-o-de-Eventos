let botoes = document.querySelectorAll(".add-button")
let enviar = document.querySelector("#add-participantes-button")
let ids = ""
	botoes.forEach(e => {
		e.onclick = e => {
			if(e.target.readOnly != "true") {
				ids += e.target.value + ","
				enviar.href += e.target.value + ","
				e.target.readOnly = "true"
			}
		}
	})
	
enviar.onclick = e => {
	e.preventDefault()
	let url = enviar.href
	url = url.substr(0,(url.length - 1))
	alert(url)
	window.location.assign(url)
}
