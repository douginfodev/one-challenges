
const cripto = ['e', 'i', 'a', 'o', 'u'];
const decripto = ['enter', 'imes', 'ai', 'ober', 'ufat'];
let textoLimpo = '';

// DOM
let textoCompleto = document.getElementById('textareainfo');
let aside = document.getElementById('aside');
let asideCenter = document.getElementById('aside-center');
let asideTexto = document.getElementById('aside-text');
let headSection = document.getElementById('header-section');
let footerSection = document.getElementById('footer-section');
let capa = document.getElementById('capa');
let container = document.getElementById('container');

let buttonEnter = document.getElementById('btn-enter');
let buttonCode = document.getElementById('btn-code');
let buttonDecode = document.getElementById('btn-decode');
let buttonCopy = document.getElementById('btn-copy');
let buttonMode = document.getElementById('site-mode-img');

//Event Listerners
buttonEnter.addEventListener("keydown", function (event) {
    if (event.key === 'Enter' || event.code === 'Space' ? init() : null);
 });

buttonCode.addEventListener("keydown", function (event) {
   if (event.key === 'Enter' || event.code === 'Space' ? criptografar() : null);
});

buttonDecode.addEventListener("keydown", function (event) {
    if (event.key === 'Enter' || event.code === 'Space' ? descriptografar() : null);
 });

 
 buttonCopy.addEventListener("keydown", function (event) {
    if (event.key === 'Enter' || event.code === 'Space' ? copyText() : null);
 });
 
 window.onload = buttonEnter.focus;

function init() {
    headSection.style.display = "flex";
    footerSection.style.display = "flex";
    aside.style.display = "flex";
    capa.style.display = "none";
    textoCompleto.style.display = "flex";
    textoCompleto.focus;
    checkWebStorage();
}

function changeSiteMode() {
    let actualMode = localStorage.getItem("modescreen");
    

    if (actualMode === 'dark'){
        console.log(actualMode);
        localStorage.setItem("modescreen","light");
        buttonMode.style.backgroundImage = 'url(../img/ligth.png)';
    }
    else
    {
        localStorage.setItem("modescreen","dark");
        buttonMode.style.backgroundImage = 'url(../img/dark.png)';
        console.log(actualMode);
    }
   
    location.reload();
}

function checkWebStorage() {

    if (typeof (Storage) !== "undefined")
        return true;

    return false;

}

function checkText(tipo) {
    switch (tipo) {
        case 'D':
            if (textoCompleto.value != "") {
                changeStyle();
                textoLimpo = Characters(textoCompleto.value);
                asideTexto.innerHTML = descriptografar(textoLimpo);
            } else {
                textoCompleto.focus;
                alert('Favor digitar o texto');
            }
            break;
        case 'E':
            if (textoCompleto.value != "") {
                changeStyle();
                textoLimpo = Characters(textoCompleto.value);
                asideTexto.innerHTML = criptografar(textoLimpo);
            } else {
                textoCompleto.focus;
                alert('Favor digitar o texto');
            }
            break;
    }
}

function changeStyle() {
    buttonCopy.style.display = 'flex';
    buttonCopy.style.justifyContent = 'center';
    aside.style.display = 'flex';
    aside.style.justifyContent = 'start';
    asideCenter.style.display = 'none';
    asideTexto.style.display = 'flex';
}

function criptografar(texto) {
    let textCripto = texto;
    let textFinal;

    for (let indice = 0; indice <= 4; indice++) {
        textFinal = '';
        textFinal = textCripto.replaceAll(cripto[indice], decripto[indice]);
        textCripto = textFinal;
    }

    return textFinal;
}

function descriptografar(texto) {
    let textCripto = texto;
    let textFinal;

    for (let indice = 0; indice <= 4; indice++) {
        textFinal = '';
        textFinal = textCripto.replaceAll(decripto[indice], cripto[indice]);
        textCripto = textFinal;
    }

    return textFinal;
}

function Characters(content) {
    const str = content;//'ÁÉÍÓÚáéíóúâêîôûàèìòùÇç/.,~!@#$%&_-12345';
    const parsed = str.normalize('NFD').replace(/([\u0300-\u036f]|[^0-9a-zA-Z\s])/g, '');

    return parsed.toLocaleLowerCase();
}

function copyText() {
    textoCompleto.value = "";
    let clipText = document.getElementById("aside-text");
    navigator.clipboard
        .writeText(clipText.innerHTML)
        .then(() => {
            clipText.style.display = "none";
            buttonCopy.style.display = 'none';
            asideCenter.style.display = "flex";
            alert("Texto Copiado");
            textoCompleto.focus;
        }
        );
}