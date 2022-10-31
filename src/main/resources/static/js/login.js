/** Iniciar Sesion */
document.querySelector("#iniciarSesion").addEventListener("click", async ()=>{
    var form = document.querySelector("#iniciarSesionForm");
    if(!form.reportValidity()){return;}
    var data = {
        "username": form.username.value,
        "contrasenia": form.password.value
    }

    try {
        const response = await axios.post("/usuarios/login", data);
        // Redirecciona directamente a '/'
        window.location.replace("/");   
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});