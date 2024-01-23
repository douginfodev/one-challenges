
const cripto = ['e', 'i', 'a', 'o', 'u'];
const decripto = ['enter', 'imes', 'ai', 'ober', 'ufat'];
let textoLimpo = '';

// DOM
let textoCompleto = document.getElementById('textareainfo');
let aside = document.getElementById('aside');
let buttonCopy = document.getElementById('btn-copy');
let asideCenter = document.getElementById('aside-center');
let asideTexto = document.getElementById('aside-text');
textoCompleto.focus;

// FUNCTION
function checkText(tipo) {
    switch (tipo) {
        case 'D':
            buttonCopy.style.display = 'flex';
            buttonCopy.style.justifyContent = 'end';
            aside.style.display = 'flex';
            aside.style.justifyContent = 'start';
            asideCenter.style.display = 'none';
            asideTexto.style.display = 'flex';
            textoLimpo = Characters(textoCompleto.value);
            asideTexto.innerHTML = descriptografar(textoLimpo);
            break;
        case 'E':
            buttonCopy.style.display = 'flex';
            aside.style.display = 'flex';
            aside.style.justifyContent = 'start';
            asideCenter.style.display = 'none';
            asideTexto.style.display = 'flex';
            textoLimpo = Characters(textoCompleto.value);
            asideTexto.innerHTML = criptografar(textoLimpo);
            break;
    }
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
    let clipText = document.getElementById("aside-text").innerHTML;
    navigator.clipboard
        .writeText(clipText)
        .then(() => {
            alert("Texto Copiado");
        }
        );
}