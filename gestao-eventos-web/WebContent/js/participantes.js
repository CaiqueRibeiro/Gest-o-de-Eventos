let botoes = document.querySelectorAll(".add-button")
let botoesPago = document.querySelectorAll(".pago-button")
let enviar = document.querySelector("#add-participantes-button")
let enviarPago = document.querySelector("#add-pago-button")
let ids = ""
	botoes.forEach(e => {
		e.onclick = e => {
			if(e.target.readOnly != "true") {
				ids += e.target.value + ","
				enviar.href += e.target.value + ","
				e.target.readOnly = "true"
				e.target.style.backgroundColor = "gray";
				e.target.style.borderColor = "gray"
				e.target.innerHTML = "Selecionado"
				
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

botoesPago.forEach(e => {
	e.onclick = e => {
		if(e.target.readOnly != "true") {
			ids += e.target.value + ","
			enviarPago.href += e.target.value + ","
			e.target.readOnly = "true"
			e.target.style.backgroundColor = "gray";
			e.target.style.borderColor = "gray"
			e.target.innerHTML = "Selecionado"
			
		}
	}
})

enviarPago.onclick = e => {
	e.preventDefault()
	let url = enviarPago.href
	url = url.substr(0,(url.length - 1))
	alert(url)
	window.location.assign(url)
}