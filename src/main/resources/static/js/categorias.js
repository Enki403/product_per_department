/** Crear categoria */
document.querySelector("#registrarCategoria").addEventListener("click", async ()=>{
    var form = document.querySelector("#crearCategoriaForm");

    var data = {
        "nombreCategoria": form.nombreCategoria.value,
        "descripcionCategoria": form.descripcionCategoria.value
    }

    try {
        const response = await axios.post("/categorias/addCategoria", data);
        form.nombreCategoria.value = "";
        form.descripcionCategoria.value = "";
        bootstrap.Modal.getOrCreateInstance(document.querySelector("#crear-categoria")).hide()
        window.location.reload()
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});

/** Ver detalles de categoria */
const verDetalles = async (id)=>{
    const response = await axios.get(`/categorias/getCategoria/${id}`);
    
    var form = document.querySelector("#modificarCategoriaForm");
    
    form.idCategoria.value = response.data.idCategoria;
    form.nombreCategoria.value = response.data.nombreCategoria;
    form.descripcionCategoria.value = response.data.descripcionCategoria;
    bootstrap.Modal.getOrCreateInstance(document.querySelector("#modificar-categoria")).show()
}

/** Modificar categoria */
document.querySelector("#modificarCategoria").addEventListener("click", async ()=>{
    var form = document.querySelector("#modificarCategoriaForm");

    var data = {
        "nombreCategoria": form.nombreCategoria.value,
        "descripcionCategoria": form.descripcionCategoria.value
    }

    try {
        const response = await axios.put(`/categorias/update/${form.idCategoria.value}`, data);
        form.idCategoria.value = "";
        form.nombreCategoria.value = "";
        form.descripcionCategoria.value = "";
        bootstrap.Modal.getOrCreateInstance(document.querySelector("#modificar-categoria")).hide()
        window.location.reload()
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});

/** Eliminar categoria */
document.querySelector("#eliminarCategoria").addEventListener("click", async ()=>{
    var form = document.querySelector("#modificarCategoriaForm");

    try {
        const response = await axios.delete(`/categorias/delete/${form.idCategoria.value}`);
        form.idCategoria.value = "";
        form.nombreCategoria.value = "";
        form.descripcionCategoria.value = "";
        bootstrap.Modal.getOrCreateInstance(document.querySelector("#modificar-categoria")).hide()
        window.location.reload()
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});