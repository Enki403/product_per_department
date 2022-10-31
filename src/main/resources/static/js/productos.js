/** poblar select */
window.onload = async ()=>{
    
    try {
        const response = await axios.get("/categorias/getAllCategorias");
        response.data.forEach( cat =>{
            var opt = document.createElement('option');
            opt.value = cat.idCategoria;
            opt.innerHTML = cat.nombreCategoria;
            document.querySelector("#categoriaSelectPrincipal").appendChild(opt);
        })
        response.data.forEach( cat =>{
            var opt = document.createElement('option');
            opt.value = cat.idCategoria;
            opt.innerHTML = cat.nombreCategoria;
            document.querySelector("#categoriaModificar").appendChild(opt);
        })
        response.data.forEach( cat =>{
            var opt = document.createElement('option');
            opt.value = cat.nombreCategoria;
            opt.innerHTML = cat.nombreCategoria;
            document.querySelector("#categoriasFiltro").appendChild(opt);
        })
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    } 

    if(getUrlVars()["categoria"] === undefined){
        filterSelection("all");
    }else{
        filterSelection(getUrlVars()["categoria"]);
        document.querySelector('#categoriasFiltro').value = getUrlVars()["categoria"];
    }
}

/** Crear Producto */
document.querySelector("#registrarProducto").addEventListener("click", async ()=>{
    var form = document.querySelector("#crearProductoForm");

    var data = {
        "nombre_producto": form.nombre_producto.value,
        "descripcion_producto": form.descripcion_producto.value,
        "cantidad": form.cantidad.value,
        "precio": form.precio.value,
        "img_dir": form.img_dir.value,
        "categoria": { 
            "idCategoria": parseInt(form.categoriaSelectPrincipal.value)
        }
    }

    try {
        const response = await axios.post("/productos/addProducto", data);
        form.nombre_producto.value = "";
        form.descripcion_producto.value = "";
        form.cantidad.value = "";
        form.precio.value = "";
        form.categoria.value = "";
        form.img_dir.value = "";
        window.location.reload()
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});

const close = (modalId)=>{
    bootstrap.Modal.getOrCreateInstance(document.querySelector(`#${modalId}`)).hide()
}
const launchModificar = ()=>{
    bootstrap.Modal.getOrCreateInstance(document.querySelector('#producto-info')).hide()
    bootstrap.Modal.getOrCreateInstance(document.querySelector('#modificar-producto')).show()
}

const verDetalles = async (id)=>{
    const response = await axios.get(`/productos/getProducto/${id}`);
    
    var formModificar = document.querySelector("#modificarProductoForm");
    var formView = document.querySelector("#viewProductoForm");

    /** form view */
    document.querySelector("#viewNombre").innerHTML = response.data.nombre_producto;
    document.querySelector("#viewPrecio").innerHTML = response.data.precio;
    formView.cantidad.value = response.data.cantidad;
    formView.categoria.value = response.data.categoria.nombreCategoria;
    formView.viewDescripcion.value = response.data.descripcion_producto;
    document.querySelector("#viewImgDir").value = response.data.img_dir;
    
    /** form modificar */
    formModificar.id_producto.value = response.data.id_producto;
    formModificar.nombre_producto.value = response.data.nombre_producto;
    formModificar.precio.value = response.data.precio;
    formModificar.cantidad.value = response.data.cantidad;
    formModificar.categoriaModificar.value = response.data.categoria.idCategoria;
    formModificar.descripcion_producto.value = response.data.descripcion_producto;
    formModificar.img_dir.value = response.data.img_dir;
    

    bootstrap.Modal.getOrCreateInstance(document.querySelector("#producto-info")).show()
}

/** Modificar producto */
document.querySelector("#modificarProducto").addEventListener("click", async ()=>{
    var form = document.querySelector("#modificarProductoForm");

    var data = {
        "nombre_producto": form.nombre_producto.value,
        "precio": form.precio.value,
        "cantidad": form.cantidad.value,
        "descripcion_producto": form.descripcion_producto.value,
        "img_dir": form.img_dir.value,
        "categoria": {
            "idCategoria": parseInt(form.categoriaModificar.value)
        }
    }

    try {
        const response = await axios.put(`/productos/update/${form.id_producto.value}`, data);
        bootstrap.Modal.getOrCreateInstance(document.querySelector("#modificar-producto")).hide();
        window.location.reload();
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});

/** Eliminar producto */
document.querySelector("#eliminarProducto").addEventListener("click", async ()=>{
    var form = document.querySelector("#modificarProductoForm");

    try {
        const response = await axios.delete(`/productos/delete/${form.id_producto.value}`);
        window.location.reload()
    } catch (error) {
        if (error.response) {
            console.log(error.reponse.status);
        } else {
            console.log(error.message);
        }
    }
});

/** filtros */

function getUrlVars() {
    var vars = {};
    var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
        vars[key] = value;
    });
    return vars;
}

function filterSelection(categoria) {
    var tarjetas, current;
    tarjetas = document.getElementsByClassName("tarjetaProducto");
    if (categoria == "all") categoria = "";
    for (current = 0; current < tarjetas.length; current++) {
      removerFiltro(tarjetas[current], "show");
      if (tarjetas[current].className.indexOf(categoria) > -1) agregarFiltro(tarjetas[current], "show");
    }
  }
  
  function agregarFiltro(element, name) {
    var current, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (current = 0; current < arr2.length; current++) {
      if (arr1.indexOf(arr2[current]) == -1) {element.className += " " + arr2[current];}
    }
  }
  
  function removerFiltro(element, name) {
    var current, arr1, arr2;
    arr1 = element.className.split(" ");
    arr2 = name.split(" ");
    for (current = 0; current < arr2.length; current++) {
      while (arr1.indexOf(arr2[current]) > -1) {
        arr1.splice(arr1.indexOf(arr2[current]), 1);     
      }
    }
    element.className = arr1.join(" ");
  }