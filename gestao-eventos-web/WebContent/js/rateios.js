let btnAdicionar = document.querySelector("#button-add-produto")
let enviar = document.querySelector("#add-produtos-rateio")
let levarProduto = document.querySelector("#input-levar-produto")

let produtos = []
let quantidades = []

let i = 1

btnAdicionar.onclick = e => {
	
    
    let produto = document.querySelector("#produto")
    let quantidade = document.querySelector("#qtde-produto")
    
    let containerProdutos = document.querySelector("#container-produtos")
    
    let divBox = document.createElement("div")
    divBox.classList.add("card-image")
    divBox.id = `box${i}`
    
    let span = document.createElement("span")
    span.classList.add("produtos")
    span.id = `produto-${i}`
    span.innerHTML = produto.value
    span.setAttribute("name","produtos")
    
    let spanQuantidade = document.createElement("span")
    spanQuantidade.classList.add("quantidades")
    spanQuantidade.id = `qtde-${i}`
    spanQuantidade.innerHTML = quantidade.value
    spanQuantidade.setAttribute("name","quantidades")
    
    produtos.push(produto.value)
    quantidades.push(quantidade.value)
    
    let button = document.createElement("button")
    button.type = "button"
    button.classList.add("btn")
    button.classList.add("btn-danger")
    button.classList.add("btn-remove-produto")
    button.innerHTML = "Remover"
    button.id= i

    
    divBox.appendChild(span)
    divBox.appendChild(spanQuantidade)
    divBox.appendChild(button)
    containerProdutos.appendChild(divBox)
    
    button.onclick = e => {
    	let vProd = span.innerHTML
    	let vQtde = spanQuantidade.innerHTML
    	produtos.splice(produtos.indexOf(vProd), 1)
    	quantidades.splice(quantidades.indexOf(vQtde), 1)
    	
    	let box = button.parentNode
    	let div = box.parentNode
    	div.removeChild(box)
    }
    
    i++
}

enviar.onclick = e => {
	e.preventDefault()
	let url = enviar.href
	url = url + "&produtos=" + produtos + "&quantidades=" + quantidades
	//url = url.substr(0,(url.length - 1))
	window.location.assign(url)
}

levarProduto.onclick = e => {
	e.preventDefault()
	/*let url = levarProduto.href
	let divPai = levarProduto.parentNode
	let filho = divPai.querySelector("#qtd-produto-rateio")*/
	alert("teste")
}