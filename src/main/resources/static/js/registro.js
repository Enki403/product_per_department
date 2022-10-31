/** Registrar */
document.querySelector("#registrarBoton").addEventListener("click", async ()=>{
    var form = document.querySelector("#registroForm");
    if(!form.reportValidity()){return;}
    var data = {
        "username": form.username.value,
        "nombre_usuario": form.nombre.value,
        "apellido": form.apellido.value,
        "email": form.correo.value,
        "contrasenia": form.password.value
    }

    try {
        const response = await axios.post("/usuarios/registrar", data);
        window.location.replace("/login");   
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});