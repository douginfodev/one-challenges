
const cripto = ['e', 'i', 'a', 'o', 'u'];
const decripto = ['enter', 'imes', 'ai', 'ober', 'ufat'];

let textoCompleto = document.getElementById('textareainfo');
let textoLimpo = '';

function checkText(tipo) {
    switch (tipo) {
        case 'D':
            alert(textoCompleto);
            break;
        case 'E':
            textoLimpo = Characters(textoCompleto.value);
            console.log(criptografar(textoLimpo));
            break;
    }
}

function criptografar(texto) {
    let textCripto = texto;
    let textFinal  = texto;
    console.log(texto);

    for (let indice = 0; indice <= 4; indice++) {
        textFinal += textFinal.replace(cripto[indice],decripto[indice]);
        //textCripto = textCripto + textFinal;
    }
    
    return textFinal;
}

function Characters(content){
   /* content = content.replace('/[áàãâä]/ui', 'a');
    content = content.replace('/[éèêë]/ui', 'e');
    content = content.replace('/[íìîï]/ui', 'i');
    content = content.replace('/[óòõôö]/ui', 'o');
    content = content.replace('/[úùûü]/ui', 'u');
    content = content.replace('/[ç]/ui', 'c');
    // content = content.replace('/[^a-z0-9]/i', '_');
    content = content.replace('/_+/', '_'); //*/
    
    const str = content;//'ÁÉÍÓÚáéíóúâêîôûàèìòùÇç/.,~!@#$%&_-12345';
    const parsed = str.normalize('NFD').replace(/([\u0300-\u036f]|[^0-9a-zA-Z\s])/g, '');
    
    return parsed;
}