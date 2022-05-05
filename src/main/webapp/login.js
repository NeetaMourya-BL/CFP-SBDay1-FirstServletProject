let name = document.getElementById('#name');
let textError = document.getElementsByClassName('.text-error');
name.addEventListener('input',function(){
    let nameRegex = RegExp('^[A-Z]{1}[a-zA-Z\\s]{2,}$');
    if(nameRegex.test(name)){
        textError.textContent="";
        return;
    }
    else textError.textContent='Name is Incorrect!';
});